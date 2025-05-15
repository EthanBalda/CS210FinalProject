package model;

import java.time.LocalDate;

public class ExpenseCategory {
    private String name;
    private boolean isCustom;

    public ExpenseCategory(String name, boolean isCustom) {
        this.name = name;
        this.isCustom = isCustom;
    }

    public LocalDate nextDueDate(int intervalDays) {
        return LocalDate.now().plusDays(intervalDays);
    }

    public LocalDate setDueDate(int daysFromNow) {
        return LocalDate.now().plusDays(daysFromNow);
    }

    public void applyCategoryToExpense(Expense expense) {
        // Logic for categorizing an expense, if needed
    }

    public void setCurrencyPreference(String preferredCurrency) {
        // Logic to store or apply preferred currency
    }

    public String getName() { return name; }
}