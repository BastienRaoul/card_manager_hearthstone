
import hearthstone.carte.*;
import hearthstone.cartes.Cartes;
import hearthstone.cartes.FabriqueJson;
import hearthstone.exception.CarteBasiqueException;
import hearthstone.exception.CarteDoreeException;
import hearthstone.exception.CoutCreationException;
import hearthstone.exception.GainDesenchantementException;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class TestCarte {

    @Test
    public void test() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        assertEquals("manna different", 10, arme.mana());
    }

    @Test
    public void test2() throws Exception {
        Cartes cartes = new Cartes(FabriqueJson.lireCartesDepuisFichier("json/initial.json"));
        assertEquals(3, cartes.collection().size());
    }

    @Test
    public void Classe() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        assertEquals("classe different", Classe.GUERRIER, arme.classe());
    }

    @Test
    public void Rarete() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        assertEquals("rarete different", Rarete.LEGENDAIRE, arme.rarete());
    }

    @Test
    public void nom() throws Exception {
        String nom = "marteau de Thor";
        Carte arme = new Arme(nom, 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        assertEquals("nom", "Marteau de thor", arme.nom());

    }

    @Test
    public void Doree() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
        100);
        arme = arme.fabriquerCarteDoree(arme);
        assertEquals("Test Doree",true,arme.estDoree());
    }

    @Test
    public void EssJouable() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 5, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
        100);

        assertEquals("Test Doree",true,arme.estJouable(6));
    }

    @Test
    public void EssestModuloDoree() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
        100);
        Carte arme2 = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
        100);
        arme = arme2.fabriquerCarteDoree(arme2);
        assertEquals("Test Doree",true,arme.estEgalModuloDoree(arme2));
    }

    @Test(expected = CoutCreationException.class)
    public void ErrCoutCreation() throws Exception{
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.BASIQUE, Classe.GUERRIER, 100,100);
        arme.coutCreation();
    }


    @Test
    public void EssCoutCreation() throws Exception{
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.RARE, Classe.GUERRIER, 100,100);
        assertEquals("Test Cout Creation",100,arme.coutCreation());
    }

    @Test
    public void GainDesenchentement() throws Exception{
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.EPIQUE, Classe.GUERRIER, 100,100);
        assertEquals("Test Gain Desenchantement",100,arme.gainDesenchantement());
    }

    @Test(expected = GainDesenchantementException.class)
    public void ErrGainDesanchentement() throws Exception{
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.BASIQUE, Classe.GUERRIER, 100,100);
        arme.gainDesenchantement();
    }

    @Test(expected = CarteDoreeException.class)
    public void ErrCarteDoree() throws Exception{
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.EPIQUE, Classe.GUERRIER, 100,100);
        arme = arme.fabriquerCarteDoree(arme);
        arme = arme.fabriquerCarteDoree(arme);
    }

    
    @Test(expected = CarteBasiqueException.class)
    public void ErrCarteBasique() throws Exception{
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.BASIQUE, Classe.GUERRIER, 100,100);
        arme = arme.fabriquerCarteDoree(arme);
    }

    @Test
    public void EssFabriquerDoree()throws Exception{
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.EPIQUE, Classe.GUERRIER, 100,100);
        Carte serviteur = new Serviteur("Ranger",4,"Strong",Rarete.RARE,Classe.DRUIDE, 5,6,Race.MECA);
        Carte sort = new Sort("sort",6,"Feu",Rarete.RARE,Classe.GUERRIER);
        arme = arme.fabriquerCarteDoree(arme);
        serviteur = serviteur.fabriquerCarteDoree(serviteur);
        sort = sort.fabriquerCarteDoree(sort);
        assertEquals("Test Carte Doree arme",true,arme.estDoree());
        assertEquals("Test Carte Doree serviteur",true,serviteur.estDoree());
        assertEquals("Test Carte Doree sort",true,sort.estDoree());
    }


    @Test
    public void EssEquals() throws Exception{
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.EPIQUE, Classe.GUERRIER, 100,100);
        Carte arme2 = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.EPIQUE, Classe.GUERRIER, 100,100);
        assertEquals("Equals ",true,arme.equals(arme2));
    }
}