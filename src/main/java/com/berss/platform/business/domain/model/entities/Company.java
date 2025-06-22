package com.berss.platform.business.domain.model.entities;

import com.berss.platform.business.domain.model.valueobjects.CompanyStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String email;

    @Enumerated(EnumType.STRING)
    private CompanyStatus status;

    public Company() {
    }

    public Company(String name, String description, String email, CompanyStatus status) {
        this.name = name;
        this.description = description;
        this.email = email;
        this.status = status;
    }

    // Getters

}
