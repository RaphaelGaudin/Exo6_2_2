package com.ex622.volaille;

/**
 * La classe {@code Poulet} représente une volaille de type poulet.
 * Elle étend la classe abstraite {@code Volaille} et implémente les méthodes
 * abstraites pour calculer le prix et obtenir le poids d'abattage.
 *
 * @author Raphaël Gaudin
 * @version 1.0
 */
public class Poulet extends Volaille {

    /**
     * Construit une nouvelle instance de la classe {@code Poulet} avec le numéro
     * d'identification et le poids spécifiés.
     *
     * @param numeroIdentification Le numéro d'identification unique du poulet.
     * @param poids Le poids du poulet.
     */
    public Poulet(int numeroIdentification, double poids) {
        super(numeroIdentification, poids);
    }

    /**
     * Calcule le prix du poulet en fonction du prix du jour.
     *
     * @param prixDuJour Le prix du jour pour le calcul du prix du poulet.
     * @return Le prix calculé du poulet.
     */
    @Override
    public double calculerPrix(double prixDuJour) {
        return getPoids() * prixDuJour;
    }

    /**
     * Obtient le poids d'abattage spécifique pour les poulets.
     *
     * @return Le poids d'abattage du poulet.
     */
    @Override
    public double getPoidsAbattage() {
        // Poids d'abattage spécifique pour les poulets
        return 2.5;
    }
}
