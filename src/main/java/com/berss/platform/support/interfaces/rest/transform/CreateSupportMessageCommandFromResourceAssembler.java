package com.berss.platform.support.interfaces.rest.transform;

import com.berss.platform.support.domain.model.commands.CreateSupportMessageCommand;
import com.berss.platform.support.interfaces.rest.resources.CreateSupportMessageResource;

public class CreateSupportMessageCommandFromResourceAssembler {
    public static CreateSupportMessageCommand toCommandFromResource(CreateSupportMessageResource resource) {
        return new CreateSupportMessageCommand(resource.content(), resource.companyId(), resource.requestDate(), resource.receivedAt());
    }
}