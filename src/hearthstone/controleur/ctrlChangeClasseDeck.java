package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import hearthstone.carte.Classe;
import hearthstone.vue.vueDeck;

public class ctrlChangeClasseDeck implements ActionListener {

	private vueDeck mVue = null;

	public ctrlChangeClasseDeck(vueDeck vue) {
		this.mVue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(((JComboBox<Classe>) e.getSource()).getSelectedItem().toString());

		mVue.clearTab();

		switch (((JComboBox<Classe>) e.getSource()).getSelectedItem().toString()) {
		case "DRUIDE":
			this.mVue.classeDruide();
			mVue.mDeck.setClasse(Classe.DRUIDE);
			break;
		case "CHASSEUR":
			this.mVue.classeChasseur();
			mVue.mDeck.setClasse(Classe.CHASSEUR);
			break;
		case "MAGE":
			this.mVue.classeMage();
			mVue.mDeck.setClasse(Classe.MAGE);
			break;
		case "PALADIN":
			this.mVue.classePaladin();
			mVue.mDeck.setClasse(Classe.PALADIN);
			break;
		case "PRETRE":
			this.mVue.classePretre();
			mVue.mDeck.setClasse(Classe.PRETRE);
			break;
		case "VOLEUR":
			this.mVue.classeVoleur();
			mVue.mDeck.setClasse(Classe.VOLEUR);
			break;
		case "CHAMAN":
			this.mVue.classeChaman();
			mVue.mDeck.setClasse(Classe.CHAMAN);
			break;
		case "DEMONISTE":
			this.mVue.classeDemoniste();
			mVue.mDeck.setClasse(Classe.DEMONISTE);
			break;
		case "GUERRIER":
			this.mVue.classeGuerrier();
			mVue.mDeck.setClasse(Classe.GUERRIER);
			break;
		default:
			break;
		}
		mVue.classeNeutre();
		
		mVue.modifNbCrateReset();
		
		if(!mVue.isInit) {
			mVue.mDeck.clearCards();
		}
	}
}