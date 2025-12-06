package com.example.tp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskManager mgr = new TaskManager();

        // 1. Création de tâches
        mgr.addTask("Écrire la doc", 2);
        mgr.addTask("Corriger les bugs", 1);
        mgr.addTask("Préparer démo", 3);
        mgr.addTask("Envoyer emails", 4);

        // 2. Affichage initial
        System.out.println("=== Toutes les tâches ===");
        mgr.listTasks().forEach(System.out::println);
        System.out.println();

        // 3. Tri par priorité
        System.out.println("=== Trier par priorité ===");
        mgr.sortByPriority();
        mgr.listTasks().forEach(System.out::println);
        System.out.println();

        // 4. Mise à jour de statut
        System.out.println("=== Tâche #2 en cours ===");
        mgr.updateStatus(2, Status.IN_PROGRESS);
        mgr.listTasks().forEach(System.out::println);
        System.out.println();

        // 5. Filtrage
        System.out.println("=== Filtrer PENDING ===");
        List<Task> pending = mgr.filterByStatus(Status.PENDING);
        pending.forEach(System.out::println);
        System.out.println();

        // 6. Suppression
        System.out.println("=== Supprimer tâche #1 ===");
        mgr.removeTask(1);
        mgr.listTasks().forEach(System.out::println);
    }
}