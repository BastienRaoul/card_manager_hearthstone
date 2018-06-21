package hearthstone.vue;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.*;

import hearthstone.carte.*;
import hearthstone.cartes.*;
import hearthstone.controleur.*;
import hearthstone.exception.*;

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

	/////////////////////////////////
	subMainRight.setBorder(BorderFactory.createTitledBorder("Création de deck..."));

	// TODO carteList.setListData(collection.collectionDeDeck());
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

	choixClasse.addItem(Classe.DRUIDE);
	choixClasse.addItem(Classe.CHASSEUR);
	choixClasse.addItem(Classe.MAGE);
	choixClasse.addItem(Classe.PALADIN);
	choixClasse.addItem(Classe.PRETRE);
	choixClasse.addItem(Classe.VOLEUR);
	choixClasse.addItem(Classe.CHAMAN);
	choixClasse.addItem(Classe.DEMONISTE);
	choixClasse.addItem(Classe.GUERRIER);
	choixClasse.setSelectedItem("Choisir Classe");

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

	choixClasse.addItemListener(new ctrlChangeClasse(this));

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

	setVisible(true);
    }

    //////////////////////////////////////////
    public void classeGuerrier() {
	mainGUERRIER = new JPanel();
	mainGUERRIER.setLayout(new BorderLayout());
	//
	subMainGUERRIERLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
	subMainGUERRIERLabel.add(new Label("GUERRIER"));

	mainGUERRIER.add(subMainGUERRIERLabel, BorderLayout.NORTH);
	//
	subMainGUERRIERCardsDisplay.setLayout(new GridLayout(2, 4, XSPACINGCARDS, YSPACINGCARDS));
	for (int i = 0; i < 8; ++i) {
	    subMainGUERRIERCards[i] = new ImagePanel();
	    subMainGUERRIERCards[i].setBackground(Color.GRAY);
	    subMainGUERRIERCardsDisplay.add(subMainGUERRIERCards[i]);
	}

	mainGUERRIER.add(subMainGUERRIERCardsDisplay, BorderLayout.CENTER);
	//
	classTab.add(mainGUERRIER, "Guerrier");

	try {
	    drawCards(subMainGUERRIERCards, Classe.GUERRIER);
	} catch (ClasseNeutreException | IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
    }

    public void classeDruide() {
	mainDRUIDE = new JPanel();
	mainDRUIDE.setLayout(new BorderLayout());
	//
	subMainDRUIDELabel.setLayout(new FlowLayout(FlowLayout.CENTER));
	subMainDRUIDELabel.add(new Label("DRUIDE"));

	mainDRUIDE.add(subMainDRUIDELabel, BorderLayout.NORTH);
	//
	subMainDRUIDECardsDisplay.setLayout(new GridLayout(2, 4, XSPACINGCARDS, YSPACINGCARDS));
	for (int i = 0; i < 8; ++i) {
	    subMainDRUIDECards[i] = new ImagePanel();
	    subMainDRUIDECards[i].setBackground(Color.GRAY);
	    subMainDRUIDECardsDisplay.add(subMainDRUIDECards[i]);
	}

	mainDRUIDE.add(subMainDRUIDECardsDisplay, BorderLayout.CENTER);
	//
	classTab.add(mainDRUIDE, "Druide");

	try {
	    drawCards(subMainDRUIDECards, Classe.DRUIDE);
	} catch (ClasseNeutreException | IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
    }

    public void classeVoleur() {
	mainVOLEUR = new JPanel();
	mainVOLEUR.setLayout(new BorderLayout());
	//
	subMainVOLEURLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
	subMainVOLEURLabel.add(new Label("VOLEUR"));

	mainVOLEUR.add(subMainVOLEURLabel, BorderLayout.NORTH);
	//
	subMainVOLEURCardsDisplay.setLayout(new GridLayout(2, 4, XSPACINGCARDS, YSPACINGCARDS));
	for (int i = 0; i < 8; ++i) {
	    subMainVOLEURCards[i] = new ImagePanel();
	    subMainVOLEURCards[i].setBackground(Color.GRAY);
	    subMainVOLEURCardsDisplay.add(subMainVOLEURCards[i]);
	}

	mainVOLEUR.add(subMainVOLEURCardsDisplay, BorderLayout.CENTER);
	//
	classTab.add(mainVOLEUR, "Voleur");

	try {
	    drawCards(subMainVOLEURCards, Classe.VOLEUR);
	} catch (ClasseNeutreException | IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
    }

    public void classeChasseur() {
	mainCHASSEUR = new JPanel();
	mainCHASSEUR.setLayout(new BorderLayout());
	//
	subMainCHASSEURLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
	subMainCHASSEURLabel.add(new Label("CHASSEUR"));

	mainCHASSEUR.add(subMainCHASSEURLabel, BorderLayout.NORTH);
	//
	subMainCHASSEURCardsDisplay.setLayout(new GridLayout(2, 4, XSPACINGCARDS, YSPACINGCARDS));
	for (int i = 0; i < 8; ++i) {
	    subMainCHASSEURCards[i] = new ImagePanel();
	    subMainCHASSEURCards[i].setBackground(Color.GRAY);
	    subMainCHASSEURCardsDisplay.add(subMainCHASSEURCards[i]);
	}

	mainCHASSEUR.add(subMainCHASSEURCardsDisplay, BorderLayout.CENTER);
	//
	classTab.add(mainCHASSEUR, "Chasseur");

	try {
	    drawCards(subMainCHASSEURCards, Classe.CHASSEUR);
	} catch (ClasseNeutreException | IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
    }

    public void classeChaman() {
	mainCHAMAN = new JPanel();
	mainCHAMAN.setLayout(new BorderLayout());
	//
	subMainCHAMANLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
	subMainCHAMANLabel.add(new Label("CHAMAN"));

	mainCHAMAN.add(subMainCHAMANLabel, BorderLayout.NORTH);
	//
	subMainCHAMANCardsDisplay.setLayout(new GridLayout(2, 4, XSPACINGCARDS, YSPACINGCARDS));
	for (int i = 0; i < 8; ++i) {
	    subMainCHAMANCards[i] = new ImagePanel();
	    subMainCHAMANCards[i].setBackground(Color.GRAY);
	    subMainCHAMANCardsDisplay.add(subMainCHAMANCards[i]);
	}

	mainCHAMAN.add(subMainCHAMANCardsDisplay, BorderLayout.CENTER);
	//
	classTab.add(mainCHAMAN, "Chaman");

	try {
	    drawCards(subMainCHAMANCards, Classe.CHAMAN);
	} catch (ClasseNeutreException | IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
    }

    public void classePaladin() {
	mainPALADIN = new JPanel();
	mainPALADIN.setLayout(new BorderLayout());
	//
	subMainPALADINLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
	subMainPALADINLabel.add(new Label("PALADIN"));

	mainPALADIN.add(subMainPALADINLabel, BorderLayout.NORTH);
	//
	subMainPALADINCardsDisplay.setLayout(new GridLayout(2, 4, XSPACINGCARDS, YSPACINGCARDS));
	for (int i = 0; i < 8; ++i) {
	    subMainPALADINCards[i] = new ImagePanel();
	    subMainPALADINCards[i].setBackground(Color.GRAY);
	    subMainPALADINCardsDisplay.add(subMainPALADINCards[i]);
	}

	mainPALADIN.add(subMainPALADINCardsDisplay, BorderLayout.CENTER);
	//
	classTab.add(mainPALADIN, "Paladin");

	try {
	    drawCards(subMainPALADINCards, Classe.PALADIN);
	} catch (ClasseNeutreException | IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
    }

    public void classeMage() {
	mainMAGE = new JPanel();
	mainMAGE.setLayout(new BorderLayout());
	//
	subMainMAGELabel.setLayout(new FlowLayout(FlowLayout.CENTER));
	subMainMAGELabel.add(new Label("MAGE"));

	mainMAGE.add(subMainMAGELabel, BorderLayout.NORTH);
	//
	subMainMAGECardsDisplay.setLayout(new GridLayout(2, 4, XSPACINGCARDS, YSPACINGCARDS));
	for (int i = 0; i < 8; ++i) {
	    subMainMAGECards[i] = new ImagePanel();
	    subMainMAGECards[i].setBackground(Color.GRAY);
	    subMainMAGECardsDisplay.add(subMainMAGECards[i]);
	}

	mainMAGE.add(subMainMAGECardsDisplay, BorderLayout.CENTER);
	//
	classTab.add(mainMAGE, "Mage");

	try {
	    drawCards(subMainMAGECards, Classe.MAGE);
	} catch (ClasseNeutreException | IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
    }

    public void classePretre() {
	mainPRETRE = new JPanel();
	mainPRETRE.setLayout(new BorderLayout());
	//
	subMainPRETRELabel.setLayout(new FlowLayout(FlowLayout.CENTER));
	subMainPRETRELabel.add(new Label("PRETRE"));

	mainPRETRE.add(subMainPRETRELabel, BorderLayout.NORTH);
	//
	subMainPRETRECardsDisplay.setLayout(new GridLayout(2, 4, XSPACINGCARDS, YSPACINGCARDS));
	for (int i = 0; i < 8; ++i) {
	    subMainPRETRECards[i] = new ImagePanel();
	    subMainPRETRECards[i].setBackground(Color.GRAY);
	    subMainPRETRECardsDisplay.add(subMainPRETRECards[i]);
	}
	mainPRETRE.add(subMainPRETRECardsDisplay, BorderLayout.CENTER);
	//
	classTab.add(mainPRETRE, "Pretre");

	try {
	    drawCards(subMainPRETRECards, Classe.PRETRE);
	} catch (ClasseNeutreException | IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
    }

    public void classeDemoniste() {
	mainDEMONISTE = new JPanel();
	mainDEMONISTE.setLayout(new BorderLayout());
	//
	subMainDEMONISTELabel.setLayout(new FlowLayout(FlowLayout.CENTER));
	subMainDEMONISTELabel.add(new Label("DEMONISTE"));

	mainDEMONISTE.add(subMainDEMONISTELabel, BorderLayout.NORTH);
	//
	subMainDEMONISTECardsDisplay.setLayout(new GridLayout(2, 4, XSPACINGCARDS, YSPACINGCARDS));
	for (int i = 0; i < 8; ++i) {
	    subMainDEMONISTECards[i] = new ImagePanel();
	    subMainDEMONISTECards[i].setBackground(Color.GRAY);
	    subMainDEMONISTECardsDisplay.add(subMainDEMONISTECards[i]);
	}

	mainDEMONISTE.add(subMainDEMONISTECardsDisplay, BorderLayout.CENTER);
	//
	classTab.add(mainDEMONISTE, "Demoniste");

	try

	{
	    drawCards(subMainDEMONISTECards, Classe.DEMONISTE);
	} catch (ClasseNeutreException | IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
    }

    //////////////////////////////////////////////
    public void classeSupp() {
	if (classTab.getTabCount() > 1) {
	    classTab.remove(1);
	}
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
}