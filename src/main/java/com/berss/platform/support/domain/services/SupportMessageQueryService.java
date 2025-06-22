package com.berss.platform.support.domain.services;

import com.berss.platform.support.domain.model.aggregates.SupportMessage;
import com.berss.platform.support.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface SupportMessageQueryService {

    /**
     * Obtiene un mensaje de soporte por su ID.
     */
    Optional<SupportMessage> handle(GetSupportMessageByIdQuery query);

    /**
     * Obtiene todos los mensajes de soporte.
     */
    List<SupportMessage> handle(GetAllSupportMessagesQuery query);

    /**
     * Obtiene los mensajes de soporte por ID de compañía.
     */
    List<SupportMessage> handle(GetSupportMessagesByCompanyIdQuery query);

    /**
     * Obtiene los mensajes por estado (SupportStatus).
     */
    List<SupportMessage> handle(GetSupportMessagesByStatusQuery query);
}
