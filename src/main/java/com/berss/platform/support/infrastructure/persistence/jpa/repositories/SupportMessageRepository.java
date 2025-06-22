package com.berss.platform.support.infrastructure.persistence.jpa.repositories;

import com.berss.platform.support.domain.model.aggregates.SupportMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is responsible for providing the SupportMessage entity related operations.
 * It extends the JpaRepository interface.
 */
@Repository
public interface SupportMessageRepository extends JpaRepository<SupportMessage, Long> {

    boolean existsByContent(String content);  // Cambié a 'existsByContent'

}
