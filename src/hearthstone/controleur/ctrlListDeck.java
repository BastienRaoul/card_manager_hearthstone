package hearthstone.controleur;

import javax.swing.JList;
import javax.swing.event.*;

import hearthstone.cartes.Deck;
import hearthstone.vue.vueCollection;
import hearthstone.vue.vueDeck;

public class ctrlListDeck implements ListSelectionListener {

    vueCollection mVue = null;

    public ctrlListDeck(vueCollection vue) {
	mVue = vue;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
	if (mVue.isWindowOpen)
	    return;

	mVue.isWindowOpen = true;
	vueDeck main = new vueDeck(mVue.collection, ((JList<Deck>) e.getSource()).getSelectedValue());

	main.pack();
	main.setVisible(true);
    }

}
