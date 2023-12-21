package com.ex622.volaille;

import java.util.Scanner;

/**
 * La classe {@code Main} est la classe principale du programme. Elle contient le point d'entrée
 * pour exécuter le programme d'élevage de volailles.
 *
 * @author Armand Girard & Raphael Gaudin
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

        // Enregistrement de quelques volailles
        elevage.enregistrerVolaille(new Poulet(101, 2.0));
        elevage.enregistrerVolaille(new Poulet(102, 2.6));
        elevage.enregistrerVolaille(new Canard(201, 3.5));
        elevage.enregistrerVolaille(new Canard(202, 3.2));

        // Affichage des informations des volailles
        System.out.println("Volailles enregistrées :");
        for (Volaille volaille : elevage.getAnimaux()) {
            System.out.println("ID: " + volaille.getNumeroIdentification() + ", Poids: " + volaille.getPoids());
        }

        // Trier les animaux à abattre
        elevage.trierAnimauxAAbattre();
        System.out.println("Volailles triées pour l'abattage.");

        
        /*System.out.print("Entrez le prix du kilo du poulet : ");
        double prixKiloPoulet = scanner.nextDouble();

        System.out.print("Entrez le prix de l'abattage du poulet: ");
        double prixAbattagePoulet = scanner.nextDouble();

        System.out.print("Entrez le prix du kilo du canard: ");
        double prixKiloCanard = scanner.nextDouble();

        System.out.print("Entrez le prix de l'abattage du canard: ");
        double prixAbattageCanard = scanner.nextDouble();*/

        System.out.print("Entrez le prix du kilo: ");
        double prixKilo = scanner.nextDouble();

        System.out.print("Entrez le prix de l'abattage: ");
        double prixAbattage = scanner.nextDouble();

        // Évaluation du prix total des animaux à abattre
        double prixTotal = elevage.evaluerPrixAnimauxAAbattre(prixKilo, prixAbattage);
        System.out.println("Prix total pour l'abattage : " + prixTotal + " euros");

        scanner.close();
    }
}
