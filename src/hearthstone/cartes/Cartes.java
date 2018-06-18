package hearthstone.cartes;

import hearthstone.carte.Carte;
import hearthstone.exception.CarteAbsenteException;
import hearthstone.exception.CarteDejaPresenteException;
import hearthstone.exception.DeckCreationException;
import hearthstone.exception.DeckSuppressionException;

import java.util.*;

/**
 * Classe représentant l'ensemble des cartes disponibles par quelqu'un Attention
 * : un paquet de cartes ne peut contenir qu'un exemplaire de chaque carte
 * 
 * @author lanoix-a remm-jf
 * @version 1.0
 */

public class Cartes implements ManipulationCartes {

    private Collection<Carte> collectionDeCarte = null;

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
        if (estPresente(carte))
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
     * @param deck le deck à ajouter
     * @throws DeckCreationException si le deck est déjà présent
     */
    public void ajouterDeck(Deck monNouveauDeck) throws DeckCreationException {
        if (estPresentDeck(monNouveauDeck))
            throw new DeckCreationException("This deck is already in the decklist !");

        for (Carte carte : monNouveauDeck.collection())
            if (!estPresente(carte))
                throw new DeckCreationException("On of the deck's card does not exist in the current set !");
        maListeDeDeck.add(monNouveauDeck);
    }

    /**
     * supprime le deck de la liste de deck
     * 
     * @param carte la carte à supprimer
     * @throws DeckSuppressionException si le deck n'est pas dans la liste de deck
     */
    public void effacerDeck(Deck deck) throws DeckSuppressionException {
        if (estPresentDeck(deck))
            throw new DeckSuppressionException("This card does not exist in this set !");
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
                while (deck.estPresente(carte))
                    deck.effacer(carte);
            } catch (CarteAbsenteException e) {
            }
        }
    }

}
