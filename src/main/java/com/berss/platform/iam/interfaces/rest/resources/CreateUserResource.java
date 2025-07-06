package com.berss.platform.iam.interfaces.rest.resources;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserResource(
        String username,
        String password,
        Long managerId
) {
    public CreateUserResource(String username, String password, Long managerId) {
        this.username = username;
        this.password = password;
        this.managerId = managerId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getManagerId() {
        return managerId;
    }
}