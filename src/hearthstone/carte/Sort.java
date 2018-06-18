package hearthstone.carte;

/**
 *
 * Classe représentant une carte Sort
 *
 * @author lanoix-a remm-jf
 * @version 1.0
 */

public class Sort extends Carte {

	/**
	 * Construit une carte Sort
	 * 
	 * @param nom
	 *            nom de la carte
	 * @param mana
	 *            valeur manna de la carte
	 * @param desc
	 *            description de la carte
	 * @param rarete
	 *            rareté de la carte
	 * @param classe
	 *            classe de la carte
	 * @param urlImage
	 *            url vers une image de la carte
	 * @param urlImageDoree
	 *            url vers une version doree de l'image de la carte
	 */
	public Sort(String nom, int mana, String desc, Rarete rarete, Classe classe, String urlImage,
			String urlImageDoree) {
		super(nom, mana, desc, rarete, classe, urlImage, urlImageDoree);
	}

	/**
	 * Construit une carte Sort sans URL d'images
	 * 
	 * @param nom
	 *            nom de la carte
	 * @param mana
	 *            valeur manna de la carte
	 * @param desc
	 *            description de la carte
	 * @param rarete
	 *            rareté de la carte
	 * @param classe
	 *            classe de la carte
	 */
	public Sort(String nom, int mana, String desc, Rarete rarete, Classe classe) {
		this(nom, mana, desc, rarete, classe, "", "");
	}
}
