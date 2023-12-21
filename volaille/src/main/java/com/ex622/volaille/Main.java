package com.ex622.volaille;

import java.util.Scanner;

/**
 * La classe {@code Main} est la classe principale du programme. Elle contient le point d'entrée
 * pour exécuter le programme d'élevage de volailles.
 *
 * @author Armand Girard
 * @author Raphael Gaudin
 * @version 1.0
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

        System.out.print("Entrez le prix du kilo: ");
        double prixKilo = scanner.nextDouble();

        System.out.print("Entrez le prix de l'abattage: ");
        double prixAbattage = scanner.nextDouble();

        System.out.println("Combien de volailles voulez-vous enregistrer?");
        int nbVolailles = scanner.nextInt();

        for (int i = 0; i < nbVolailles; i++) {
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

        // Demander à l'utilisateur d'entrer un poids
        System.out.print("Entrez le poids pour filtrer les volailles: ");
        double poidsFiltre = scanner.nextDouble();

        // Affichage des volailles avec un poids supérieur ou égal au poids entré
        System.out.println("Volailles avec un poids supérieur ou égal à " + poidsFiltre + " kg:");
        for (Volaille volaille : elevage.getAnimaux()) {
            if (volaille.getPoids() >= poidsFiltre) {
                String typeVolaille = volaille instanceof Poulet ? "Poulet" : "Canard";
                System.out.println("Type: " + typeVolaille + ", ID: " + volaille.getNumeroIdentification() + ", Poids: " + volaille.getPoids());
            }
        }

        // Affichage des informations des volailles
        System.out.println("Volailles enregistrées :");
        for (Volaille volaille : elevage.getAnimaux()) {
            System.out.println("ID: " + volaille.getNumeroIdentification() + ", Poids: " + volaille.getPoids());
        }

        // Trier les animaux à abattre
        elevage.trierAnimauxAAbattre();
        System.out.println("Volailles triées pour l'abattage.");

        // Évaluation du prix total des animaux à abattre
        double prixTotal = elevage.evaluerPrixAnimauxAAbattre(prixKilo, prixAbattage);
        System.out.println("Prix total pour l'abattage : " + prixTotal + " euros");

        scanner.close();
    }
}
