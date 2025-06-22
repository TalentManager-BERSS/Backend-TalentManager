package com.berss.platform.business.interfaces.rest.resources;

public record CreateProfileResource(String username, String password, String companyName, String companyEmail, String companyDescription) {}
