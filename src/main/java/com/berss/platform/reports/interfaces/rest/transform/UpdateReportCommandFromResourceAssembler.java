package com.berss.platform.reports.interfaces.rest.transform;

import com.berss.platform.reports.domain.model.commands.UpdateReportCommand;
import com.berss.platform.reports.interfaces.rest.resources.UpdateReportResource;

public class UpdateReportCommandFromResourceAssembler {
    public static UpdateReportCommand toCommandfromResource(Long reportId, UpdateReportResource resource) {
        return new UpdateReportCommand(reportId, resource.title(), resource.content());
    }
}
