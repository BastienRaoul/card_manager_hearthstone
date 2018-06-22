package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.vue.vue;

public class ctrlTerminerFenetre implements ActionListener {

	vue mVue = null;

	public ctrlTerminerFenetre(vue vue) {
		mVue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		mVue.isWindowOpen = false;
		mVue.dispose();
	}

}
