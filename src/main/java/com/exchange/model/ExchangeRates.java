package com.exchange.model;

import com.google.gson.annotations.SerializedName;

public class ExchangeRates {
  @SerializedName("base_code")
  private String base;
  @SerializedName("conversion_rates")
  private Rates rates;

  public String getBase() {
    return base;
  }

  public Rates getRates() {
    return rates;
  }

  public void printRates() {
    System.out.println("USD: " + rates.getUSD());
    System.out.println("BRL: " + rates.getBRL());
    System.out.println("EUR: " + rates.getEUR());
    System.out.println("JPY: " + rates.getJPY());
  }

  public double convert(double amount, String targetCurrency) {
    double conversionRate;
    switch (targetCurrency) {
      case "USD":
        conversionRate = rates.getUSD();
        break;
      case "BRL":
        conversionRate = rates.getBRL();
        break;
      case "EUR":
        conversionRate = rates.getEUR();
        break;
      case "JPY":
        conversionRate = rates.getJPY();
        break;
      default:
        throw new IllegalArgumentException("Moeda de destino inválida.");
    }
    return amount * conversionRate;
  }
}
