package com.berss.platform.reports.interfaces.rest.transform;

import com.berss.platform.reports.domain.model.aggregates.Report;
import com.berss.platform.reports.interfaces.rest.resources.ReportResource;

public class ReportResourceFromEntityAssembler {
    /**
     * Converts a Report entity to a ReportResource.
     *
     * @param entity The {@link Report} entity to convert.
     * @return The {@link ReportResource} resource that results from the conversion.
     */

    public static ReportResource toResourcefromEntity(Report entity) {
        return new ReportResource(entity.getId(), entity.getTitle(), entity.getContent(), entity.getCompanyId(),  entity.getMonthlySummaryId());
    }
}
