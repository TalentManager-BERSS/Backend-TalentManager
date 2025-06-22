package com.berss.platform.support.interfaces.rest.transform;

import com.berss.platform.support.domain.model.commands.ChangeStatusCommand;
import com.berss.platform.support.interfaces.rest.resources.ChangeStatusResource;

public class ChangeStatusCommandFromResourceAssembler {
    public static ChangeStatusCommand toCommandFromResource(Long id, ChangeStatusResource resource) {
        return new ChangeStatusCommand(id, resource.newStatus());
    }
}