package com.exchange.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;
import com.exchange.model.ExchangeRates;

public class ExchangeRateService {
  private static Dotenv dotenv = Dotenv.load();
  private static final String URL = dotenv.get("BASE_URL");
  private static final String API_KEY = dotenv.get("API_KEY");
  private static final String BASE_URL = URL + API_KEY + "/latest/";

  public static ExchangeRates getExchangeRates(String baseCurrency) throws Exception {
    URL url = new URL(BASE_URL + baseCurrency);
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");

    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    StringBuilder response = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
      response.append(line);
    }
    reader.close();

    Gson gson = new Gson();
    return gson.fromJson(response.toString(), ExchangeRates.class);
  }
}
