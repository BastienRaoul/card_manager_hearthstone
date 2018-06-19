
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

public class TestDenombrement {

    @Test
    public void testDenombrement1() throws Exception {
        Carte arme2 = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme2);

        assertEquals(1, den.nombre());
        assertEquals(arme2, den.carte());
    }

    @Test
    public void testDenombrement2() throws Exception {
        Carte arme2 = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme2, 3);

        assertEquals(3, den.nombre());
        assertEquals(arme2, den.carte());
    }

    @Test(expected = ValeurNegativeException.class)
    public void testDenombrement3() throws Exception {
        Carte arme2 = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme2, -1);
    }

    @Test
    public void testDenombrement4() throws Exception {
        Carte arme2 = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme2);

        assertEquals(1, den.nombre());
        den.incremente();
        assertEquals(2, den.nombre());
        assertEquals(arme2, den.carte());
    }

    @Test
    public void testDenombrement5() throws Exception {
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme);

        Carte arme1 = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den1 = new Denombrement(arme1);

        assertEquals(den, den1);
    }

    @Test
    public void testEquals() throws Exception {
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme);

        Carte arme1 = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den1 = new Denombrement(arme1);

        assertEquals(true, den1.equals(den));
    }
}