package hearthstone;

import java.util.*;

import hearthstone.carte.*;
import hearthstone.cartes.*;

/**
 * @author lanoix-a remm-jf
 * @version 1.0
 */

public class Hearthstone {

    public static void main(String[] args) {
        
        Cartes collection = new Cartes();
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        List<Carte> col = new ArrayList<Carte>();
        col.add(arme);
        col.add(arme);

        try {
            collection.ajouter(arme);
            collection.ajouter(arme);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(collection.collection());
        try {
            Cartes collection2 = new Cartes(col);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }           
    }    
}