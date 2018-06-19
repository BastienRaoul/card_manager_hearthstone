
import hearthstone.carte.*;
import hearthstone.cartes.Cartes;
import hearthstone.cartes.FabriqueJson;
import hearthstone.exception.CarteBasiqueException;
import hearthstone.exception.CarteDoreeException;
import hearthstone.exception.CoutCreationException;
import hearthstone.exception.GainDesenchantementException;
import hearthstone.exception.ValeurNegativeException;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class TestCarte {

    /**
     * Test récupération coût en mana d'une arme
     */
    @Test
    public void test() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        assertEquals("manna different", 10, arme.mana());
    }

    /**
     * Test taille d'une collection
     */
    @Test
    public void test2() throws Exception {
        Cartes cartes = new Cartes(FabriqueJson.lireCartesDepuisFichier("json/initial.json"));
        assertEquals(3, cartes.collection().size());
    }

    /**
     * Test récupération de la classe de l'arme
     */
    @Test
    public void Classe() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        assertEquals("classe different", Classe.GUERRIER, arme.classe());
    }

    /**
     * Test récupération de la rareté d'une arme
     */
    @Test
    public void Rarete() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        assertEquals("rarete different", Rarete.LEGENDAIRE, arme.rarete());
    }

    /**
     * Test récupération du nom d'une arme
     */
    @Test
    public void nom() throws Exception {
        String nom = "marteau de Thor";
        Carte arme = new Arme(nom, 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        assertEquals("nom", "Marteau de thor", arme.nom());

    }

    /**
     * Test l'arme est dorée
     */
    @Test
    public void Doree() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        arme = arme.fabriquerCarteDoree(arme);
        assertEquals("Test Doree", true, arme.estDoree());
    }

    /**
     * Test l'arme n'est pas dorée
     */
    @Test
    public void nDoree() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        assertEquals("Test Doree", false, arme.estDoree());
    }

    /**
     * Test mana suffisant pour jouer l'arme
     */
    @Test
    public void EssJouable() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 5, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        assertEquals("Test Doree", true, arme.estJouable(6));
    }

    /**
     * Test mana insuffisant pour jouer l'arme
     */
    @Test
    public void EssnJouable() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 5, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        assertEquals("Test Doree", false, arme.estJouable(4));
    }

    /**
     * Test arme est la même qu'une autre arme (dorée / non dorée)
     */
    @Test
    public void EssestModuloDoree() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        Carte arme2 = arme;

        arme2 = Carte.fabriquerCarteDoree(arme);
        assertEquals("Test Doree", true, arme.estEgalModuloDoree(arme2));
    }

    /**
     * Test arme n'est pas la même qu'une autre arme (dorée / non dorée)
     */
    @Test
    public void EssnestModuloDoree() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        Carte arme2 = new Arme("Marteau de Thor", 5, "Marteau de Thor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100,
                100);
        arme2 = arme2.fabriquerCarteDoree(arme2);
        assertEquals("Test Doree", false, arme.estEgalModuloDoree(arme2));
    }

    /**
     * Test retourne le coût de création de l'arme
     */
    @Test(expected = CoutCreationException.class)
    public void ErrCoutCreation() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.BASIQUE, Classe.GUERRIER, 100, 100);
        arme.coutCreation();
    }

    /**
     * Test le coût le création d'une arme
     */
    @Test
    public void EssCoutCreation() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.RARE, Classe.GUERRIER, 100, 100);
        assertEquals("Test Cout Creation", 100, arme.coutCreation());
    }

    /**
     * Test le gain de désenchantement de l'arme
     */
    @Test
    public void GainDesenchentement() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.EPIQUE, Classe.GUERRIER, 100, 100);
        assertEquals("Test Gain Desenchantement", 100, arme.gainDesenchantement());
    }

    /**
     * Test retourne le gain de désenchantement de l'arme
     */
    @Test(expected = GainDesenchantementException.class)
    public void ErrGainDesanchentement() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.BASIQUE, Classe.GUERRIER, 100, 100);
        arme.gainDesenchantement();
    }

    /**
     * Test exception CarteDoreeException Transforme une carte déja dorée en dorée
     */
    @Test(expected = CarteDoreeException.class)
    public void ErrCarteDoree() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.EPIQUE, Classe.GUERRIER, 100, 100);
        arme = arme.fabriquerCarteDoree(arme);
        arme = arme.fabriquerCarteDoree(arme);
    }

    /**
     * Test exception CarteBasiqueException Transforme une carte en dorée On expecte
     * une carte basique
     */
    @Test(expected = CarteBasiqueException.class)
    public void ErrCarteBasique() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.BASIQUE, Classe.GUERRIER, 100, 100);
        arme = arme.fabriquerCarteDoree(arme);
    }

    /**
     * Création carte arme, serviteur, sort Transformation des cartes en dorée Test
     * carte arme, serviteur, sort est doré
     */
    @Test
    public void EssFabriquerDoree() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.EPIQUE, Classe.GUERRIER, 100, 100);
        Carte serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.RARE, Classe.DRUIDE, 5, 6, Race.MECA);
        Carte sort = new Sort("sort", 6, "Feu", Rarete.RARE, Classe.GUERRIER);
        arme = arme.fabriquerCarteDoree(arme);
        serviteur = serviteur.fabriquerCarteDoree(serviteur);
        sort = sort.fabriquerCarteDoree(sort);
        assertEquals("Test Carte Doree arme", true, arme.estDoree());
        assertEquals("Test Carte Doree serviteur", true, serviteur.estDoree());
        assertEquals("Test Carte Doree sort", true, sort.estDoree());
    }

    /**
     * Création carte arme, serviteur, sort Test carte arme, serviteur, sort n'est
     * pas doré
     */
    @Test
    public void EssnFabriquerDoree() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.EPIQUE, Classe.GUERRIER, 100, 100);
        Carte serviteur = new Serviteur("Ranger", 4, "Strong", Rarete.RARE, Classe.DRUIDE, 5, 6, Race.MECA);
        Carte sort = new Sort("sort", 6, "Feu", Rarete.RARE, Classe.GUERRIER);

        assertEquals("Test Carte Doree arme", false, arme.estDoree());
        assertEquals("Test Carte Doree serviteur", false, serviteur.estDoree());
        assertEquals("Test Carte Doree sort", false, sort.estDoree());
    }

    /**
     * Test méthode equals
     * Une arme est la même qu'une autre arme
     */
    @Test
    public void EssEquals() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.EPIQUE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.EPIQUE, Classe.GUERRIER, 100, 100);
        assertEquals("Equals ", true, arme.equals(arme2));
    }

    /**
     * Test NullPointerException
     * Création d'une arme avec en paramètre nom : null
     */
    @Test(expected = NullPointerException.class)
    public void testNullparam() throws Exception {
        Carte arme1 = new Arme(null, 10, "Marteau de Thor...", Rarete.EPIQUE, Classe.GUERRIER, 100, 100);
    }

    /**
     * Test NullPointerException
     * Création d'une arme avec en paramètre desc : null
     */
    @Test(expected = NullPointerException.class)
    public void testNullparam1() throws Exception {
        Carte arme2 = new Arme("Marteau de Thor.", 10, null, Rarete.EPIQUE, Classe.GUERRIER, 100, 100);
    }

    /**
     * Test NullPointerException
     * Création d'une arme avec en paramètre rarete : null
     */
    @Test(expected = NullPointerException.class)
    public void testNullparam2() throws Exception {
        Carte arme3 = new Arme("Marteau de Thor.", 10, "Marteau de Thor...", null, Classe.GUERRIER, 100, 100);
    }

    /**
     * Test NullPointerException
     * Création d'une arme avec en paramètre classe : null
     */
    @Test(expected = NullPointerException.class)
    public void testNullparam3() throws Exception {
        Carte arme4 = new Arme("Marteau de Thor.", 10, "Marteau de Thor...", Rarete.EPIQUE, null, 100, 100);
    }

    /**
     * Test méthode equals
     * Une arme n'est pas la même qu'une autre arme
     */
    @Test
    public void EssnEquals() throws Exception {
        Carte arme = new Arme("Marteau de Thor", 10, "Marteau de Thor...", Rarete.EPIQUE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau de Thor", 5, "Marteau de Thor...", Rarete.EPIQUE, Classe.GUERRIER, 100, 100);
        assertEquals("Equals ", false, arme.equals(arme2));
    }

    /**
     * Test description courte de la carte arme
     */
    @Test
    public void estDescription() throws ValeurNegativeException {
        Carte arme2 = new Arme("Marteau de Thor", 5, "aaaaaaaaaaaaaaaaaaaa", Rarete.EPIQUE, Classe.GUERRIER, 100, 100);
        assertEquals("aaaaaaaaaa", arme2.descriptionCourte());
    }

}