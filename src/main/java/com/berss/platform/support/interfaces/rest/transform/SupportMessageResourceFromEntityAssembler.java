package com.berss.platform.support.interfaces.rest.transform;

import com.berss.platform.support.domain.model.aggregates.SupportMessage;
import com.berss.platform.support.interfaces.rest.resources.SupportMessageResource;

public class SupportMessageResourceFromEntityAssembler {
    public static SupportMessageResource toResourceFromEntity(SupportMessage entity) {
        return new SupportMessageResource(
                entity.getId(),
                entity.getContent(),
                entity.getCompanyId().asLong(),
                entity.getRequestDate().value(),
                entity.getReceivedAt().value(),
                entity.getStatusAsString()
        );
    }
}