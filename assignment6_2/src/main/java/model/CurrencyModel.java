package model;


import java.util.*;

public class CurrencyModel {
    private final List<Currency> currencies = new ArrayList<>();

    public CurrencyModel() {
        // Hardcoded
        currencies.add(new Currency("USD", "US Dollar", 1.0));
        currencies.add(new Currency("EUR", "Euro", 0.94));
        currencies.add(new Currency("GBP", "British Pound", 0.82));
        currencies.add(new Currency("JPY", "Japanese Yen", 149.0));
    }

    public List<Currency> getCurrencies() {
        return Collections.unmodifiableList(currencies);
    }

    public double convert(double amount, Currency from, Currency to) {
        double amountInUSD = amount / from.getRateToUSD();
        return amountInUSD * to.getRateToUSD();
    }
}
