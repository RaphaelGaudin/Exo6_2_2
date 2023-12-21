package com.ex622.volaille;

import java.util.Scanner;

/**
 * La classe {@code Main} est la classe principale du programme. Elle contient le point d'entrée
 * pour exécuter le programme d'élevage de volailles.
 *
 * @author Armand Girard
 * @author Raphael Gaudin
 * @version 1.1
 */
public class Main {
    /**
     * Le point d'entrée principal du programme.
     *
     * @param args Les arguments de la ligne de commande (non utilisés dans cet exemple).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Création de l'élevage
        Elevage elevage = new Elevage();

        // Démarrage du programme
        System.out.print("Entrez le prix du kilo: ");
        double prixKilo = scanner.nextDouble();

        System.out.print("Entrez le prix de l'abattage: ");
        double prixAbattage = scanner.nextDouble();

        String quit = null;
        String choice = null;

        do {
            System.out.println("Que voulez-vous faire ? (q pour quitter)");
            System.out.println("Pour ajouter des volailles tapez 1");
            System.out.println("Pour afficher les volailles à abattre tapez 2");
            System.out.println("Pour afficher les volailles tapez 3");
            System.out.println("Pour calculer le prix total tapez 4");
            choice = scanner.next();

            switch (choice) {
                case "q":
                    quit = "q";
                    break;
                case "1":
                    ajouterVolaille(elevage, scanner);
                    scanner.nextLine();
                    break;
                case "2":
                    afficherVolaillesTriees(elevage);
                    scanner.nextLine();
                    break;
                case "3":
                    afficherVolailles(elevage);
                    scanner.nextLine();
                    break;
                case "4":
                    afficherPrixTotal(elevage, prixKilo, prixAbattage);
                    scanner.nextLine();
                    break;

                default:
                    break;
            }
        } while (quit != "q");

        scanner.close();
    }

    public static void ajouterVolaille(Elevage elevage, Scanner scanner) {
        System.out.print("Entrez le type de volaille (poulet ou canard): ");
        String choice = scanner.next();

        if (choice.equals("poulet")) {
            System.out.println("Entrez le numéro d'identification: ");
            int id = scanner.nextInt();
            System.out.println("Entrez le poids en kilos: ");
            double poids = scanner.nextDouble();
            elevage.enregistrerVolaille(new Poulet(id, poids));
        } else if (choice.equals("canard")) {
            System.out.println("Entrez le numéro d'identification: ");
            int id = scanner.nextInt();
            System.out.print("Entrez le poids: ");
            double poids = scanner.nextDouble();
            elevage.enregistrerVolaille(new Canard(id, poids));
        } else {
            System.out.println("Erreur: type de volaille invalide.");
        }
    }

    public static void afficherVolaillesTriees(Elevage elevage) {
        // Affichage des volailles triées par poids
        System.out.println("Volailles triées par poids :");
        for (Volaille volaille : elevage.getAnimaux()) {
            String typeVolaille = volaille instanceof Poulet ? "Poulet" : "Canard";
            System.out.println("Type: " + typeVolaille + ", ID: " + volaille.getNumeroIdentification() + ", Poids: " + volaille.getPoids());
        }
    }

    public static void afficherVolailles(Elevage elevage) {
        // Affichage de toutes les volailles
        System.out.println("Volailles:");
        for (Volaille volaille : elevage.getAnimaux()) {
            String typeVolaille = volaille instanceof Poulet ? "Poulet" : "Canard";
            System.out.println("Type: " + typeVolaille + ", ID: " + volaille.getNumeroIdentification() + ", Poids: " + volaille.getPoids());
        }
    }

    public static void afficherPrixTotal(Elevage elevage, double prixKilo, double prixAbattage) {
        // Évaluation du prix total des animaux à abattre
        double prixTotal = elevage.evaluerPrixAnimauxAAbattre(prixKilo, prixAbattage);
        System.out.println("Prix total pour l'abattage : " + prixTotal + " euros");
    }
}
