package hearthstone.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

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
import hearthstone.exception.ClasseNeutreException;
import hearthstone.exception.DeckCreationException;
import hearthstone.exception.LimiteNombreDeCartesException;

public class vueDeck extends vue {

	public Deck mDeck = null;

	/////////////////////////
	private JList<Carte> carteList = new JList<>();

	private JComboBox<Classe> choixClasse = new JComboBox<>();

	JPanel bottomPanel = new JPanel();

	JLabel nbCarteDansDeck = new JLabel("0");

	JLabel labelMaxCarte = new JLabel("/30 cartes");

	private JButton creationDeck = new JButton("Terminer");

	private JButton supprimerDeck = new JButton("Supprimer Deck");

	private JButton supprimerCarte = new JButton("Supprimer Carte");

	/////////////////////////

	/////

	public vueDeck(Cartes collection, Deck currentDeck) {
		super(collection);

		if (currentDeck == null)
			try {
				mDeck = new Deck(collection, Classe.GUERRIER, "NouveauDeck");
			} catch (ClasseNeutreException | LimiteNombreDeCartesException | DeckCreationException e1) {
				e1.printStackTrace();
			}
		else
			mDeck = currentDeck;

		classTab.removeAll();
		classeGuerrier();
		classeNeutre();

		/////////////////////////////////
		subMainRight.setBorder(BorderFactory.createTitledBorder("Création de deck..."));
		subMainRight.setLayout(new BorderLayout());

		carteList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		carteList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		carteList.setVisibleRowCount(-1);

		// Drag & Drop Image dans List
		carteList.setDragEnabled(true);
		carteList.setDropMode(DropMode.INSERT);

		// GhostGlassPane glassPane = new GhostGlassPane();

		JScrollPane listeDesCartes = new JScrollPane(carteList);
		listeDesCartes.setPreferredSize(new Dimension(250, 80));

		subMainRight.add(listeDesCartes, BorderLayout.CENTER);

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

		JPanel titreDeck = new JPanel();
		titreDeck.setLayout(new BoxLayout(titreDeck, BoxLayout.Y_AXIS));

		JTextField nomDeck = new JTextField();
		nomDeck.setText("NouveauDeck");
		titreDeck.add(choixClasse);
		titreDeck.add(nomDeck);

		subMainRight.add(titreDeck, BorderLayout.NORTH);

		////////////////////////////////////

		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

		bottomPanel.add(nbCarteDansDeck);
		bottomPanel.add(labelMaxCarte);
		bottomPanel.add(supprimerDeck);
		bottomPanel.add(supprimerCarte);
		bottomPanel.add(creationDeck);

		subMainRight.add(bottomPanel, BorderLayout.SOUTH);

		/////////////////////////////////

		choixClasse.addActionListener(new ctrlChangeClasse(this));

		/////////////////////////////////

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setLocation(300, 300);

		this.setPreferredSize(new Dimension(X + 150, Y));
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