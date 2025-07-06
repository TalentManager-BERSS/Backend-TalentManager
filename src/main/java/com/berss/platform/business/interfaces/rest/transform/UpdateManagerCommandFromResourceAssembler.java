package com.berss.platform.business.interfaces.rest.transform;

import com.berss.platform.business.domain.model.commands.UpdateManagerNameCommand;
import com.berss.platform.business.interfaces.rest.resources.UpdateManagerResource;

/**
 * Assembler to convert an UpdateManagerResource to an UpdateManagerNameCommand.
 */
public class UpdateManagerCommandFromResourceAssembler {
    /**
     * Converts an UpdateManagerResource to an UpdateManagerNameCommand.
     *
     * @param managerId The manager ID.
     * @param resource The {@link UpdateManagerResource} resource to convert.
     * @return The {@link UpdateManagerNameCommand} command that results from the conversion.
     */
    public static UpdateManagerNameCommand toCommandFromResource(Long managerId, UpdateManagerResource resource) {
        return new UpdateManagerNameCommand(managerId, resource.firstname(), resource.lastname());
    }
}
