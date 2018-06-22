package hearthstone.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
import hearthstone.controleur.ctrlAjoutCarteDeck;
import hearthstone.controleur.ctrlChangeClasse;
import hearthstone.controleur.ctrlTerminerFenetre;
import hearthstone.controleur.ctrlTitreDeck;
import hearthstone.exception.ClasseNeutreException;
import hearthstone.exception.DeckCreationException;
import hearthstone.exception.LimiteNombreDeCartesException;

/**
 * Cette vue permet d'afficher les cartes contenus dans un deck, d'ajouter des
 * cartes dans le deck affiché ou encore de supprimer des cartes du deck. Cette
 * vue s'ouvre après avoir cliquer sur le boutons "Nouveau deck" de la vue
 * vueCollection ou après avoir selectionner un deck déjà créé sur la vue
 * vueCollection.
 */

public class vueDeck extends vue {

	public Deck mDeck = null;

	/////////////////////////

	private JComboBox<Classe> choixClasse = new JComboBox<>();

	private JPanel titreDeck = new JPanel();

	private JTextField nomDeck = new JTextField();

	private JList<Carte> carteList = null;

	private JPanel bottomPanel = new JPanel();

	public JLabel nbCarteDansDeck = new JLabel("0 / 30 cartes");

	private JButton ajoutCarteDeck = new JButton("Ajouter la carte");

	private JButton supprimerDeck = new JButton("Supprimer Deck");

	private JButton supprimerCarte = new JButton("Supprimer Carte");

	private JButton manipulationTerminee = new JButton("Terminer");

	/////////////////////////

	public vueDeck(Cartes collection, Deck currentDeck) {
		super(collection);
		mDeck = currentDeck;

		if (mDeck == null)
			try {
				mDeck = new Deck(collection, Classe.GUERRIER, "NouveauDeck");
			} catch (ClasseNeutreException | LimiteNombreDeCartesException | DeckCreationException e1) {
				e1.printStackTrace();
			}

		/////////////////////////////////

		subMainRight.setBorder(BorderFactory.createTitledBorder("Création de deck..."));
		subMainRight.setLayout(new BorderLayout());

		titreDeck.setLayout(new BoxLayout(titreDeck, BoxLayout.Y_AXIS));

		choixClasse.addItem(Classe.GUERRIER);
		choixClasse.addItem(Classe.DRUIDE);
		choixClasse.addItem(Classe.CHASSEUR);
		choixClasse.addItem(Classe.MAGE);
		choixClasse.addItem(Classe.PALADIN);
		choixClasse.addItem(Classe.PRETRE);
		choixClasse.addItem(Classe.CHAMAN);
		choixClasse.addItem(Classe.DEMONISTE);
		choixClasse.addItem(Classe.VOLEUR);

		titreDeck.add(choixClasse);

		nomDeck.setText(mDeck.getNom());
		titreDeck.add(nomDeck);

		subMainRight.add(titreDeck, BorderLayout.NORTH);

		carteList = new JList<>(new CardsHandler(mDeck.collection()));
		carteList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		carteList.setVisibleRowCount(-1);

		JScrollPane listeDesCartes = new JScrollPane(carteList);
		listeDesCartes.setPreferredSize(new Dimension(250, 80));

		subMainRight.add(listeDesCartes, BorderLayout.CENTER);

		////////////////////////////////////

		bottomPanel.setLayout(new GridLayout(3, 2));

		nbCarteDansDeck.setText(mDeck.collection().size() + " / 30 cartes");
		bottomPanel.add(nbCarteDansDeck);
		bottomPanel.add(supprimerDeck);
		bottomPanel.add(supprimerCarte);
		bottomPanel.add(ajoutCarteDeck);
		bottomPanel.add(manipulationTerminee);

		subMainRight.add(bottomPanel, BorderLayout.SOUTH);

		/////////////////////////////////

		manipulationTerminee.addActionListener(new ctrlTerminerFenetre(this));

		choixClasse.addActionListener(new ctrlChangeClasse(this));

		nomDeck.addKeyListener(new ctrlTitreDeck(this));

		ajoutCarteDeck.addActionListener(new ctrlAjoutCarteDeck(this));

		/////////////////////////////////

		classTab.removeAll();

		switch (mDeck.classe()) {
		case GUERRIER:
			classeGuerrier();
			choixClasse.setSelectedIndex(0);
			break;
		case DRUIDE:
			classeDruide();
			choixClasse.setSelectedIndex(1);
			break;
		case CHASSEUR:
			classeChasseur();
			choixClasse.setSelectedIndex(2);
			break;
		case MAGE:
			classeMage();
			choixClasse.setSelectedIndex(3);
			break;
		case PALADIN:
			classePaladin();
			choixClasse.setSelectedIndex(4);
			break;
		case PRETRE:
			classePretre();
			choixClasse.setSelectedIndex(5);
			break;
		case CHAMAN:
			classeChaman();
			choixClasse.setSelectedIndex(6);
			break;
		case DEMONISTE:
			classeDemoniste();
			choixClasse.setSelectedIndex(7);
			break;
		case VOLEUR:
			classeVoleur();
			choixClasse.setSelectedIndex(8);
			break;
		}

		classeNeutre();

		/////////////////////////////////
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setLocation(300, 300);

		this.setPreferredSize(new Dimension(X + 50, Y));

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