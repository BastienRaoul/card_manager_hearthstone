package hearthstone.cartes;

import hearthstone.carte.Carte;
import hearthstone.exception.ValeurNegativeException;

/**
 * "couple" permettant d'associer à une carte son nombre d'exemplaires
 * 
 * @author lanoix-a remm-jf
 * @version 1.0
 */

public class Denombrement {
    private final Carte carte;
    private int nombre;

    /**
     * creer un "couple" (carte,nombre)
     * 
     * @param carte  la carte à utiliser
     * @param nombre le nombre d'exemplaires
     */
    public Denombrement(Carte carte, int nombre) throws ValeurNegativeException {
        this.carte = carte;
        if (nombre < 0)
            throw new ValeurNegativeException("The card count can not be negative");
        this.nombre = nombre;
    }

    /**
     * creer un "couple" (carte,1)
     * 
     * @param carte la carte à utiliser
     */
    public Denombrement(Carte carte) throws ValeurNegativeException {
        this(carte, 1);
    }

    /**
     *
     * @return la carte
     */
    public Carte carte() {
        return carte;
    }

    /**
     *
     * @return le nombre d'exemplaires
     */
    public int nombre() {
        return nombre;
    }

    /**
     * incremente le nombre d'exemplaires
     */
    public void incremente() {
        nombre++;
    }
 
     /**
     * met le nombre d'exemplaires à la valeur de nombre
     */
    public void setNombre(int nombre){
      this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "(" + "carte=" + carte + ", nombre=" + nombre + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Denombrement that = (Denombrement) o;

        if (nombre != that.nombre)
            return false;
        return carte.equals(that.carte);
    }

    @Override
    public int hashCode() {
        int result = carte.hashCode();
        result = 31 * result + nombre;
        return result;
    }
}
