
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

public class TestSort {

    /**
     * Création d'une carte sort sans URL d'image 
     * Test de la classe de la carte sort
     * Test de la rarete de la carte sort
     * Test du coût en mana de la carte sort
     * Test une carte sort est la même qu'une autre carte sort
     */
    @Test
    public void testSort1() throws Exception {
        Sort sort = new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR);
        assertEquals(Classe.CHASSEUR, sort.classe());
        assertEquals(Rarete.COMMUNE, sort.rarete());
        assertEquals(5, sort.mana());
        assertEquals(true, sort.equals(new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR)));
    }

    /**
     * Création d'une carte sort avec URL d'image 
     * Test de la classe de la carte sort
     * Test de la rarete de la carte sort
     * Test du coût en mana de la carte sort
     * Test une carte sort est la même qu'une autre carte sort
     */
    @Test
    public void testSort2() throws Exception {
        Sort sort = new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR, "", "");
        assertEquals(Classe.CHASSEUR, sort.classe());
        assertEquals(Rarete.COMMUNE, sort.rarete());
        assertEquals(5, sort.mana());
        assertEquals(true, sort.equals(new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR)));
    }

    /**
     * Test valeur négative  d'une carte sort sans URL d'image
     */
    @Test(expected = ValeurNegativeException.class)
    public void testNegativeException() throws Exception {
        Sort sort = new Sort("Groot", -12, "Description", Rarete.COMMUNE, Classe.CHASSEUR);
    }

     /**
     * Test valeur négative  d'une carte sort avec URL d'image
     */
    @Test(expected = ValeurNegativeException.class)
    public void testNegativeException2() throws Exception {
        Sort sort = new Sort("Groot", -12, "Description", Rarete.COMMUNE, Classe.CHASSEUR, "", "");
    }

    @Test
    public void testSort3() throws Exception {
        Sort sort = new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR, "", "");
        assertEquals(Classe.CHASSEUR, sort.classe());
        assertEquals(Rarete.COMMUNE, sort.rarete());
        assertEquals(5, sort.mana());
        assertEquals(false, sort.equals(new Sort("Groot", 6, "Description", Rarete.COMMUNE, Classe.CHASSEUR)));
    }

    @Test
    public void testSort4() throws Exception {
        Sort sort = new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR);
        assertEquals(Classe.CHASSEUR, sort.classe());
        assertEquals(Rarete.COMMUNE, sort.rarete());
        assertEquals(5, sort.mana());
        assertEquals("mana diff",false, sort.equals(new Sort("Groot", 6, "Description", Rarete.COMMUNE, Classe.CHASSEUR,"","")));
    }

    @Test
    public void testSort5() throws Exception {
        Sort sort = new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR);
        assertEquals(Classe.CHASSEUR, sort.classe());
        assertEquals(Rarete.COMMUNE, sort.rarete());
        assertEquals(5, sort.mana());
        assertEquals("description diff",false, sort.equals(new Sort("Groot", 5,"desc", Rarete.COMMUNE, Classe.CHASSEUR,"","")));
    }

    @Test
    public void testSort6() throws Exception {
        Sort sort = new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR);
        assertEquals(Classe.CHASSEUR, sort.classe());
        assertEquals(Rarete.COMMUNE, sort.rarete());
        assertEquals(5, sort.mana());
        assertEquals("Nom différent",false, sort.equals(new Sort("NomDiff", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR,"","")));
    }

    @Test
    public void testSort7() throws Exception {
        Sort sort = new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR);
        assertEquals(Classe.CHASSEUR, sort.classe());
        assertEquals(Rarete.COMMUNE, sort.rarete());
        assertEquals(5, sort.mana());
        assertEquals("Rarete diff", false, sort.equals(new Sort("Groot", 5, "Description", Rarete.BASIQUE, Classe.CHASSEUR,"","")));
    }

    @Test
    public void testSort8() throws Exception {
        Sort sort = new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR);
        assertEquals(Classe.CHASSEUR, sort.classe());
        assertEquals(Rarete.COMMUNE, sort.rarete());
        assertEquals(5, sort.mana());
        assertEquals("classe diff", false, sort.equals(new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.GUERRIER,"","")));
    }
}