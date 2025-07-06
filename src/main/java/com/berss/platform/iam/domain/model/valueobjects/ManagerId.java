package com.berss.platform.iam.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
public class ManagerId {

    @Getter
    private Long value;

    protected ManagerId() {
    }

    public ManagerId(Long value) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("ManagerId must be a positive number.");
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ManagerId)) return false;
        ManagerId that = (ManagerId) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
