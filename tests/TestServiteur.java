
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

    @Test
    public void testServiteur() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE);
        assertEquals("vie différente", 6, serviteur.pointSDeVie());
        assertEquals("race différente", Race.BETE, serviteur.race());
        assertEquals(true,
                serviteur.equals(new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE)));
    }

    @Test
    public void testServiteur2() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6,
                Race.BETE);
        assertEquals("vie différente", 6, serviteur.pointSDeVie());
        assertEquals("race différente", Race.BETE, serviteur.race());
        assertEquals(true,
                serviteur.equals(new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE)));
    }

    @Test(expected = ValeurNegativeException.class)
    public void testServiteur3() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", -1, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6,
                Race.BETE);
    }

    @Test(expected = ValeurNegativeException.class)
    public void testServiteur4() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", -1, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE);
    }
}