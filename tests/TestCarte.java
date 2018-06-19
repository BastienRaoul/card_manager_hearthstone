
import hearthstone.carte.*;
import hearthstone.cartes.Cartes;
import hearthstone.cartes.FabriqueJson;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class TestCarte {

    @Test
    public void test() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        assertEquals("manna different", 10, arme.mana());
    }

    @Test
    public void test2() throws Exception {
        Cartes cartes = new Cartes(FabriqueJson.lireCartesDepuisFichier("json/initial.json"));
        assertEquals(3, cartes.collection().size());
    }

    @Test
    public void Classe() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        assertEquals("classe different", Classe.GUERRIER, arme.classe());
    }

    @Test
    public void Rarete() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        assertEquals("rarete different", Rarete.LEGENDAIRE, arme.rarete());
    }

    @Test
    public void nom() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        assertEquals("rarete different", new String("Marteau de Thor"), arme.nom().toCharArray());
        // probleme pour tout les test avec string
        // assertNotSame(message, unexpected, actual);
    }

}