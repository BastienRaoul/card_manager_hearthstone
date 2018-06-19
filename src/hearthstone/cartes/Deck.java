package hearthstone.cartes;

import hearthstone.carte.Carte;
import hearthstone.carte.Classe;
import hearthstone.carte.Rarete;
import hearthstone.exception.*;

import java.util.*;

/**
 *
 * Classe représentant un deck, c'est à dire, une sélection de cartes parmi les
 * cartes disponible dans le paquet de cartes associés - un deck est associé à
 * un paquet de cartes - un deck a une classe de cartes associée - un deck a une
 * taille maximum fixé On ne peut ajouter un carte à un deck qu'en respectant
 * certaines contraintes : - la carte doit être dans le paquet de cartes associé
 * - la carte doit respectée la classe du deck ou être NEUTRE - le deck ne doit
 * pas être plein - si la carte est LEGENDAIRE elle ne peut être qu'une 1 fois
 * dans le deck (que la carte soit dorée ou non) ; - sinon la carte ne peut être
 * que 1 ou 2 fois dans le deck (que la carte soit dorée ou non)
 *
 * @author lanoix-a remm-jf
 * @version 1.0
 */

public class Deck implements ManipulationCartes {

  private ArrayList<Carte> list;
  private Cartes mesCartes;
  private Classe maClasse;
  private int tailleMax;

  /**
   * créer un deck
   * On creer une ArrayList pour laisser des doublons
   * 
   * @param mesCartes le paquet de carte associé
   * @param maClasse  la classe associée
   * @param tailleMax la taille maximum pour ce deck
   * @throws ClasseNeutreException         si la classe du deck est NEUTRE
   * @throws LimiteNombreDeCartesException si la taille max dépasse 30
   */
  public Deck(Cartes mesCartes, Classe maClasse, int tailleMax)
      throws ClasseNeutreException, LimiteNombreDeCartesException {
        //On test chaque erreur cas par cas
    if (tailleMax > 30) {
      throw new LimiteNombreDeCartesException("taille trop grande");
    }
    if (maClasse == Classe.NEUTRE) {
      throw new ClasseNeutreException("un deck ne peut pas être NEUTRE");
    }
    this.mesCartes = mesCartes;
    this.maClasse = maClasse;
    this.tailleMax = tailleMax;
    this.list = new ArrayList<>(tailleMax);
  }

  /**
   * créer un deck
   * 
   * @param mesCartes le paquet de carte associé
   * @param maClasse  la classe associée
   * @throws ClasseNeutreException         si la classe du deck est NEUTRE
   * @throws LimiteNombreDeCartesException si la taille max dépasse 30
   */
  public Deck(Cartes mesCartes, Classe maClasse) throws ClasseNeutreException, LimiteNombreDeCartesException {
    //On appelle le constructeur au dessus en mettant comme valeur de base 30 pour la taille maximum
    this(mesCartes, maClasse, 30);
  }

  /**
   *
   * @return le deck sous la forme d'une collection de cartes au sens Collection
   *         de Cartes
   */
  @Override
  public Collection<Carte> collection() {
    return this.list;
  }

  /**
   * test si la carte est présente dans le deck
   * 
   * @param carte la carte à rechercher
   * @return true si la carte est présente dans le deck
   */
  @Override
  public boolean estPresente(Carte carte) {
    return this.list.contains(carte);
  }

  /**
   * Ajout d'une carte dans le deck
   * 
   * @param carte la carte à ajouter
   * @throws DeckPleinException            le deck ne doit pas être plein
   * @throws CarteNonDisponibleException   la carte doit être dans le paquet de
   *                                       cartes associé
   * @throws CarteMauvaiseClasseException  la carte doit respectée la classe du
   *                                       deck ou être NEUTRE
   * @throws LimiteNombreDeCartesException la carte ne peut être que 1 ou 2 fois
   *                                       dans le deck (que la carte soit dorée
   *                                       ou non) ; 1 seule fois si carte
   *                                       LEGENDAIRE
   */
  @Override
  public void ajouter(Carte carte) throws DeckPleinException, CarteNonDisponibleException, CarteMauvaiseClasseException,
      LimiteNombreDeCartesException {
    //On exclu les Exception au cas par cas
    if (this.list.size() >= this.tailleMax) {
      throw new DeckPleinException("le deck est plein");
    }
    if (!(this.mesCartes.estPresente(carte))) {
      throw new CarteNonDisponibleException("la carte n'est pas présente dans le paquet de carte");
    }
    if (!(carte.classe() == this.maClasse || carte.classe() == Classe.NEUTRE)) {
      throw new CarteMauvaiseClasseException("la carte ne fait pas partie de la bonne classe");
    }

    //Pour la dernière Exception on parcours toutes la liste grâce à un iterator pour compter le nombre de fois qu'est présente la carte
    //Si on as déjà deux carte on directement une Exception et si on en a seulement une on verifi que ce n'est pas un carte légendaire 
    int count = 0;
    for (Iterator<Carte> i = list.iterator(); i.hasNext();) {

      Carte tmp = i.next();
      if (tmp.equals(carte)) {
        count++;
        if (carte.rarete() == Rarete.LEGENDAIRE) {
          throw new LimiteNombreDeCartesException("Une carte légendaire ne peut être ajouté qu'une fois");
        }
        if (count == 2) {
          throw new LimiteNombreDeCartesException("On ne peut pas ajouter une carte plus de deux fois");
        }
      }
    }
    this.list.add(carte);
  }

  /**
   * supprime la carte du deck
   * 
   * @param carte la carte à supprimer
   * @throws CarteAbsenteException si la carte n'est pas dans le deck
   */
  @Override
  public void effacer(Carte carte) throws CarteAbsenteException {
    //On verifie si la carte est présente dans le Deck avant de la supprimer
    if (!estPresente(carte)) {
      throw new CarteAbsenteException("cette carte n'est pas présente dans le Deck");
    }

    list.remove(carte);
  }

  /**
   * supprime les cartes du deck
   * 
   * @param carte la carte à supprimer
   * @throws CarteAbsenteException si la carte n'est pas dans le deck
   */
  public void effacerToutesCartes(Carte carte) throws CarteAbsenteException {
    //On verifie si la carte est présente dans le Deck
    if (!estPresente(carte)) {
      throw new CarteAbsenteException("cette carte n'est pas présente dans le Deck");
    }
    //On supprime la carte tant qu'elle est présente dans le Deck
    while (estPresente(carte))
      list.remove(carte);
  }

  /**
   *
   * @return la taille maximum déterminée pour le deck
   */
  public int tailleMax() {
    return this.tailleMax;
  }

  /**
   *
   * @return la taille actuelle du deck
   */
  public int tailleActuelle() {
    return list.size();
  }

  /**
   *
   * @return la classe du deck
   */
  public Classe classe() {
    return this.maClasse;
  }

  /**
   * melange le deck ; l'ordre des cartes dans le deck doit être modifié
   */
  public void melanger() {
    //On utilise un shuffle qui nous permet de melanger l'ordre de la liste
    Collections.shuffle(list);
  }
}
