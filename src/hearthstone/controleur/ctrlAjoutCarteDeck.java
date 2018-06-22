package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.carte.Carte;
import hearthstone.exception.CarteMauvaiseClasseException;
import hearthstone.exception.CarteNonDisponibleException;
import hearthstone.exception.DeckPleinException;
import hearthstone.exception.LimiteNombreDeCartesException;
import hearthstone.vue.ImagePanel;
import hearthstone.vue.vueDeck;

//Controlleur permettant ajouter une carte à un deck en cliquant sur le bouton
//"ajouter la carte"
public class ctrlAjoutCarteDeck implements ActionListener {

	vueDeck mVue = null;

	public ctrlAjoutCarteDeck(vueDeck vue) {
		mVue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (ImagePanel panel : mVue.getCurrentImagePanels()) {
			if (panel.isSelected()) {

				if (mVue.collection.getNbExemplaireFromDenombrement(panel.mCarte) > 0) {
					int nbCarte = 0;
					for (Carte carte : mVue.mDeck.collection()) {
						if (carte.equals(panel.mCarte)) {
							++nbCarte;
						}
					}

					if (nbCarte < 2 && nbCarte < mVue.collection.getNbExemplaireFromDenombrement(panel.mCarte)) {
						try {
							mVue.mDeck.ajouter(panel.mCarte);
							mVue.modifNbCarte(true);
							mVue.cardshandler.fire();
						} catch (DeckPleinException | CarteNonDisponibleException | CarteMauvaiseClasseException
								| LimiteNombreDeCartesException e1) {
							e1.printStackTrace();
						}
					}
					break;
				}
			}
		}
	}
}