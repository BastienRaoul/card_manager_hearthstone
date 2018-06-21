package hearthstone.controleur;

import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;

import hearthstone.carte.Classe;
import hearthstone.exception.ClasseNeutreException;
import hearthstone.vue.*;

public class ctrlTabbedPaneCollection implements ChangeListener {

    vue mVue = null;

    public ctrlTabbedPaneCollection(vue vue) {
	mVue = vue;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
	switch (((JTabbedPane) e.getSource()).getSelectedIndex()) {
	case 0:
	    try {
		mVue.drawCards(mVue.subMainGUERRIERCards, Classe.GUERRIER);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case 1:
	    try {
		mVue.drawCards(mVue.subMainDRUIDECards, Classe.DRUIDE);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case 2:
	    try {
		mVue.drawCards(mVue.subMainCHASSEURCards, Classe.CHASSEUR);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case 3:
	    try {
		mVue.drawCards(mVue.subMainMAGECards, Classe.MAGE);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case 4:
	    try {
		mVue.drawCards(mVue.subMainPALADINCards, Classe.PALADIN);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case 5:
	    try {
		mVue.drawCards(mVue.subMainPRETRECards, Classe.PRETRE);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case 6:
	    try {
		mVue.drawCards(mVue.subMainCHAMANCards, Classe.CHAMAN);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case 7:
	    try {
		mVue.drawCards(mVue.subMainDEMONISTECards, Classe.DEMONISTE);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case 8:
	    try {
		mVue.drawCards(mVue.subMainVOLEURCards, Classe.VOLEUR);
	    } catch (ClasseNeutreException | IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    break;
	case 9:
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
