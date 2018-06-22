
package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.exception.CarteAbsenteException;
import hearthstone.vue.vueDeck;

public class ctrlSuppCarteDeck implements ActionListener {

	vueDeck mVue = null;

	public ctrlSuppCarteDeck(vueDeck vue) {
		mVue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (mVue.carteList.getSelectedValue() != null) {
			
			try {
				mVue.mDeck.effacer(mVue.carteList.getSelectedValue());
				mVue.modifNbCarte(false);
				mVue.cardshandler.fire();
			} catch (CarteAbsenteException e1) {
				e1.printStackTrace();
			}
		}
	}
}
