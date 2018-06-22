package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.exception.CarteMauvaiseClasseException;
import hearthstone.exception.CarteNonDisponibleException;
import hearthstone.exception.DeckPleinException;
import hearthstone.exception.LimiteNombreDeCartesException;
import hearthstone.vue.ImagePanel;
import hearthstone.vue.vueDeck;

public class ctrlAjoutCarteDeck implements ActionListener {

	vueDeck mVue = null;

	public ctrlAjoutCarteDeck(vueDeck vue) {
		mVue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (ImagePanel panel : mVue.getCurrentImagePanels()) {
			if (panel.isSelected()) {
				try {
					mVue.mDeck.ajouter(panel.mCarte);
					mVue.nbCarteDansDeck.setText(
							Integer.toString(Integer.parseInt(mVue.nbCarteDansDeck.getText().split("/")[0].trim()) + 1) + " / 30 cartes");
				} catch (DeckPleinException | CarteNonDisponibleException | CarteMauvaiseClasseException
						| LimiteNombreDeCartesException e1) {
					e1.printStackTrace();
				}
				break;
			}
		}

	}
}
