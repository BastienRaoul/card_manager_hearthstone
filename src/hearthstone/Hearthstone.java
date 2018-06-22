
package hearthstone;

import java.io.IOException;

import hearthstone.carte.Classe;
import hearthstone.cartes.Cartes;
import hearthstone.cartes.Deck;
import hearthstone.cartes.FabriqueJson;
import hearthstone.exception.CarteDejaPresenteException;
import hearthstone.exception.ClasseNeutreException;
import hearthstone.exception.DeckCreationException;
import hearthstone.exception.LimiteNombreDeCartesException;
import hearthstone.vue.vueCollection;

public class Hearthstone {

	public static void main(String[] args) throws CarteDejaPresenteException, IOException, ClasseNeutreException,
			LimiteNombreDeCartesException, DeckCreationException {
		Cartes collection = new Cartes(FabriqueJson.lireCartesDepuisFichier("./json/collection.json"));

		collection.setNbPoussiere(10000);
		
		Deck d1 = new Deck(collection, Classe.CHAMAN, "deck 1");
		Deck d2 = new Deck(collection, Classe.DEMONISTE, "deck 2");
		Deck d3 = new Deck(collection, Classe.CHASSEUR, "deck 3");
		Deck d4 = new Deck(collection, Classe.MAGE, "deck 4");
		vueCollection main = new vueCollection(collection);

		main.pack();
		main.setVisible(true);
	}
}