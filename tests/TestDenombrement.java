
import hearthstone.carte.*;
import hearthstone.cartes.*;
import hearthstone.exception.ValeurNegativeException;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class TestDenombrement {
    // On test le constructeur de la classe dénombrement avec comme seul paramètre
    // une carte
    // Par défaut on a donc un exemplaire de la carte donnée en paramètre
    @Test
    public void testDenombrement1() throws Exception {
        Carte arme2 = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme2);

        assertEquals(1, den.nombre());
        assertEquals(arme2, den.carte());
    }

    // On test le constructeur a deux paramètres de la classe dénombrement, avec ici
    // 3 exemplaires de
    // la carte
    @Test
    public void testDenombrement2() throws Exception {
        Carte arme2 = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme2, 3);

        assertEquals(3, den.nombre());
        assertEquals(arme2, den.carte());
    }

    // On teste ici que l'exception ValeurNegative se déclenche bien, pour qu'il n'y
    // ai pas un nombre
    // D'exemplaires négatif
    @Test(expected = ValeurNegativeException.class)
    public void testDenombrement3() throws Exception {
        Carte arme2 = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme2, -1);
    }

    // On test l'incrémentation de la classe dénombrement, pour vérifier qu'il y'a
    // bien un ajout
    // de l'exemplaire de la carte liée
    @Test
    public void testDenombrement4() throws Exception {
        Carte arme2 = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme2);

        assertEquals(1, den.nombre());
        den.incremente();
        assertEquals(2, den.nombre());
        assertEquals(arme2, den.carte());
    }

    // On vérifie ici l'égalité entre le dénombrement de deux cartes correspondant à
    // des variables
    // différentes mais étant les mêmes
    @Test
    public void testDenombrement5() throws Exception {
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme);

        Carte arme1 = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den1 = new Denombrement(arme1);

        assertEquals(den, den1);
    }

    @Test
    public void testEquals() throws Exception {
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme);

        Carte arme1 = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den1 = new Denombrement(arme1);

        assertEquals(true, den1.equals(den));
    }

    @Test
    public void testEquals1() throws Exception {
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme);

        Denombrement den1 = den;

        assertEquals(true, den1.equals(den));
    }

    @Test
    public void testEquals2() throws Exception {
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme);

        assertEquals(false, den.equals(null));
    }

    @Test
    public void testEquals3() throws Exception {
        Carte arme = new Arme("Marteau Thor", 10, "MarteauThor...", Rarete.LEGENDAIRE, Classe.GUERRIER, 100, 100);

        Denombrement den = new Denombrement(arme);

        assertEquals(false, den.equals(new Denombrement(arme, 2)));
    }
}