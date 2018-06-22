package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.vue.vueCollection;
import hearthstone.vue.vueDeck;

//Controlleur permettant de créer une nouvelle fenêtre de création de deck 
//Et de l'afficher
public class ctrlNewCreationDeck implements ActionListener {

	vueCollection mVue = null;

	public ctrlNewCreationDeck(vueCollection vue) {
		mVue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (mVue.isWindowOpen)
			return;

		mVue.isWindowOpen = true;
		vueDeck main = new vueDeck(mVue.collection, null);
		
		main.pack();
		main.setVisible(true);
	}
}
