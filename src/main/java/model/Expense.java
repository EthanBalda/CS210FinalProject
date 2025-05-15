package model;

import service.ConvertCurrency;

import java.util.List;

public class Expense {
    private double amount;
    private String description;
    private List<User> participants;
    private boolean paid;
    private String currency;

    private static final ConvertCurrency currencyConverter = new ConvertCurrency(); // shared instance


    public Expense(double amount, String description, List<User> participants, boolean paid, String currency) {
        this.amount = amount;
        this.description = description;
        this.participants = participants;
        this.paid = false;
        this.currency = currency;
    }

    public double calculateShare(User user) {
        if (!participants.contains(user) || participants.isEmpty()) return 0.0;
        double convertedAmount = currencyConverter.convertToDefault(amount, currency);
        return convertedAmount / participants.size();
    }

    public void markPaid() {
        this.paid = true;
    }

    public boolean filterExpenses(String keyword) {
        return description != null && description.toLowerCase().contains(keyword.toLowerCase());
    }

    public static void setDefaultCurrency(String defaultCurrency) {
        currencyConverter.setDefaultCurrency(defaultCurrency);
    }

    public static ConvertCurrency getCurrencyConverter() {
        return currencyConverter;
    }

    public List<User> getParticipants() { return participants; }
    public boolean isPaid() { return paid; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
}

