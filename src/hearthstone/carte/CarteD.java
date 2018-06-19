package hearthstone.carte;

import com.google.gson.annotations.SerializedName;
import hearthstone.exception.ValeurNegativeException;

/**
 *
 * Classe représentant une carte de manière abstraite, permettant de partager
 * l'attribut dégat entre les cartes Arme et les cartes serviteur
 *
 * @author lanoix-a remm-jf
 * @version 1.2
 */
public abstract class CarteD extends Carte {

    @SerializedName("attack")
    private final int degats;

    /**
     * Construit une carte abstraite
     * 
     * @param nom           nom de la carte
     * @param mana          valeur manna de la carte
     * @param desc          description de la carte
     * @param rarete        rareté de la carte
     * @param classe        classe de la carte
     * @param urlImage      url vers une image de la carte
     * @param urlImageDoree url vers une version doree de l'image de la carte
     * @param degats        valeur de degats de la carte
     * @throws ValeurNegativeException si une veleur negative est utilisee pour
     *                                 initialiser une carte
     *
     */
    CarteD(String nom, int mana, String desc, Rarete rarete, Classe classe, String urlImage, String urlImageDoree,
            int degats) throws ValeurNegativeException, NullPointerException {
        super(nom, mana, desc, rarete, classe, urlImage, urlImageDoree);
        if (degats < 0)
            throw new ValeurNegativeException("valeur de degats negative");
        this.degats = degats;
    }

    /**
     *
     * @return la valeur de degats de la carte
     */
    public int degats() {
        return degats;
    }

    /**
     * indique si deux cartes sont égales, indépendemment du fait qu'elles soient
     * dorées ou non
     *
     * @param carte la carte a comparer
     * @return true si la carte courante est égale à la carte sans considere
     *         qu'elles soient dorées ou non
     */
    @Override
    public boolean estEgalModuloDoree(Carte carte) {
        if (this == carte)
            return true;
        if (!(carte instanceof CarteD))
            return false;
        if (!super.estEgalModuloDoree(carte))
            return false;

        CarteD carteD = (CarteD) carte;

        return degats == carteD.degats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof CarteD))
            return false;
        if (!super.equals(o))
            return false;

        CarteD carteD = (CarteD) o;

        return degats == carteD.degats;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + degats;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", degats='" + degats + '\'';
    }
}
