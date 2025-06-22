package com.berss.platform.reports.interfaces.rest.transform;

import com.berss.platform.reports.domain.model.commands.UpdateMonthlySummaryCommand;
import com.berss.platform.reports.interfaces.rest.resources.UpdateMonthlySummaryResource;

public class UpdateMonthlySummaryCommandFromResourceAssembler {
    public static UpdateMonthlySummaryCommand toCommandfromResource(Long monthlySummaryId, UpdateMonthlySummaryResource resource) {
        return new UpdateMonthlySummaryCommand(monthlySummaryId, resource.totalHours(), resource.completedHours(), resource.score(), resource.inputAmount());
    }
}
