package com.ex622.volaille;

public class Poulet extends Volaille {
    public Poulet(int numeroIdentification, double poids) {
        super(numeroIdentification, poids);
    }

    @Override
    public double calculerPrix(double prixDuJour) {
        return getPoids() * prixDuJour;
    }

    @Override
    public double getPoidsAbattage() {
        // Poids d'abattage spécifique pour les poulets
        return 2.5;
    }
}
