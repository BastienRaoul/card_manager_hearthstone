
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
    // On test la méthode Degats

    @Test
    public void testCarteD() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6,
                Race.BETE);
        assertEquals("Valeur fausse", 5, serviteur.degats());
    }

    //La méthode equals
    @Test
    public void testCarteD2() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6,
                Race.BETE);
        Serviteur serviteur2 = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6,
                Race.BETE);

        assertEquals(true, serviteur.equals(serviteur2));
    }


    //On test l'erreur avec des valeur négative
    @Test(expected = ValeurNegativeException.class)
    public void testServiteur4() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", -1, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE);
    }


    @Test(expected=ValeurNegativeException.class)
    public void EssConst() throws Exception{
        Serviteur serviteur = new Serviteur("Ranger", 2, "Strong", Rarete.EPIQUE, Classe.NEUTRE, -1, 6, Race.BETE);

    }

    @Test
    public void EssestModulo() throws Exception{
        Serviteur serviteur = new Serviteur("Ranger", 2, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE);

        assertEquals("estModulo",true,serviteur.estEgalModuloDoree(serviteur));
    }

    @Test
    public void EssestModulo2() throws Exception{
        Serviteur serviteur = new Serviteur("Ranger", 2, "Strong", Rarete.EPIQUE, Classe.NEUTRE, 5, 6, Race.BETE);
        Sort sort = new Sort("Groot", 5, "Description", Rarete.COMMUNE, Classe.CHASSEUR);
        assertEquals("estModulo",false,serviteur.estEgalModuloDoree(sort));
    }
}