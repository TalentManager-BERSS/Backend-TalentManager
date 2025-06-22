package com.berss.platform.business.domain.services;

import com.berss.platform.business.domain.model.aggregates.Profile;
import com.berss.platform.business.domain.model.commands.CreateProfileCommand;
import com.berss.platform.business.domain.model.commands.UpdateProfileNameCommand;
import com.berss.platform.business.domain.model.commands.DeleteProfileCommand;

import java.util.Optional;

/**
 * ProfileCommandService
 * Service that handles profile commands
 */
public interface ProfileCommandService {

    /**
     * Handle a create profile command
     * @param command The create profile command containing the profile data
     * @return The ID of the created profile
     * @see CreateProfileCommand
     */
    Long handle(CreateProfileCommand command);

    /**
     * Handle an update profile name command
     * @param command The update profile name command containing the profile ID and new name
     * @see UpdateProfileNameCommand
     */
    void handle(UpdateProfileNameCommand command);

    /**
     * Handle a delete profile command
     * @param command The delete profile command containing the profile ID to delete
     * @see DeleteProfileCommand
     */
    void handle(DeleteProfileCommand command);

    /**
     * Optional: return the updated profile
     * @param command The update profile name command
     * @return Optional containing the updated profile if found
     */
    Optional<Profile> updateAndReturn(UpdateProfileNameCommand command);
}
