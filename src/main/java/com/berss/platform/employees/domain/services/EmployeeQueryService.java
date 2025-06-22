package com.berss.platform.employees.domain.services;

import com.berss.platform.employees.domain.model.queries.GetAllEmployeesQuery;
import com.berss.platform.employees.domain.model.queries.GetEmployeesByIdQuery;
import com.berss.platform.employees.domain.model.aggregates.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeQueryService {
    Optional<Employee> handle(GetEmployeesByIdQuery query);

    List<Employee> handle(GetAllEmployeesQuery query);
}
