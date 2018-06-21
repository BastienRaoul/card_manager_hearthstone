package hearthstone.vue;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.*;
import javax.swing.UIManager.*;

import hearthstone.carte.*;
import hearthstone.cartes.*;
import hearthstone.controleur.ctrlApplyFilter;
import hearthstone.controleur.ctrlApplyFilterCreation;
import hearthstone.controleur.ctrlCardClicked;
import hearthstone.controleur.ctrlCardClickedCreation;
import hearthstone.controleur.ctrlCollectionNext;
import hearthstone.controleur.ctrlCollectionNextCreation;
import hearthstone.controleur.ctrlTabbedPaneCollection;
import hearthstone.controleur.ctrlTabbedPaneCollectionCreation;
import hearthstone.exception.ClasseNeutreException;
import javafx.scene.layout.Border;

public class vueCreation extends JFrame {

    private final int YSPACINGCARDS = 10;
    private final int XSPACINGCARDS = 80;// (int) (YSPACINGCARDS /2 );

    private final int X = 1280;
    private final int Y = 720;

    public Cartes collection = null;

    public int pageNumber = 0;

    public boolean isWindowOpen = false;

    ///////////////////
    private JPanel main = new JPanel();

    private JPanel subMainRight = new JPanel();
    private JPanel subMainCenter = new JPanel();

    private JTabbedPane classTab = new JTabbedPane();
    //
    private JPanel cartesLeft = new JPanel(new BorderLayout());
    private JButton cartesButtonNextLeft = new JButton("<");

    private JPanel cartesRight = new JPanel(new BorderLayout());
    private JButton cartesButtonNextRight = new JButton(">");
    //

    private ctrlCardClickedCreation ctrlCards = new ctrlCardClickedCreation(this);

    /////
    private JPanel mainGUERRIER = null;
    private JPanel subMainGUERRIERLabel = new JPanel();
    private JPanel subMainGUERRIERCardsDisplay = new JPanel();
    public ImagePanel[] subMainGUERRIERCards = new ImagePanel[8];
    /////
    private JPanel mainDRUIDE = null;;
    private JPanel subMainDRUIDELabel = new JPanel();
    private JPanel subMainDRUIDECardsDisplay = new JPanel();
    public ImagePanel[] subMainDRUIDECards = new ImagePanel[8];
    /////
    private JPanel mainCHASSEUR = null;
    private JPanel subMainCHASSEURLabel = new JPanel();
    private JPanel subMainCHASSEURCardsDisplay = new JPanel();
    public ImagePanel[] subMainCHASSEURCards = new ImagePanel[8];
    /////
    private JPanel mainMAGE = null;
    private JPanel subMainMAGELabel = new JPanel();
    private JPanel subMainMAGECardsDisplay = new JPanel();
    public ImagePanel[] subMainMAGECards = new ImagePanel[8];
    /////
    private JPanel mainPALADIN = null;
    private JPanel subMainPALADINLabel = new JPanel();
    private JPanel subMainPALADINCardsDisplay = new JPanel();
    public ImagePanel[] subMainPALADINCards = new ImagePanel[8];
    /////
    private JPanel mainPRETRE = null;
    private JPanel subMainPRETRELabel = new JPanel();
    private JPanel subMainPRETRECardsDisplay = new JPanel();
    public ImagePanel[] subMainPRETRECards = new ImagePanel[8];
    /////
    private JPanel mainCHAMAN = null;
    private JPanel subMainCHAMANLabel = new JPanel();
    private JPanel subMainCHAMANCardsDisplay = new JPanel();
    public ImagePanel[] subMainCHAMANCards = new ImagePanel[8];
    /////
    private JPanel mainDEMONISTE = null;
    private JPanel subMainDEMONISTELabel = new JPanel();
    private JPanel subMainDEMONISTECardsDisplay = new JPanel();
    public ImagePanel[] subMainDEMONISTECards = new ImagePanel[8];
    /////
    private JPanel mainVOLEUR = null;
    private JPanel subMainVOLEURLabel = new JPanel();
    private JPanel subMainVOLEURCardsDisplay = new JPanel();
    public ImagePanel[] subMainVOLEURCards = new ImagePanel[8];
    /////
    private JPanel mainNEUTRE = null;
    private JPanel subMainNEUTRELabel = new JPanel();
    private JPanel subMainNEUTRECardsDisplay = new JPanel();
    public ImagePanel[] subMainNEUTRECards = new ImagePanel[8];
    /////

