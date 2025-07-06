package com.berss.platform.business.interfaces.rest;

import com.berss.platform.business.domain.model.commands.CreateManagerCommand;
import com.berss.platform.business.domain.model.commands.DeleteManagerCommand;
import com.berss.platform.business.domain.model.commands.UpdateManagerNameCommand;
import com.berss.platform.business.domain.model.queries.GetAllManagersQuery;
import com.berss.platform.business.domain.model.queries.GetManagerByIdQuery;
import com.berss.platform.business.domain.services.ManagerCommandService;
import com.berss.platform.business.domain.services.ManagerQueryService;
import com.berss.platform.business.interfaces.rest.resources.CreateManagerResource;
import com.berss.platform.business.interfaces.rest.resources.ManagerResource;
import com.berss.platform.business.interfaces.rest.transform.CreateManagerCommandFromResourceAssembler;
import com.berss.platform.business.interfaces.rest.transform.ManagerResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping(value = "/api/v1/managers", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Managers", description = "Available Manager Endpoints")
public class ManagersController {

    private final ManagerCommandService managerCommandService;
    private final ManagerQueryService managerQueryService;

    public ManagersController(ManagerCommandService managerCommandService, ManagerQueryService managerQueryService) {
        this.managerCommandService = managerCommandService;
        this.managerQueryService = managerQueryService;
    }

    @PostMapping
    @Operation(summary = "Create a new manager", description = "Create a new manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Manager created"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<ManagerResource> createManager(@RequestBody CreateManagerResource resource) {
        var command = CreateManagerCommandFromResourceAssembler.toCommandFromResource(resource);
        var managerId = managerCommandService.handle(command);
        var query = new GetManagerByIdQuery(managerId);
        var manager = managerQueryService.handle(query);
        if (manager.isEmpty()) return ResponseEntity.notFound().build();
        var managerResource = ManagerResourceFromEntityAssembler.toResourceFromEntity(manager.get());
        return new ResponseEntity<>(managerResource, HttpStatus.CREATED);
    }

    @GetMapping("/{managerId}")
    @Operation(summary = "Get manager by id", description = "Get manager by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Manager found"),
            @ApiResponse(responseCode = "404", description = "Manager not found")
    })
    public ResponseEntity<ManagerResource> getManagerById(@PathVariable Long managerId) {
        var query = new GetManagerByIdQuery(managerId);
        var manager = managerQueryService.handle(query);
        if (manager.isEmpty()) return ResponseEntity.notFound().build();
        var resource = ManagerResourceFromEntityAssembler.toResourceFromEntity(manager.get());
        return ResponseEntity.ok(resource);
    }

    @GetMapping
    @Operation(summary = "Get all managers", description = "Get all managers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Managers found"),
            @ApiResponse(responseCode = "404", description = "No managers found")
    })
    public ResponseEntity<List<ManagerResource>> getAllManagers() {
        var query = new GetAllManagersQuery();
        var managers = managerQueryService.handle(query);
        if (managers.isEmpty()) return ResponseEntity.notFound().build();
        var resources = managers.stream()
                .map(ManagerResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }

    @DeleteMapping("/{managerId}")
    @Operation(summary = "Delete manager", description = "Delete manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Manager deleted"),
            @ApiResponse(responseCode = "404", description = "Manager not found")
    })
    public ResponseEntity<String> deleteManager(@PathVariable Long managerId) {
        managerCommandService.handle(new DeleteManagerCommand(managerId));
        return ResponseEntity.ok("Manager with given id successfully deleted");
    }

    @PutMapping("/{managerId}")
    @Operation(summary = "Update manager name", description = "Update the first name and last name of a manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Manager updated"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Manager not found")
    })
    public ResponseEntity<ManagerResource> updateManagerFirstName(
            @PathVariable Long managerId,
            @RequestBody CreateManagerResource resource) {

        if (resource.firstname() == null || resource.firstname().isBlank()) {
            return ResponseEntity.badRequest().body(null);
        }

        var command = new UpdateManagerNameCommand(managerId, resource.firstname(), resource.lastname());
        var updated = managerCommandService.updateAndReturn(command);

        return updated
                .map(manager -> ResponseEntity.ok(ManagerResourceFromEntityAssembler.toResourceFromEntity(manager)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
