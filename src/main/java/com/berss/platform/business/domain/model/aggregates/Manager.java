package com.berss.platform.business.domain.model.aggregates;

import com.berss.platform.business.domain.model.commands.CreateManagerCommand;
import com.berss.platform.business.domain.model.commands.UpdateManagerNameCommand;
import com.berss.platform.business.domain.model.entities.Company;
import com.berss.platform.business.domain.model.valueobjects.CompanyStatus;
import com.berss.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Manager extends AuditableAbstractAggregateRoot<Manager> {

    @NotBlank
    private String firstname;

    private String lastname;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    public Manager() {}

    public Manager(CreateManagerCommand command) {
        this.firstname = command.firstname();
        this.lastname = command.lastname();

        this.company = new Company(
                command.companyName(),
                command.companyDescription(),
                command.companyEmail(),
                CompanyStatus.ACTIVE
        );
    }

    public Manager(String firstname, String lastname, Company company) {
        this.firstname = firstname;
        this.lastname = lastname;

        this.company = company;
    }

    public void updateManager(UpdateManagerNameCommand command) {
        this.firstname = command.firstname();
        this.lastname = command.lastname();
    }
}
