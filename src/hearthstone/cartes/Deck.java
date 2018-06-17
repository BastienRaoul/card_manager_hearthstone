package hearthstone.cartes;

import hearthstone.carte.Carte;
import hearthstone.carte.Classe;
import hearthstone.carte.Rarete;
import hearthstone.exception.*;

import java.util.*;

/**
 *
 *  Classe représentant un deck, c'est à dire, une sélection de cartes parmi les cartes disponible dans le paquet de cartes associés
 *  - un deck est associé à un paquet de cartes
 *  - un deck a une classe de cartes associée
 *  - un deck a une taille maximum fixé
 * On ne peut ajouter un carte à un deck qu'en respectant certaines contraintes :
 * - la carte doit être dans le paquet de cartes associé
 *  - la carte doit respectée la classe du deck ou être NEUTRE
 *  - le deck ne doit pas être plein
 *  - si la carte est LEGENDAIRE elle ne peut être qu'une 1 fois dans le deck (que la carte soit dorée ou non) ;
 *  - sinon la carte ne peut être que 1 ou 2 fois dans le deck (que la carte soit dorée ou non)
 *
 * @author lanoix-a remm-jf
 * @version 1.0
 */

public class Deck implements ManipulationCartes  {


  /**
   * créer un deck
   * @param mesCartes le paquet de carte associé
   * @param maClasse la classe associée
   * @param tailleMax la taille maximum pour ce deck
   * @throws ClasseNeutreException si la classe du deck est NEUTRE
   * @throws LimiteNombreDeCartesException si la taille max dépasse 30
   */
    public Deck(Cartes mesCartes, Classe maClasse, int tailleMax) throws ClasseNeutreException, LimiteNombreDeCartesException {
      // TODO
    }

    /**
     * créer un deck
     * @param mesCartes le paquet de carte associé
     * @param maClasse la classe associée
     * @throws ClasseNeutreException si la classe du deck est NEUTRE
     * @throws LimiteNombreDeCartesException si la taille max dépasse 30
     */
    public Deck(Cartes mesCartes, Classe maClasse) throws ClasseNeutreException, LimiteNombreDeCartesException{
      // TODO
    }

    /**
     *
     * @return le deck sous la forme d'une collection de cartes au sens Collection de Cartes
     */
    @Override
    public Collection<Carte> collection() {
        // TODO
        return null;
    }

    /**
     * test si la carte est présente dans le deck
     * @param carte la carte à rechercher
     * @return true si la carte est présente dans le deck
     */
    @Override
    public boolean estPresente(Carte carte) {
        // TODO
        return false;
    }

    /**
     * Ajout d'une carte dans le deck
     * @param carte la carte à ajouter
     * @throws DeckPleinException le deck ne doit pas être plein
     * @throws CarteNonDisponibleException la carte doit être dans le paquet de cartes associé
     * @throws CarteMauvaiseClasseException la carte doit respectée la classe du deck ou être NEUTRE
     * @throws LimiteNombreDeCartesException la carte ne peut être que 1 ou 2 fois dans le deck (que la carte soit dorée ou non) ; 1 seule fois si carte LEGENDAIRE
     */
    @Override
    public void ajouter(Carte carte) throws DeckPleinException, CarteNonDisponibleException, CarteMauvaiseClasseException, LimiteNombreDeCartesException {
      // TODO
    }

    /**
     * supprime la carte du deck
     * @param carte la carte à supprimer
     * @throws CarteAbsenteException si la carte n'est pas dans le deck
     */
    @Override
    public void effacer(Carte carte) throws CarteAbsenteException {
      // TODO
    }


    /**
     *
     * @return la taille maximum déterminée pour le deck
     */
    public int tailleMax() {
      // TODO
        return 0;
    }

    /**
     *
     * @return la taille actuelle du deck
     */
    public int tailleActuelle() {
      // TODO
        return 0;
    }

    /**
     *
     * @return la classe du deck
     */
    public Classe classe() {
      // TODO
        return null;
    }


    /**
     * melange le deck ;
     * l'ordre des cartes dans le deck doit être modifié
     */
    public void melanger() {
      // TODO
    }

}
