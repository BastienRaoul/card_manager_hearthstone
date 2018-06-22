package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.vue.vueCreation;

//Controlleur permettant de fermer la fenêtre liée
public class ctrlTerminerFenetreCreation implements ActionListener {

	vueCreation mVue = null;

	public ctrlTerminerFenetreCreation(vueCreation vue) {
		mVue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mVue.isWindowOpen = false;
		mVue.dispose();
	}
}
