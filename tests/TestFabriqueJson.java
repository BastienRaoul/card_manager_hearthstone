
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

import java.io.IOException;
import java.util.*;

public class TestFabriqueJson {

    @Test
    public void testFabriqueJson1() {
        Collection<Carte> desCartes = null;
        try {
            desCartes = FabriqueJson.lireCartesDepuisFichier("./json/cartes11.json");
        } catch (IOException e) {
        }

        assertEquals(11, desCartes.size());
    }

    @Test(expected = IOException.class)
    public void testFabriqueJson2() throws Exception {
        Collection<Carte> desCartes = null;
        desCartes = FabriqueJson.lireCartesDepuisFichier("..wdfqen");

    }
    /*
     * @Test public void testFabriqueJson3() throws ValeurNegativeException {
     * Collection<Carte> desCartes = null; try { desCartes =
     * FabriqueJson.lireCartesDepuisFichier("./json/cartes11.json"); } catch
     * (IOException e) { }
     * 
     * assertEquals(true, ); }
     */
}