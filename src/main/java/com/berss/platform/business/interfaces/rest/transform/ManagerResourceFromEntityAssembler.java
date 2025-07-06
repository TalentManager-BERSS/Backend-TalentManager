package com.berss.platform.business.interfaces.rest.transform;

import com.berss.platform.business.domain.model.aggregates.Manager;
import com.berss.platform.business.interfaces.rest.resources.ManagerResource;

/**
 * Assembler to convert a Manager entity to a ManagerResource.
 */
public class ManagerResourceFromEntityAssembler {
    /**
     * Converts a Manager entity to a ManagerResource.
     *
     * @param entity The {@link Manager} entity to convert.
     * @return The {@link ManagerResource} resource that results from the conversion.
     */
    public static ManagerResource toResourceFromEntity(Manager entity) {
        var company = entity.getCompany();
        return new ManagerResource(
                entity.getId(),
                entity.getFirstname(),
                entity.getLastname(),
                company != null ? company.getName() : null,
                company != null ? company.getEmail() : null,
                company != null ? company.getDescription() : null
        );
    }
}
