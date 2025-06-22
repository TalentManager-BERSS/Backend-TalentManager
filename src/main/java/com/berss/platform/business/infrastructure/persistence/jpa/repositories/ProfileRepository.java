package com.berss.platform.business.infrastructure.persistence.jpa.repositories;

import com.berss.platform.business.domain.model.aggregates.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * ProfileRepository
 * <p>This interface is used to interact with the database and perform CRUD operations
 * and business queries related to the Profile aggregate.</p>
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    /**
     * Checks if a profile exists with the given company email.
     * @param email The email to check.
     * @return true if a profile exists with the given email in its company, false otherwise.
     */
    boolean existsByCompany_Email(String email);

    /**
     * Finds a profile by company email.
     * @param email The email to search for.
     * @return An Optional containing the profile if found, or empty if not found.
     */
    Optional<Profile> findByCompany_Email(String email);

    /**
     * Checks if a profile with the same company email exists but with a different id.
     * Useful for validating uniqueness when updating.
     * @param email The email to check.
     * @param id The id to exclude from the search.
     * @return true if such a profile exists, false otherwise.
     */
    boolean existsByCompany_EmailAndIdIsNot(String email, Long id);
}
