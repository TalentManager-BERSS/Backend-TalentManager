package com.berss.platform.business.domain.services;

import com.berss.platform.business.domain.model.aggregates.Manager;
import com.berss.platform.business.domain.model.queries.GetAllManagersQuery;
import com.berss.platform.business.domain.model.queries.GetManagerByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ManagerQueryService {
    Optional<Manager> handle(GetManagerByIdQuery query);
    List<Manager> handle(GetAllManagersQuery query);
}
