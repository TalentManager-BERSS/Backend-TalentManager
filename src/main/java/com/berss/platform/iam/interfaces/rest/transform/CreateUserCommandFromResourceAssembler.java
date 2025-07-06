package com.berss.platform.iam.interfaces.rest.transform;

import com.berss.platform.iam.domain.model.commands.CreateUserCommand;
import com.berss.platform.iam.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {

    public static CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(
                resource.getUsername(),
                resource.getPassword(),
                resource.getManagerId()
        );
    }
}