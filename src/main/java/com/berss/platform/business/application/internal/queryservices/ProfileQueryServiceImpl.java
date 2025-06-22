package com.berss.platform.business.application.internal.queryservices;

import com.berss.platform.business.domain.model.aggregates.Profile;
import com.berss.platform.business.domain.model.queries.GetAllProfilesQuery;
import com.berss.platform.business.domain.model.queries.GetProfileByIdQuery;
import com.berss.platform.business.domain.services.ProfileQueryService;
import com.berss.platform.business.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Profile query service.
 * Handles queries for retrieving profiles.
 */
@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    /**
     * Constructor.
     *
     * @param profileRepository the profile repository
     */
    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.profileId());
    }

    @Override
    public List<Profile> handle(GetAllProfilesQuery query) {
        return profileRepository.findAll();
    }
}
