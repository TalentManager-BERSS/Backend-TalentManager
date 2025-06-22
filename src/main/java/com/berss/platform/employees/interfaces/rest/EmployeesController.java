package com.berss.platform.employees.interfaces.rest;

import com.berss.platform.employees.domain.model.commands.DeleteEmployeeCommand;
import com.berss.platform.employees.domain.model.queries.GetAllEmployeesQuery;
import com.berss.platform.employees.domain.model.queries.GetEmployeesByIdQuery;
import com.berss.platform.employees.domain.services.EmployeeCommandService;
import com.berss.platform.employees.domain.services.EmployeeQueryService;
import com.berss.platform.employees.interfaces.rest.resources.CreateEmployeeResource;
import com.berss.platform.employees.interfaces.rest.resources.EmployeeResource;
import com.berss.platform.employees.interfaces.rest.resources.UpdateEmployeeResource;
import com.berss.platform.employees.interfaces.rest.transform.CreateEmployeeCommandFromResourceAssembler;
import com.berss.platform.employees.interfaces.rest.transform.EmployeeResourceFromEntityAssembler;
import com.berss.platform.employees.interfaces.rest.transform.UpdateEmployeeCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/employees", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Employee", description = "Available Employee Endpoints")
public class EmployeesController {
    private final EmployeeCommandService employeeCommandService;
    private final EmployeeQueryService employeeQueryService;
    public EmployeesController(EmployeeCommandService employeeCommandService, EmployeeQueryService employeeQueryService) {
        this.employeeCommandService = employeeCommandService;
        this.employeeQueryService = employeeQueryService;
    }

    @PostMapping
    @Operation(summary = "Create a new employee", description = "Create a new employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Employee not found")})
    public ResponseEntity<EmployeeResource> createEmployee(@RequestBody CreateEmployeeResource resource) {
        var createCourseCommand = CreateEmployeeCommandFromResourceAssembler.toCommandFromResource(resource);
        var employeeId = employeeCommandService.handle(createCourseCommand);
        if (employeeId == null || employeeId == 0L) return ResponseEntity.badRequest().build();
        var getCourseByIdQuery = new GetEmployeesByIdQuery(employeeId);
        var employee = employeeQueryService.handle(getCourseByIdQuery);
        if (employee.isEmpty()) return ResponseEntity.notFound().build();
        var employeeEntity = employee.get();
        var employeeResource = EmployeeResourceFromEntityAssembler.toResourceFromEntity(employeeEntity);
        return new ResponseEntity<>(employeeResource, HttpStatus.CREATED);
    }

    @GetMapping("/{employeeId}")
    @Operation(summary = "Get employee by id", description = "Get employee by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee found"),
            @ApiResponse(responseCode = "404", description = "Employee not found")})
    public ResponseEntity<EmployeeResource> getEmployeeById(@PathVariable Long employeeId) {
        var getCourseByIdQuery = new GetEmployeesByIdQuery(employeeId);
        var employee = employeeQueryService.handle(getCourseByIdQuery);
        if (employee.isEmpty()) return ResponseEntity.notFound().build();
        var employeeEntity = employee.get();
        var employeeResource = EmployeeResourceFromEntityAssembler.toResourceFromEntity(employeeEntity);
        return ResponseEntity.ok(employeeResource);
    }

    @GetMapping
    @Operation(summary = "Get all employee", description = "Get all employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee found"),
            @ApiResponse(responseCode = "404", description = "Employee not found")})
    public ResponseEntity<List<EmployeeResource>> getAllEmployees() {
        var employee = employeeQueryService.handle(new GetAllEmployeesQuery());
        if (employee.isEmpty()) return ResponseEntity.notFound().build();
        var employeeResources = employee.stream()
                .map(EmployeeResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(employeeResources);
    }


    @PutMapping("/{employeeId}")
    @Operation(summary = "Update employee", description = "Update employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee updated"),
            @ApiResponse(responseCode = "404", description = "Employee not found")})
    public ResponseEntity<EmployeeResource> updateEmployee(@PathVariable Long employeeId, @RequestBody UpdateEmployeeResource resource) {
        var updateEmployeeCommand = UpdateEmployeeCommandFromResourceAssembler.toCommandFromResource(employeeId, resource);
        var updatedEmployee = employeeCommandService.handle(updateEmployeeCommand);
        if (updatedEmployee.isEmpty()) return ResponseEntity.notFound().build();
        var updatedEmployeeEntity = updatedEmployee.get();
        var updatedEmployeeResource = EmployeeResourceFromEntityAssembler.toResourceFromEntity(updatedEmployeeEntity);
        return ResponseEntity.ok(updatedEmployeeResource);
    }

    @DeleteMapping("/{employeeId}")
    @Operation(summary = "Delete employee", description = "Delete employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee deleted"),
            @ApiResponse(responseCode = "404", description = "Employee not found")})
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
        var deleteEmployeeCommand = new DeleteEmployeeCommand(employeeId);
        employeeCommandService.handle(deleteEmployeeCommand);
        return ResponseEntity.ok("Employee with given id successfully deleted");
    }
}
