
import hearthstone.carte.*;
import hearthstone.cartes.Cartes;
import hearthstone.cartes.Deck;
import hearthstone.cartes.FabriqueJson;
import hearthstone.exception.CarteAbsenteException;
import hearthstone.exception.CarteDejaPresenteException;
import hearthstone.exception.CarteMauvaiseClasseException;
import hearthstone.exception.CarteNonDisponibleException;
import hearthstone.exception.ClasseNeutreException;
import hearthstone.exception.DeckPleinException;
import hearthstone.exception.LimiteNombreDeCartesException;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeNoException;

import java.util.ArrayList;

public class TestDeck {

    @Test(expected = LimiteNombreDeCartesException.class)
    public void ErrTaille() throws Exception {
        Deck d = new Deck(new Cartes(), Classe.MAGE, 31);
    }

    @Test(expected = ClasseNeutreException.class)
    public void ErrClasse() throws Exception {
        Deck d = new Deck(new Cartes(), Classe.NEUTRE, 30);
    }

    @Test(expected = ClasseNeutreException.class)
    public void ErrClasse2() throws Exception {
        Deck d = new Deck(new Cartes(), Classe.NEUTRE);
    }

    @Test(expected = DeckPleinException.class)
    public void ErrTailleaj() throws Exception {
        Cartes t = new Cartes();
        Deck d = new Deck(t, Classe.GUERRIER, 4);

        Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme1 = new Arme("arteau Thor", 1, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Mrteau Thor", 2, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme3 = new Arme("Mateau Thor", 3, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme4 = new Arme("Mareau Thor", 4, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        t.ajouter(arme0);
        t.ajouter(arme1);
        t.ajouter(arme2);
        t.ajouter(arme3);
        t.ajouter(arme4);

        d.ajouter(arme0);
        d.ajouter(arme1);
        d.ajouter(arme2);
        d.ajouter(arme3);
        d.ajouter(arme4);
    }

    @Test(expected = CarteNonDisponibleException.class)
    public void ErrCartesaj() throws Exception {
        Deck d = new Deck(new Cartes(), Classe.GUERRIER);
        Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        d.ajouter(arme0);
    }

    @Test(expected = CarteMauvaiseClasseException.class)
    public void ErrClasseaj() throws Exception {
        Cartes t = new Cartes();
        Deck d = new Deck(t, Classe.GUERRIER);
        Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.LEGENDAIRE, Classe.DEMONISTE, 100, 100);
        t.ajouter(arme0);
        d.ajouter(arme0);
    }

    @Test(expected = LimiteNombreDeCartesException.class)
    public void Errrareteaj() throws Exception {
        Cartes t = new Cartes();
        Deck d = new Deck(t, Classe.GUERRIER);
        Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        t.ajouter(arme0);
        d.ajouter(arme0);
        d.ajouter(arme0);
    }

    @Test(expected = LimiteNombreDeCartesException.class)
    public void Errrareteaj2() throws Exception {
        Cartes t = new Cartes();
        Deck d = new Deck(t, Classe.MAGE);
        Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.EPIQUE, Classe.MAGE, 100, 100);
        t.ajouter(arme0);
        d.ajouter(arme0);
        d.ajouter(arme0);
        d.ajouter(arme0);
    }

    @Test(expected = CarteAbsenteException.class)
    public void Erreffacer() throws Exception {
        Cartes t = new Cartes();
        Deck d = new Deck(t, Classe.MAGE);
        Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.EPIQUE, Classe.MAGE, 100, 100);
        t.ajouter(arme0);
        d.effacer(arme0);

    }

    @Test
    public void EssTailleMax() throws Exception {
        Cartes t = new Cartes();
        Deck d = new Deck(t, Classe.MAGE, 30);
        assertEquals("testDeck 10 ", 30, d.tailleMax());
    }

    @Test
    public void EssTailleActuelle() throws Exception {
        Cartes t = new Cartes();
        Deck d = new Deck(t, Classe.MAGE);
        Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.EPIQUE, Classe.MAGE, 100, 100);
        t.ajouter(arme0);
        d.ajouter(arme0);
        assertEquals("testDeck 11 ", 1, d.tailleActuelle());
    }

    @Test
    public void EssClasse() throws Exception {
        Cartes t = new Cartes();
        Deck d = new Deck(t, Classe.MAGE);
        assertEquals("testDeck 12 ", Classe.MAGE, d.classe());

    }

    @Test
    public void EssAjouter() throws Exception {
        Cartes t = new Cartes();
        Deck d = new Deck(t, Classe.MAGE);
        Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.EPIQUE, Classe.MAGE, 100, 100);
        t.ajouter(arme0);
        d.ajouter(arme0);
        assertEquals("testDeck 13 ", 1, d.tailleActuelle());
    }

    @Test
    public void EssEffacer() throws Exception {
        Cartes t = new Cartes();
        Deck d = new Deck(t, Classe.MAGE);
        Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.EPIQUE, Classe.MAGE, 100, 100);
        t.ajouter(arme0);
        d.ajouter(arme0);
        d.ajouter(arme0);
        d.effacer(arme0);
        assertEquals("testDeck 13 ", 1, d.tailleActuelle());
    }

    @Test
    public void EssestPresent() throws Exception {
        Cartes t = new Cartes();
        Deck d = new Deck(t, Classe.MAGE);
        Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.EPIQUE, Classe.MAGE, 100, 100);
        t.ajouter(arme0);
        d.ajouter(arme0);
        assertEquals("testDeck 13 ", true, d.estPresente(arme0));
    }

    @Test
    public void EssCollection() throws Exception {
        Cartes t = new Cartes();
        Deck d = new Deck(t, Classe.MAGE);
        Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.EPIQUE, Classe.MAGE, 100, 100);
        t.ajouter(arme0);
        d.ajouter(arme0);
        ArrayList ar = new ArrayList();
        ar.add(arme0);
        assertEquals("testDeck 16 ", ar, d.collection());
    }
}