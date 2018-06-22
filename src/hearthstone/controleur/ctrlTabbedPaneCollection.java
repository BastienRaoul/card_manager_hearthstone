package hearthstone.controleur;

import java.io.IOException;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import hearthstone.carte.Classe;
import hearthstone.exception.ClasseNeutreException;
import hearthstone.vue.vue;

//Controlleur permettant d'afficher les cartes de l'onglet choisi
//En effaçant les cartes précédents grâce aux méthodes drawCards() et reset()
public class ctrlTabbedPaneCollection implements ChangeListener {

	vue mVue = null;

	public ctrlTabbedPaneCollection(vue vue) {
		mVue = vue;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		try {
			mVue.drawCards(mVue.getCurrentImagePanels(), mVue.getClasseFromTabbedPaneId());
		} catch (ClasseNeutreException | IOException e1) {
			e1.printStackTrace();
		}

		mVue.resetDesciption();
		mVue.pageNumber = 0;
	}
}
