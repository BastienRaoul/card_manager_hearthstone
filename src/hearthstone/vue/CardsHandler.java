package hearthstone.vue;

import java.util.List;

import javax.swing.AbstractListModel;

import hearthstone.carte.Carte;

public class CardsHandler extends AbstractListModel<Carte> {

	List<Carte> listeCarte = null;

	public CardsHandler(List<Carte> carte) {
		listeCarte = carte;
	}

	@Override
	public int getSize() {
		return listeCarte.size();
	}

	@Override
	public Carte getElementAt(int index) {
		return listeCarte.get(index);
	}
}
