package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import hearthstone.vue.vueDeck;

public class ctrlTitreDeck implements KeyListener {

	vueDeck mVue = null;

	public ctrlTitreDeck(vueDeck vue) {
		mVue = vue;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		mVue.mDeck.setNom(((JTextField) e.getSource()).getText());
	}

}
