package com.ex622.volaille;

/**
 * La classe {@code Canard} représente une volaille de type canard.
 * Elle étend la classe abstraite {@code Volaille} et implémente les méthodes
 * abstraites pour calculer le prix et obtenir le poids d'abattage.
 *
 * @author Armand Girard
 * @version 1.0
 */
public class Canard extends Volaille {

    /**
     * Construit une nouvelle instance de la classe {@code Canard} avec le numéro
     * d'identification et le poids spécifiés.
     *
     * @param numeroIdentification Le numéro d'identification unique du canard.
     * @param poids Le poids du canard.
     */
    public Canard(int numeroIdentification, double poids) {
        super(numeroIdentification, poids);
    }

    /**
     * Calcule le prix du canard en fonction du prix du jour.
     *
     * @param prixDuJour Le prix du jour pour le calcul du prix du canard.
     * @return Le prix calculé du canard.
     */
    @Override
    public double calculerPrix(double prixDuJour) {
        return getPoids() * prixDuJour;
    }

    /**
     * Obtient le poids d'abattage spécifique pour les canards.
     *
     * @return Le poids d'abattage du canard.
     */
    @Override
    public double getPoidsAbattage() {
        // Poids d'abattage spécifique pour les canards
        return 3.0;
    }
}
