package hearthstone.cartes;

import hearthstone.carte.*;
import hearthstone.exception.ClasseNeutreException;
import hearthstone.exception.CoutCreationException;
import hearthstone.exception.GainDesenchantementException;

import java.util.*;

/**
 * Classe statique proposant diverses méthodes de filtrage de collection de cartes
 *
 * @author lanoix-a remm-jf
 * @version 1.0
 */

public class Filtre {

    /**
     * filtre uniquement les cartes "Arme" d'une collection de cartes données
     * @param desCartes la collection de cartes à trier
     * @return la collection des carte "Serviteur" contenues dans la collection de cartes
     */
    public static Collection<Arme> cartesArme(Collection<? extends Carte> desCartes) {
      // TODO
      return null;
    }

    /**
     *  filtre uniquement les cartes "Serviteur" d'une collection de cartes données
     * @param desCartes la collection de cartes à trier
     * @return la collection des cartes "Serviteur" contenues dans la collection de cartes
     */
    public static Collection<Serviteur> cartesServiteur(Collection<? extends Carte> desCartes) {
      // TODO
      return null;
    }

    /**
     *  filtre uniquement les cartes "Sort" d'une collection de cartes données
     * @param desCartes la collection de cartes à trier
     * @return la collection des cartes "Sort" contenues dans la collection de cartes
     */
    public static Collection<Sort> cartesSort(Collection<? extends Carte> desCartes) {
      // TODO
      return null;
    }

    /**
     * filtre les cartes d'une collection en fonction de leur Rareté
     * @param desCartes une collection de cartes à trier
     * @param rarete la rareté utilisée pour filtrer
     * @return la collection des cartes qui ont comme raretés rarete
     */
    public static Collection<Carte> cartesParRarete(Collection<? extends Carte> desCartes, Rarete rarete) {
      // TODO
      return null;
    }

    /**
     * filtre une collection de cartes "Serviteur" en fonction d'une race donné
     * @param desCartes la collection de cartes "Serviteur" à filtrer
     * @param race la race pour filtrer
     * @return la collection de cartes qui ont comme races race
     */
    public static Collection<Serviteur> cartesParRace(Collection<Serviteur> desCartes, Race race) {
      // TODO
      return null;

    }

    /**
     * filtre une collection de cartes en fonction si les cartes sont dorées
     * @param desCartes la collection de cartes à filtrer
     * @return la colelction de cartes dorées
     */
    public static Collection<Carte> cartesDorees(Collection<? extends Carte> desCartes) {
      // TODO
      return null;

    }

    /**
     * filtre une collection de cartes en fonction d'une classe donnée
     * la collection résultat ne contiendra que des cartes de la classe données ou une classe NEUTRE
     * @param desCartes la collection de cartes à filtrer
     * @param classe la classe pour filtrer
     * @return la collection de cartes qui ont comme class la classe donnée ou NEUTRE
     * @throws ClasseNeutreException si jamais il est demandé de filtrer avec la classe NEUTRE
     */
    public static Collection<Carte> cartesParClasse(Collection<? extends Carte> desCartes, Classe classe) throws ClasseNeutreException {
      // TODO
      return null;
    }

    /**
     * calcule le mana necessaire pour activer un paquet de cartes
     * @param desCartes les cartes à activer
     * @return la valeur de mana necessaire
     */
    public static int manaMinimalNecessaire(Collection<? extends Carte> desCartes) {
      // TODO
      return 0;
    }


    /**
     * calcule le gain total issu du desenchantement d'une collection de cartes
     * @param desCartes les cartes à desenchanter
     * @return la valeur totale de desenchantement
     */
    public static int gainDesenchantementTotal(Collection<? extends Carte> desCartes) {
      // TODO
      return 0;
    }


    /**
     * indique s'il est possible de créer un ensemble de cartes avec une valeur de création  disponible?
     * @param desCartes le scartes à créer
     * @param valeurCreationDisponible la valeur de création disponible
     * @return true si la création est possible
     */
    public static boolean possibleDeCreer(Collection<? extends Carte> desCartes, int valeurCreationDisponible) {
      // TODO
      return false;
    }




    /**
     * dénombre les cartes contenues dans la collection de cartes, cad
     * construit une collection d'objet Denombrement associant
     * à chaque carte de la collection le nombre d'exemplaires de
     * la carte dans la collection
     * @param desCartes les cartes à dénombrer
     * @return la collection de cartes dénombrées
     */
    public static Collection<Denombrement> cartesDenombrees(Collection<? extends Carte> desCartes) {
      // TODO
      return null;
    }

}
