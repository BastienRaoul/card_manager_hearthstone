package hearthstone.controleur;

import java.awt.event.*;

import javax.swing.*;

import hearthstone.vue.*;

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

		main.pack();
		main.setVisible(true);
	}
}
