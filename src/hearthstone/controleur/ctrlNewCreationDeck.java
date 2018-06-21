package hearthstone.controleur;

import java.awt.event.*;

import javax.swing.*;

import hearthstone.vue.*;

public class ctrlNewCreationDeck implements ActionListener {
	
	vueCollection mVue = null;
	
	public ctrlNewCreationDeck(vueCollection vue) {
		mVue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		vueDeck main = new vueDeck(mVue.collection);

        main.pack();
        main.setVisible(true);
	}
}
