package com.berss.platform.business.application.internal.commandservices;

import com.berss.platform.business.domain.model.aggregates.Profile;
import com.berss.platform.business.domain.model.commands.CreateProfileCommand;
import com.berss.platform.business.domain.model.commands.DeleteProfileCommand;
import com.berss.platform.business.domain.model.commands.UpdateProfileNameCommand;
import com.berss.platform.business.domain.services.ProfileCommandService;
import com.berss.platform.business.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the ProfileCommandService interface.
 * <p>This class is responsible for handling the commands related to the Profile aggregate. It uses ProfileRepository.</p>
 * @see ProfileCommandService
 * @see ProfileRepository
 */
@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {
    private final ProfileRepository profileRepository;

    /**
     * Constructor for ProfileCommandServiceImpl.
     * @param profileRepository the repository used for accessing profile data.
     */
    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    // inherit javadoc
    @Override
    public Long handle(CreateProfileCommand command) {
        var profile = new Profile(command);
        try {
            profileRepository.save(profile);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving profile: %s".formatted(e.getMessage()));
        }
        return profile.getId();
    }

    // inherit javadoc
    @Override
    public void handle(UpdateProfileNameCommand command) {
        var profile = profileRepository.findById(command.profileId())
                .orElseThrow(() -> new IllegalArgumentException("Profile with id %s not found".formatted(command.profileId())));
        try {
            profile.updateProfile(command);
            profileRepository.save(profile);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating profile: %s".formatted(e.getMessage()));
        }
    }

    // inherit javadoc
    @Override
    public void handle(DeleteProfileCommand command) {
        if (!profileRepository.existsById(command.profileId())) {
            throw new IllegalArgumentException("Profile with id %s not found".formatted(command.profileId()));
        }
        try {
            profileRepository.deleteById(command.profileId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting profile: %s".formatted(e.getMessage()));
        }
    }

    // Optional return
    @Override
    public Optional<Profile> updateAndReturn(UpdateProfileNameCommand command) {
        var profile = profileRepository.findById(command.profileId());
        if (profile.isEmpty()) return Optional.empty();
        profile.get().updateProfile(command);
        try {
            return Optional.of(profileRepository.save(profile.get()));
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating profile: %s".formatted(e.getMessage()));
        }
    }
}
