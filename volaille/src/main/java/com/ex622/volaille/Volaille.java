package com.ex622.volaille;

/**
 * La classe abstraite {@code Volaille} représente une volaille générique avec un numéro d'identification
 * et un poids. Elle fournit des méthodes abstraites pour calculer le prix et obtenir le poids d'abattage.
 *
 * @author Armand Girard
 * @author Raphael Gaudin
 * @version 1.0
 */
public abstract class Volaille {
    /**
     * Le numéro d'identification unique de la volaille.
     */
    private int numeroIdentification;

    /**
     * Le poids de la volaille.
     */
    private double poids;

    /**
     * Construit une nouvelle instance de la classe {@code Volaille} avec le numéro d'identification
     * et le poids spécifiés.
     *
     * @param numeroIdentification Le numéro d'identification unique de la volaille.
     * @param poids Le poids de la volaille.
     */
    public Volaille(int numeroIdentification, double poids) {
        this.numeroIdentification = numeroIdentification;
        this.poids = poids;
    }

    /**
     * Obtient le numéro d'identification de la volaille.
     *
     * @return Le numéro d'identification de la volaille.
     */
    public int getNumeroIdentification() {
        return numeroIdentification;
    }

    /**
     * Obtient le poids de la volaille.
     *
     * @return Le poids de la volaille.
     */
    public double getPoids() {
        return poids;
    }

    /**
     * Retourne l'instance de la classe {@code Volaille}.
     *
     * @return L'instance de la classe {@code Volaille}.
     */
    public Volaille getVolaille() {
        return this;
    }

    /**
     * Calcule le prix de la volaille en fonction du prix du jour.
     *
     * @param prixDuJour Le prix du jour pour le calcul du prix de la volaille.
     * @return Le prix calculé de la volaille.
     */
    public abstract double calculerPrix(double prixDuJour);

    /**
     * Obtient le poids d'abattage spécifique à chaque type de volaille.
     *
     * @return Le poids d'abattage de la volaille.
     */
    public abstract double getPoidsAbattage();
}
