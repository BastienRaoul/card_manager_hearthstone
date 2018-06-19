package hearthstone.carte;

import com.google.gson.annotations.SerializedName;
import hearthstone.exception.ValeurNegativeException;

/**
 *
 * Classe représentant une carte Arme
 *
 * @author lanoix-a remm-jf
 * @version 1.2
 */
public class Arme extends CarteD {

    @SerializedName("durability")
    private final int durabilite;

    /**
     * Construit une carte Arme
     * 
     * @param nom           nom de la carte
     * @param mana          valeur manna de la carte
     * @param desc          description de la carte
     * @param rarete        rareté de la carte
     * @param classe        classe de la carte
     * @param urlImage      url vers une image de la carte
     * @param urlImageDoree url vers une version doree de l'image de la carte
     * @param degats        valeur de degats de la carte
     * @param durabilite    valeur de durabilité de la carte
     * @throws ValeurNegativeException si une veleur negative est utilisee pour
     *                                 initialiser une carte
     */
    public Arme(String nom, int mana, String desc, Rarete rarete, Classe classe, String urlImage, String urlImageDoree,
            int degats, int durabilite) throws ValeurNegativeException, NullPointerException {
        super(nom, mana, desc, rarete, classe, urlImage, urlImageDoree, degats);
        if (durabilite < 0)
            throw new ValeurNegativeException("valeur de durabilite negative");
        this.durabilite = durabilite;
    }

    /**
     * Construit une carte Arme sans URL d'images
     * 
     * @param nom        nom de la carte
     * @param mana       valeur manna de la carte
     * @param desc       description de la carte
     * @param rarete     rareté de la carte
     * @param classe     classe de la carte
     * @param degats     valeur de degats de la carte
     * @param durabilite valeur de durabilité de la carte
     * @throws ValeurNegativeException si une veleur negative est utilisee pour
     *                                 initialiser une carte
     */
    public Arme(String nom, int mana, String desc, Rarete rarete, Classe classe, int degats, int durabilite)
            throws ValeurNegativeException, NullPointerException {
        this(nom, mana, desc, rarete, classe, "", "", degats, durabilite);
    }

    /**
     *
     * @return la durabilité de la carte
     */
    public int durabilite() {
        return durabilite;
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
        if (!(carte instanceof Arme))
            return false;
        if (!super.estEgalModuloDoree(carte))
            return false;

        Arme arme = (Arme) carte;

        return durabilite == arme.durabilite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Arme))
            return false;
        if (!super.equals(o))
            return false;

        Arme arme = (Arme) o;

        return durabilite == arme.durabilite;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + durabilite;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", durabilite='" + durabilite + '\'';
    }
}
