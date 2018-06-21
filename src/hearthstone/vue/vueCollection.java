package hearthstone.vue;

import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.*;

import hearthstone.carte.*;
import hearthstone.cartes.*;

public class vueCollection extends JFrame {

	private final int XSPACINGCARDS = 80;
	private final int YSPACINGCARDS = (int)(XSPACINGCARDS / (1.421800948));

	private final int X = 1280;
	private final int Y = 720;

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
	/////
	private JPanel mainGUERRIER = null;
	private JPanel subMainGUERRIERLabel = new JPanel();
	private JPanel subMainGUERRIERCardsDisplay = new JPanel();
	private JPanel[] subMainGUERRIERCards = new JPanel[8];
	/////
	private JPanel mainDRUIDE = null;;
	private JPanel subMainDRUIDELabel = new JPanel();
	private JPanel subMainDRUIDECardsDisplay = new JPanel();
	private JPanel[] subMainDRUIDECards = new JPanel[8];
	/////
	private JPanel mainCHASSEUR = null;
	private JPanel subMainCHASSEURLabel = new JPanel();
	private JPanel subMainCHASSEURCardsDisplay = new JPanel();
	private JPanel[] subMainCHASSEURCards = new JPanel[8];
	/////
	private JPanel mainMAGE = null;
	private JPanel subMainMAGELabel = new JPanel();
	private JPanel subMainMAGECardsDisplay = new JPanel();
	private JPanel[] subMainMAGECards = new JPanel[8];
	/////
	private JPanel mainPALADIN = null;
	private JPanel subMainPALADINLabel = new JPanel();
	private JPanel subMainPALADINCardsDisplay = new JPanel();
	private JPanel[] subMainPALADINCards = new JPanel[8];
	/////
	private JPanel mainPRETRE = null;
	private JPanel subMainPRETRELabel = new JPanel();
	private JPanel subMainPRETRECardsDisplay = new JPanel();
	private JPanel[] subMainPRETRECards = new JPanel[8];
	/////
	private JPanel mainCHAMAN = null;
	private JPanel subMainCHAMANLabel = new JPanel();
	private JPanel subMainCHAMANCardsDisplay = new JPanel();
	private JPanel[] subMainCHAMANCards = new JPanel[8];
	/////
	private JPanel mainDEMONISTE = null;
	private JPanel subMainDEMONISTELabel = new JPanel();
	private JPanel subMainDEMONISTECardsDisplay = new JPanel();
	private JPanel[] subMainDEMONISTECards = new JPanel[8];
	/////
	private JPanel mainVOLEUR = null;
	private JPanel subMainVOLEURLabel = new JPanel();
	private JPanel subMainVOLEURCardsDisplay = new JPanel();
	private JPanel[] subMainVOLEURCards = new JPanel[8];
	/////
	private JPanel mainNEUTRE = null;
	private JPanel subMainNEUTRELabel = new JPanel();
	private JPanel subMainNEUTRECardsDisplay = new JPanel();
	private JPanel[] subMainNEUTRECards = new JPanel[8];
	/////

	private JPanel description = new JPanel();

	private JPanel textDescription = new JPanel();
	private JTextArea textAreaDescription = new JTextArea("aaaaaaaaaaaaaaaaaaaaaaaaaaa");

	private JPanel perksDescription = new JPanel();
	private JLabel coutDescription = new JLabel("Cout :");
	private JLabel valeurDesemDescription = new JLabel("Valeur :");
	private JLabel nbExemplairesDescription = new JLabel("Exemplaires :");

	/////

	private JList<Deck> deckList = new JList<>();

	private JButton creationCarte = new JButton("Creation de carte");

	private JButton creationDeck = new JButton("Nouveau deck");
	/////

	private JPanel subMainFilterPanel = new JPanel();

	private JCheckBox filtreRaceCheck = new JCheckBox("Filtre par race :");
	private JComboBox<Race> filtreRaceCombo = new JComboBox();

	private JCheckBox filtreRareteCheck = new JCheckBox("Filtre par rarete :");
	private JComboBox<Rarete> filtreRareteCombo = new JComboBox();

	private ButtonGroup filtreTypeGrp = new ButtonGroup();
	private JRadioButton filtreArme = new JRadioButton("Armes");
	private JRadioButton filtreServiteur = new JRadioButton("Serviteurs");
	private JRadioButton filtreSort = new JRadioButton("Sorts");

