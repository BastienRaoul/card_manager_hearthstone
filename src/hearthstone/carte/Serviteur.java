package hearthstone.carte;

import com.google.gson.annotations.SerializedName;

/**
 *
 * Classe représentant une carte Serviteur
 *
 * @author lanoix-a remm-jf
 * @version 1.0
 */
public class Serviteur extends CarteD {

    @SerializedName("health")
    private final int pointsDeVie;

    @SerializedName("race")
    private Race race;


    /**
     * Construit une carte Serviteur
     * @param nom nom de la carte
     * @param mana valeur manna de la carte
     * @param desc description de la carte
     * @param rarete rareté de la carte
     * @param classe classe de la carte
     * @param urlImage url vers une image de la carte
     * @param urlImageDoree url vers une version doree de l'image de la carte
     * @param degats valeur de degats de la carte
     * @param pointsDeVie valeur de points de vie de la carte
     * @param race race de la carte
     *
     */
    public Serviteur(String nom, int mana, String desc, Rarete rarete, Classe classe, String urlImage, String urlImageDoree, int degats, int pointsDeVie, Race race) {
        super(nom, mana, desc, rarete, classe, urlImage, urlImageDoree, degats);
        this.pointsDeVie = pointsDeVie;
        this.race = race;
    }

    /**
     * Construit une carte Serviteur sans URL d'images
     * @param nom nom de la carte
     * @param mana valeur manna de la carte
     * @param desc description de la carte
     * @param rarete rareté de la carte
     * @param classe classe de la carte
     * @param degats valeur de degats de la carte
     * @param pointsDeVie valeur de points de vie de la carte
     * @param race race de la carte
     *
     */
    public Serviteur(String nom, int mana, String desc, Rarete rarete, Classe classe, int degats, int pointsDeVie, Race race) {
        this(nom, mana, desc, rarete, classe, "", "", degats, pointsDeVie, race);
    }

    /**
     *
     * @return la valeur de vie de la carte
     */
    public int pointSDeVie() {
        return pointsDeVie;
    }

    /**
     *
     * @return la race de la carte
     */
    public Race race(){
        return race;
    }

    public void verifie() {
        super.verifie();
        if (race == null)
            race = Race.ELEMENTAIRE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Serviteur)) return false;
        if (!super.equals(o)) return false;

        Serviteur serviteur = (Serviteur) o;

        if (pointsDeVie != serviteur.pointsDeVie) return false;
        return race == serviteur.race;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + pointsDeVie;
        result = 31 * result + race.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", pointsDeVie='" + pointsDeVie + '\''+
                ", race='" + race + '\'' ;
    }


}
