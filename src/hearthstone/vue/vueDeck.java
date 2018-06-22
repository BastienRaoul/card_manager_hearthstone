package hearthstone.vue;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.UIManager.*;

import hearthstone.carte.*;
import hearthstone.cartes.*;
import hearthstone.controleur.ctrlChangeClasse;
import hearthstone.exception.ClasseNeutreException;

public class vueDeck extends vue {

    private Deck mDeck = null;

    /////////////////////////
    private JList<Carte> carteList = new JList<>();

    private JComboBox<Classe> choixClasse = new JComboBox<>();

    private JButton creationDeck = new JButton("Terminer");
    /////////////////////////    

    public vueDeck(Cartes collection, Deck currentDeck) {
		super(collection);

		mDeck = currentDeck;

		classTab.removeAll();
		classeVoleur();
		classeNeutre();

		/////////////////////////////////
		subMainRight.setBorder(BorderFactory.createTitledBorder("Création de deck..."));

		carteList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		carteList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		carteList.setVisibleRowCount(-1);

		
		// GhostGlassPane glassPane = new GhostGlassPane();


		



		JScrollPane listeDesDeck = new JScrollPane(carteList);
		listeDesDeck.setPreferredSize(new Dimension(250, 80));

		// Drag & Drop Image dans List
		carteList.setDragEnabled(true);
		carteList.setTransferHandler(new ListTransferHandler());

		
		
	
		


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