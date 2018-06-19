
import hearthstone.carte.*;
import hearthstone.cartes.*;
import hearthstone.cartes.FabriqueJson;
import hearthstone.exception.ValeurNegativeException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class TestServiteur {

    /**
    * Création d'un serviteur sans URL d'image
    * Test des nombres de points de vie du serviteur
    * Test de la race du serviteur
    * Test de la méthode equals de la classe Serviteur
    * Test de la méthode estEgalModuloDoree de la classe Serviteur
    */
    @Test
    public void testServiteur() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE);
        Serviteur serviteur2 = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE);
        assertEquals("vie différente", 6, serviteur.pointSDeVie());
        assertEquals("race différente", Race.BETE, serviteur.race());
        assertEquals(true, serviteur.equals(serviteur2));
        assertEquals("Test Doree",true,serviteur.estEgalModuloDoree(serviteur2));
    }

    /**
    * Création d'un serviteur avec URL d'image
    * Test des nombres de points de vie du serviteur
    * Test de la race du serviteur
    * Test de la méthode equals de la classe Serviteur
    * Test de la méthode estEgalModuloDoree de la classe Serviteur
    */
    @Test
    public void testServiteur2() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6, Race.BETE);
        Serviteur serviteur2 = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6, Race.BETE);
        assertEquals("vie différente", 6, serviteur.pointSDeVie());
        assertEquals("race différente", Race.BETE, serviteur.race());
        assertEquals(true, serviteur.equals(serviteur2));
        assertEquals("Test Doree",true,serviteur.estEgalModuloDoree(serviteur2));
    }

    /**
     * Création d'un serviteur avec URL d'image
     * Test valeur négative
     */
    @Test(expected = ValeurNegativeException.class)
    public void testServiteur3() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", -1, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6,
                Race.BETE);
    }

    /**
     * Création d'un serviteur sans URL d'image
     * Test valeur négative
     */
    @Test(expected = ValeurNegativeException.class)
    public void testServiteur4() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", -1, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE);
    }

    /**
     * Création d'un serviteur sans URL d'image
     * Test equals false
     */
    @Test
    public void testServiteurFalse() throws Exception
    {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE);
        assertEquals(false, serviteur.equals(new Serviteur("Ranger", 5, "Strong", Rarete.EPIQUE, Classe.GUERRIER, 5, 6, Race.BETE)));
    }

    /**
     * Création d'un serviteur avec URL d'image
     * Test equals false
     */
    @Test
    public void testServiteur2False() throws Exception
    {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6, Race.BETE);
        assertEquals(false, serviteur.equals(new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.MECA)));
    }
   
    /**
     * Création d'un serviteur avec URL d'image
     * Test méthode verifie de la classe Serviteur
     */
    @Test
    public void testServiteur5() throws Exception {
        Serviteur serviteur = new Serviteur(null, 1, null, null, null, 5, 6, null);
        serviteur.verifie();
        assertEquals(Race.ELEMENTAIRE, serviteur.race());
    }
}