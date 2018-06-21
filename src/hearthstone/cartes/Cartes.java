package hearthstone.cartes;

import hearthstone.carte.*;
import hearthstone.exception.*;

import java.util.*;

/**
 * Classe représentant l'ensemble des cartes disponibles par quelqu'un
 * Attention : un paquet de cartes ne peut contenir qu'un exemplaire de chaque
 * carte
 * 
 * @author lanoix-a remm-jf
 * @version 1.0
 */

public class Cartes implements ManipulationCartes {

    /**
     * Le hashset nous permet de ne pas avoir de doublon tous en permettant le
     * stockage des données. Il nous permet grace à sa structure interne de
     * facilement et rapidement acceder au données.
     */
    private HashSet<Carte> collectionDeCarte = null;

    /**
     * La structure de donnée qui contient les decks que l'on bind à la liste de
     * carte est une ArrayList. L'arraylist permet de stocker simplement les decks
     * sans ce soucier des doublons. En effet les doublons ne sont pas un probleme
     * en ce qui concerne les decks car il est permis de d'avoir plusieurs decks
     * égaux. De plus l'arraylist peux facilement est lié à une interface.
     */
    private List<Deck> maListeDeDeck = null;

    /*
     * 
     * Impl�mentation du d�nombrement. Permet � l'interface de mieux g�rer les
     * cartes.
     * 
     */
    private List<Denombrement> monDenombrement = null;

    /**
     * créer un paquet de cartes
     */
    public Cartes() {
	collectionDeCarte = new HashSet<>();
	maListeDeDeck = new ArrayList<>();
	monDenombrement = new ArrayList<>();
    }

    /**
     * créer un paquet de cartes et le remplir à partir des cartes initiales
     * passées en paramètre
     * 
     * @param cartesInitiales
     *            les cartes pour remplir le paquet de cartes
     * @throws CarteDejaPresenteException
     *             si une carte de cartes initiales est présente plusieurs fois
     */
    public Cartes(Collection<Carte> cartesInitiales) throws CarteDejaPresenteException {
	this();
	/*
	 * int throwException = 0;
	 * 
	 * for (Carte c : cartesInitiales) { if (throwException > 0 || estPresente(c))
	 * ++throwException; ajouter(c); }
	 * 
	 * if (throwException > 0) throw new CarteDejaPresenteException(throwException +
	 * " cards could not be added because of duplicates !");
	 */
	for (Carte c : cartesInitiales) {
	    if (estPresente(c))
		throw new CarteDejaPresenteException("Cards could not be added because of duplicates !");
	    ajouter(c);
	}
	buildDenombrement();
    }

    /**
     *
     * @return le paquet de cartes sous la forme d'une collection de cartes au sens
     *         Collection de Cartes
     */
    @Override
    public Collection<Carte> collection() {
	return collectionDeCarte;
    }

    /**
     * Ajout d'une carte au paquet de cartes
     * 
     * @param carte
     *            la carte à ajouter
     * @throws CarteDejaPresenteException
     *             si la carte est déjà présente
     */
    @Override
    public void ajouter(Carte carte) throws CarteDejaPresenteException {
	if (estPresente(carte)) {
	    throw new CarteDejaPresenteException("This card is already in this card set !");
	} else {
	    collectionDeCarte.add(carte);
	}
    }

    /**
     * test si la carte est présente dans le paquet de cartes
     * 
     * @param carte
     *            la carte à rechercher
     * @return true si la carte est présente
     */
    @Override
    public boolean estPresente(Carte carte) {
	return collectionDeCarte.contains(carte);
    }

    /**
     * supprime la carte du paquet de cartes
     * 
     * @param carte
     *            la carte à supprimer
     * @throws CarteAbsenteException
     *             si la carte n'est pas dans le paquet de cartes ou dans un decks
     */
    @Override
    public void effacer(Carte carte) throws CarteAbsenteException {
	if (!estPresente(carte))
	    throw new CarteAbsenteException("This card does not exist in this set !");

	effacerCarteDesDecks(carte);

	collectionDeCarte.remove(carte);
    }

