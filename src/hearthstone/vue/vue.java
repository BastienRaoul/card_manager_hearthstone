package hearthstone.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import hearthstone.carte.Carte;
import hearthstone.carte.Classe;
import hearthstone.carte.Race;
import hearthstone.carte.Rarete;
import hearthstone.cartes.Cartes;
import hearthstone.cartes.FabriqueJson;
import hearthstone.cartes.Filtre;
import hearthstone.controleur.ctrlApplyFilter;
import hearthstone.controleur.ctrlCardClicked;
import hearthstone.controleur.ctrlCollectionNext;
import hearthstone.controleur.ctrlTabbedPaneCollection;
import hearthstone.exception.ClasseNeutreException;

//Classe vue abstraite, dont hérite toutes les vues, afin d'avoir le même design
public class vue extends JFrame {

	protected final int YSPACINGCARDS = 10;
	protected final int XSPACINGCARDS = 80;// (int) (YSPACINGCARDS /2 );

	protected final int X = 1280;
	protected final int Y = 720;

	public Cartes collection = null;

	public int pageNumber = 0;

	public static boolean isWindowOpen = false;

	/////////////////// On crée les trois panneaux principaux
	private JPanel main = new JPanel();

	protected JPanel subMainRight = new JPanel();
	private JPanel subMainCenter = new JPanel();
	/////////////////////// :
	// On ajoute un JTabbedPane pour choisir la classe des cartes
	protected JTabbedPane classTab = new JTabbedPane();

	// On crée des panneaux représentant les précédentes et prochaines cartes
	private JPanel cartesLeft = new JPanel(new BorderLayout());
	// ainsi que des boutons pour aller d'un panel de carte à l'autre
	private JButton cartesButtonNextLeft = new JButton("<");

	private JPanel cartesRight = new JPanel(new BorderLayout());
	private JButton cartesButtonNextRight = new JButton(">");
	//

	private ctrlCardClicked ctrlCards = new ctrlCardClicked(this);

	///// On crée des tableau d'ImagePanel permettant d'afficher les cartes
	// Et ce, pour chaque classe
	protected JPanel mainGUERRIER = null;
	protected JPanel subMainGUERRIERLabel = new JPanel();
	protected JPanel subMainGUERRIERCardsDisplay = new JPanel();
	public ImagePanel[] subMainGUERRIERCards = new ImagePanel[8];
	/////
	protected JPanel mainDRUIDE = null;;
	protected JPanel subMainDRUIDELabel = new JPanel();
	protected JPanel subMainDRUIDECardsDisplay = new JPanel();
	public ImagePanel[] subMainDRUIDECards = new ImagePanel[8];
	/////
	protected JPanel mainCHASSEUR = null;
	protected JPanel subMainCHASSEURLabel = new JPanel();
	protected JPanel subMainCHASSEURCardsDisplay = new JPanel();
	public ImagePanel[] subMainCHASSEURCards = new ImagePanel[8];
	/////
	protected JPanel mainMAGE = null;
	protected JPanel subMainMAGELabel = new JPanel();
	protected JPanel subMainMAGECardsDisplay = new JPanel();
	public ImagePanel[] subMainMAGECards = new ImagePanel[8];
	/////
	protected JPanel mainPALADIN = null;
	protected JPanel subMainPALADINLabel = new JPanel();
	protected JPanel subMainPALADINCardsDisplay = new JPanel();
	public ImagePanel[] subMainPALADINCards = new ImagePanel[8];
	/////
	protected JPanel mainPRETRE = null;
	protected JPanel subMainPRETRELabel = new JPanel();
	protected JPanel subMainPRETRECardsDisplay = new JPanel();
	public ImagePanel[] subMainPRETRECards = new ImagePanel[8];
	/////
	protected JPanel mainCHAMAN = null;
	protected JPanel subMainCHAMANLabel = new JPanel();
	protected JPanel subMainCHAMANCardsDisplay = new JPanel();
	public ImagePanel[] subMainCHAMANCards = new ImagePanel[8];
	/////
	protected JPanel mainDEMONISTE = null;
	protected JPanel subMainDEMONISTELabel = new JPanel();
	protected JPanel subMainDEMONISTECardsDisplay = new JPanel();
	public ImagePanel[] subMainDEMONISTECards = new ImagePanel[8];
	/////
	protected JPanel mainVOLEUR = null;
	protected JPanel subMainVOLEURLabel = new JPanel();
	protected JPanel subMainVOLEURCardsDisplay = new JPanel();
	public ImagePanel[] subMainVOLEURCards = new ImagePanel[8];
	/////
	protected JPanel mainNEUTRE = null;
	protected JPanel subMainNEUTRELabel = new JPanel();
	protected JPanel subMainNEUTRECardsDisplay = new JPanel();
	public ImagePanel[] subMainNEUTRECards = new ImagePanel[8];
	/////

