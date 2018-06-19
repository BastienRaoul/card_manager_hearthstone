
import hearthstone.carte.*;
import hearthstone.cartes.*;
import hearthstone.exception.CarteAbsenteException;
import hearthstone.exception.CarteDejaPresenteException;
import hearthstone.exception.DeckCreationException;
import hearthstone.exception.DeckSuppressionException;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

public class TestCartes {

    @Test
    public void testCartes1() throws Exception {
        Cartes tasDeCarte = new Cartes();
        assertEquals("Test constructeur 1", 0, tasDeCarte.collection().size());
    }

    @Test(expected = CarteDejaPresenteException.class)
    public void testConstr1() throws Exception {
        Collection<Carte> listcatre = new ArrayList<>();
        Arme arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        listcatre.add(arme);
        listcatre.add(arme);
        Cartes tasDeCarte = new Cartes(listcatre);
    }

    @Test
    public void testCartes101() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau Thor2", 11, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme2);

        HashSet<Carte> dummy = new HashSet<>();
        dummy.add(arme);
        dummy.add(arme2);
        assertEquals("Test constructeur 2", dummy, tasDeCarte.collection());
    }

    @Test
    public void testCartes102() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau Thor2", 11, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        HashSet<Carte> dummy = new HashSet<>();
        assertEquals("Test constructeur 4", dummy, tasDeCarte.collection());
    }

    @Test
    public void testCartes2() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau Thor2", 11, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme2);
        assertEquals("Test constructeur 3", 2, tasDeCarte.collection().size());
    }

    @Test(expected = CarteDejaPresenteException.class)
    public void testCartes3() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau Thor2", 11, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme2);
    }

    @Test
    public void testCartes4() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau Thor2", 11, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        try {
            tasDeCarte.ajouter(arme2);
            tasDeCarte.ajouter(arme);
            tasDeCarte.ajouter(arme);
        } catch (Exception e) {
        }
        assertEquals("Test ajouter 1", 2, tasDeCarte.collection().size());
    }

    @Test
    public void testCartes5() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        assertEquals("Test ajouter 2", 0, tasDeCarte.collection().size());
        tasDeCarte.ajouter(arme);
        assertEquals("Test ajouter 3", 1, tasDeCarte.collection().size());
    }

    @Test
    public void testCartes6() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        assertEquals("Test est presente 1", false, tasDeCarte.estPresente(arme));
        tasDeCarte.ajouter(arme);
        assertEquals("Test est presente 2", true, tasDeCarte.estPresente(arme));
    }

    @Test(expected = CarteAbsenteException.class)
    public void testCartes7() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.effacer(arme);
        assertEquals("Test effacer 2", 0, tasDeCarte.collection().size());
        tasDeCarte.effacer(arme);
    }

    @Test
    public void testCartes8() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        tasDeCarte.ajouterDeck(Classe.CHASSEUR);
        tasDeCarte.collectionDeDeck().get(0).ajouter(arme);

        assertEquals("Test estPresentDeck 2", true, tasDeCarte.estPresentDeck(tasDeCarte.collectionDeDeck().get(0)));
    }

    @Test
    public void testCartes9() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        tasDeCarte.ajouterDeck(Classe.CHASSEUR);
        tasDeCarte.ajouterDeck(Classe.CHAMAN);
        tasDeCarte.ajouterDeck(Classe.DEMONISTE);
        tasDeCarte.ajouterDeck(Classe.CHASSEUR);

        assertEquals("Test estPresentDeck 1", 4, tasDeCarte.collectionDeDeck().size());
    }

    @Test
    public void testCartes10() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        tasDeCarte.ajouterDeck(Classe.CHASSEUR);
        tasDeCarte.ajouterDeck(Classe.CHAMAN);

        assertEquals("Test effacerDeck 1", 2, tasDeCarte.collectionDeDeck().size());

        tasDeCarte.effacerDeck(tasDeCarte.collectionDeDeck().get(0));

        assertEquals("Test effacerDeck 2", 1, tasDeCarte.collectionDeDeck().size());
    }

    @Test(expected = DeckSuppressionException.class)
    public void testCartes11() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.effacerDeck(new Deck(tasDeCarte, Classe.CHASSEUR, 30));
    }

    @Test
    public void testCartes12() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        tasDeCarte.ajouterDeck(Classe.CHASSEUR);
        tasDeCarte.collectionDeDeck().get(0).ajouter(arme);

        assertEquals("Test effacceCarteDesDecks 1", 1, tasDeCarte.collectionDeDeck().get(0).collection().size());
        tasDeCarte.effacerCarteDesDecks(arme);
        assertEquals("Test effacceCarteDesDecks 2", 0, tasDeCarte.collectionDeDeck().get(0).collection().size());
    }

    @Test
    public void testCartes13() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        tasDeCarte.ajouterDeck(Classe.CHASSEUR);

        assertEquals("Test collectionDeDeck 2", 1, tasDeCarte.collectionDeDeck().size());
    }

    @Test(expected = DeckSuppressionException.class)
    public void testCartes14() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        tasDeCarte.ajouterDeck(Classe.CHASSEUR);
        tasDeCarte.collectionDeDeck().get(0).ajouter(arme);

        Deck deck = tasDeCarte.collectionDeDeck().get(0);
        tasDeCarte.effacerDeck(deck);

        tasDeCarte.effacerDeck(deck);
    }

    @Test(expected = DeckCreationException.class)
    public void testCartes15() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        tasDeCarte.ajouterDeck(Classe.CHASSEUR, 31);
    }

    @Test
    public void testCartes16() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        tasDeCarte.ajouterDeck(Classe.CHASSEUR, 30);

        assertEquals(1, tasDeCarte.collectionDeDeck().size());
    }

    @Test(expected = DeckCreationException.class)
    public void testExceptionAjoutDeck() throws Exception {
        Cartes tasDeCarte = new Cartes();
        tasDeCarte.ajouterDeck(null);
    }
}