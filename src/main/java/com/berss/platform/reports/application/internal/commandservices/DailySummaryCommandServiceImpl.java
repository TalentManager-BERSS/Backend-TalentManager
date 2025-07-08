package com.berss.platform.reports.application.internal.commandservices;

import com.berss.platform.reports.domain.model.aggregates.DailySummary;
import com.berss.platform.reports.domain.model.commands.CreateDailySummaryCommand;
import com.berss.platform.reports.domain.model.commands.DeleteDailySummaryCommand;
import com.berss.platform.reports.domain.model.commands.UpdateDailySummaryCommand;
import com.berss.platform.reports.domain.services.DailySummaryCommandService;
import com.berss.platform.reports.infrastructure.persistence.jpa.repositories.DailySummaryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DailySummaryCommandServiceImpl implements DailySummaryCommandService {

    private final DailySummaryRepository repository;

    public DailySummaryCommandServiceImpl(DailySummaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long handle(CreateDailySummaryCommand command) {
        DailySummary summary = new DailySummary(
                command.employeeId(),
                command.companyId(),
                command.day(),
                command.month(),
                command.year(),
                command.entryTime(),
                command.exitTime(),
                command.inputAmount(),
                command.score()
        );
        return repository.save(summary).getId();
    }

    @Override
    public Optional<DailySummary> handle(UpdateDailySummaryCommand command) {
        var optional = repository.findById(command.dailySummaryId());
        if (optional.isEmpty()) return Optional.empty();

        var summary = optional.get();
        summary.updateEntryTime(command.entryTime());
        summary.updateExitTime(command.exitTime());
        summary.updateInput(command.inputAmount());
        summary.updateScore(command.score());

        return Optional.of(repository.save(summary));
    }

    @Override
    public void handle(DeleteDailySummaryCommand command) {
        repository.deleteById(command.dailySummaryId());
    }
}
