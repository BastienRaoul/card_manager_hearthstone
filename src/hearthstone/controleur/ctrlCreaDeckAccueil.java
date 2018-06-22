/*package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.vue.vueDeck;
import hearthstone.vue.vueCollection;

import hearthstone.cartes.Cartes;
import hearthstone.cartes.Deck;

public class ctrlCreaDeckAccueil implements ActionListener {

	vueDeck mVue = null;
	Cartes mCollection = null;

    public ctrlCreaDeckAccueil(vueDeck vue, Cartes collection) {
	mVue = vue;
	mCollection = collection;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (mVue.isWindowOpen)
	    return;

	mVue.isWindowOpen = true;
	mVue.setVisible(false);
	vueCollection main = new vueCollection(mVue.collection);
	main.isWindowOpen = false;

	if(mVue.getnomDeck() != null )
	{
		mCollection.ajouterDeck(mVue.getClasse(), 30, mVue.getnomDeck());
	}
	else
	{
		mCollection.ajouterDeck(mVue.getClasse(), 30, "Nouveau deck");
	}

	main.pack();
	main.setVisible(true);
    }
}*/