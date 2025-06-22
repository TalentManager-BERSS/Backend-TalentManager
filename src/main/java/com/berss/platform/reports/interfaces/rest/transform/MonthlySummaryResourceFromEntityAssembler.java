package com.berss.platform.reports.interfaces.rest.transform;

import com.berss.platform.reports.domain.model.aggregates.MonthlySummary;
import com.berss.platform.reports.interfaces.rest.resources.MonthlySummaryResource;

public class MonthlySummaryResourceFromEntityAssembler {
    /**
     * Converts a MonthlySummary entity to a MonthlySummaryResource.
     *
     * @param entity The {@link MonthlySummary} entity to convert.
     * @return The {@link MonthlySummaryResource} resource that results from the conversion.
     */

    public static MonthlySummaryResource toResourcefromEntity(MonthlySummary entity) {
        return new MonthlySummaryResource(entity.getId(), entity.getEmployeeId(), entity.getCompanyId(), entity.getPeriod().getMonth(), entity.getPeriod().getYear(), entity.getTotalHours(), entity.getCompletedHours(), entity.getInput(), entity.getScore());
    }
}
