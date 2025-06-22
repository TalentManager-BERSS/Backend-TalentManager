package com.berss.platform.employees.interfaces.rest.transform;

import com.berss.platform.employees.domain.model.commands.UpdateEmployeeCommand;
import com.berss.platform.employees.interfaces.rest.resources.UpdateEmployeeResource;

public class UpdateEmployeeCommandFromResourceAssembler {
    public static UpdateEmployeeCommand toCommandFromResource(Long courseId, UpdateEmployeeResource resource) {
        return new UpdateEmployeeCommand(courseId, resource.firstName(), resource.lastName(), resource.occupation(), resource.entryDate(), resource.teamName());
    }
}
