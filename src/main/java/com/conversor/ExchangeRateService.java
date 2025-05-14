package com.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.concurrent.TimeUnit;

public class ExchangeRateService {
    private final OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();

    public double getExchangeRate(String from, String to) {
        String url = "https://api.apilayer.com/exchangerates_data/latest?base=" + from + "&symbols=" + to;

        Request request = new Request.Builder()
                .url(url)
                .addHeader("apikey", "71QYYh35r0Bd9eV5VJerLe9tax5EL5QT")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String jsonData = response.body().string();
                JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();

                if (jsonObject.has("rates")) {
                    JsonObject rates = jsonObject.getAsJsonObject("rates");
                    if (rates.has(to)) {
                        return rates.get(to).getAsDouble();
                    }
                }
            } else {
                System.out.println("Falha na requisição: " + response.code());
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar taxa: " + e.getMessage());
        }

        return -1;
    }
}
