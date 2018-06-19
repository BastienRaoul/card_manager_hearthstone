
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

public class TestCarteD {

    @Test
    public void testCarteD() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6,
                Race.BETE);
        assertEquals("Valeur fausse", 5, serviteur.degats());
    }

    @Test
    public void testCarteD2() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6,
                Race.BETE);
        Serviteur serviteur2 = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6,
                Race.BETE);

        assertEquals(true, serviteur.equals(serviteur2));
    }

    @Test(expected = ValeurNegativeException.class)
    public void testServiteur4() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", -1, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE);
    }
}