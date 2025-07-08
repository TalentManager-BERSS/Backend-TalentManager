package com.berss.platform.shared.domain.model.valueobjects;

import java.time.LocalDate;
import java.util.Objects;

public record SpecificDate (
       int day,
       int month,
       int year
)
{

    public SpecificDate(int day, int month, int year) {
        if (year < 2000 || year > 2100)
            throw new IllegalArgumentException("Year must be between 2000 and 2100");

        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Month must be between 1 and 12");

        if (day < 1 || day > daysInMonth(month, year))
            throw new IllegalArgumentException("Day is invalid for the given month and year");

        this.day = day;
        this.month = month;
        this.year = year;
    }

    private int daysInMonth(int month, int year) {
        return switch (month) {
            case 2 -> isLeapYear(year) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public int day() {
        return day;
    }

    public int month() {
        return month;
    }

    public int year() {
        return year;
    }

    @Override
    public String toString() {
        return "%02d-%02d-%04d".formatted(day, month, year);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpecificDate that)) return false;
        return day == that.day && month == that.month && year == that.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    public LocalDate toLocalDate() {
        return LocalDate.of(this.year, this.month, this.day);
    }
}
