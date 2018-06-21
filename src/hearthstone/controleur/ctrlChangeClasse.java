package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import hearthstone.carte.Classe;
import hearthstone.vue.vueDeck;

public class ctrlChangeClasse implements ActionListener {

    private vueDeck mVue = null;

    public ctrlChangeClasse(vueDeck vue) {
	this.mVue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	System.out.println(((JComboBox<Classe>) e.getSource()).getSelectedItem().toString());

	mVue.clearTab();

	switch (((JComboBox<Classe>) e.getSource()).getSelectedItem().toString()) {
	case "DRUIDE":
	    this.mVue.classeDruide();
	    break;
	case "CHASSEUR":
	    this.mVue.classeChasseur();
	    break;
	case "MAGE":
	    this.mVue.classeMage();
	    break;
	case "PALADIN":
	    this.mVue.classePaladin();
	    break;
	case "PRETRE":
	    this.mVue.classePretre();
	    break;
	case "VOLEUR":
	    this.mVue.classeVoleur();
	    break;
	case "CHAMAN":
	    this.mVue.classeChaman();
	    break;
	case "DEMONISTE":
	    this.mVue.classeDemoniste();
	    break;
	case "GUERRIER":
	    this.mVue.classeGuerrier();
	    break;
	default:
	    break;
	}
	mVue.classeNeutre();
    }
}