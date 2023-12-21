package com.ex622.volaille;

public class Main {
    public static void main(String[] args) {
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

        // Évaluation du prix total des animaux à abattre
        double prixTotal = elevage.evaluerPrixAnimauxAAbattre(5.0); // Supposons que le prix du jour est 5 euros par kilo
        System.out.println("Prix total pour l'abattage : " + prixTotal + " euros");
    }
}