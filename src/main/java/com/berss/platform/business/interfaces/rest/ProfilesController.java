package com.berss.platform.business.interfaces.rest;

import com.berss.platform.business.domain.model.commands.CreateProfileCommand;
import com.berss.platform.business.domain.model.commands.DeleteProfileCommand;
import com.berss.platform.business.domain.model.commands.UpdateProfileNameCommand;
import com.berss.platform.business.domain.model.queries.GetAllProfilesQuery;
import com.berss.platform.business.domain.model.queries.GetProfileByIdQuery;
import com.berss.platform.business.domain.services.ProfileCommandService;
import com.berss.platform.business.domain.services.ProfileQueryService;
import com.berss.platform.business.interfaces.rest.resources.CreateProfileResource;
import com.berss.platform.business.interfaces.rest.resources.ProfileResource;
import com.berss.platform.business.interfaces.rest.transform.CreateProfileCommandFromResourceAssembler;
import com.berss.platform.business.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/profiles", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Profiles", description = "Available Profile Endpoints")
public class ProfilesController {

    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfilesController(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    @PostMapping
    @Operation(summary = "Create a new profile", description = "Create a new profile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Profile created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<ProfileResource> createProfile(@RequestBody CreateProfileResource resource) {
        var command = CreateProfileCommandFromResourceAssembler.toCommandFromResource(resource);
        var profileId = profileCommandService.handle(command);
        var query = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(query);
        if (profile.isEmpty()) return ResponseEntity.notFound().build();
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }

    @GetMapping("/{profileId}")
    @Operation(summary = "Get profile by id", description = "Get profile by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profile found"),
            @ApiResponse(responseCode = "404", description = "Profile not found")
    })
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable Long profileId) {
        var query = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(query);
        if (profile.isEmpty()) return ResponseEntity.notFound().build();
        var resource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(resource);
    }

    @GetMapping
    @Operation(summary = "Get all profiles", description = "Get all profiles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profiles found"),
            @ApiResponse(responseCode = "404", description = "No profiles found")
    })
    public ResponseEntity<List<ProfileResource>> getAllProfiles() {
        var query = new GetAllProfilesQuery();
        var profiles = profileQueryService.handle(query);
        if (profiles.isEmpty()) return ResponseEntity.notFound().build();
        var resources = profiles.stream()
                .map(ProfileResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }

    @DeleteMapping("/{profileId}")
    @Operation(summary = "Delete profile", description = "Delete profile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profile deleted"),
            @ApiResponse(responseCode = "404", description = "Profile not found")
    })
    public ResponseEntity<String> deleteProfile(@PathVariable Long profileId) {
        profileCommandService.handle(new DeleteProfileCommand(profileId));
        return ResponseEntity.ok("Profile with given id successfully deleted");
    }

    @PutMapping("/{profileId}")
    @Operation(summary = "Update profile username", description = "Update the username of a profile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profile updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Profile not found")
    })
    public ResponseEntity<ProfileResource> updateProfileUsername(
            @PathVariable Long profileId,
            @RequestBody CreateProfileResource resource) {

        if (resource.username() == null || resource.username().isBlank()) {
            return ResponseEntity.badRequest().body(null);
        }

        var command = new UpdateProfileNameCommand(profileId, resource.username());
        var updated = profileCommandService.updateAndReturn(command);

        return updated
                .map(profile -> ResponseEntity.ok(ProfileResourceFromEntityAssembler.toResourceFromEntity(profile)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
