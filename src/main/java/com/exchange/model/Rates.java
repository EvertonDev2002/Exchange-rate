package com.exchange.model;

import java.util.HashMap;
import java.util.Map;

public class Rates {
  private double USD;
  private double BRL;
  private double EUR;
  private double JPY;

  public double getUSD() {
    return USD;
  }

  public double getBRL() {
    return BRL;
  }

  public double getEUR() {
    return EUR;
  }

  public double getJPY() {
    return JPY;
  }

  public Map<String, Double> toMap() {
    Map<String, Double> ratesMap = new HashMap<>();
    ratesMap.put("USD", USD);
    ratesMap.put("BRL", BRL);
    ratesMap.put("EUR", EUR);
    ratesMap.put("JPY", JPY);
    return ratesMap;
  }
}
