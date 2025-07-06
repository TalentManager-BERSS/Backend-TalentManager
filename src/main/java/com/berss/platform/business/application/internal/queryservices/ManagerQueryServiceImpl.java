package com.berss.platform.business.application.internal.queryservices;

import com.berss.platform.business.domain.model.aggregates.Manager;
import com.berss.platform.business.domain.model.queries.GetAllManagersQuery;
import com.berss.platform.business.domain.model.queries.GetManagerByIdQuery;
import com.berss.platform.business.domain.services.ManagerQueryService;
import com.berss.platform.business.infrastructure.persistence.jpa.repositories.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Manager query service.
 * Handles queries for retrieving managers.
 */
@Service
public class ManagerQueryServiceImpl implements ManagerQueryService {

    private final ManagerRepository managerRepository;

    /**
     * Constructor.
     *
     * @param managerRepository the manager repository
     */
    public ManagerQueryServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public Optional<Manager> handle(GetManagerByIdQuery query) {
        return managerRepository.findById(query.managerId());
    }

    @Override
    public List<Manager> handle(GetAllManagersQuery query) {
        return managerRepository.findAll();
    }
}
