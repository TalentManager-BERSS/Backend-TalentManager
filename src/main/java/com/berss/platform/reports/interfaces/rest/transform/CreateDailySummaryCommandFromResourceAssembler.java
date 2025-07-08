package com.berss.platform.reports.interfaces.rest.transform;

import com.berss.platform.reports.domain.model.commands.CreateDailySummaryCommand;
import com.berss.platform.reports.interfaces.rest.resources.CreateDailySummaryResource;

public class CreateDailySummaryCommandFromResourceAssembler {
    public static CreateDailySummaryCommand toCommandFromResource(CreateDailySummaryResource resource) {
        return new CreateDailySummaryCommand(
                resource.employeeId(),
                resource.companyId(),
                resource.day(),
                resource.month(),
                resource.year(),
                resource.entryTime(),
                resource.exitTime(),
                resource.inputAmount(),
                resource.score()
        );
    }
}