	///////////////////////

	// On crée le JPanel contenant la description de la carte, son coût, son nombre
	// d'exemplaires..
	private JPanel description = new JPanel();

	private JPanel textDescription = new JPanel();
	public JEditorPane textEditorDescription = new JEditorPane("text/html", "Description...");

	private JPanel perksDescription = new JPanel();
	public JLabel coutDescription = new JLabel("Cout : 0");
	public JLabel valeurDesemDescription = new JLabel("Valeur : 0");
	public JLabel nbExemplairesDescription = new JLabel("Exemplaires : 0");

	// On ajoute le panel de filtrage
	private JPanel subMainFilterPanel = new JPanel();

	// Ainsi que les ComboBox et les radiosButton permettant de choisir comment
	// filtrer
	private JCheckBox filtreRaceCheck = new JCheckBox("Filtre par race :");
	private JComboBox<Race> filtreRaceCombo = new JComboBox<>();

	private JCheckBox filtreRareteCheck = new JCheckBox("Filtre par rarete :");
	private JComboBox<Rarete> filtreRareteCombo = new JComboBox<>();

	private ButtonGroup filtreTypeGrp = new ButtonGroup();
	private JRadioButton filtreArme = new JRadioButton("Armes");
	private JRadioButton filtreServiteur = new JRadioButton("Serviteurs");
	private JRadioButton filtreSort = new JRadioButton("Sorts");
	private JRadioButton filtreNone = new JRadioButton("Tous");

	// Bouton d'application des filtres
	private JButton applyFilter = new JButton("Appliquer");

	/////

