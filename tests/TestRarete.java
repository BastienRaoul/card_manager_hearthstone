
import hearthstone.carte.*;
import hearthstone.cartes.Cartes;
import hearthstone.cartes.FabriqueJson;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.awt.Color;

public class TestRarete {

    @Test
    public void testRarete() throws Exception
    {
        assertEquals("Mauvaise couleur",Color.ORANGE, Rarete.LEGENDAIRE.gemme());
    }

    @Test
    public void testRarete2() throws Exception
    {
        assertEquals("Valeur fausse", 1600, Rarete.LEGENDAIRE.valeurCreation());
    }

    @Test
    public void testRarete3() throws Exception
    {
        assertEquals("Valeur fausse", 400, Rarete.LEGENDAIRE.valeurDesenchantement());
    }

    @Test
    public void testRarete4() throws Exception
    {
        assertEquals("Valeur fausse", 3200, Rarete.LEGENDAIRE.valeurCreationDoree());
    }

    @Test
    public void testRarete5() throws Exception
    {
        assertEquals("Valeur fausse", 1600, Rarete.LEGENDAIRE.valeurDesenchantementDoree());
    }
}