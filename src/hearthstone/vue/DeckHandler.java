package hearthstone.vue;

import java.util.List;

import javax.swing.AbstractListModel;

import hearthstone.cartes.Deck;

public class DeckHandler extends AbstractListModel<Deck> {

	List<Deck> listeDeck = null;

	public DeckHandler(List<Deck> decks) {
		listeDeck = decks;
	}

	@Override
	public int getSize() {
		return listeDeck.size();
	}

	@Override
	public Deck getElementAt(int index) {
		return listeDeck.get(index);
	}

	public void fire() {
		if (listeDeck.size() != 0)
			fireIntervalAdded(this, 0, listeDeck.size() - 1);
		else
			fireIntervalAdded(this, 0, 0);
	}
}
