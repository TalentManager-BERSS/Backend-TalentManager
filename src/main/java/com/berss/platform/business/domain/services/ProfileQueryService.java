package com.berss.platform.business.domain.services;

import com.berss.platform.business.domain.model.aggregates.Profile;
import com.berss.platform.business.domain.model.queries.GetAllProfilesQuery;
import com.berss.platform.business.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByIdQuery query);
    List<Profile> handle(GetAllProfilesQuery query);
}
