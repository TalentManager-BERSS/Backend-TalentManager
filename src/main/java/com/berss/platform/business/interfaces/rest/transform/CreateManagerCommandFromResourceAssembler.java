package com.berss.platform.business.interfaces.rest.transform;

import com.berss.platform.business.interfaces.rest.resources.CreateManagerResource;
import com.berss.platform.business.domain.model.commands.CreateManagerCommand;

/**
 * Assembler to convert a CreateManagerResource to a CreateManagerCommand.
 */
public class CreateManagerCommandFromResourceAssembler {
    /**
     * Converts a CreateManagerResource to a CreateManagerCommand.
     *
     * @param resource The {@link CreateManagerResource} resource to convert.
     * @return The {@link CreateManagerCommand} command that results from the conversion.
     */
    public static CreateManagerCommand toCommandFromResource(CreateManagerResource resource) {
        return new CreateManagerCommand(
                resource.firstname(),
                resource.lastname(),
                resource.companyName(),
                resource.companyDescription(),
                resource.companyEmail()
        );
    }
}
