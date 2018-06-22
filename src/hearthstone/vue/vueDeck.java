package hearthstone.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import hearthstone.carte.Carte;
import hearthstone.carte.Classe;
import hearthstone.cartes.Cartes;
import hearthstone.cartes.Deck;
import hearthstone.controleur.ctrlChangeClasse;
import hearthstone.controleur.ctrlCreaDeckAccueil;
import hearthstone.exception.ClasseNeutreException;

public class vueDeck extends vue {

    private Deck mDeck = null;

    /////////////////////////
    private JList<Carte> carteList = new JList<>();

    private JComboBox<Classe> choixClasse = new JComboBox<>();

	private JButton creationDeck = new JButton("Terminer");
	
    /////////////////////////

    /////

    public vueDeck(Cartes collection, Deck currentDeck) {
	super(collection);

	mDeck = currentDeck;

	classTab.removeAll();
	classeGuerrier();
	classeNeutre();

	/////////////////////////////////
	subMainRight.setBorder(BorderFactory.createTitledBorder("Création de deck..."));

	carteList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	carteList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
	carteList.setVisibleRowCount(-1);

	// Drag & Drop Image dans List
	carteList.setDragEnabled(true);
	carteList.setDropMode(DropMode.INSERT);

	// GhostGlassPane glassPane = new GhostGlassPane();

	JScrollPane listeDesDeck = new JScrollPane(carteList);
	listeDesDeck.setPreferredSize(new Dimension(250, 80));

	////////////////////////////////

	choixClasse.addItem(Classe.GUERRIER);
	choixClasse.addItem(Classe.DRUIDE);
	choixClasse.addItem(Classe.CHASSEUR);
	choixClasse.addItem(Classe.MAGE);
	choixClasse.addItem(Classe.PALADIN);
	choixClasse.addItem(Classe.PRETRE);
	choixClasse.addItem(Classe.CHAMAN);
	choixClasse.addItem(Classe.DEMONISTE);
	choixClasse.addItem(Classe.VOLEUR);

	choixClasse.setMaximumRowCount(choixClasse.getModel().getSize());

	/////////////////////////////////

	subMainRight.setLayout(new BorderLayout());
	subMainRight.add(listeDesDeck, BorderLayout.CENTER);

	JPanel titreDeck = new JPanel();
	titreDeck.setLayout(new BoxLayout(titreDeck, BoxLayout.Y_AXIS));

	JTextField nomDeck = new JTextField();
	nomDeck.setText("*Deck*");
	titreDeck.add(choixClasse);
	titreDeck.add(nomDeck);

	subMainRight.add(titreDeck, BorderLayout.NORTH);

	////////////////////////////////////
	JPanel test = new JPanel();
	test.setLayout(new BoxLayout(test, BoxLayout.X_AXIS));

	JLabel nbCarteDansDeck = new JLabel("15");
	JLabel sur30 = new JLabel("/30 ");
	JLabel cartes = new JLabel("cartes");
	Font font = new Font("Helvetica", Font.BOLD, 18);
	nbCarteDansDeck.setFont(font);
	sur30.setFont(font);

	test.add(nbCarteDansDeck);
	test.add(sur30);
	test.add(cartes);
	test.add(Box.createHorizontalStrut(48));
	test.add(creationDeck);

	subMainRight.add(test, BorderLayout.SOUTH);

	/////////////////////////////////

	choixClasse.addActionListener(new ctrlChangeClasse(this));

	/////////////////////////////////

	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// this.setLocation(300, 300);

	this.setPreferredSize(new Dimension(X, Y));
	setSize(X, Y);

	try {
	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (Exception e) {
	    System.out.println("No nimbus");
	}

	creationDeck.addActionListener(new ctrlCreaDeckAccueil(this));

	setVisible(true);
    }

    //////////////////////////////////////////
    public void classeGuerrier() {
	classTab.add(mainGUERRIER, "Guerrier");
    }

    public void classeDruide() {
	classTab.add(mainDRUIDE, "Druide");

    }

    public void classeVoleur() {
	classTab.add(mainVOLEUR, "Voleur");

    }

    public void classeChasseur() {
	classTab.add(mainCHASSEUR, "Chasseur");

    }

    public void classeChaman() {
	classTab.add(mainCHAMAN, "Chaman");
    }

    public void classePaladin() {
	classTab.add(mainPALADIN, "Paladin");
    }

    public void classeMage() {
	classTab.add(mainMAGE, "Mage");

    }

    public void classePretre() {
	classTab.add(mainPRETRE, "Pretre");

    }

    public void classeDemoniste() {
	classTab.add(mainDEMONISTE, "Demoniste");

    }

    public void classeNeutre() {
	classTab.add(mainNEUTRE, "Neutre");
    }

    //////////////////////////

    public Classe getClasse() {
	if (choixClasse.getSelectedItem() != null) {
	    switch (choixClasse.getSelectedItem().toString()) {
	    case "GUERRIER":
		return Classe.GUERRIER;

	    case "DRUIDE":
		return Classe.DRUIDE;

	    case "CHASSEUR":
		return Classe.CHASSEUR;

	    case "MAGE":
		return Classe.MAGE;

	    case "PALADIN":
		return Classe.PALADIN;

	    case "PRETRE":
		return Classe.PRETRE;

	    case "CHAMAN":
		return Classe.CHAMAN;

	    case "DEMONISTE":
		return Classe.DEMONISTE;

	    case "VOLEUR":
		return Classe.VOLEUR;

	    default:
		return Classe.NEUTRE;
	    }
	}

	return Classe.NEUTRE;
    }

    public void clearTab() {
	classTab.removeAll();
    }
}