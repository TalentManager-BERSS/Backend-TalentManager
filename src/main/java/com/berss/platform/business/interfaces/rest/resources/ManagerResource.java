package com.berss.platform.business.interfaces.rest.resources;

/**
 * Manager resource.
 * Used to expose Manager data in REST responses.
 */
public record ManagerResource (
        Long id,
        String firstname,
        String lastname,
        String companyName,
        String companyEmail,
        String companyDescription)
{
}