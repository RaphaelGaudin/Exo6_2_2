package com.volaille.volaille;

/**
 * La classe {@code Poulet} représente une volaille de type poulet.
 * Elle étend la classe abstraite {@code Volaille} et implémente les méthodes
 * abstraites pour calculer le prix et obtenir le poids d'abattage.
 *
 * @author Armand Girard
 * @author Raphael Gaudin
 * @version 1.0
 */
public class Poulet extends Volaille {

    /**
     * Construit une nouvelle instance de la classe {@code Poulet} avec le numéro
     * d'identification et le poids spécifiés.
     *
     * @param numeroIdentification Le numéro d'identification unique du poulet.
     * @param poids Le poids du poulet.y
     */
    public Poulet(int numeroIdentification, double poids) {
        super(numeroIdentification, poids);
    }

    /**
     * Calcule le prix du poulet en fonction du prix du jour.
     *
     * @param prixKilo Le prix du kilo pour le calcul du prix du poulet.
     * @return Le prix calculé du poulet.
     */
    @Override
    public double calculerPrix(double prixKilo) {
        return getPoids() * prixKilo;
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
