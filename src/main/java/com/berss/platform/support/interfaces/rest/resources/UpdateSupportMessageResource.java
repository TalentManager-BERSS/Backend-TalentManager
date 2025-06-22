package com.berss.platform.support.interfaces.rest.resources;

public record UpdateSupportMessageResource(Long companyId, String content) {
    public UpdateSupportMessageResource {
        if (companyId == null || companyId <= 0) {
            throw new IllegalArgumentException("Company ID is required and must be greater than 0");
        }
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content is required and must not be blank");
        }
    }
}