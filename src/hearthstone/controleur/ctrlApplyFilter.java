package hearthstone.controleur;

import java.awt.event.*;
import java.io.IOException;

import hearthstone.exception.ClasseNeutreException;
import hearthstone.vue.*;

public class ctrlApplyFilter implements ActionListener {
	vueCollection mVue = null;
	vueDeck mVueDeck = null;
	vueCreation mVueCreation = null;

	public ctrlApplyFilter(vueCollection vue) {
		mVue = vue;
	}

	public ctrlTabbedPaneCollection(vueDeck vue) {
		mVueDeck = vue;
	}

	public ctrlTabbedPaneCollection(vueCreation vue) {
		mVueCreation = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			mVue.drawCards(mVue.getImagePanelFromTabbedPaneId(), mVue.getClasseFromTabbedPaneId());
		} catch (ClasseNeutreException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
