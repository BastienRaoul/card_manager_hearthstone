package hearthstone.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import hearthstone.carte.Carte;
import hearthstone.carte.Classe;
import hearthstone.cartes.Cartes;
import hearthstone.cartes.Deck;
import hearthstone.controleur.ctrlListDeck;
import hearthstone.controleur.ctrlNewCreationCards;
import hearthstone.controleur.ctrlNewCreationDeck;
import hearthstone.exception.ClasseNeutreException;

public class vueCollection extends vue {


    /////
    private JList<Deck> deckList = null;

    private JButton creationCarte = new JButton("Creation de carte");

    private JButton creationDeck = new JButton("Nouveau deck");
    /////

    public vueCollection(Cartes collection) {
	super(collection);

	deckList = new JList<>(new DeckHandeler(collection.collectionDeDeck()));
	deckList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	/////////////////////////////////
	subMainRight.setBorder(BorderFactory.createTitledBorder("Mes decks..."));

	deckList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	deckList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
	deckList.setVisibleRowCount(-1);

	JScrollPane listeDesDeck = new JScrollPane(deckList);
	listeDesDeck.setPreferredSize(new Dimension(250, 80));

	subMainRight.setLayout(new BorderLayout());
	subMainRight.add(listeDesDeck, BorderLayout.CENTER);
	subMainRight.add(creationCarte, BorderLayout.NORTH);
	subMainRight.add(creationDeck, BorderLayout.SOUTH);

	creationDeck.addActionListener(new ctrlNewCreationDeck(this));

	creationCarte.addActionListener(new ctrlNewCreationCards(this));

	deckList.addListSelectionListener(new ctrlListDeck(this));

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
}