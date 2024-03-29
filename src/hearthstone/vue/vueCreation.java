package hearthstone.vue;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import hearthstone.carte.Classe;
import hearthstone.carte.Race;
import hearthstone.carte.Rarete;
import hearthstone.cartes.Cartes;
import hearthstone.controleur.ctrlAjoutCarteCreation;
import hearthstone.controleur.ctrlAjoutImageCreation;
import hearthstone.controleur.ctrlCreerCarteCreation;
import hearthstone.controleur.ctrlDetruireCarteCreation;
import hearthstone.controleur.ctrlTerminerFenetreCreation;

//Classe vueCreation héritant de vue, affichant l'interface de création de cartes
public class vueCreation extends vue {

	// Ajout des éléments permettant à l'utilisateur d'entrer les
	// données voulues pour créer sa carte

	private JLabel labelNomCreation = new JLabel("Nom :");
	public JTextField textFieldNomCreation = new JTextField("Un nom random...");

	private JLabel labelClasse = new JLabel("Classe de la carte :");
	public JComboBox<Classe> creationClasse = new JComboBox<>();

	private JLabel labelTypeCarte = new JLabel("Type de carte :");
	public JComboBox<String> creationTypeCarte = new JComboBox<>();

	private JLabel labelRarete = new JLabel("Rarete :");
	public JComboBox<Rarete> creationRarete = new JComboBox<>();

	private JLabel labelRace = new JLabel("Race :");
	public JComboBox<Race> creationRace = new JComboBox<>();

	private JLabel labelMana = new JLabel("Mana :");
	public JComboBox<Integer> creationNbMana = new JComboBox<>();

	private JLabel labelDegats = new JLabel("Degat :");
	public JComboBox<Integer> creationDegats = new JComboBox<>();

	private JLabel labelPointDeVie = new JLabel("Point de Vie :");
	public JComboBox<Integer> creationPointVie = new JComboBox<>();

	public JLabel labelDescription = new JLabel("Description de la carte :");
	public JTextArea textAreaExplication = new JTextArea("Explication...");

	public JScrollPane scrollArea = new JScrollPane(textAreaExplication);
	public JPanel panFile = new JPanel();
	public JButton file = new JButton("Ajouter image");

	private JButton ajoutCarteButton = new JButton("Ajouter la carte.");
	private JButton terminer = new JButton("Terminer");

	// création du panel de validation
	private JPanel subMainRightButton = new JPanel();
	private JPanel subMainRightButton2 = new JPanel();

	private JButton creationBoutton = new JButton("Créer carte.");
	private JButton destructionCarte = new JButton("Détruire carte.");

	//////
	private JLabel pousseireEtoile = new JLabel("Poussiere d'étoiles :");
	public JLabel nbPoussiereEtoile = new JLabel();

	////////

	public vueCreation(Cartes collection) {
		super(collection);

		/// Ajout dans le panel principal, remplissage du panel de création
		// et remplissage des comboBox
		subMainRight.setBorder(BorderFactory.createTitledBorder("Manipulation de carte..."));

		subMainRight.setLayout(new GridLayout(10, 0));
		panFile.setLayout(new GridLayout(1, 2));

		subMainRight.add(labelNomCreation);
		subMainRight.add(textFieldNomCreation);

		/**
		 * Ajout de toutes les classes à une ComboBox qui permet de donner une classe à
		 * la carte prochainement créée
		 */
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

		/**
		 * Ajout de toutes les types de carte à une ComboBox qui permet de donner le
		 * type de carte que l'on veut créer
		 */
		creationTypeCarte.addItem("Arme");
		creationTypeCarte.addItem("Sort");
		creationTypeCarte.addItem("Serviteur");
		subMainRight.add(creationTypeCarte);
		subMainRight.add(labelTypeCarte);
		subMainRight.add(creationTypeCarte);

		/**
		 * Ajout de toutes les rareté possibles pour une carte dans une ComboBox qui
		 * permet de choisir la rareté voulu a la carte
		 */
		creationRarete.addItem(Rarete.BASIQUE);
		creationRarete.addItem(Rarete.COMMUNE);
		creationRarete.addItem(Rarete.RARE);
		creationRarete.addItem(Rarete.EPIQUE);
		creationRarete.addItem(Rarete.LEGENDAIRE);
		subMainRight.add(labelRarete);
		subMainRight.add(creationRarete);

		/**
		 * Ajout de toutes les races de carte à une ComboBox qui permet de donner le
		 * type de carte que l'on veut créer
		 */
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

		/**
		 * Ajout de toutes les valeur de Mana à une ComboBox qui permet de donner le
		 * nombre de Mana que coute la carte
		 */
		for (int i = 0; i < 11; i++) {
			creationNbMana.addItem(i);
		}

		/**
		 * Ajout de toutes les valeur de degats possible à une ComboBox qui permet de
		 * donner le nombre de degats à la carte
		 */
		for (int i = 0; i < 13; i++) {
			creationDegats.addItem(i);
		}

		/**
		 * Ajout de toutes les valeur de Point de Vie Possible à une ComboBox qui permet
		 * de donner le nombre de Point de Vie pour la carte
		 */
		for (int i = 0; i < 21; i++) {
			creationPointVie.addItem(i);
		}

		subMainRight.add(labelRace);
		subMainRight.add(creationRace);

		subMainRight.add(labelMana);
		creationNbMana.setMaximumRowCount(creationNbMana.getModel().getSize());
		subMainRight.add(creationNbMana);

		subMainRight.add(labelDegats);
		creationDegats.setMaximumRowCount(creationDegats.getModel().getSize());
		subMainRight.add(creationDegats);

		subMainRight.add(labelPointDeVie);
		creationPointVie.setMaximumRowCount(creationPointVie.getModel().getSize());
		subMainRight.add(creationPointVie);

		subMainRight.add(labelDescription);

		subMainRight.add(panFile);
		panFile.add(scrollArea);
		textAreaExplication.setLineWrap(true);
		panFile.add(file);
		file.addActionListener(new ctrlAjoutImageCreation(this)); // Listener : fabrique une carte puis l'ajoute à la
																	// collection

		// Bouton pour ajouter une image a la carte créée
		subMainRight.add(ajoutCarteButton);
		ajoutCarteButton.addActionListener(new ctrlAjoutCarteCreation(this));

		subMainRightButton.setLayout(new GridLayout(0, 2));
		subMainRightButton.add(creationBoutton);
		subMainRightButton.add(destructionCarte);
		subMainRightButton.add(pousseireEtoile);
		nbPoussiereEtoile.setText(Integer.toString(collection.getNbPoussiere()));
		subMainRightButton.add(nbPoussiereEtoile);
		subMainRight.add(subMainRightButton);

		subMainRightButton2.setLayout(new GridLayout(0, 2));
		subMainRightButton2.add(ajoutCarteButton);
		subMainRightButton2.add(terminer);

		subMainRight.add(subMainRightButton2);

		/**
		 * On ajoute les controleur au bouton associer
		 */
		terminer.addActionListener(new ctrlTerminerFenetreCreation(this));

		creationBoutton.addActionListener(new ctrlCreerCarteCreation(this));

		destructionCarte.addActionListener(new ctrlDetruireCarteCreation(this));
		/////////////////////////////////

		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * On parametre la taille de la fenetre
		 */

		this.setPreferredSize(new Dimension(X + 200, Y));
		setSize(X, Y);

		/**
		 * On met le lookandfeel qui s'appelle Nimbus
		 */

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
