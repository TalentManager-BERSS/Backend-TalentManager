package com.berss.platform.support.interfaces.rest.transform;

import com.berss.platform.support.domain.model.commands.UpdateSupportMessageCommand;
import com.berss.platform.support.interfaces.rest.resources.UpdateSupportMessageResource;

public class UpdateSupportMessageCommandFromResourceAssembler {
    public static UpdateSupportMessageCommand toCommandFromResource(Long id, UpdateSupportMessageResource resource) {
        return new UpdateSupportMessageCommand(id, resource.companyId(), resource.content());
    }
}