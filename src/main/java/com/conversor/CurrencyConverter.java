package com.conversor;

public class CurrencyConverter {
    private final ExchangeRateService service = new ExchangeRateService();

    public void convert(String from, String to, double amount) {
        System.out.printf("Convertendo %.2f de %s para %s...\n", amount, from, to);
        double rate = service.getExchangeRate(from, to);
        if (rate > 0) {
            double result = amount * rate;
            System.out.printf("%.2f %s = %.2f %s\n", amount, from, result, to);
        } else {
            System.out.println("Erro ao converter moedas. Verifique a conexão ou o código das moedas.");
        }
    }
}
