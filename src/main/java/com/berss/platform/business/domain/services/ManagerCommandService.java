package com.berss.platform.business.domain.services;

import com.berss.platform.business.domain.model.aggregates.Manager;
import com.berss.platform.business.domain.model.commands.CreateManagerCommand;
import com.berss.platform.business.domain.model.commands.UpdateManagerNameCommand;
import com.berss.platform.business.domain.model.commands.DeleteManagerCommand;

import java.util.Optional;

/**
 * ManagerCommandService
 * Service that handles manager commands
 */
public interface ManagerCommandService {

    /**
     * Handle a create manager command
     * @param command The create manager command containing the manager data
     * @return The ID of the created manager
     * @see CreateManagerCommand
     */
    Long handle(CreateManagerCommand command);

    /**
     * Handle an update manager name command
     * @param command The update manager name command containing the manager ID and new name
     * @see UpdateManagerNameCommand
     */
    void handle(UpdateManagerNameCommand command);

    /**
     * Handle a delete manager command
     * @param command The delete manager command containing the manager ID to delete
     * @see DeleteManagerCommand
     */
    void handle(DeleteManagerCommand command);

    /**
     * Optional: return the updated manager
     * @param command The update manager name command
     * @return Optional containing the updated manager if found
     */
    Optional<Manager> updateAndReturn(UpdateManagerNameCommand command);
}
