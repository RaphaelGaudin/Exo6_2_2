package com.ex622.volaille;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Elevage {
    private List<Volaille> animaux;

    public Elevage() {
        this.animaux = new ArrayList<>();
    }

    // Méthode pour enregistrer de jeunes animaux qui arrivent
    public void enregistrerVolaille(Volaille volaille) {
        animaux.add(volaille);
    }

    // Méthode pour trier les animaux à abattre en fonction de leur poids
    public void trierAnimauxAAbattre() {
        Collections.sort(animaux, Comparator.comparingDouble(Volaille::getPoids));
    }

    // Méthode pour évaluer le prix obtenu pour les animaux à abattre en fonction du prix du jour
    public double evaluerPrixAnimauxAAbattre(double prixDuJour) {
        double prixTotal = 0.0;
        for (Volaille volaille : animaux) {
            prixTotal += volaille.calculerPrix(prixDuJour);
        }
        return prixTotal;
    }
}