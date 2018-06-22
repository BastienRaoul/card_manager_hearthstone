package hearthstone.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import hearthstone.cartes.Cartes;
import hearthstone.cartes.Deck;
import hearthstone.controleur.ctrlListDeck;
import hearthstone.controleur.ctrlNewCreationCards;
import hearthstone.controleur.ctrlNewCreationDeck;

//Classe vueCollection, héritant de la classe vue, affichant la collection du joueur
//Accessoirement, écran d'accueil
public class vueCollection extends vue {

	/////
	private JList<Deck> deckList = null;

	private JButton creationCarte = new JButton("Creation de carte");

	private JButton creationDeck = new JButton("Nouveau deck");
	/////

	public vueCollection(Cartes collection) {
		super(collection);

		/////////////////////////////////
		subMainRight.setBorder(BorderFactory.createTitledBorder("Mes decks..."));

		deckList = new JList<>(new DeckHandler(collection.collectionDeDeck()));
		deckList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		deckList.setVisibleRowCount(-1);

		//Ajout de la liste à un JSrollPane afin de scroll si nécessaire
		JScrollPane listeDesDeck = new JScrollPane(deckList);
		listeDesDeck.setPreferredSize(new Dimension(250, 80));

		//Ajout des panels
		subMainRight.setLayout(new BorderLayout());
		subMainRight.add(listeDesDeck, BorderLayout.CENTER);
		subMainRight.add(creationCarte, BorderLayout.NORTH);
		subMainRight.add(creationDeck, BorderLayout.SOUTH);

		///////// Ajout controlleurs 
		creationDeck.addActionListener(new ctrlNewCreationDeck(this));

		creationCarte.addActionListener(new ctrlNewCreationCards(this));

		deckList.addListSelectionListener(new ctrlListDeck(this));

		/////////////////////////////////

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setLocation(300, 300);

		this.setPreferredSize(new Dimension(X, Y));
		setSize(X, Y);

		//Changement du look&feel
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
}