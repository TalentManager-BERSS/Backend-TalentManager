package com.berss.platform.support.application.internal.queryservices;

import com.berss.platform.support.domain.model.aggregates.SupportMessage;
import com.berss.platform.support.domain.model.queries.*;
import com.berss.platform.support.domain.services.SupportMessageQueryService;
import com.berss.platform.support.infrastructure.persistence.jpa.repositories.SupportMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupportMessageQueryServiceImpl implements SupportMessageQueryService {

    private final SupportMessageRepository supportMessageRepository;

    public SupportMessageQueryServiceImpl(SupportMessageRepository supportMessageRepository) {
        this.supportMessageRepository = supportMessageRepository;
    }

    @Override
    public Optional<SupportMessage> handle(GetSupportMessageByIdQuery query) {
        return supportMessageRepository.findById(query.id());
    }

    @Override
    public List<SupportMessage> handle(GetAllSupportMessagesQuery query) {
        return supportMessageRepository.findAll();
    }

    @Override
    public List<SupportMessage> handle(GetSupportMessagesByCompanyIdQuery query) {
        return supportMessageRepository.findAll().stream()
                .filter(msg -> msg.getCompanyId() != null && msg.getCompanyId().companyId().equals(query.companyId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<SupportMessage> handle(GetSupportMessagesByStatusQuery query) {
        return supportMessageRepository.findAll().stream()
                .filter(msg -> msg.getStatus() != null && msg.getStatus().getName() == query.status())
                .collect(Collectors.toList());
    }
}
