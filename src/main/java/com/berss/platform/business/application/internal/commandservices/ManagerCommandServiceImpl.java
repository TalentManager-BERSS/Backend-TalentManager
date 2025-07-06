package com.berss.platform.business.application.internal.commandservices;

import com.berss.platform.business.domain.model.aggregates.Manager;
import com.berss.platform.business.domain.model.commands.CreateManagerCommand;
import com.berss.platform.business.domain.model.commands.DeleteManagerCommand;
import com.berss.platform.business.domain.model.commands.UpdateManagerNameCommand;
import com.berss.platform.business.domain.model.entities.Company;
import com.berss.platform.business.domain.model.valueobjects.CompanyStatus;
import com.berss.platform.business.domain.services.ManagerCommandService;
import com.berss.platform.business.infrastructure.persistence.jpa.repositories.CompanyQueryRepository;
import com.berss.platform.business.infrastructure.persistence.jpa.repositories.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the ManagerCommandService interface.
 * <p>This class is responsible for handling the commands related to the Manager aggregate. It uses ManagerRepository.</p>
 * @see ManagerCommandService
 * @see ManagerRepository
 */
@Service
public class ManagerCommandServiceImpl implements ManagerCommandService {
    private final ManagerRepository managerRepository;
    private final CompanyQueryRepository companyQueryRepository;

    /**
     * Constructor for ManagerCommandServiceImpl.
     * @param managerRepository the repository used for accessing manager data.
     */
    public ManagerCommandServiceImpl(ManagerRepository managerRepository, CompanyQueryRepository companyQueryRepository) {
        this.managerRepository = managerRepository;
        this.companyQueryRepository = companyQueryRepository;
    }

    // inherit javadoc
    @Override
    public Long handle(CreateManagerCommand command) {
        Company company = companyQueryRepository.findByNameIgnoreCase(command.companyName())
                .orElseGet(() -> new Company(
                        command.companyName(),
                        command.companyEmail(),
                        command.companyDescription(),
                        CompanyStatus.ACTIVE
                ));

        var manager = new Manager(command.firstname(), command.lastname(), company);
        try {
            managerRepository.save(manager);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error saving manager: %s".formatted(e.getMessage()));
        }
        return manager.getId();
    }

    // inherit javadoc
    @Override
    public void handle(UpdateManagerNameCommand command) {
        var manager = managerRepository.findById(command.managerId())
                .orElseThrow(() -> new IllegalArgumentException("Manager with id %s not found".formatted(command.managerId())));
        try {
            manager.updateManager(command);
            managerRepository.save(manager);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating manager: %s".formatted(e.getMessage()));
        }
    }

    // inherit javadoc
    @Override
    public void handle(DeleteManagerCommand command) {
        if (!managerRepository.existsById(command.managerId())) {
            throw new IllegalArgumentException("Manager with id %s not found".formatted(command.managerId()));
        }
        try {
            managerRepository.deleteById(command.managerId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting manager: %s".formatted(e.getMessage()));
        }
    }

    // Optional return
    @Override
    public Optional<Manager> updateAndReturn(UpdateManagerNameCommand command) {
        var manager = managerRepository.findById(command.managerId());
        if (manager.isEmpty()) return Optional.empty();
        manager.get().updateManager(command);
        try {
            return Optional.of(managerRepository.save(manager.get()));
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating manager: %s".formatted(e.getMessage()));
        }
    }
}
