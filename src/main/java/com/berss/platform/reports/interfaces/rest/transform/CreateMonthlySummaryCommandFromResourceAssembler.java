package com.berss.platform.reports.interfaces.rest.transform;

import com.berss.platform.reports.domain.model.commands.CreateMonthlySummaryCommand;
import com.berss.platform.reports.interfaces.rest.resources.CreateMonthlySummaryResource;

public class CreateMonthlySummaryCommandFromResourceAssembler {
    public static CreateMonthlySummaryCommand toCommandFromResource(CreateMonthlySummaryResource resource) {
        return new CreateMonthlySummaryCommand(resource.employeeId(), resource.companyId(), resource.month(), resource.year(), resource.totalHours(), resource.completedHours(), resource.inputAmount(), resource.score());
    }
}
