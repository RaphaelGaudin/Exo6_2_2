package com.ex622.volaille;

public class Canard extends Volaille {
    public Canard(int numeroIdentification, double poids) {
        super(numeroIdentification, poids);
    }

    @Override
    public double calculerPrix(double prixDuJour) {
        return getPoids() * prixDuJour;
    }

    @Override
    public double getPoidsAbattage() {
        // Poids d'abattage spécifique pour les canards
        return 3.0;
    }
}
