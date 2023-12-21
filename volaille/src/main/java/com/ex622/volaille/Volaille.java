package com.ex622.volaille;

abstract class Volaille {
    private int numeroIdentification;
    private double poids;

    public Volaille(int numeroIdentification, double poids) {
        this.numeroIdentification = numeroIdentification;
        this.poids = poids;
    }

    public int getNumeroIdentification() {
        return numeroIdentification;
    }

    public double getPoids() {
        return poids;
    }

    // Méthode abstraite pour calculer le prix d'une volaille en fonction du prix du jour
    public abstract double calculerPrix(double prixDuJour);

    // Méthode abstraite pour obtenir le poids d'abattage spécifique à chaque type de volaille
    public abstract double getPoidsAbattage();
}