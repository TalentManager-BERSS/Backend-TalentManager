package com.berss.platform.iam.interfaces.rest.resources;

import lombok.AllArgsConstructor;
import lombok.Getter;

public record RegisterUserWithManagerResource (
        String username,
        String password,
        String firstname,
        String lastname,
        String companyName,
        String companyEmail,
        String companyDescription
)
{
}
