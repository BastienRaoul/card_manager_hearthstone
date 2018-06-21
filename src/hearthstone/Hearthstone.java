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

    public static void main(String[] args) throws CarteDejaPresenteException, IOException {
        Cartes collection = new Cartes(FabriqueJson.lireCartesDepuisFichier("./json/cartes11.json"));

        vueCollection main = new vueCollection(collection);

        main.pack();
        main.setVisible(true);

    }
}