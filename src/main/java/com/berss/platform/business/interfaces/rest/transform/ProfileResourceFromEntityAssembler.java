package com.berss.platform.business.interfaces.rest.transform;

import com.berss.platform.business.domain.model.aggregates.Profile;
import com.berss.platform.business.interfaces.rest.resources.ProfileResource;

/**
 * Assembler to convert a Profile entity to a ProfileResource.
 */
public class ProfileResourceFromEntityAssembler {
    /**
     * Converts a Profile entity to a ProfileResource.
     *
     * @param entity The {@link Profile} entity to convert.
     * @return The {@link ProfileResource} resource that results from the conversion.
     */
    public static ProfileResource toResourceFromEntity(Profile entity) {
        var company = entity.getCompany();
        return new ProfileResource(
                entity.getId(),
                entity.getUsername(),
                entity.getPassword(),
                company != null ? company.getName() : null,
                company != null ? company.getEmail() : null
        );
    }
}
