package service;

import java.util.Map;

public class ConvertCurrency {
    private String defaultCurrency = "USD";

    // Hardcoded exchange rates relative to USD
    private static final Map<String, Double> exchangeRates = Map.of(
            "USD", 1.0,
            "EUR", 0.92,
            "GBP", 0.79,
            "JPY", 136.5,
            "INR", 83.3,
            "CAD", 1.34
    );

    public void setDefaultCurrency(String currency) {
        if (exchangeRates.containsKey(currency)) {
            this.defaultCurrency = currency;
        } else {
            throw new IllegalArgumentException("Unsupported currency: " + currency);
        }
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Unsupported currency conversion.");
        }

        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);
        return amount * (toRate / fromRate);
    }

    public double convertToDefault(double amount, String fromCurrency) {
        return convert(amount, fromCurrency, defaultCurrency);
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }
}



