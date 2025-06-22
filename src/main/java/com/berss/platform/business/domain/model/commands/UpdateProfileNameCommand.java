package com.berss.platform.business.domain.model.commands;

public record UpdateProfileNameCommand(
        Long profileId,
        String username
) {}