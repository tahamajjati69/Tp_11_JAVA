package com.example.tp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String sample = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                      + "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

        WordManager manager = new WordManager(sample);
        manager.parseText();
        manager.displayAll();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\n> Entrer un mot à rechercher (ou 'exit') : ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) break;

            boolean found = manager.contains(input);
            System.out.printf("Présence de '%s' ? %b%n", input, found);

            System.out.print("Souhaitez-vous supprimer ce mot ? (y/n) ");
            String confirm = scanner.nextLine().trim();
            if (confirm.equalsIgnoreCase("y")) {
                boolean removed = manager.remove(input);
                System.out.printf(removed
                    ? "Le mot '%s' a été supprimé.%n"
                    : "Le mot '%s' n'existait pas.%n", input);
                manager.displayAll();
            }
        }
        scanner.close();
        System.out.println("Fin du programme.");
    }
}