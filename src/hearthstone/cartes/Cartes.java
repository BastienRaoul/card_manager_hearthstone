package hearthstone.cartes;

import hearthstone.carte.*;
import hearthstone.exception.*;

import java.util.*;

/**
 * Classe représentant l'ensemble des cartes disponibles par quelqu'un Attention
 * : un paquet de cartes ne peut contenir qu'un exemplaire de chaque carte
 * 
 * @author lanoix-a remm-jf
 * @version 1.0
 */

public class Cartes implements ManipulationCartes {

    private HashSet<Carte> collectionDeCarte = null;

    private List<Deck> maListeDeDeck = null;

    /**
     * créer un paquet de cartes
     */
    public Cartes() {
        collectionDeCarte = new HashSet<>();
    }

    /**
     * créer un paquet de cartes et le remplir à partir des cartes initiales passées
     * en paramètre
     * 
     * @param cartesInitiales les cartes pour remplir le paquet de cartes
     * @throws CarteDejaPresenteException si une carte de cartes initiales est
     *                                    présente plusieurs fois
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
     * @param carte la carte à ajouter
     * @throws CarteDejaPresenteException si la carte est déjà présente
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
     * @param carte la carte à rechercher
     * @return true si la carte est présente
     */
    @Override
    public boolean estPresente(Carte carte) {
        return collectionDeCarte.contains(carte);
    }

    /**
     * supprime la carte du paquet de cartes
     * 
     * @param carte la carte à supprimer
     * @throws CarteAbsenteException si la carte n'est pas dans le paquet de cartes
     *                               ou dans un decks
     */
    @Override
    public void effacer(Carte carte) throws CarteAbsenteException {
        if (!estPresente(carte))
            throw new CarteAbsenteException("This card does not exist in this set !");
        collectionDeCarte.remove(carte);
    }

    /**
     * test si le deck est présent dans la liste de deck
     * 
     * @param deck le deck à rechercher
     * @return true si le deck est présente
     */
    public boolean estPresentDeck(Deck deck) {
        return maListeDeDeck.contains(deck);
    }

    /**
     * tente d'ajouter le deck à la liste de deck
     * 
     * @param maClasse la classe du deck à ajouter
     * @throws DeckCreationException si le deck est déjà présent
     */
    public void ajouterDeck(Classe maClasse) throws DeckCreationException {
        Deck nouveauDeck = null;
        try {
            nouveauDeck = new Deck(this, maClasse, 30);
        } catch (Exception e) {
            throw new DeckCreationException(e.getMessage());
        } finally {
            if (estPresentDeck(nouveauDeck))
                throw new DeckCreationException("This deck is already in the decklist !");
            /*
             * for (Carte carte : nouveauDeck.collection()) if (!estPresente(carte)) throw
             * new
             * DeckCreationException("On of the deck's card does not exist in the current set !"
             * );
             */
        }
        maListeDeDeck.add(nouveauDeck);
    }

    /**
     * supprime le deck de la liste de deck
     * 
     * @param deck le deck à supprimer
     * @throws DeckSuppressionException si le deck n'est pas dans la liste de deck
     */
    public void effacerDeck(Deck deck) throws DeckSuppressionException {
        if (!estPresentDeck(deck))
            throw new DeckSuppressionException("This deck does not exist in this list !");
        maListeDeDeck.remove(deck);
    }

    /**
     * supprimme une carte de tous les decks
     * 
     * @param carte la carte à supprimer des decks
     */
    public void effacerCarteDesDecks(Carte carte) {
        for (Deck deck : maListeDeDeck) {
            // l'utilisation de estPresente est une possibilitée mais rend le code plus lent
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
    public Collection<Deck> collectionDeDeck() {
        return maListeDeDeck;
    }

}