    private JPanel description = new JPanel();

    private JPanel textDescription = new JPanel();
    public JTextArea textAreaDescription = new JTextArea("Description...");

    private JPanel perksDescription = new JPanel();
    public JLabel coutDescription = new JLabel("Cout :");
    public JLabel valeurDesemDescription = new JLabel("Valeur :");
    public JLabel nbExemplairesDescription = new JLabel("Exemplaires :");

    /////
    private JPanel subMainFilterPanel = new JPanel();

    private JCheckBox filtreRaceCheck = new JCheckBox("Filtre par race :");
    private JComboBox<Race> filtreRaceCombo = new JComboBox<>();

    private JCheckBox filtreRareteCheck = new JCheckBox("Filtre par rarete :");
    private JComboBox<Rarete> filtreRareteCombo = new JComboBox<>();

    private ButtonGroup filtreTypeGrp = new ButtonGroup();
    private JRadioButton filtreArme = new JRadioButton("Armes");
    private JRadioButton filtreServiteur = new JRadioButton("Serviteurs");
    private JRadioButton filtreSort = new JRadioButton("Sorts");
    private JRadioButton filtreNone = new JRadioButton("None");

    private JButton applyFilter = new JButton("Appliquer");

    /////

    private JLabel labelNomCreation = new JLabel("Nom :");
    public JTextField textFieldNomCreation = new JTextField("Un nom random...");

    private JLabel labelClasse = new JLabel("Classe de la carte :");
    public JComboBox<Classe> creationClasse = new JComboBox<>();

    private JLabel labelTypeCarte = new JLabel("Type de carte :");
    private JComboBox<String> creationTypeCarte = new JComboBox<>();

    private JLabel labelRarete = new JLabel("Rarete :");
    private JComboBox<Rarete> creationRarete = new JComboBox<>();

    private JLabel labelRace = new JLabel("Race :");
    private JComboBox<Race> creationRace = new JComboBox<>();

    private JLabel labelMana = new JLabel("Mana :");
    public JComboBox<Integer> creationNbMana = new JComboBox<>();

    private JLabel labelDegats = new JLabel("Degat :");
    public JComboBox<Integer> creationDegats = new JComboBox<>();

    private JLabel labelPointDeVie = new JLabel("Point de Vie :");
    public JComboBox<Integer> creationPointVie = new JComboBox<>();

    public JLabel labelDescription = new JLabel("Description de la carte :");
    public JTextArea textAreaExplication = new JTextArea("Explication...");

    private JButton ajoutCarteButton = new JButton("Ajouter la carte.");

    //
    private JPanel subMainRightButton = new JPanel();

    private JButton creationBoutton = new JButton("Créer carte.");
    private JButton destructionCarte = new JButton("Détruire carte.");

    //////

    private JLabel pousseireEtoile = new JLabel("Poussiere d'étoiles :");
    private JLabel nbPoussiereEtoile = new JLabel("2000");

    ////////

    public vueCreation(Cartes collection) {
	super("DECK manager");

	this.collection = collection;

	/////////////////////////////////
	main.setLayout(new BorderLayout());

	/////////////////////////////////
	subMainCenter.setBorder(BorderFactory.createTitledBorder("Collection de carte..."));

	cartesLeft.add(cartesButtonNextLeft, BorderLayout.CENTER);
	cartesRight.add(cartesButtonNextRight, BorderLayout.CENTER);

	{
	    ////// GUERRIER
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
		subMainGUERRIERCards[i].addMouseListener(ctrlCards);
		subMainGUERRIERCardsDisplay.add(subMainGUERRIERCards[i]);
	    }

	    mainGUERRIER.add(subMainGUERRIERCardsDisplay, BorderLayout.CENTER);
	    //
	    classTab.add(mainGUERRIER, "Guerrier");

	    ////// DROOD
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
		subMainDRUIDECards[i].addMouseListener(ctrlCards);
		subMainDRUIDECardsDisplay.add(subMainDRUIDECards[i]);
	    }

	    mainDRUIDE.add(subMainDRUIDECardsDisplay, BorderLayout.CENTER);
	    //
	    classTab.add(mainDRUIDE, "Druide");

