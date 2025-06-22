package com.berss.platform.support.domain.model.entities;

import com.berss.platform.support.domain.model.valueobjects.SupportStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private SupportStatus name;

    public Status(SupportStatus name) {
        this.name = name;
    }

    public String getStringName() {
        return name.name();
    }

    public static Status getDefaultStatus() {
        return new Status(SupportStatus.PENDING);
    }


    /**
     * Validate the role set
     * <p>
     *     This method validates the role set and returns the default role if the set is empty.
     * </p>
     * @param supportstatus the status set
     * @return the role set
     */
    public static List<Status> validateStatusSet(List<Status> supportstatus) {
        if (supportstatus == null || supportstatus.isEmpty()) {
            return List.of(getDefaultStatus());
        }
        return supportstatus;
    }
}
