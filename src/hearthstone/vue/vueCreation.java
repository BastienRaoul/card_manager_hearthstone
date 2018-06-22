package hearthstone.vue;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import hearthstone.carte.Classe;
import hearthstone.carte.Race;
import hearthstone.carte.Rarete;
import hearthstone.cartes.Cartes;

//Classe vueCreation héritant de vue, affichant l'interface de création de cartes
public class vueCreation extends vue {

	//Ajout des éléments permettant à l'utilisateur d'entrer les 
	//données voulues pour créer sa carte

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

	//création du panel de validation
	private JPanel subMainRightButton = new JPanel();

	private JButton creationBoutton = new JButton("Créer carte.");
	private JButton destructionCarte = new JButton("Détruire carte.");

	////// création des champs de poussière d'étoile du joueur

	private JLabel pousseireEtoile = new JLabel("Poussiere d'�toiles :");
	private JLabel nbPoussiereEtoile = new JLabel("2000");

	////////

	public vueCreation(Cartes collection) {
		super(collection);

		///Ajout dans le panel principal, remplissage du panel de création
		// et remplissage des comboBox
		subMainRight.setBorder(BorderFactory.createTitledBorder("Manipulation de carte..."));

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
		// TODO control
		/////////////////////////////////

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
}
