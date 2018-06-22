
package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.exception.DeckSuppressionException;
import hearthstone.vue.vueDeck;

public class ctrlSuppDeck implements ActionListener {

	vueDeck mVue = null;

	public ctrlSuppDeck(vueDeck vue) {
		mVue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			mVue.collection.effacerDeck(mVue.mDeck);
		} catch (DeckSuppressionException e1) {
			e1.printStackTrace();
		}

		mVue.isWindowOpen = false;
		mVue.deckList.fire();
		mVue.dispose();
	}
}
