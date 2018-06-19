
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
    @Test
    public void testSort1() throws Exception
    {
        Sort sort = new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR);
        assertEquals(Classe.CHASSEUR, sort.classe());
        assertEquals(Rarete.COMMUNE, sort.rarete());
        assertEquals(5, sort.mana());
        assertEquals(true, sort.equals(new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR)));
    }

    @Test
    public void testSort2() throws Exception
    {
        Sort sort = new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR, "", "");
        assertEquals(Classe.CHASSEUR, sort.classe());
        assertEquals(Rarete.COMMUNE, sort.rarete());
        assertEquals(5, sort.mana());
        assertEquals(true, sort.equals(new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR)));
    }

    @Test(expected = ValeurNegativeException.class)
    public void testNegativeException() throws Exception
    {
        Sort sort = new Sort("Groot", -12, "Description", Rarete.COMMUNE, Classe.CHASSEUR);
    }

    @Test(expected = ValeurNegativeException.class)
    public void testNegativeException2() throws Exception
    {
        Sort sort = new Sort("Groot", -12, "Description", Rarete.COMMUNE, Classe.CHASSEUR,"","");
    }
}