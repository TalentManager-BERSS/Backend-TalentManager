package com.berss.platform.employees.infrastructure.persistence.jpa.repositories;

import com.berss.platform.employees.domain.model.aggregates.Employee;
import com.berss.platform.employees.domain.model.valueobjects.EmployeeName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByName(Long id);
    boolean existsByNameAndIdIsNot(EmployeeName name, Long id);

}
