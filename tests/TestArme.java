
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

    @Test
    public void testArme1() throws Exception {
        Arme arme = new Arme("az", 2, "desc", Rarete.COMMUNE, Classe.CHAMAN, 3, 3);

        assertEquals(Classe.CHAMAN, arme.classe());
        assertEquals(3, arme.durabilite());
        assertEquals(true, arme.equals(new Arme("az", 2, "desc", Rarete.COMMUNE, Classe.CHAMAN, 3, 3)));
    }

    @Test
    public void testArme2() throws Exception {
        Arme arme = new Arme("az", 2, "desc", Rarete.COMMUNE, Classe.CHAMAN, "", "", 3, 3);

        assertEquals(Classe.CHAMAN, arme.classe());
        assertEquals(3, arme.durabilite());
        assertEquals(true, arme.equals(new Arme("az", 2, "desc", Rarete.COMMUNE, Classe.CHAMAN, 3, 3)));
    }

    @Test(expected = ValeurNegativeException.class)
    public void testArme3() throws Exception {
        Arme arme = new Arme("az", -1, "desc", Rarete.COMMUNE, Classe.CHAMAN, "", "", 3, 3);
    }

    @Test(expected = ValeurNegativeException.class)
    public void testArme4() throws Exception {
        Arme arme = new Arme("az", -1, "desc", Rarete.COMMUNE, Classe.CHAMAN, 3, 3);
    }
}