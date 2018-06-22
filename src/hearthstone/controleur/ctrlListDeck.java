package hearthstone.controleur;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	mVue.setVisible(false);
	vueDeck main = new vueDeck(mVue.collection, ((JList<Deck>) e.getSource()).getSelectedValue());
	main.isWindowOpen = false;

	main.pack();
	main.setVisible(true);
    }

}
