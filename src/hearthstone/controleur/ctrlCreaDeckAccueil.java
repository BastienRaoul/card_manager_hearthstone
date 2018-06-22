package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.vue.vueDeck;
import hearthstone.vue.vueCollection;

public class ctrlCreaDeckAccueil implements ActionListener {

    vueDeck mVue = null;

    public ctrlCreaDeckAccueil(vueDeck vue) {
	mVue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (mVue.isWindowOpen)
	    return;

	mVue.isWindowOpen = true;
	vueCollection main = new vueCollection(mVue.collection);
	main.isWindowOpen = false;

	main.pack();
	main.setVisible(true);
    }
}