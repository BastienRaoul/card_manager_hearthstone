
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

import java.util.Collection;

public class TestFiltre {

    @Test
    public void testFiltre1() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau Thor2", 11, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte serviteur = new Serviteur("smop", 2, "qd", Rarete.BASIQUE, Classe.CHASSEUR, 2, 4, Race.DEMON);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme2);
        assertEquals("Test constructeur 2", 2, tasDeCarte.collection().size());
    }
}