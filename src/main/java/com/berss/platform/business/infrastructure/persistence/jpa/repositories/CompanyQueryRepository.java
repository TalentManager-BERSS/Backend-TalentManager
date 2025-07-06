package com.berss.platform.business.infrastructure.persistence.jpa.repositories;

import com.berss.platform.business.domain.model.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyQueryRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByNameIgnoreCase(String name);
    Optional<Company> findByName(String name);
}
