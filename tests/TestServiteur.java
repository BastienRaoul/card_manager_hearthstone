
import hearthstone.carte.*;
import hearthstone.cartes.*;
import hearthstone.cartes.FabriqueJson;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class TestServiteur {

    @Test
    public void test() throws Exception
    {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE);
        assertEquals("vie différente", 6, serviteur.pointSDeVie());
    }
    
    @Test
    public void test2() throws Exception
    {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE);
        assertEquals("race différente", Race.BETE, serviteur.race());
    }
}