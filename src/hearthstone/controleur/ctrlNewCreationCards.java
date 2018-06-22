package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.vue.vueCollection;
import hearthstone.vue.vueCreation;

public class ctrlNewCreationCards implements ActionListener {

	vueCollection mVue = null;

	public ctrlNewCreationCards(vueCollection vue) {
		mVue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (mVue.isWindowOpen)
			return;

		mVue.isWindowOpen = true;
		vueCreation main = new vueCreation(mVue.collection);
		main.isWindowOpen = false;

		main.pack();
		main.setVisible(true);
	}
}
