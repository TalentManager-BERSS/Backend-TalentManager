package com.berss.platform.employees.domain.services;

import com.berss.platform.employees.domain.model.aggregates.Employee;
import com.berss.platform.employees.domain.model.commands.CreateEmployeeCommand;
import com.berss.platform.employees.domain.model.commands.DeleteEmployeeCommand;
import com.berss.platform.employees.domain.model.commands.UpdateEmployeeCommand;

import java.util.Optional;

public interface EmployeeCommandService {
    Long handle(CreateEmployeeCommand command);

    Optional<Employee> handle(UpdateEmployeeCommand command);

    void handle(DeleteEmployeeCommand command);


}
