
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

public class TestDeck {

    @Test(expected = LimiteNombreDeCartesException.class)
    public void testDeck1() throws Exception {
    Deck d = new Deck(new Cartes(),Classe.MAGE,31);
    }

    @Test(expected = ClasseNeutreException.class)
    public void testDeck2() throws Exception {
    Deck d = new Deck(new Cartes(),Classe.NEUTRE,30);
    }

       
    @Test(expected = ClasseNeutreException.class)
    public void testDeck3() throws Exception {
    Deck d = new Deck(new Cartes(),Classe.NEUTRE);
    }

       
    @Test(expected = DeckPleinException.class)
    public void testDeck4() throws Exception {
    Cartes t = new Cartes();
    Deck d = new Deck(t,Classe.GUERRIER,4);
   
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
    public void testDeck5() throws Exception {
    Deck d = new Deck(new Cartes(),Classe.GUERRIER);
    Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
    d.ajouter(arme0);
    }

    @Test(expected = CarteMauvaiseClasseException.class)
    public void testDeck6() throws Exception {
    Cartes t = new Cartes();
    Deck d = new Deck(t,Classe.GUERRIER);
    Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.LEGENDAIRE, Classe.DEMONISTE, 100, 100);
    t.ajouter(arme0);
    d.ajouter(arme0);
    }


    @Test(expected = LimiteNombreDeCartesException.class)
    public void testDeck7() throws Exception {
    Cartes t = new Cartes();
    Deck d = new Deck(t,Classe.GUERRIER);
    Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
    t.ajouter(arme0);
    d.ajouter(arme0);
    d.ajouter(arme0);
    }

    @Test(expected = LimiteNombreDeCartesException.class)
    public void testDeck8() throws Exception {
    Cartes t = new Cartes();
    Deck d = new Deck(t,Classe.MAGE);
    Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.EPIQUE, Classe.MAGE, 100, 100);
    t.ajouter(arme0);
    d.ajouter(arme0);
    d.ajouter(arme0);
    d.ajouter(arme0);
    }


    @Test(expected = CarteAbsenteException.class)
    public void testDeck9() throws Exception {
    Cartes t = new Cartes();
    Deck d = new Deck(t,Classe.MAGE);
    Carte arme0 = new Arme("Marteau Thor", 0, "MarteauThor...", Rarete.EPIQUE, Classe.MAGE, 100, 100);
    t.ajouter(arme0);
    d.effacer(arme0);

    }




    


}