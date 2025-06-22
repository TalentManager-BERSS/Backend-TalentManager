package com.berss.platform.business.domain.model.aggregates;

import com.berss.platform.business.domain.model.commands.CreateProfileCommand;
import com.berss.platform.business.domain.model.commands.UpdateProfileNameCommand;
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
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @NotBlank
    private String username;

    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    public Profile() {}

    public Profile(CreateProfileCommand command) {
        this.username = command.username();
        this.password = command.password(); // asegúrate de tener este campo en el comando

        this.company = new Company(
                command.companyName(),
                command.companyDescription(),
                command.companyEmail(),
                CompanyStatus.ACTIVE // o command.companyStatus() si se envía desde el cliente
        );
    }

    public void updateProfile(UpdateProfileNameCommand command) {
        this.username = command.username();
    }
}
