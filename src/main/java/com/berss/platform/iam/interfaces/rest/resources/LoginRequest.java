package com.berss.platform.iam.interfaces.rest.resources;

public record LoginRequest (
        String username,
        String password
) {}
