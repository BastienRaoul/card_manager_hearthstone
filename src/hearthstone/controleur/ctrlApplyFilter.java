package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import hearthstone.exception.ClasseNeutreException;
import hearthstone.vue.vue;

//Controlleur permettant d'afficher les cartes après avoir lancé les filtres
public class ctrlApplyFilter implements ActionListener {
    
	vue mVue = null;

	public ctrlApplyFilter(vue vue) {
		mVue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			mVue.drawCards(mVue.getCurrentImagePanels(), mVue.getClasseFromTabbedPaneTitle());
		} catch (ClasseNeutreException | IOException e1) {
			e1.printStackTrace();
		}
	}
}