	public vue(Cartes collection) {
		super("DECK manager");

		this.collection = collection;

		/////////////////////////////////
		main.setLayout(new BorderLayout());

		/////////////////////////////////
		subMainCenter.setBorder(BorderFactory.createTitledBorder("Collection de carte..."));

		cartesLeft.add(cartesButtonNextLeft, BorderLayout.CENTER);
		cartesRight.add(cartesButtonNextRight, BorderLayout.CENTER);

		{
			// On crée pour chaque classe un layout permettant d'afficher les cartes
			// En affichant de base des carrés gris et en ajoutant des mouseListener
			// Les rendant cliquables

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

			////// DRUID
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
			subMainNEUTRELabel.add(new Label("NEUTRE"));

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

		/////////// Ajout des éléments centraux
		subMainCenter.setLayout(new BorderLayout());
		subMainCenter.add(classTab, BorderLayout.CENTER);
		subMainCenter.add(description, BorderLayout.SOUTH);

		subMainCenter.add(cartesLeft, BorderLayout.WEST);
		subMainCenter.add(cartesRight, BorderLayout.EAST);

		/////////////////////////////////
		subMainRight.setBorder(BorderFactory.createTitledBorder("Mes decks..."));

		//////////////////////////////// ajout des éléments de description

		description.setLayout(new BorderLayout());

		textDescription.setLayout(new BorderLayout());
		textDescription.setBorder(BorderFactory.createTitledBorder("Description :"));
		textEditorDescription.setEditable(false);
		textDescription.add(textEditorDescription, BorderLayout.CENTER);

		description.add(textDescription, BorderLayout.CENTER);

		perksDescription.setLayout(new BoxLayout(perksDescription, BoxLayout.Y_AXIS));
		perksDescription.add(coutDescription);
		perksDescription.add(valeurDesemDescription);
		perksDescription.add(nbExemplairesDescription);

		description.add(perksDescription, BorderLayout.EAST);

		//////////////////////////////// Ajout des éléments du filtre

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

		///////////////////////////////// Affichage des cartes de classe Guerrier

		try {
			// Appel à la fonction drawCards affichant les cartes
			drawCards(subMainGUERRIERCards, Classe.GUERRIER);
		} catch (ClasseNeutreException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		///////////////////////////////// On ajoute tous les panels au panel principal
		main.add(subMainCenter, BorderLayout.CENTER);
		main.add(subMainRight, BorderLayout.EAST);
		main.add(subMainFilterPanel, BorderLayout.SOUTH);
		///////////////////////////////// Controleurs

		classTab.addChangeListener(new ctrlTabbedPaneCollection(this));

		cartesButtonNextRight.addActionListener(new ctrlCollectionNext(this, false));

		cartesButtonNextLeft.addActionListener(new ctrlCollectionNext(this, true));

		applyFilter.addActionListener(new ctrlApplyFilter(this));

		/////////////////////////////////
		this.getContentPane().add(main);

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {

				try {
					FabriqueJson.ecrireCartesDansFichier(collection.collection(), "./savedCards.json");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
	}

	// Méthode drawCards permettant d'afficher les cartes en fonction de leur classe
	public void drawCards(ImagePanel[] cardsHolders, Classe classe) throws ClasseNeutreException, IOException {
		Collection<Carte> cartes = applyFilterRace();

		int counter = 0;
		int offset = 8 * (pageNumber);

		// Tri des cartes par Race

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

		// Chargement des images des cartes

		for (Carte carte : cartes) {
			if (counter == 8)
				break;
			// System.out.println("Drawing for " + carte);
			try {
				cardsHolders[counter].loadPic(carte);
				// System.out.println(carte);
			} catch (Exception e) {
				// System.out.println("Carte sans image");
				e.printStackTrace();
				// continue;
			}

			++counter;
		}

		for (int i = counter; i < 8; ++i) {
			cardsHolders[i].reset();
		}
	}

	// Méthode de filtre
	public Collection<Carte> applyFilterRace() throws ClasseNeutreException {
		Collection<Carte> cartes = collection.collection();

		cartes = applyFilter();
		cartes = Filtre.cartesParClasse(cartes, getClasseFromTabbedPaneTitle());
		return cartes;
	}

	public Collection<Carte> applyFilter() {
		Collection<Carte> cartes = collection.collection();

		// On vérifie si les filtres sont sélectionnés
		// Si un filtre est sélectionné, on appelle la méthode de la classe Filtre
		// correspondante
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

	// Méthode getCurrentImagePanels qui affiche les images correspondantes à
	// l'onglet
	// de la classe choisie
	public ImagePanel[] getCurrentImagePanels() {
		try {
			switch (classTab.getTitleAt((classTab.getSelectedIndex()))) {
			case "Guerrier":
				return subMainGUERRIERCards;

			case "Druide":
				return subMainDRUIDECards;

			case "Chasseur":
				return subMainCHASSEURCards;

			case "Mage":
				return subMainMAGECards;

			case "Paladin":
				return subMainPALADINCards;

			case "Pretre":
				return subMainPRETRECards;

			case "Chaman":
				return subMainCHAMANCards;

			case "Demoniste":
				return subMainDEMONISTECards;

			case "Voleur":
				return subMainVOLEURCards;

			case "Neutre":
				return subMainNEUTRECards;
			default:
				return subMainGUERRIERCards;
			}
		} catch (Exception e) {
			return subMainGUERRIERCards;
		}

	}

	// Méthode getClasseFromTabbedPaneId qui permet de récupérer la classe
	// correspondant
	// à l'onglet choisi
	public Classe getClasseFromTabbedPaneTitle() {
		try {
			switch (classTab.getTitleAt((classTab.getSelectedIndex()))) {
			case "Guerrier":
				return Classe.GUERRIER;

			case "Druide":
				return Classe.DRUIDE;

			case "Chasseur":
				return Classe.CHASSEUR;

			case "Mage":
				return Classe.MAGE;

			case "Paladin":
				return Classe.PALADIN;

			case "Pretre":
				return Classe.PRETRE;

			case "Chaman":
				return Classe.CHAMAN;

			case "Demoniste":
				return Classe.DEMONISTE;

			case "Voleur":
				return Classe.VOLEUR;

			case "Neutre":
				return Classe.NEUTRE;
			default:
				return Classe.GUERRIER;
			}
		} catch (Exception e) {
			return Classe.GUERRIER;
		}

	}

	// Méthode resetDescription qui efface le contenu du JEditorPane correspondant à
	// la description
	public void resetDesciption() {
		textEditorDescription.setText("");

		coutDescription.setText("Cout : 0");
		valeurDesemDescription.setText("Valeur : 0");

		nbExemplairesDescription.setText("Exemplaire : 0");

	}
}