package com.berss.platform.business.interfaces.rest.resources;

/**
 * Profile resource.
 * Used to expose Profile data in REST responses.
 */
public record ProfileResource(Long id, String username, String password ,String companyName, String companyEmail) {
}
