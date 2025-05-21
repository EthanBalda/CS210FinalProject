package model;

import java.time.LocalDate;

public class ExpenseCategory {
    private String name;
    private boolean isCustom;
    private String preferredCurrency;

    public ExpenseCategory(String name, boolean isCustom) {
        this.name = name;
        this.isCustom = isCustom;
        this.preferredCurrency = "USD";
    }

    public LocalDate nextDueDate(int intervalDays) {
        if (intervalDays <= 0) {
            throw new IllegalArgumentException("Interval must be positive.");
        }
        return LocalDate.now().plusDays(intervalDays);
    }

    public LocalDate setDueDate(int daysFromNow) {
        if (daysFromNow < 0) {
            throw new IllegalArgumentException("Days from now must not be negative.");
        }
        return LocalDate.now().plusDays(daysFromNow);
    }

    public void applyCategoryToExpense(Expense expense) {
        System.out.println("Applied category '" + name + "' to expense: " + expense.getDescription());
    }

    public void setCurrencyPreference(String preferredCurrency) {
        if (preferredCurrency != null && !preferredCurrency.isBlank()) {
            this.preferredCurrency = preferredCurrency;
        }
    }

    public String getName() {
        return name;
    }

    public String getPreferredCurrency() {
        return preferredCurrency;
    }
}