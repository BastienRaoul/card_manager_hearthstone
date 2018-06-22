package hearthstone.vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import hearthstone.cartes.Cartes;
import hearthstone.cartes.Deck;
import hearthstone.controleur.ctrlModifDeck;
import hearthstone.controleur.ctrlNewCreationCards;
import hearthstone.controleur.ctrlNewCreationDeck;

public class vueCollection extends vue {

	/////
	public JList<Deck> deckList = null;

	public DeckHandler deckhandler = null;
	
	private JButton creationCarte = new JButton("Creation de carte");

	private JPanel panelBottomBut = new JPanel();

	private JButton manipulationDeck = new JButton("Modifier le deck");

	private JButton creationDeck = new JButton("Nouveau deck");
	/////

	public vueCollection(Cartes collection) {
		super(collection);

		deckhandler = new DeckHandler(collection.collectionDeDeck());
		
		/////////////////////////////////
		subMainRight.setBorder(BorderFactory.createTitledBorder("Mes decks..."));

		deckList = new JList<>(deckhandler);
		deckList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//deckList.setVisibleRowCount(-1);

		JScrollPane listeDesDeck = new JScrollPane(deckList);
		listeDesDeck.setPreferredSize(new Dimension(250, 80));

		subMainRight.setLayout(new BorderLayout());
		subMainRight.add(listeDesDeck, BorderLayout.CENTER);
		subMainRight.add(creationCarte, BorderLayout.NORTH);

		panelBottomBut.setLayout(new GridLayout(0, 2));
		panelBottomBut.add(manipulationDeck);
		panelBottomBut.add(creationDeck);

		subMainRight.add(panelBottomBut, BorderLayout.SOUTH);

		/////////////////////////////////
		creationDeck.addActionListener(new ctrlNewCreationDeck(this));

		creationCarte.addActionListener(new ctrlNewCreationCards(this));

		manipulationDeck.addActionListener(new ctrlModifDeck(this));				
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
}