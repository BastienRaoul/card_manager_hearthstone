
import hearthstone.carte.*;
import hearthstone.cartes.Cartes;
import hearthstone.cartes.FabriqueJson;
import hearthstone.exception.CarteAbsenteException;
import hearthstone.exception.CarteDejaPresenteException;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

public class TestCartes {

    @Test
    public void testCartes1() throws Exception {
        Cartes tasDeCarte = new Cartes();
        assertEquals("Test constructeur 1", 0, tasDeCarte.collection().size());
    }

    @Test
    public void testCartes101() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau Thor2", 11, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme2);

        HashSet<Carte> dummy = new HashSet<>();
        dummy.add(arme);
        dummy.add(arme2);
        assertEquals("Test constructeur 1", dummy, tasDeCarte.collection());
    }

    @Test
    public void testCartes2() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau Thor2", 11, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme2);
        assertEquals("Test constructeur 2", 2, tasDeCarte.collection().size());
    }

    @Test(expected = CarteDejaPresenteException.class)
    public void testCartes3() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau Thor2", 11, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme2);
    }

    @Test
    public void testCartes4() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau Thor2", 11, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        try {
            tasDeCarte.ajouter(arme2);
            tasDeCarte.ajouter(arme);
            tasDeCarte.ajouter(arme);
        } catch (Exception e) {
        }
        assertEquals("Test constructeur 4", 2, tasDeCarte.collection().size());
    }

    @Test(expected = CarteDejaPresenteException.class)
    public void testCartes5() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme);
    }

    @Test
    public void testCartes6() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        assertEquals("Test ajouter 1", false, tasDeCarte.estPresente(arme));
        tasDeCarte.ajouter(arme);
        assertEquals("Test ajouter 2", true, tasDeCarte.estPresente(arme));
    }

    @Test(expected = CarteAbsenteException.class)
    public void testCartes7() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.effacer(arme);
        assertEquals("Test ajouter 2", 0, tasDeCarte.collection().size());
        tasDeCarte.effacer(arme);
    }
}