	    ////// CHASSEUR
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
		subMainCHASSEURCards[i].addMouseListener(ctrlCards);
		subMainCHASSEURCardsDisplay.add(subMainCHASSEURCards[i]);
	    }

	    mainCHASSEUR.add(subMainCHASSEURCardsDisplay, BorderLayout.CENTER);
	    //
	    classTab.add(mainCHASSEUR, "Chasseur");

	    ////// MAGE
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
		subMainMAGECards[i].addMouseListener(ctrlCards);
		subMainMAGECardsDisplay.add(subMainMAGECards[i]);
	    }

	    mainMAGE.add(subMainMAGECardsDisplay, BorderLayout.CENTER);
	    //
	    classTab.add(mainMAGE, "Mage");

	    ////// PAL
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
		subMainPALADINCards[i].addMouseListener(ctrlCards);
		subMainPALADINCardsDisplay.add(subMainPALADINCards[i]);
	    }

	    mainPALADIN.add(subMainPALADINCardsDisplay, BorderLayout.CENTER);
	    //
	    classTab.add(mainPALADIN, "Paladin");

	    ////// Priest
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
		subMainPRETRECards[i].addMouseListener(ctrlCards);
		subMainPRETRECardsDisplay.add(subMainPRETRECards[i]);
	    }

	    mainPRETRE.add(subMainPRETRECardsDisplay, BorderLayout.CENTER);
	    //
	    classTab.add(mainPRETRE, "Pretre");

	    ////// Chaman
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
		subMainCHAMANCards[i].addMouseListener(ctrlCards);
		subMainCHAMANCardsDisplay.add(subMainCHAMANCards[i]);
	    }

	    mainCHAMAN.add(subMainCHAMANCardsDisplay, BorderLayout.CENTER);
	    //
	    classTab.add(mainCHAMAN, "Chaman");

	    ////// Warlock
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
		subMainDEMONISTECards[i].addMouseListener(ctrlCards);
		subMainDEMONISTECardsDisplay.add(subMainDEMONISTECards[i]);
	    }

	    mainDEMONISTE.add(subMainDEMONISTECardsDisplay, BorderLayout.CENTER);
	    //
	    classTab.add(mainDEMONISTE, "Demoniste");

	    ////// Rogue
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
		subMainVOLEURCards[i].addMouseListener(ctrlCards);
		subMainVOLEURCardsDisplay.add(subMainVOLEURCards[i]);
	    }

	    mainVOLEUR.add(subMainVOLEURCardsDisplay, BorderLayout.CENTER);
	    //
	    classTab.add(mainVOLEUR, "Voleur");

	    ////// Neutral
	    mainNEUTRE = new JPanel();
	    mainNEUTRE.setLayout(new BorderLayout());
	    //
	    subMainNEUTRELabel.setLayout(new FlowLayout(FlowLayout.CENTER));
	    subMainNEUTRELabel.add(new Label("VOLEUR"));

	    mainNEUTRE.add(subMainNEUTRELabel, BorderLayout.NORTH);
	    //
	    subMainNEUTRECardsDisplay.setLayout(new GridLayout(2, 4, XSPACINGCARDS, YSPACINGCARDS));
	    for (int i = 0; i < 8; ++i) {
		subMainNEUTRECards[i] = new ImagePanel();
		subMainNEUTRECards[i].setBackground(Color.GRAY);
		subMainNEUTRECards[i].addMouseListener(ctrlCards);
		subMainNEUTRECardsDisplay.add(subMainNEUTRECards[i]);
	    }

	    mainNEUTRE.add(subMainNEUTRECardsDisplay, BorderLayout.CENTER);
	    //
	    classTab.add(mainNEUTRE, "Neutre");
	}

	///////////
	subMainCenter.setLayout(new BorderLayout());
	subMainCenter.add(classTab, BorderLayout.CENTER);
	subMainCenter.add(description, BorderLayout.SOUTH);

	subMainCenter.add(cartesLeft, BorderLayout.WEST);
	subMainCenter.add(cartesRight, BorderLayout.EAST);

	////////////////////
	subMainRight.setBorder(BorderFactory.createTitledBorder("Mes decks..."));

	subMainRight.setLayout(new GridLayout(10, 0));

	subMainRight.add(labelNomCreation);
	subMainRight.add(textFieldNomCreation);

	creationClasse.addItem(Classe.NEUTRE);
	creationClasse.addItem(Classe.PALADIN);
	creationClasse.addItem(Classe.PRETRE);
	creationClasse.addItem(Classe.VOLEUR);
	creationClasse.addItem(Classe.CHAMAN);
	creationClasse.addItem(Classe.CHASSEUR);
	creationClasse.addItem(Classe.DEMONISTE);
	creationClasse.addItem(Classe.DRUIDE);
	creationClasse.addItem(Classe.GUERRIER);
	creationClasse.addItem(Classe.MAGE);
	subMainRight.add(labelClasse);
	subMainRight.add(creationClasse);

	creationTypeCarte.addItem("Arme");
	creationTypeCarte.addItem("Sort");
	creationTypeCarte.addItem("Serviteur");
	subMainRight.add(creationTypeCarte);
	subMainRight.add(labelTypeCarte);
	subMainRight.add(creationTypeCarte);

	creationRarete.addItem(Rarete.BASIQUE);
	creationRarete.addItem(Rarete.COMMUNE);
	creationRarete.addItem(Rarete.RARE);
	creationRarete.addItem(Rarete.EPIQUE);
	creationRarete.addItem(Rarete.LEGENDAIRE);
	subMainRight.add(labelRarete);
	subMainRight.add(creationRarete);

	creationRace.addItem(Race.BETE);
	creationRace.addItem(Race.DEMON);
	creationRace.addItem(Race.DRAGON);
	creationRace.addItem(Race.ELEMENTAIRE);
	creationRace.addItem(Race.MECA);
	creationRace.addItem(Race.MURLOC);
	creationRace.addItem(Race.PIRATE);
	creationRace.addItem(Race.TOTEM);
	subMainRight.add(labelRace);
	subMainRight.add(creationRace);

	subMainRight.add(labelMana);
	subMainRight.add(creationNbMana);

	subMainRight.add(labelDegats);
	subMainRight.add(creationDegats);

	subMainRight.add(labelPointDeVie);
	subMainRight.add(creationPointVie);

	subMainRight.add(labelDescription);
	subMainRight.add(textAreaExplication);

	subMainRight.add(ajoutCarteButton);

	subMainRightButton.setLayout(new GridLayout(0, 2));
	subMainRightButton.add(creationBoutton);
	subMainRightButton.add(destructionCarte);
	subMainRight.add(subMainRightButton);

	/////////////////////////////////

	description.setLayout(new BorderLayout());

	textDescription.setLayout(new BorderLayout());
	textDescription.setBorder(BorderFactory.createTitledBorder("Description :"));
	textAreaDescription.setEditable(false);
	textDescription.add(textAreaDescription, BorderLayout.CENTER);

	description.add(textDescription, BorderLayout.CENTER);

	perksDescription.setLayout(new BoxLayout(perksDescription, BoxLayout.Y_AXIS));
	perksDescription.add(coutDescription);
	perksDescription.add(valeurDesemDescription);
	perksDescription.add(nbExemplairesDescription);

	description.add(perksDescription, BorderLayout.EAST);

	/////////////////////////////////

	subMainFilterPanel.setBorder(BorderFactory.createTitledBorder("Filtres :"));
	subMainFilterPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

	filtreTypeGrp.add(filtreArme);
	filtreTypeGrp.add(filtreSort);
	filtreTypeGrp.add(filtreServiteur);
	filtreTypeGrp.add(filtreNone);

	subMainFilterPanel.add(filtreArme);
	subMainFilterPanel.add(filtreSort);
	subMainFilterPanel.add(filtreServiteur);
	filtreNone.setSelected(true);
	subMainFilterPanel.add(filtreNone);
	subMainFilterPanel.add(filtreRaceCheck);

	filtreRaceCombo.addItem(Race.BETE);
	filtreRaceCombo.addItem(Race.DEMON);
	filtreRaceCombo.addItem(Race.DRAGON);
	filtreRaceCombo.addItem(Race.ELEMENTAIRE);
	filtreRaceCombo.addItem(Race.MECA);
	filtreRaceCombo.addItem(Race.MURLOC);
	filtreRaceCombo.addItem(Race.PIRATE);
	filtreRaceCombo.addItem(Race.TOTEM);
	subMainFilterPanel.add(filtreRaceCombo);

	subMainFilterPanel.add(filtreRareteCheck);

	filtreRareteCombo.addItem(Rarete.BASIQUE);
	filtreRareteCombo.addItem(Rarete.COMMUNE);
	filtreRareteCombo.addItem(Rarete.RARE);
	filtreRareteCombo.addItem(Rarete.EPIQUE);
	filtreRareteCombo.addItem(Rarete.LEGENDAIRE);
	subMainFilterPanel.add(filtreRareteCombo);

	subMainFilterPanel.add(applyFilter);

	subMainFilterPanel.add(pousseireEtoile);
	subMainFilterPanel.add(nbPoussiereEtoile);
	/////////////////////////////////

	try {
	    drawCards(subMainGUERRIERCards, Classe.GUERRIER);
	} catch (ClasseNeutreException | IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	/////////////////////////////////
	main.add(subMainCenter, BorderLayout.CENTER);
	main.add(subMainRight, BorderLayout.EAST);
	main.add(subMainFilterPanel, BorderLayout.SOUTH);
	/////////////////////////////////

	classTab.addChangeListener(new ctrlTabbedPaneCollectionCreation(this));

	cartesButtonNextRight.addActionListener(new ctrlCollectionNextCreation(this, false));

	cartesButtonNextLeft.addActionListener(new ctrlCollectionNextCreation(this, true));

	applyFilter.addActionListener(new ctrlApplyFilterCreation(this));

	
	/////////////////////////////////
	this.getContentPane().add(main);
	
	//setUndecorated(true);
	//this.setLocation(300, 300);

	this.setPreferredSize(new Dimension(X + 200, Y));
	setSize(X, Y);

	// TODO
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

    public void drawCards(ImagePanel[] cardsHolders, Classe classe) throws ClasseNeutreException, IOException {
	Collection<Carte> cartes = applyFilterRace();

	int counter = 0;
	int offset = 8 * (pageNumber);

	if (cartes.size() > offset) {
	    Collection<Carte> offsetedCollection = new ArrayList<>();

	    int count = 0;
	    for (Carte carte : cartes) {
		if (count < offset) {
		    ++count;
		    continue;
		}

		offsetedCollection.add(carte);

	    }
	    cartes = offsetedCollection;
	}

	for (Carte carte : cartes) {
	    if (counter == 8)
		break;

	    try {
		cardsHolders[counter].loadPic(carte);
	    } catch (Exception e) {
		continue;
	    }

	    ++counter;
	}

	for (int i = counter; i < 8; ++i) {
	    cardsHolders[i].reset();
	}
    }

    public Classe getClasseFromTabbedPaneId() {
	switch (classTab.getSelectedIndex()) {
	case 0:
	    return Classe.GUERRIER;

	case 1:
	    return Classe.DRUIDE;

	case 2:
	    return Classe.CHASSEUR;

	case 3:
	    return Classe.MAGE;

	case 4:
	    return Classe.PALADIN;

	case 5:
	    return Classe.PRETRE;

	case 6:
	    return Classe.CHAMAN;

	case 7:
	    return Classe.DEMONISTE;

	case 8:
	    return Classe.VOLEUR;

	case 9:
	    return Classe.NEUTRE;

	}
	return null;
    }

    public ImagePanel[] getImagePanelFromTabbedPaneId() {
	switch (classTab.getSelectedIndex()) {
	case 0:
	    return subMainGUERRIERCards;

	case 1:
	    return subMainDRUIDECards;

	case 2:
	    return subMainCHASSEURCards;

	case 3:
	    return subMainMAGECards;

	case 4:
	    return subMainPALADINCards;

	case 5:
	    return subMainPRETRECards;

	case 6:
	    return subMainCHAMANCards;

	case 7:
	    return subMainDEMONISTECards;

	case 8:
	    return subMainVOLEURCards;

	case 9:
	    return subMainNEUTRECards;

	}
	return null;
    }

    public Collection<Carte> applyFilterRace() throws ClasseNeutreException {
	Collection<Carte> cartes = collection.collection();

	cartes = applyFilter();
	cartes = Filtre.cartesParClasse(cartes, getClasseFromTabbedPaneId());
	return cartes;
    }

    public Collection<Carte> applyFilter() {
	Collection<Carte> cartes = collection.collection();

	if (filtreArme.isSelected()) {
	    cartes = Filtre.cartesArme(cartes);
	} else if (filtreServiteur.isSelected()) {
	    cartes = Filtre.cartesServiteur(cartes);
	} else if (filtreSort.isSelected()) {
	    cartes = Filtre.cartesSort(cartes);
	}

	if (filtreRaceCheck.isSelected()) {
	    cartes = Filtre.cartesParRace(cartes, (Race) filtreRaceCombo.getSelectedItem());
	}

	if (filtreRareteCheck.isSelected()) {
	    cartes = Filtre.cartesParRarete(cartes, (Rarete) filtreRareteCombo.getSelectedItem());
	}
	return cartes;
    }
}
