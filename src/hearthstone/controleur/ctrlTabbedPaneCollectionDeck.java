package hearthstone.controleur;

import java.io.IOException;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import hearthstone.carte.Classe;
import hearthstone.exception.ClasseNeutreException;
import hearthstone.vue.vueCreation;
import hearthstone.vue.vueDeck;

public class ctrlTabbedPaneCollectionDeck implements ChangeListener {
    vueDeck mVue = null;

    public ctrlTabbedPaneCollectionDeck(vueDeck vue) {
	mVue = vue;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
	switch (((JTabbedPane) e.getSource()).getTitleAt(((JTabbedPane) e.getSource()).getSelectedIndex())) {
	case "Guerrier":
	    try {
		mVue.drawCards(mVue.subMainGUERRIERCards, Classe.GUERRIER);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case "Druide":
	    try {
		mVue.drawCards(mVue.subMainDRUIDECards, Classe.DRUIDE);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case "Chasseur":
	    try {
		mVue.drawCards(mVue.subMainCHASSEURCards, Classe.CHASSEUR);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case "Mage":
	    try {
		mVue.drawCards(mVue.subMainMAGECards, Classe.MAGE);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case "Paladin":
	    try {
		mVue.drawCards(mVue.subMainPALADINCards, Classe.PALADIN);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case "Pretre":
	    try {
		mVue.drawCards(mVue.subMainPRETRECards, Classe.PRETRE);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case "Chaman":
	    try {
		mVue.drawCards(mVue.subMainCHAMANCards, Classe.CHAMAN);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case "Demoniste":
	    try {
		mVue.drawCards(mVue.subMainDEMONISTECards, Classe.DEMONISTE);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case "Voleur":
	    try {
		mVue.drawCards(mVue.subMainVOLEURCards, Classe.VOLEUR);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case "Neutral":
	    try {
		mVue.drawCards(mVue.subMainNEUTRECards, Classe.NEUTRE);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	default:
	    break;
	}
	mVue.resetDesciption();	
	mVue.pageNumber = 0;
    }
}
