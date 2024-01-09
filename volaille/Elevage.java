package com.volaille.volaille;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe {@code Elevage} représente un élevage de volailles.
 * Elle contient des méthodes pour enregistrer de jeunes animaux, trier les animaux
 * à abattre en fonction de leur poids, et évaluer le prix obtenu pour les animaux à abattre.
 *
 * @author Armand Girard
 * @author Raphael Gaudin
 * @version 1.0
 */
public class Elevage {
    /**
     * La liste des volailles dans l'élevage.
     */
    private List<Volaille> animaux;
    private int prochainID;

    private List<Canard> canardsAAbattre;
    private List<Canard> canardsSousPoidsAbattage;

    private List<Poulet> pouletsAAbattre;
    private List<Poulet> pouletsSousPoidsAbattage;

    /**
     * Construit une nouvelle instance de la classe {@code Elevage}.
     * Initialise la liste des volailles.
     */
    public Elevage() {
        this.animaux = new ArrayList<>();
        this.prochainID = 1;

        this.canardsAAbattre = new ArrayList<>();
        this.canardsSousPoidsAbattage = new ArrayList<>();

        this.pouletsAAbattre = new ArrayList<>();
        this.pouletsSousPoidsAbattage = new ArrayList<>();
    }

    public List<Canard> getCanardsAAbattre() {
        return canardsAAbattre;
    }

    public List<Canard> getCanardsSousPoidsAbattage() {
        return canardsSousPoidsAbattage;
    }

    public List<Poulet> getPouletsAAbattre() {
        return pouletsAAbattre;
    }

    public List<Poulet> getPouletsSousPoidsAbattage() {
        return pouletsSousPoidsAbattage;
    }

    public void ajouterCanardAAbattre(Canard canard) { canardsAAbattre.add(canard); }

    public void ajouterCanardSousPoidsAbattage(Canard canard) {
        canardsSousPoidsAbattage.add(canard);
    }

    public void ajouterPouletAAbattre(Poulet poulet) { pouletsAAbattre.add(poulet); }

    public void ajouterPouletSousPoidsAbattage(Poulet poulet) {
        pouletsSousPoidsAbattage.add(poulet);
    }

    public void afficherCanardsAAbattre() {
        System.out.println("Canards à abattre :");
        for (Canard canard : canardsAAbattre) {
            System.out.println("ID: " + canard.getNumeroIdentification());
        }
    }

    public void afficherVolaillesAAbattre() {
        System.out.println("IDS des Volailles à abattre : ");
        for (Canard canard : canardsAAbattre) {
            System.out.println(canard.getNumeroIdentification());
        }
        for (Poulet poulet : pouletsAAbattre) {
            System.out.println(poulet.getNumeroIdentification());
        }
    }

    public void afficherPouletsAAbattre() {
        System.out.println("Poulets à abattre :");
        for (Poulet poulet : pouletsAAbattre) {
            System.out.println("ID: " + poulet.getNumeroIdentification());
        }
    }

    public void afficherCanardsSousPoidsAbattage() {
        System.out.println("Canards sous poids d'abattage :");
        for (Canard canard : canardsSousPoidsAbattage) {
            System.out.println("ID: " + canard.getNumeroIdentification());
        }
    }

    public void afficherPouletsSousPoidsAbattage() {
        System.out.println("Poulets sous poids d'abattage :");
        for (Poulet poulet : pouletsSousPoidsAbattage) {
            System.out.println("ID: " + poulet.getNumeroIdentification());
        }
    }

    public void afficherVolaillesSousPoidsAbattage() {
        System.out.println("IDS des Volailles sous le poids d'abattage : ");
        for (Canard canard : canardsSousPoidsAbattage) {
            System.out.println(canard.getNumeroIdentification());
        }
        for (Poulet poulet : pouletsSousPoidsAbattage) {
            System.out.println(poulet.getNumeroIdentification());
        }
    }

    /**
     * Enregistre une volaille jeune qui arrive dans l'élevage.
     *
     * @param volaille La volaille à enregistrer.
     */
    public void enregistrerVolaille(Volaille volaille) {
        animaux.add(volaille);
    }

    /**
     * Supprime une volaille de l'élevage.
     *
     * @param volaille La volaille à supprimer.
     */
    public void supprimerVolaille(Volaille volaille) {
        animaux.remove(volaille);
    }

    /**
     * Évalue le prix total obtenu pour les animaux à abattre en fonction du prix du jour.
     *
     * @param prixKilo Le prix du kilo pour le calcul du prix total.
     * @param prixAbattage Le prix de l'abattage pour le calcul du prix total.
     * @return Le prix total des animaux à abattre.
     */
    /*public double evaluerPrixAnimauxAAbattre(double prixKilo, double prixAbattage) {
        double prixTotal = 0.0;
        for (Volaille volaille : animaux) {
            prixTotal += volaille.calculerPrix(prixKilo);
            prixTotal -= prixAbattage;
        }
        return prixTotal;
    }*/
    public double evaluerPrixAnimauxAAbattre(double prixKilo, double prixAbattage) {
        double prixTotal = 0.0;
        for (Volaille volaille : animaux) {
            prixTotal += volaille.calculerPrix(prixKilo);
        }
        prixTotal -= prixAbattage * animaux.size(); // Soustraction du prix d'abattage une fois après la boucle
        return prixTotal;
    }


    public Volaille[] getAnimaux() {
        return animaux.toArray(new Volaille[0]);
    }

    public int getProchainID() {
        return prochainID++;
    }
}
