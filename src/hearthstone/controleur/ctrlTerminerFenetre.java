package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.vue.vueDeck;

public class ctrlTerminerFenetre implements ActionListener {

	vueDeck mVue = null;

	public ctrlTerminerFenetre(vueDeck vue) {
		mVue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mVue.isWindowOpen = false;
		mVue.deckList.fire();
		mVue.dispose();
		
	}

}
