package com.berss.platform.business.interfaces.rest.transform;

import com.berss.platform.business.interfaces.rest.resources.CreateProfileResource;
import com.berss.platform.business.domain.model.commands.CreateProfileCommand;

/**
 * Assembler to convert a CreateProfileResource to a CreateProfileCommand.
 */
public class CreateProfileCommandFromResourceAssembler {
    /**
     * Converts a CreateProfileResource to a CreateProfileCommand.
     *
     * @param resource The {@link CreateProfileResource} resource to convert.
     * @return The {@link CreateProfileCommand} command that results from the conversion.
     */
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
        return new CreateProfileCommand(
                resource.username(),
                resource.password(),
                resource.companyDescription(),
                resource.companyName(),
                resource.companyEmail()
        );
    }
}
