package hearthstone.cartes;

import hearthstone.carte.Carte;
import hearthstone.exception.CarteAbsenteException;
import hearthstone.exception.CarteDejaPresenteException;

import java.util.*;

/**
 * Classe représentant l'ensemble des cartes disponibles par quelqu'un Attention
 * : un paquet de cartes ne peut contenir qu'un exemplaire de chaque carte
 * 
 * @author lanoix-a remm-jf
 * @version 1.0
 */

public class Cartes implements ManipulationCartes {

  /**
   * créer un paquet de cartes
   */
  public Cartes() {
    // TODO
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
    // TODO
  }

  /**
   *
   * @return le paquet de cartes sous la forme d'une collection de cartes au sens
   *         Collection de Cartes
   */
  @Override
  public Collection<Carte> collection() {
    // TODO
    return null;
  }

  /**
   * Ajout d'une carte au paquet de cartes
   * 
   * @param carte la carte à ajouter
   * @throws CarteDejaPresenteException si la carte est déjà présente
   */
  @Override
  public void ajouter(Carte carte) throws CarteDejaPresenteException {
    // TODO
  }

  /**
   * test si la carte est présente dans le paquet de cartes
   * 
   * @param carte la carte à rechercher
   * @return true si la carte est présente
   */
  @Override
  public boolean estPresente(Carte carte) {
    // TODO
    return false;
  }

  /**
   * supprime la carte du paquet de cartes
   * 
   * @param carte la carte à supprimer
   * @throws CarteAbsenteException si la carte n'est pas dans le paquet de cartes
   */
  @Override
  public void effacer(Carte carte) throws CarteAbsenteException {
    // TODO
  }

}
