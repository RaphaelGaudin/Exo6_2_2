package com.ex622.volaille;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    /**
     * Construit une nouvelle instance de la classe {@code Elevage}.
     * Initialise la liste des volailles.
     */
    public Elevage() {
        this.animaux = new ArrayList<>();
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
     * Trie les animaux à abattre en fonction de leur poids.
     */
    public void trierAnimauxAAbattre() {
        Collections.sort(animaux, Comparator.comparingDouble(Volaille::getPoids));
    }

    /**
     * Évalue le prix total obtenu pour les animaux à abattre en fonction du prix du jour.
     *
     * @param prixKilo Le prix du kilo pour le calcul du prix total.
     * @param prixAbattage Le prix de l'abattage pour le calcul du prix total.
     * @return Le prix total des animaux à abattre.
     */
    public double evaluerPrixAnimauxAAbattre(double prixKilo, double prixAbattage) {
        double prixTotal = 0.0;
        for (Volaille volaille : animaux) {
            prixTotal += volaille.calculerPrix(prixKilo);
            prixTotal -= prixAbattage;
        }
        return prixTotal;
    }

    public Volaille[] getAnimaux() {
        return animaux.toArray(new Volaille[0]);
    }
}
