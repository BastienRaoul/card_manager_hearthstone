package hearthstone;

import java.io.IOException;
import java.util.*;

import hearthstone.carte.*;
import hearthstone.cartes.*;
import hearthstone.exception.CarteDejaPresenteException;
import hearthstone.exception.ValeurNegativeException;
import hearthstone.vue.*;

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