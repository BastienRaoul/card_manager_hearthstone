
import hearthstone.carte.*;
import hearthstone.cartes.*;
import hearthstone.exception.CarteAbsenteException;
import hearthstone.exception.CarteDejaPresenteException;
import hearthstone.exception.DeckCreationException;
import hearthstone.exception.DeckSuppressionException;
import hearthstone.exception.LimiteNombreDeCartesException;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

public class TestCartes {

    /**
     * Test taille du tasDeCarte
     */
    @Test
    public void testCartes1() throws Exception {
        Cartes tasDeCarte = new Cartes();
        assertEquals("Test constructeur 1", 0, tasDeCarte.collection().size());
    }

    /**
     * Test CarteDejaPresenteException ajout d'une carte déja existante dans
     * listcartre
     */
    @Test(expected = CarteDejaPresenteException.class)
    public void testConstr1() throws Exception {
        Collection<Carte> listcartre = new ArrayList<>();
        Arme arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        listcartre.add(arme);
        listcartre.add(arme);
        Cartes tasDeCarte = new Cartes(listcartre);
    }

    /**
     * Test collection du tasDeCarte avec 2 cartes
     */
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

    /**
     * Test collection du tasDeCarte sans carte
     */
    @Test
    public void testCartes102() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau Thor2", 11, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        HashSet<Carte> dummy = new HashSet<>();
        assertEquals("Test constructeur 4", dummy, tasDeCarte.collection());
    }

    /**
     * Test taille de la collection de cartes tasDeCarte
     */
    @Test
    public void testCartes2() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau Thor2", 11, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme2);
        assertEquals("Test constructeur 3", 2, tasDeCarte.collection().size());
    }

    /**
     * Test CarteDejaPresenteException Ajout de 2 fois la même carte dans le
     * tasDeCarte
     */
    @Test(expected = CarteDejaPresenteException.class)
    public void testCartes3() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte arme2 = new Arme("Marteau Thor2", 11, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(arme2);
    }

    /**
     * Exception car ajout de 2 fois la même carte dans le tasDeCarte Test taille de
     * la collection de cartes tasDeCarte
     */
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

    /**
     * Test taille collection tasDeCarte avec ajout d'une carte arme
     */
    @Test
    public void testCartes5() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        assertEquals("Test ajouter 2", 0, tasDeCarte.collection().size());
        tasDeCarte.ajouter(arme);
        assertEquals("Test ajouter 3", 1, tasDeCarte.collection().size());
    }

    /**
     * Test méthode estPresente carte arme dans tasDeCarte
     */
    @Test
    public void testCartes6() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        assertEquals("Test est presente 1", false, tasDeCarte.estPresente(arme));
        tasDeCarte.ajouter(arme);
        assertEquals("Test est presente 2", true, tasDeCarte.estPresente(arme));
    }

    /**
     * Test CarteAbsenteException Méthode effacer une carte arme dans collection
     * tasDeCarte mais déjà vide
     */
    @Test(expected = CarteAbsenteException.class)
    public void testCartes7() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);
        tasDeCarte.effacer(arme);
        assertEquals("Test effacer 2", 0, tasDeCarte.collection().size());
        tasDeCarte.effacer(arme);
    }

    /**
     * Test méthode estPresentDeck dans tasDeCarte
     */
    @Test
    public void testCartes8() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        Deck deck = new Deck(tasDeCarte, Classe.CHASSEUR);

        deck.ajouter(arme);

        assertEquals("Test estPresentDeck 2", true, tasDeCarte.estPresentDeck(deck));
    }

    /**
     * Test taille collectionDeck de tasDeCarte
     */
    @Test
    public void testCartes9() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        Deck deck = new Deck(tasDeCarte, Classe.CHASSEUR);
        Deck deck1 = new Deck(tasDeCarte, Classe.CHAMAN);
        Deck deck2 = new Deck(tasDeCarte, Classe.DEMONISTE);
        Deck deck3 = new Deck(tasDeCarte, Classe.CHASSEUR);

        assertEquals("Test estPresentDeck 1", 4, tasDeCarte.collectionDeDeck().size());
    }

    /**
     * Test taille collectionDeck de tasDeCarte Effacement première entrée de
     * tasDeCarte Test taille collectionDeck de tasDeCarte
     */
    @Test
    public void testCartes10() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        Deck deck2 = new Deck(tasDeCarte, Classe.CHAMAN);
        Deck deck3 = new Deck(tasDeCarte, Classe.CHASSEUR);

        assertEquals("Test effacerDeck 1", 2, tasDeCarte.collectionDeDeck().size());

        tasDeCarte.effacerDeck(tasDeCarte.collectionDeDeck().get(0));

        assertEquals("Test effacerDeck 2", 1, tasDeCarte.collectionDeDeck().size());
    }

    /**
     * Test DeckSuppressionException
     */
    @Test(expected = DeckSuppressionException.class)
    public void testCartes11() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        Deck deck = new Deck(tasDeCarte, Classe.CHASSEUR);
        tasDeCarte.effacerDeck(deck);
        tasDeCarte.effacerDeck(deck);
    }

    /**
     * Test taille de la collection tasDeCarte Suppresion de la carte arme dans
     * tasDeCarte Test taille de la collection tasDeCarte
     */
    @Test
    public void testCartes12() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        Deck deck = new Deck(tasDeCarte, Classe.CHASSEUR);

        tasDeCarte.collectionDeDeck().get(0).ajouter(arme);

        assertEquals("Test effacceCarteDesDecks 1", 1, tasDeCarte.collectionDeDeck().get(0).collection().size());
        tasDeCarte.effacerCarteDesDecks(arme);
        assertEquals("Test effacceCarteDesDecks 2", 0, tasDeCarte.collectionDeDeck().get(0).collection().size());
    }

    /**
     * Ajout deck de la classe chasseur Test taille collectionDeDeck de tasDeCarte
     */
    @Test
    public void testCartes13() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        Deck deck = new Deck(tasDeCarte, Classe.CHASSEUR);

        assertEquals("Test collectionDeDeck 2", 1, tasDeCarte.collectionDeDeck().size());
    }

    /**
     * Test DeckSuppressionException Suppresion de 2 deck alors qu'un seul a été
     * ajouté
     */
    @Test(expected = DeckSuppressionException.class)
    public void testCartes14() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        Deck deck = new Deck(tasDeCarte, Classe.CHASSEUR);

        tasDeCarte.collectionDeDeck().get(0).ajouter(arme);

        Deck deck2 = tasDeCarte.collectionDeDeck().get(0);
        tasDeCarte.effacerDeck(deck);

        tasDeCarte.effacerDeck(deck);
    }

    /**
     * Test DeckCreationException Taille du deck trop grande par rapport à la limite
     */
    @Test(expected = LimiteNombreDeCartesException.class)
    public void testCartes15() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        Deck deck = new Deck(tasDeCarte, Classe.CHASSEUR, 31);
    }

    /**
     * Ajout deck de la classe chasseur de taille 30 dans tasDeCarte Test taille
     * collectionDeDeck tasDeCarte *
     */
    @Test
    public void testCartes16() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.CHASSEUR, 100, 100);
        tasDeCarte.ajouter(arme);

        tasDeCarte.ajouterDeck(Classe.CHASSEUR, 30);

        assertEquals(1, tasDeCarte.collectionDeDeck().size());
    }

    /**
     * Test DeckCreationException ajout d'un deck null dans tasDeCarte
     */
    @Test(expected = DeckCreationException.class)
    public void testExceptionAjoutDeck() throws Exception {
        Cartes tasDeCarte = new Cartes();
        tasDeCarte.ajouterDeck(null, 1);
    }
}