package com.berss.platform.business.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Value object representing a valid company website URL
 */

@Embeddable
public record CompanyWebsite(String address) {

    public CompanyWebsite {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Website URL cannot be null or blank");
        }

        try {
            new URL(address);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid website URL format: " + address);
        }
    }
}
