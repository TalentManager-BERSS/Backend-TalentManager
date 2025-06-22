package com.berss.platform.business.domain.model.commands;

public record CreateProfileCommand(String username,String password, String companyName, String companyEmail, String companyDescription) {}
