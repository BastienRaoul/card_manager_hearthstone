package hearthstone;

import java.util.*;

import hearthstone.carte.*;
import hearthstone.cartes.*;
import hearthstone.exception.ValeurNegativeException;
import hearthstone.vue.*;

/**
 * @author lanoix-a remm-jf
 * @version 1.0
 */

public class Hearthstone {

    public static void main(String[] args) {
        vueCollection main = new vueCollection();

        main.pack();
        main.setVisible(true);
    }
}