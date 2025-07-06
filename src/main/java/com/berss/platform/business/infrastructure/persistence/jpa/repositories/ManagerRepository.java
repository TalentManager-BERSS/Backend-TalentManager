package com.berss.platform.business.infrastructure.persistence.jpa.repositories;

import com.berss.platform.business.domain.model.aggregates.Manager;
import com.berss.platform.business.domain.model.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * ManagerRepository
 * <p>This interface is used to interact with the database and perform CRUD operations
 * and business queries related to the Manager aggregate.</p>
 */
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    /**
     * Checks if a manager exists with the given company email.
     * @param email The email to check.
     * @return true if a manager exists with the given email in its company, false otherwise.
     */
    boolean existsByCompany_Email(String email);

    /**
     * Finds a manager by company email.
     * @param email The email to search for.
     * @return An Optional containing the manager if found, or empty if not found.
     */
    Optional<Manager> findByCompany_Email(String email);

    /**
     * Checks if a manager with the same company email exists but with a different id.
     * Useful for validating uniqueness when updating.
     * @param email The email to check.
     * @param id The id to exclude from the search.
     * @return true if such a manager exists, false otherwise.
     */
    boolean existsByCompany_EmailAndIdIsNot(String email, Long id);

    Optional<Manager> findByCompanyNameAndCompanyEmail(String name, String email);
    Optional<Manager> findByCompanyId(Long companyId);
}
