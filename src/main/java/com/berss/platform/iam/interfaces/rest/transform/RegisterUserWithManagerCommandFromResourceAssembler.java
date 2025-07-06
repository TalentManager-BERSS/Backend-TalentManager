package com.berss.platform.iam.interfaces.rest.transform;

import com.berss.platform.iam.domain.model.commands.RegisterUserWithManagerCommand;
import com.berss.platform.iam.interfaces.rest.resources.RegisterUserWithManagerResource;

public class RegisterUserWithManagerCommandFromResourceAssembler {
    public static RegisterUserWithManagerCommand toCommandFromResource(RegisterUserWithManagerResource resource) {
        return new RegisterUserWithManagerCommand(
                resource.username(),
                resource.password(),
                resource.firstname(),
                resource.lastname(),
                resource.companyName(),
                resource.companyEmail(),
                resource.companyDescription()
        );
    }
}
