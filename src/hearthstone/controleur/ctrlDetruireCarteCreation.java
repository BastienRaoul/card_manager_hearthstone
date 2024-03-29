package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.carte.Rarete;
import hearthstone.cartes.Deck;
import hearthstone.cartes.Denombrement;
import hearthstone.exception.GainDesenchantementException;
import hearthstone.vue.ImagePanel;
import hearthstone.vue.vueCreation;

public class ctrlDetruireCarteCreation implements ActionListener {

	vueCreation mVue = null;

	public ctrlDetruireCarteCreation(vueCreation vue) {
		mVue = vue;
	}

	public void actionPerformed(ActionEvent e) {
		for (ImagePanel panel : mVue.getCurrentImagePanels()) {
			if (panel.isSelected()) {
				for (Denombrement denomb : mVue.collection.decombrements()) {
					if (denomb.carte().equals(panel.mCarte)) {
						if (denomb.nombre() > 0 && denomb.carte().rarete() != Rarete.BASIQUE) {
							denomb.setNombre(denomb.nombre() - 1);

							try {
								for (Deck deck : mVue.collection.collectionDeDeck()) {
									deck.collection().remove(panel.mCarte);
								}

								mVue.collection.setNbPoussiere(
										mVue.collection.getNbPoussiere() + panel.mCarte.gainDesenchantement());
								// System.out.println(panel.mCarte.gainDesenchantement());
							} catch (GainDesenchantementException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							mVue.nbPoussiereEtoile.setText(Integer.toString(mVue.collection.getNbPoussiere()));

							mVue.nbExemplairesDescription.setText(
									"Exemplaire : " + mVue.collection.getNbExemplaireFromDenombrement((panel.mCarte)));
						}
					}

					/*
					 * try { mVue.drawCards(mVue.getCurrentImagePanels(),
					 * mVue.getClasseFromTabbedPaneTitle()); } catch (ClasseNeutreException |
					 * IOException e1) { e1.printStackTrace(); }
					 */
				}
			}
		}
	}

}
