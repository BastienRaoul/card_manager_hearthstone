package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.cartes.Denombrement;
import hearthstone.exception.CoutCreationException;
import hearthstone.vue.ImagePanel;
import hearthstone.vue.vueCreation;

public class ctrlCreerCarteCreation implements ActionListener {

	vueCreation mVue = null;

	public ctrlCreerCarteCreation(vueCreation vue) {
		mVue = vue;
	}

	public void actionPerformed(ActionEvent e) {
		for (ImagePanel panel : mVue.getCurrentImagePanels()) {
			if (panel.isSelected()) {
				try {
					if (mVue.collection.getNbPoussiere() >= panel.mCarte.coutCreation()) {

						for(Denombrement denomb : mVue.collection.decombrements()) {
							if(denomb.carte().equals(panel.mCarte)) {
								denomb.incremente();
							}
						}
						
						mVue.collection.setNbPoussiere(mVue.collection.getNbPoussiere() - panel.mCarte.coutCreation());

						mVue.nbPoussiereEtoile.setText(Integer.toString(mVue.collection.getNbPoussiere()));
						
						mVue.nbExemplairesDescription.setText(
								"Exemplaire : " + mVue.collection.getNbExemplaireFromDenombrement((panel.mCarte)));

						/*
						 * try { mVue.drawCards(mVue.getCurrentImagePanels(),
						 * mVue.getClasseFromTabbedPaneTitle()); } catch (ClasseNeutreException |
						 * IOException e1) { e1.printStackTrace(); }
						 */
					}
				} catch (CoutCreationException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
