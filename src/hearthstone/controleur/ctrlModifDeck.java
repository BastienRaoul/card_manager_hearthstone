package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.vue.vueCollection;
import hearthstone.vue.vueDeck;

//Controlleur permettant de lancer la vue de manipulation de deck pour modifier un deck
public class ctrlModifDeck implements ActionListener {

	vueCollection mVue = null;

	public ctrlModifDeck(vueCollection vue) {
		mVue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (mVue.isWindowOpen)
			return;

		

		if(mVue.deckList.getSelectedValue() == null)
			return;
		
		mVue.isWindowOpen = true;
		vueDeck main = new vueDeck(mVue.collection, mVue.deckhandler, mVue.deckList.getSelectedValue());

		main.pack();
		main.setVisible(true);
	}

}
