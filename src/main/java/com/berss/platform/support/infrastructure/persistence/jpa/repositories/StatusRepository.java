package com.berss.platform.support.infrastructure.persistence.jpa.repositories;

import com.berss.platform.support.domain.model.entities.Status;
import com.berss.platform.support.domain.model.valueobjects.SupportStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface is responsible for providing the Role entity related operations.
 * It extends the JpaRepository interface.
 */
@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    /**
     * This method is responsible for finding the role by name.
     * @param name The status name.
     * @return The status object.
     */
    Optional<Status> findByName(SupportStatus name);


    boolean existsByName(SupportStatus name);

}