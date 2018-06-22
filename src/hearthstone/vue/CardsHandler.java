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

	public void fire() {
		if (listeCarte.size() != 0) {
			System.out.println("Fire");
			fireIntervalAdded(this, 0, listeCarte.size() - 1);
		} else {
			System.out.println("No fire");
			fireIntervalAdded(this, 0, 0);
		}

	}
}
