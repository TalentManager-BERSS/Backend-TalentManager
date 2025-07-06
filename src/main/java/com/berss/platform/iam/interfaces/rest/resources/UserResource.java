package com.berss.platform.iam.interfaces.rest.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;

public record UserResource(
        Long id,
        String username,
        Long managerId,
        Long companyId
) {

    public UserResource(Long id, String username, Long managerId, Long companyId) {
        this.id = id;
        this.username = username;
        this.managerId = managerId;
        this.companyId = companyId;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Long getManagerId() {
        return managerId;
    }

    public Long getCompanyId() {
        return companyId;
    }
}
