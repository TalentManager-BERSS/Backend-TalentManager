package com.berss.platform.reports.application.internal.commandservices;

import com.berss.platform.reports.domain.model.aggregates.MonthlySummary;
import com.berss.platform.reports.domain.model.commands.CreateMonthlySummaryCommand;
import com.berss.platform.reports.domain.model.commands.DeleteMonthlySummaryCommand;
import com.berss.platform.reports.domain.model.commands.UpdateMonthlySummaryCommand;
import com.berss.platform.reports.domain.services.MonthlySummaryCommandService;
import com.berss.platform.reports.infrastructure.persistence.jpa.repositories.MonthlySummaryRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonthlySummaryCommandServiceImpl implements MonthlySummaryCommandService {

    private final MonthlySummaryRepository repository;

    public MonthlySummaryCommandServiceImpl(MonthlySummaryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long handle(CreateMonthlySummaryCommand command) {
        MonthlySummary summary = new MonthlySummary(
                command.employeeId(),
                command.companyId(),
                command.year(),
                command.month(),
                command.totalHours(),
                command.completedHours(),
                command.inputAmount(),
                command.score()
        );
        return repository.save(summary).getId();
    }

    @Override
    public Optional<MonthlySummary> handle(UpdateMonthlySummaryCommand command) {
        var optional = repository.findById(command.monthlySummaryId());
        if (optional.isEmpty()) return Optional.empty();

        var summary = optional.get();
        summary.updateTotalHours(command.totalHours());
        summary.updateCompletedHours(command.completedHours());
        summary.updateInput(command.inputAmount());
        summary.updateScore(command.score());

        return Optional.of(repository.save(summary));
    }

    @Override
    public void handle(DeleteMonthlySummaryCommand command) {
        repository.deleteById(command.monthlySummaryId());
    }
}
