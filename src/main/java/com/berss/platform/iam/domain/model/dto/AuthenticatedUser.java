package com.berss.platform.iam.domain.model.dto;

import com.berss.platform.iam.domain.model.aggregates.User;

public class AuthenticatedUser {
    private final User user;
    private final String token;

    public AuthenticatedUser(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }
}