    /**
     * test si le deck est présent dans la liste de deck
     * 
     * @param deck
     *            le deck à rechercher
     * @return true si le deck est présente
     */
    public boolean estPresentDeck(Deck deck) {
	return maListeDeDeck.contains(deck);
    }

    /**
     * tente d'ajouter le deck à la liste de deck
     * 
     * @param maClasse
     *            la classe du deck à ajouter
     */
    protected void ajouterDeck(Deck deck) throws DeckCreationException {
	for (Carte c : deck.collection()) {
	    if (!estPresente(c)) {
		throw new DeckCreationException("Le deck contient des carte qui ne peuvent pas etre utilisées");
	    }
	}
	maListeDeDeck.add(deck);
    }

    /**
     * tente d'ajouter le deck à la liste de deck avec un taille spécifiée
     * 
     * @param maClasse
     *            la classe du deck à ajouter
     * @param tailleMax
     *            la classe du deck à ajouter
     * @throws DeckCreationException
     *             quand le deck ne peut pas etre bind à la collection
     */
    public void ajouterDeck(Classe maClasse, int tailleMax, String nom) throws DeckCreationException {

	if (maClasse == null)
	    throw new DeckCreationException("classe null");

	try {
	    Deck nouveauDeck = null;
	    nouveauDeck = new Deck(this, maClasse, tailleMax, nom);
	} catch (Exception e) {
	    throw new DeckCreationException(e.getMessage());
	}
    }

    /**
     * supprime le deck de la liste de deck
     * 
     * @param deck
     *            le deck à supprimer
     * @throws DeckSuppressionException
     *             si le deck n'est pas dans la liste de deck
     */
    public void effacerDeck(Deck deck) throws DeckSuppressionException {
	if (!estPresentDeck(deck))
	    throw new DeckSuppressionException("This deck does not exist in this list !");
	maListeDeDeck.remove(deck);
    }

    /**
     * supprimme une carte de tous les decks
     * 
     * @param carte
     *            la carte à supprimer des decks
     */
    public void effacerCarteDesDecks(Carte carte) {
	// supprime une carte de tous les decks connus. Si la carte existe en double
	// dans un deck, la carte est supprimée 2 fois
	for (Deck deck : maListeDeDeck) {
	    // l'utilisation de estPresente est une possibilitée mais rend le code plus
	    // lent
	    // !
	    try {
		deck.effacerToutesCartes(carte);
	    } catch (CarteAbsenteException e) {
	    }
	}
    }

    /**
     *
     * @return les deck sous la forme d'une collection de deck au sens Collection de
     *         Deck
     */
    public List<Deck> collectionDeDeck() {
	return maListeDeDeck;
    }

    /**
     *
     * @return la liste des d�nombrement des cartes de la collection.
     */
    public List<Deck> decombrements() {
	return maListeDeDeck;
    }

    /**
     * Permet de construire le denombrement des cartes. Il faut executer apres
     * chaques modification, ou groupe de modification.
     */
    public void buildDenombrement() {
	List<Denombrement> denombrementsCartes = new ArrayList<>();

	for (Carte carte : collectionDeCarte) {
	    try {
		denombrementsCartes.add(new Denombrement(carte));
	    } catch (ValeurNegativeException e) {
		e.printStackTrace();
	    }
	}

	monDenombrement = denombrementsCartes;
    }

    /**
     * 
     * @param la
     *            carte a d�combrer
     * @return le nombre de cartes pos�d�es
     */
    public int getNbExemplaireFromDenombrement(Carte carte) {
	for (Denombrement denomb : monDenombrement) {
	    if (denomb.carte().equals(carte)) {
		return denomb.nombre();
	    }
	}
	return 0;
    }
}
