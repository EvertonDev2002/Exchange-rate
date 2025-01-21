package com.exchange;

import com.exchange.model.ExchangeRates;
import com.exchange.service.ExchangeRateService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Conversor de Moedas!");

        try {
            System.out.print("Escolha a moeda base (USD, BRL, EUR, JPY): ");
            String baseCurrency = scanner.nextLine().toUpperCase();

            ExchangeRates exchangeRates = ExchangeRateService.getExchangeRates(baseCurrency);

            System.out.println("Taxas de câmbio atualizadas para a moeda base: " + exchangeRates.getBase());
            exchangeRates.printRates();

            while (true) {
                System.out.println("\nEscolha uma opção:");
                int optionIndex = 1;
                Map<Integer, String> menuOptions = new HashMap<>();

                for (Map.Entry<String, Double> entry : exchangeRates
                        .getRates().toMap()
                        .entrySet()) {
                    String currency = entry.getKey();
                    if (!currency.equals(baseCurrency)) {
                        System.out.printf("%d. Converter de %s para %s\n",
                                optionIndex,
                                baseCurrency,
                                currency);
                        menuOptions.put(optionIndex, currency);
                        optionIndex++;
                    }
                }
                System.out.println(optionIndex + ". Sair");
                menuOptions.put(optionIndex, "EXIT");

                System.out.print("Escolha uma opção: ");
                int option = scanner.nextInt();

                if (menuOptions.get(option).equals("EXIT")) {
                    System.out.println("Encerrando o programa...");
                    break;
                }

                String targetCurrency = menuOptions.get(option);

                System.out.print("Digite o valor a ser convertido: ");
                double amount = scanner.nextDouble();

                double convertedAmount = exchangeRates.convert(
                        amount,
                        targetCurrency);

                System.out.printf("%.2f %s equivalem a %.2f %s\n",
                        amount,
                        baseCurrency,
                        convertedAmount,
                        targetCurrency);
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
