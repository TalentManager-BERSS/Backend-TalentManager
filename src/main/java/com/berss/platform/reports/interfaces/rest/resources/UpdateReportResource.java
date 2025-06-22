package com.berss.platform.reports.interfaces.rest.resources;

public record UpdateReportResource(String title, String content) {
    public UpdateReportResource {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or blank");
        }
    }
}
