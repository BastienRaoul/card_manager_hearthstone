
package hearthstone;

import java.io.IOException;
import java.util.*;

import hearthstone.carte.*;
import hearthstone.cartes.*;
import hearthstone.exception.*;
import hearthstone.vue.*;
import hearthstone.*;
import hearthstone.carte.*;

/**
 * @author lanoix-a remm-jf
 * @version 1.0
 */

public class Hearthstone {

	public static void main(String[] args) throws CarteDejaPresenteException, IOException, ClasseNeutreException,
			LimiteNombreDeCartesException, DeckCreationException {
		Cartes collection = new Cartes(FabriqueJson.lireCartesDepuisFichier("./json/cartes11.json"));

		Deck d1 = new Deck(collection, Classe.CHAMAN, "deck 1");
		Deck d2 = new Deck(collection, Classe.DEMONISTE, "deck 2");
		Deck d3 = new Deck(collection, Classe.CHASSEUR, "deck 3");
		Deck d4 = new Deck(collection, Classe.MAGE, "deck 4");
		vueCollection main = new vueCollection(collection);

		main.pack();
		main.setVisible(true);
	}
}