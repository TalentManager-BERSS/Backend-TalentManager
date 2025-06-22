package com.berss.platform.employees.application.internal.queryservices;

import com.berss.platform.employees.domain.model.aggregates.Employee;
import com.berss.platform.employees.domain.model.queries.GetAllEmployeesQuery;
import com.berss.platform.employees.domain.model.queries.GetEmployeesByIdQuery;
import com.berss.platform.employees.domain.services.EmployeeQueryService;
import com.berss.platform.employees.infrastructure.persistence.jpa.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeQueryServiceImpl implements EmployeeQueryService {
    private final EmployeeRepository employeeRepository;

    public EmployeeQueryServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // inherited javadoc
    @Override
    public Optional<Employee> handle(GetEmployeesByIdQuery query) {
        return employeeRepository.findById(query.employeeId());
    }

    // inherited javadoc
    @Override
    public List<Employee> handle(GetAllEmployeesQuery query) {
        return employeeRepository.findAll();
    }

}
