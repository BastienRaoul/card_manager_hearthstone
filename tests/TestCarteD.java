
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
<<<<<<< HEAD
    // On test la méthode Degats

=======
    // On test ici la méthode dégats() de carteD en instanciant un serviteur
>>>>>>> 287d10ad64eb60c1f67aa068a793fea71b584b0f
    @Test
    public void testCarteD() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6,
                Race.BETE);
        assertEquals("Valeur fausse", 5, serviteur.degats());
    }

<<<<<<< HEAD
    //La méthode equals
=======
    // On vérifie ici la méthode equals en créant deux instances du même Serviteur
    // (héritant de CarteD)
    // Et en les comparant
>>>>>>> 287d10ad64eb60c1f67aa068a793fea71b584b0f
    @Test
    public void testCarteD2() throws Exception {
        Serviteur serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6,
                Race.BETE);
        Serviteur serviteur2 = new Serviteur("Ranger", 4, "Strong", Rarete.EPIQUE, Classe.NEUTRE, "", "", 5, 6,
                Race.BETE);

        assertEquals(true, serviteur.equals(serviteur2));
    }

<<<<<<< HEAD

    //On test l'erreur avec des valeur négative
=======
    // On test ici le déclenchement de l'exception valeur négative dans le
    // constructeur de CarteDs
>>>>>>> 287d10ad64eb60c1f67aa068a793fea71b584b0f
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