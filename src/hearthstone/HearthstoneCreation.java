package hearthstone;

import java.io.IOException;

import hearthstone.cartes.Cartes;
import hearthstone.cartes.FabriqueJson;
import hearthstone.exception.CarteDejaPresenteException;
import hearthstone.vue.vueCreation;

/**
 * @author lanoix-a remm-jf
 * @version 1.0
 */

public class HearthstoneCreation {

    public static void main(String[] args) throws CarteDejaPresenteException, IOException {
	Cartes collection = new Cartes(FabriqueJson.lireCartesDepuisFichier("./json/cartes11.json"));
	vueCreation main = new vueCreation(collection);

	main.pack();
	main.setVisible(true);
    }
}