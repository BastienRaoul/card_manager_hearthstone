package hearthstone.vue;

import java.awt.*;
import javax.swing.*;

public class vueCollection extends JFrame {

	private JPanel main = new JPanel();

	private JPanel subMainRight = new JPanel();
	private JPanel subMainCenter = new JPanel();

	private JTabbedPane classTab = new JTabbedPane();

	private JPanel cartesLeft = new JPanel(new BorderLayout());
	private JButton cartesButtonNextLeft = new JButton("<");

	private JPanel cartesRight = new JPanel(new BorderLayout());
	private JButton cartesButtonNextRight = new JButton(">");

	/////
	private JPanel mainGUERRIER = new JPanel();
	private JPanel subMainGUERRIERLabel = new JPanel();
	private JPanel subMainGUERRIERCartes = new JPanel();
	/////
	private JPanel mainDRUIDE = new JPanel();
	private JPanel mainCHASSEUR = new JPanel();
	private JPanel mainMAGE = new JPanel();
	private JPanel mainPALADIN = new JPanel();
	private JPanel mainPRETRE = new JPanel();
	private JPanel mainCHAMAN = new JPanel();
	private JPanel mainDEMONISTE = new JPanel();
	private JPanel mainVOLEUR = new JPanel();
	private JPanel mainNEUTRE = new JPanel();

	public vueCollection() {
		super("DECK manager");

		/////////////////////////////////
		main.setLayout(new BorderLayout());

		/////////////////////////////////
		subMainCenter.setBorder(BorderFactory.createTitledBorder("Collection de carte..."));

		cartesLeft.add(cartesButtonNextLeft, BorderLayout.CENTER);
		cartesRight.add(cartesButtonNextRight, BorderLayout.CENTER);
		////
		mainGUERRIER = new JPanel();
		mainGUERRIER.setLayout(new BorderLayout());
		//
		subMainGUERRIERLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
		subMainGUERRIERLabel.add(new Label("GUERRIER"));

		mainGUERRIER.add(subMainGUERRIERLabel, BorderLayout.NORTH);
		//
		subMainGUERRIERCartes.setLayout(new BorderLayout());
		subMainGUERRIERCartes.add(cartesLeft, BorderLayout.WEST);
		subMainGUERRIERCartes.add(cartesRight, BorderLayout.EAST);

		mainGUERRIER.add(subMainGUERRIERCartes, BorderLayout.CENTER);
		//
		classTab.add(mainGUERRIER, "Guerrier");

		////////
		mainDRUIDE = new JPanel();
		mainCHASSEUR = new JPanel();
		mainMAGE = new JPanel();
		mainPALADIN = new JPanel();
		mainPRETRE = new JPanel();
		mainCHAMAN = new JPanel();
		mainDEMONISTE = new JPanel();
		mainVOLEUR = new JPanel();
		mainNEUTRE = new JPanel();

		/////////////////////////////////
		subMainRight.setBorder(BorderFactory.createTitledBorder("Mes decks..."));

		/////////////////////////////////
		subMainCenter.setLayout(new BorderLayout());
		subMainCenter.add(classTab, BorderLayout.CENTER);
		main.add(subMainCenter, BorderLayout.CENTER);
		main.add(subMainRight, BorderLayout.EAST);

		/////////////////////////////////
		this.getContentPane().add(main);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setLocation(300, 300);

		this.setPreferredSize(new Dimension(1280, 720));
		setSize(1280, 720);
		setVisible(true);
	}
}