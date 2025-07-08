package com.berss.platform.reports.interfaces.rest.transform;

import com.berss.platform.reports.domain.model.commands.UpdateDailySummaryCommand;
import com.berss.platform.reports.interfaces.rest.resources.UpdateDailySummaryResource;

public class UpdateDailySummaryCommandFromResourceAssembler {
    public static UpdateDailySummaryCommand toCommandfromResource(Long dailySummaryId, UpdateDailySummaryResource resource) {
        return new UpdateDailySummaryCommand(dailySummaryId, resource.entryTime(), resource.exitTime(), resource.score(), resource.inputAmount());
    }
}
