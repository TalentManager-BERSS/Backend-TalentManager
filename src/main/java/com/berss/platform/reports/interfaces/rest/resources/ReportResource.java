package com.berss.platform.reports.interfaces.rest.resources;

import java.time.LocalDate;

public record ReportResource(
        Long id,
        String title,
        String content,
        LocalDate createdAt,
        Long companyId
) {}