	/////
	private Cartes collection = null;

	public vueCollection(Cartes collection) {
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
				subMainGUERRIERCards[i] = new JPanel();
				subMainGUERRIERCards[i].setBackground(Color.GRAY);
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
				subMainDRUIDECards[i] = new JPanel();
				subMainDRUIDECards[i].setBackground(Color.GRAY);
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
				subMainCHASSEURCards[i] = new JPanel();
				subMainCHASSEURCards[i].setBackground(Color.GRAY);
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
				subMainMAGECards[i] = new JPanel();
				subMainMAGECards[i].setBackground(Color.GRAY);
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
				subMainPALADINCards[i] = new JPanel();
				subMainPALADINCards[i].setBackground(Color.GRAY);
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
				subMainPRETRECards[i] = new JPanel();
				subMainPRETRECards[i].setBackground(Color.GRAY);
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
				subMainCHAMANCards[i] = new JPanel();
				subMainCHAMANCards[i].setBackground(Color.GRAY);
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
				subMainDEMONISTECards[i] = new JPanel();
				subMainDEMONISTECards[i].setBackground(Color.GRAY);
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
				subMainVOLEURCards[i] = new JPanel();
				subMainVOLEURCards[i].setBackground(Color.GRAY);
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
				subMainNEUTRECards[i] = new JPanel();
				subMainNEUTRECards[i].setBackground(Color.GRAY);
				subMainNEUTRECardsDisplay.add(subMainNEUTRECards[i]);
			}

			mainNEUTRE.add(subMainNEUTRECardsDisplay, BorderLayout.CENTER);
			//
			classTab.add(mainNEUTRE, "Neutre");
		}
		///////////

		description.setLayout(new BorderLayout());

		textDescription.setLayout(new BorderLayout());
		textDescription.setBorder(BorderFactory.createTitledBorder("Description VIDE :"));
		textAreaDescription.setEditable(false);
		textDescription.add(textAreaDescription, BorderLayout.CENTER);

		description.add(textDescription, BorderLayout.CENTER);

		perksDescription.setLayout(new BoxLayout(perksDescription, BoxLayout.Y_AXIS));
		perksDescription.add(coutDescription);
		perksDescription.add(valeurDesemDescription);
		perksDescription.add(nbExemplairesDescription);

		description.add(perksDescription, BorderLayout.EAST);

		/////////////////////////////////
		subMainRight.setBorder(BorderFactory.createTitledBorder("Mes decks..."));

		// TODO deckList.setListData(collection.collectionDeDeck());
		deckList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		deckList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		deckList.setVisibleRowCount(-1);

		JScrollPane listeDesDeck = new JScrollPane(deckList);
		listeDesDeck.setPreferredSize(new Dimension(250, 80));

		subMainFilterPanel.setBorder(BorderFactory.createTitledBorder("Filtres :"));
		subMainFilterPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		filtreTypeGrp.add(filtreArme);
		filtreTypeGrp.add(filtreSort);
		filtreTypeGrp.add(filtreServiteur);

		subMainFilterPanel.add(filtreArme);
		subMainFilterPanel.add(filtreSort);
		subMainFilterPanel.add(filtreServiteur);

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
		/////////////////////////////////
		subMainCenter.setLayout(new BorderLayout());
		subMainCenter.add(classTab, BorderLayout.CENTER);
		subMainCenter.add(description, BorderLayout.SOUTH);

		subMainCenter.add(cartesLeft, BorderLayout.WEST);
		subMainCenter.add(cartesRight, BorderLayout.EAST);

		subMainRight.setLayout(new BorderLayout());
		subMainRight.add(listeDesDeck, BorderLayout.CENTER);
		subMainRight.add(creationCarte, BorderLayout.NORTH);
		subMainRight.add(creationDeck, BorderLayout.SOUTH);

		main.add(subMainCenter, BorderLayout.CENTER);
		main.add(subMainRight, BorderLayout.EAST);
		main.add(subMainFilterPanel, BorderLayout.SOUTH);
		/////////////////////////////////
		this.getContentPane().add(main);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setLocation(300, 300);

		this.setPreferredSize(new Dimension(X, Y));
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
			// If Nimbus is not available, you can set the GUI to another look and feel.
		}

		setVisible(true);
	}
}