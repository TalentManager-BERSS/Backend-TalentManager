package com.berss.platform.business.interfaces.rest.transform;

import com.berss.platform.business.domain.model.commands.UpdateProfileNameCommand;
import com.berss.platform.business.interfaces.rest.resources.UpdateProfileResource;

/**
 * Assembler to convert an UpdateProfileResource to an UpdateProfileNameCommand.
 */
public class UpdateProfileCommandFromResourceAssembler {
    /**
     * Converts an UpdateProfileResource to an UpdateProfileNameCommand.
     *
     * @param profileId The profile ID.
     * @param resource The {@link UpdateProfileResource} resource to convert.
     * @return The {@link UpdateProfileNameCommand} command that results from the conversion.
     */
    public static UpdateProfileNameCommand toCommandFromResource(Long profileId, UpdateProfileResource resource) {
        return new UpdateProfileNameCommand(profileId, resource.username());
    }
}
