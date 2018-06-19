
import hearthstone.carte.*;
import hearthstone.cartes.Cartes;
import hearthstone.cartes.Denombrement;
import hearthstone.cartes.FabriqueJson;
import hearthstone.cartes.Filtre;
import hearthstone.exception.CarteAbsenteException;
import hearthstone.exception.CarteDejaPresenteException;
import hearthstone.exception.ClasseNeutreException;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

import static org.junit.Assert.*;

import java.util.*;

public class TestFiltre {

    // on test le filtre des armes en donnant en paramètre une collection contenant
    // diverses cartes
    @Test
    public void testFiltre1() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte serviteur = new Serviteur("smop", 2, "qd", Rarete.BASIQUE, Classe.CHASSEUR, 2, 4, Race.DEMON);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(serviteur);

        ArrayList<Carte> dummy = new ArrayList<>();
        dummy.add(arme);
        assertEquals("Test filtre arme 1", dummy, Filtre.cartesArme(tasDeCarte.collection()));
    }

    // on test le filtre des armes en donnant en paramètre une collection de cartes
    // sans armes
    @Test
    public void testFiltre2() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte serviteur = new Serviteur("smop", 2, "qd", Rarete.BASIQUE, Classe.CHASSEUR, 2, 4, Race.DEMON);
        tasDeCarte.ajouter(serviteur);

        ArrayList<Carte> dummy = new ArrayList<>();
        assertEquals("Test filtre arme 2", dummy, Filtre.cartesArme(tasDeCarte.collection()));
    }

    // on test le filtre des serviteurs en donnant en paramètre une collection
    // contenant diverses cartes
    @Test
    public void testFiltre3() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte serviteur = new Serviteur("smop", 2, "qd", Rarete.BASIQUE, Classe.CHASSEUR, 2, 4, Race.DEMON);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(serviteur);

        ArrayList<Carte> dummy = new ArrayList<>();
        dummy.add(serviteur);
        assertEquals("Test filtre serviteur 1", dummy, Filtre.cartesServiteur(tasDeCarte.collection()));
    }

    // on test le filtre des serviteurs en donnant en paramètre une collection sans
    // serviteurs
    @Test
    public void testFiltre4() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);

        ArrayList<Carte> dummy = new ArrayList<>();
        assertEquals("Test filtre arme 2", dummy, Filtre.cartesServiteur(tasDeCarte.collection()));
    }

    // on test le filtre des sorts en donnant en paramètre une collection contenant
    // diverses cartes
    @Test
    public void testFiltre5() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.BASIQUE, Classe.CHAMAN);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        ArrayList<Carte> dummy = new ArrayList<>();
        dummy.add(sort);
        assertEquals("Test filtre sort 1", dummy, Filtre.cartesSort(tasDeCarte.collection()));
    }

    // on test le filtre des sorts en donnant en paramètre une collection sans sort
    @Test
    public void testFiltre6() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        tasDeCarte.ajouter(arme);

        ArrayList<Carte> dummy = new ArrayList<>();
        assertEquals("Test filtre sort 2", dummy, Filtre.cartesSort(tasDeCarte.collection()));
    }

    // on test le filtre des armes en donnant en paramètre une collection contenant
    // diverses cartes
    // Ayant des raretés différents
    @Test
    public void testFiltre7() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.BASIQUE, Classe.CHAMAN);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        ArrayList<Carte> dummy = new ArrayList<>();
        dummy.add(arme);
        assertEquals("Test filtre rarete 1", dummy, Filtre.cartesParRarete(tasDeCarte.collection(), Rarete.LEGENDAIRE));
    }

    // On test le filtre des cartes dorées en donnant en paramètres une collection
    // de diverses cartes,
    // dont une dorée
    @Test
    public void testFiltre8() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.RARE, Classe.CHAMAN);
        arme = Carte.fabriquerCarteDoree(arme);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        ArrayList<Carte> dummy = new ArrayList<>();
        dummy.add(arme);
        assertEquals("Test filtre dore 1", dummy, Filtre.cartesDorees(tasDeCarte.collection()));
    }

    // On test le filtre de classe en donnant en paramètre une collection de
    // diverses cartes
    // ayant des classe différentes
    @Test
    public void testFiltre9() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.RARE, Classe.CHAMAN);
        arme = Carte.fabriquerCarteDoree(arme);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        ArrayList<Carte> dummy = new ArrayList<>();
        dummy.add(sort);
        assertEquals("Test filtre classe 1", dummy, Filtre.cartesParClasse(tasDeCarte.collection(), Classe.CHAMAN));
    }

    // On test le filtre de classe en donnant en paramètre une collection contenant
    // diverses cartes
    // Dont une ayant pour classe la classe neutre
    @Test(expected = ClasseNeutreException.class)
    public void testFiltre10() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.COMMUNE, Classe.NEUTRE);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        Filtre.cartesParClasse(tasDeCarte.collection(), Classe.NEUTRE);
    }

    // On test le filtre de mana avec une collection contenant deux cartes ayant un
    // total de mana de 15
    // en paramètre, et en mettant 15 de mana disponible
    @Test
    public void testFiltre11() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.COMMUNE, Classe.NEUTRE);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        assertEquals("Test filtre manamin 1", 15, Filtre.manaMinimalNecessaire(tasDeCarte.collection()));
    }

    // On test le filtre de mana en mettant en paramètre une collection vide et 0 de
    // mana
    @Test
    public void testFiltre12() throws Exception {
        Cartes tasDeCarte = new Cartes();
        assertEquals("Test filtre manamin 2", 0, Filtre.manaMinimalNecessaire(tasDeCarte.collection()));
    }

    // On test le filtre de gain de désenchantement en mettant en paramètre une
    // collection de
    // diverses cartes et le gain attendu, de 405
    @Test
    public void testFiltre13() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.COMMUNE, Classe.NEUTRE);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        assertEquals("Test filtre gaindesenchantemet 1", 405, Filtre.gainDesenchantementTotal(tasDeCarte.collection()));
    }

    // On test le filtre de possibilité de créer en donnant en paramètre true et une
    // collection
    // de diverses cartes
    @Test
    public void testFiltre14() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.COMMUNE, Classe.NEUTRE);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        assertEquals("Test filtre possible de creer 1", true, Filtre.possibleDeCreer(tasDeCarte.collection(), 1640));
    }

    // On test le filtre de dénombrement en donnant en paramètre deux collections
    // une collection de cartes diverses, et une collection de dénombrement
    // correspondant aux cartes
    // de l'autre collection
    @Test
    public void testFiltre15() throws Exception {
        ArrayList<Carte> tasDeCartes = new ArrayList<Carte>();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.COMMUNE, Classe.NEUTRE);

        tasDeCartes.add(arme);
        tasDeCartes.add(arme);
        tasDeCartes.add(sort);

        ArrayList<Denombrement> resultat = new ArrayList<Denombrement>();
        resultat.add(new Denombrement(arme, 2));
        resultat.add(new Denombrement(sort));

        assertEquals("Test cartes denombrees", resultat, Filtre.cartesDenombrees(tasDeCartes));
    }

    // on test le filtre de rareté en mettant en aramètre une rareté de carte
    // n'étant pas dans
    // la collection
    @Test
    public void testFiltre16() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.BASIQUE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.BASIQUE, Classe.CHAMAN);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        ArrayList<Carte> dummy = new ArrayList<>();
        assertEquals("Test filtre rarete 2", dummy, Filtre.cartesParRarete(tasDeCarte.collection(), Rarete.LEGENDAIRE));
    }

    // On test le filtre doré avec une collection n'ayant pas de carte dorée
    @Test
    public void testFiltre17() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.RARE, Classe.CHAMAN);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        ArrayList<Carte> dummy = new ArrayList<>();
        assertEquals("Test filtre dore 2", dummy, Filtre.cartesDorees(tasDeCarte.collection()));
    }

    // On test le filtre classe avec une classe n'étant pas dans la collection
    @Test
    public void testFiltre18() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.RARE, Classe.GUERRIER);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        ArrayList<Carte> dummy = new ArrayList<>();
        assertEquals("Test filtre classe 3", dummy, Filtre.cartesParClasse(tasDeCarte.collection(), Classe.CHAMAN));
    }

    // on test le filtre de gain désenchantement pour 0 cartes, avec un résultat
    // attendu de 0
    @Test
    public void testFiltre19() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.COMMUNE, Classe.NEUTRE);

        assertEquals("Test filtre gaindesenchantemet 2", 0, Filtre.gainDesenchantementTotal(tasDeCarte.collection()));
    }

    // on test le filtre de possibilité de créer pour 0 cartes avec en paramètres
    // true, car
    // il n'y a aucune carte
    @Test
    public void testFiltre20() throws Exception {
        Cartes tasDeCarte = new Cartes();
        assertEquals("Test filtre possible de creer 2", true, Filtre.possibleDeCreer(tasDeCarte.collection(), 0));
    }

    // On test le filtre de possibilité de créer avec en paramètre false pour des
    // cartes trop chères
    @Test
    public void testFiltre21() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.COMMUNE, Classe.NEUTRE);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        assertEquals("Test filtre possible de creer 3", false, Filtre.possibleDeCreer(tasDeCarte.collection(), 20));
    }

    // on test le filtre de cartes dénombrées pour une collection vide, on a donc
    // une collection
    // de dénombrement vide en résultat
    @Test
    public void testFiltre22() throws Exception {
        ArrayList<Carte> tasDeCartes = new ArrayList<Carte>();

        ArrayList<Denombrement> resultat = new ArrayList<Denombrement>();

        assertEquals("Test cartes denombrees", resultat, Filtre.cartesDenombrees(tasDeCartes));
    }

    // On test le filtre de dénombrement avec la même arme ayant été créé sous deux
    // noms de variables
    // différents, pour vérifier que le dénombrement se fait bien malgré un ajout de
    // deux variables
    // étant différentes de base
    @Test
    public void testFiltre23() throws Exception {
        ArrayList<Carte> tasDeCartes = new ArrayList<Carte>();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.COMMUNE, Classe.NEUTRE);
        Carte arme2 = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        tasDeCartes.add(arme);
        tasDeCartes.add(sort);
        tasDeCartes.add(arme2);

        ArrayList<Denombrement> resultat = new ArrayList<Denombrement>();
        resultat.add(new Denombrement(arme, 2));
        resultat.add(new Denombrement(sort));

        assertEquals("Test cartes denombrees", resultat, Filtre.cartesDenombrees(tasDeCartes));
    }

    /**
     * Test taille de cartesParRace de la race démon dans tasDeCarte
     */
    @Test
    public void testcarteparrace() throws Exception {
        ArrayList<Serviteur> tasDeCartes = new ArrayList<>();

        Serviteur serviteur = new Serviteur("smaop", 2, "qd", Rarete.BASIQUE, Classe.CHASSEUR, 2, 4, Race.BETE);
        Serviteur serviteur2 = new Serviteur("smsop", 2, "qd", Rarete.BASIQUE, Classe.CHASSEUR, 2, 4, Race.BETE);
        Serviteur serviteur3 = new Serviteur("smosdp", 2, "qd", Rarete.BASIQUE, Classe.CHASSEUR, 2, 4, Race.BETE);

        tasDeCartes.add(serviteur);
        tasDeCartes.add(serviteur2);
        tasDeCartes.add(serviteur3);
        assertEquals("", 0, Filtre.cartesParRace(tasDeCartes, Race.DEMON).size());
    }

}