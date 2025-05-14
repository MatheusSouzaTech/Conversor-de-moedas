package com.conversor;

import java.util.Scanner;

public class CurrencyMenu {
    private final CurrencyConverter converter = new CurrencyConverter();
    private final Scanner scanner = new Scanner(System.in);

    public void show() {
        while (true) {
            System.out.println("\n--- Conversor de Moedas ---");
            System.out.println("1. USD -> BRL");
            System.out.println("2. EUR -> BRL");
            System.out.println("3. GBP -> BRL");
            System.out.println("4. JPY -> BRL");
            System.out.println("5. BRL -> USD");
            System.out.println("6. BRL -> EUR");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            String opcaoInput = scanner.nextLine();
            int opcao;
            try {
                opcao = Integer.parseInt(opcaoInput);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
                continue;
            }

            if (opcao == 0) break;

            System.out.print("Digite o valor: ");
            String valorInput = scanner.nextLine();
            double valor;
            try {
                valor = Double.parseDouble(valorInput);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido.");
                continue;
            }

            switch (opcao) {
                case 1 -> converter.convert("USD", "BRL", valor);
                case 2 -> converter.convert("EUR", "BRL", valor);
                case 3 -> converter.convert("GBP", "BRL", valor);
                case 4 -> converter.convert("JPY", "BRL", valor);
                case 5 -> converter.convert("BRL", "USD", valor);
                case 6 -> converter.convert("BRL", "EUR", valor);
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
