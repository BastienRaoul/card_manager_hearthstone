package hearthstone;

import java.io.IOException;

import hearthstone.cartes.Cartes;
import hearthstone.cartes.FabriqueJson;
import hearthstone.exception.CarteDejaPresenteException;
import hearthstone.vue.vueDeck;

/**
 * @author lanoix-a remm-jf
 * @version 1.0
 */

public class HearthstoneDeck {

    public static void main(String[] args) throws CarteDejaPresenteException, IOException {

        Cartes collection = new Cartes(FabriqueJson.lireCartesDepuisFichier("./json/cartes11.json"));

        vueDeck main = new vueDeck(collection, null);
        main.pack();
        main.setVisible(true);
    }
}