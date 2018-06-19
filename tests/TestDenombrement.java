
import hearthstone.carte.*;
import hearthstone.cartes.*;
import hearthstone.cartes.FabriqueJson;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class TestDenombrement {
    @Test
    public void testDenombrement1() throws Exception
    {
        Denombrement denombrement = new Denombrement(new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR),3);
        assertEquals(new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR), denombrement.carte());
        assertEquals(3, denombrement.nombre());
    }

    @Test
    public void testDenombrement2() throws Exception
    {
        Denombrement denombrement = new Denombrement(new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR),-3);
        assertEquals(new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR), denombrement.carte());
        assertEquals(-3, denombrement.nombre());
    }

    @Test
    public void testDenombrement3() throws Exception
    {
        Denombrement denombrement = new Denombrement(new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR),3);
        assertEquals(new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR), denombrement.carte());
        denombrement.incremente();
        assertEquals(4, denombrement.nombre());
    }
}