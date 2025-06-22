package com.berss.platform.support.interfaces.rest.resources;

public record ChangeStatusResource(String newStatus) {
    public ChangeStatusResource {
        if (newStatus == null || newStatus.isBlank()) {
            throw new IllegalArgumentException("New status must not be blank");
        }
    }
}