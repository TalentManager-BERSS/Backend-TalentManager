package com.berss.platform.business.domain.model.commands;

/**
 * Command to delete a manager.
 * @param managerId the manager id.
 *                  Cannot be null or less than 1
 */
public record DeleteManagerCommand(Long managerId) {
    /**
     * Constructor
     * @param managerId the manager id.
     *                  Cannot be null or less than 1
     * @throws IllegalArgumentException if managerId is null or less than 1
     */
    public DeleteManagerCommand {
        if (managerId == null || managerId <= 0) {
            throw new IllegalArgumentException("managerId cannot be null or less than 1");
        }
    }
}
