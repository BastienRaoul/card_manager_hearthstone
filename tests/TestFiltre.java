
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.*;

public class TestFiltre {

    @Test
    public void testFiltre1() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte serviteur = new Serviteur("smop", 2, "qd", Rarete.BASIQUE, Classe.CHASSEUR, 2, 4, Race.DEMON);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(serviteur);

        HashSet<Carte> dummy = new HashSet<>();
        dummy.add(arme);
        assertEquals("Test filtre arme 1", dummy, Filtre.cartesArme(tasDeCarte.collection()));
    }

    @Test
    public void testFiltre2() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte serviteur = new Serviteur("smop", 2, "qd", Rarete.BASIQUE, Classe.CHASSEUR, 2, 4, Race.DEMON);
        tasDeCarte.ajouter(serviteur);

        HashSet<Carte> dummy = new HashSet<>();
        assertEquals("Test filtre arme 2", dummy, Filtre.cartesArme(tasDeCarte.collection()));
    }

    @Test
    public void testFiltre3() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte serviteur = new Serviteur("smop", 2, "qd", Rarete.BASIQUE, Classe.CHASSEUR, 2, 4, Race.DEMON);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(serviteur);

        HashSet<Carte> dummy = new HashSet<>();
        dummy.add(serviteur);
        assertEquals("Test filtre serviteur 1", dummy, Filtre.cartesServiteur(tasDeCarte.collection()));
    }

    @Test
    public void testFiltre4() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte serviteur = new Serviteur("smop", 2, "qd", Rarete.BASIQUE, Classe.CHASSEUR, 2, 4, Race.DEMON);
        tasDeCarte.ajouter(arme);

        HashSet<Carte> dummy = new HashSet<>();
        assertEquals("Test filtre arme 2", dummy, Filtre.cartesServiteur(tasDeCarte.collection()));
    }

    @Test
    public void testFiltre5() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.BASIQUE, Classe.CHAMAN);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        HashSet<Carte> dummy = new HashSet<>();
        dummy.add(sort);
        assertEquals("Test filtre sort 1", dummy, Filtre.cartesSort(tasDeCarte.collection()));
    }

    @Test
    public void testFiltre6() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.BASIQUE, Classe.CHAMAN);
        tasDeCarte.ajouter(arme);

        HashSet<Carte> dummy = new HashSet<>();
        assertEquals("Test filtre sort 2", dummy, Filtre.cartesSort(tasDeCarte.collection()));
    }

    @Test
    public void testFiltre7() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.BASIQUE, Classe.CHAMAN);
        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        HashSet<Carte> dummy = new HashSet<>();
        dummy.add(arme);
        assertEquals("Test filtre rarete 1", dummy, Filtre.cartesParRarete(tasDeCarte.collection(), Rarete.LEGENDAIRE));
    }

    @Test
    public void testFiltre8() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.RARE, Classe.CHAMAN);
        arme = Carte.fabriquerCarteDoree(arme);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        HashSet<Carte> dummy = new HashSet<>();
        dummy.add(arme);
        assertEquals("Test filtre dore 1", dummy, Filtre.cartesDorees(tasDeCarte.collection()));
    }

    @Test
    public void testFiltre9() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.RARE, Classe.CHAMAN);
        arme = Carte.fabriquerCarteDoree(arme);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        HashSet<Carte> dummy = new HashSet<>();
        dummy.add(sort);
        assertEquals("Test filtre classe 1", dummy, Filtre.cartesParClasse(tasDeCarte.collection(), Classe.CHAMAN));
    }

    @Test(expected = ClasseNeutreException.class)
    public void testFiltre10() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.COMMUNE, Classe.NEUTRE);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        Filtre.cartesParClasse(tasDeCarte.collection(), Classe.NEUTRE);
    }

    @Test
    public void testFiltre11() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.COMMUNE, Classe.NEUTRE);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        assertEquals("Test filtre manamin 1", 15, Filtre.manaMinimalNecessaire(tasDeCarte.collection()));
    }

    @Test
    public void testFiltre12() throws Exception {
        Cartes tasDeCarte = new Cartes();
        assertEquals("Test filtre manamin 2", 0, Filtre.manaMinimalNecessaire(tasDeCarte.collection()));
    }

    @Test
    public void testFiltre13() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.COMMUNE, Classe.NEUTRE);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        assertEquals("Test filtre gaindesenchantemet 1", 405, Filtre.gainDesenchantementTotal(tasDeCarte.collection()));
    }

    @Test
    public void testFiltre14() throws Exception {
        Cartes tasDeCarte = new Cartes();
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);
        Carte sort = new Sort("monsort", 5, "descri", Rarete.COMMUNE, Classe.NEUTRE);

        tasDeCarte.ajouter(arme);
        tasDeCarte.ajouter(sort);

        assertEquals("Test filtre possible de creer 1", true, Filtre.possibleDeCreer(tasDeCarte.collection(), 1640));
    }

    @Test 
    public void testFiltre15() throws Exception 
    {
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

        assertEquals("Test cartes denombrees", resultat, tasDeCartes);
    }
}