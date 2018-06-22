package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.vue.vueDeck;

//Controlleur permettant de fermer la fenêtre liée
public class ctrlTerminerFenetreDeck implements ActionListener {

	vueDeck mVue = null;

	public ctrlTerminerFenetreDeck(vueDeck vue) {
		mVue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mVue.isWindowOpen = false;
		mVue.deckList.fire();
		mVue.dispose();		
	}

}
