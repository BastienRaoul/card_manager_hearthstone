
import hearthstone.carte.*;
import hearthstone.cartes.Cartes;
import hearthstone.cartes.FabriqueJson;
import hearthstone.exception.ValeurNegativeException;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class TestArme {

    /**
     * Création d'une arme sans URL d'image Test de la classe de l'arme Test de la
     * durabilité de l'arme Test de la méthode equals de la classe Arme Test de la
     * méthode estEgalModuloDoree de la classe Arme
     */
    @Test
    public void testArme1() throws Exception {
        Arme arme = new Arme("az", 2, "desc", Rarete.COMMUNE, Classe.CHAMAN, 3, 3);
        Arme arme2 = new Arme("az", 2, "desc", Rarete.COMMUNE, Classe.CHAMAN, 3, 3);
        assertEquals(Classe.CHAMAN, arme.classe());
        assertEquals(3, arme.durabilite());
        assertEquals(true, arme.equals(arme2));
        assertEquals("Test Doree", true, arme.estEgalModuloDoree(arme2));
    }

    /**
     * Création d'une arme avec URL d'image Test de la classe de l'arme Test de la
     * durabilité de l'arme Test de la méthode equals de la classe Arme Test de la
     * méthode estEgalModuloDoree de la classe Arme
     */
    @Test
    public void testArme2() throws Exception {
        Arme arme = new Arme("az", 2, "desc", Rarete.COMMUNE, Classe.CHAMAN, "", "", 3, 3);
        Arme arme2 = new Arme("az", 2, "desc", Rarete.COMMUNE, Classe.CHAMAN, "", "", 3, 3);
        assertEquals(Classe.CHAMAN, arme.classe());
        assertEquals(3, arme.durabilite());
        assertEquals(true, arme.equals(arme2));
        assertEquals("Test Doree", true, arme.estEgalModuloDoree(arme2));
    }

    /**
     * Création d'une arme avec URL d'image Test d'une valeur négative
     */
    @Test(expected = ValeurNegativeException.class)
    public void testArme3() throws Exception {
        Arme arme = new Arme("az", -1, "desc", Rarete.COMMUNE, Classe.CHAMAN, "", "", 3, 3);
    }

    @Test(expected = ValeurNegativeException.class)
    public void testArme5() throws Exception {
        Arme arme = new Arme("az", 2, "desc", Rarete.COMMUNE, Classe.CHAMAN, "", "", 3, -1);
    }

    /**
     * Création d'une arme sans URL d'image Test d'une valeur négative
     */
    @Test(expected = ValeurNegativeException.class)
    public void testArme4() throws Exception {
        Arme arme = new Arme("az", -1, "desc", Rarete.COMMUNE, Classe.CHAMAN, 3, 3);
    }

    @Test
    public void TestModulo() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE);
        Arme arme = new Arme("az", 2, "desc", Rarete.COMMUNE, Classe.CHAMAN, 3, 3);
        assertEquals("est Modulo avec !=arme", false, arme.estEgalModuloDoree(serviteur));

    }
}