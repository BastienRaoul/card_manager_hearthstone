
import hearthstone.carte.*;
import hearthstone.cartes.Cartes;
import hearthstone.cartes.FabriqueJson;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCartes {

    @Test
    public void testCartes1() throws Exception {
        Cartes tasDeCarte = new Cartes();
        assertEquals("Test constructeur 1", 0, tasDeCarte.collection().size());
    }

    @Test
    public void testCartes2() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme);
        assertEquals("Test constructeur 2", 2, tasDeCarte.collection().size());
    }

    @Test
    public void testCartes3() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme);
        assertEquals("Test constructeur 3", 2, tasDeCarte.collection().size());

    }

    @Test
    public void testCartes4() throws Exception {
        Cartes cartes = new Cartes(FabriqueJson.lireCartesDepuisFichier("json/initial.json"));
        assertEquals(3, cartes.collection().size());
    }

    @Test
    public void testCartes5() throws Exception {
        Cartes cartes = new Cartes(FabriqueJson.lireCartesDepuisFichier("json/initial.json"));
        assertEquals(3, cartes.collection().size());
    }

    @Test
    public void testCartes6() throws Exception {
        Cartes cartes = new Cartes(FabriqueJson.lireCartesDepuisFichier("json/initial.json"));
        assertEquals(3, cartes.collection().size());
    }

    @Test
    public void testCartes7() throws Exception {
        Cartes cartes = new Cartes(FabriqueJson.lireCartesDepuisFichier("json/initial.json"));
        assertEquals(3, cartes.collection().size());
    }

    @Test
    public void testCartes8() throws Exception {
        Cartes cartes = new Cartes(FabriqueJson.lireCartesDepuisFichier("json/initial.json"));
        assertEquals(3, cartes.collection().size());
    }
}