import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({ TestCarte.class, TestArme.class, TestCarteD.class, TestCartes.class, TestDeck.class,
        TestDenombrement.class, TestFabriqueJson.class, TestFiltre.class, TestRarete.class, TestServiteur.class,
        TestSort.class })

public class HearthstoneTestSuite {

}
