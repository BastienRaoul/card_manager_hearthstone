package hearthstone.controleur;

import java.awt.event.*;

import hearthstone.vue.ImagePanel;
import hearthstone.vue.vueCollection;

public class ctrlCardClicked implements MouseListener {
	vueCollection mVue = null;

	public ctrlCardClicked() {
		mVue = null;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mVue.textAreaDescription.setText(((ImagePanel)e.getSource()).mCarte.description());
		mVue.coutDescription.setText(Integer.toString(((ImagePanel)e.getSource()).mCarte.coutCreation())));
		mVue.valeurDesemDescription.setText(((ImagePanel)e.getSource()).mCarte.description());	
		mVue.nbExemplairesDescription.setText(((ImagePanel)e.getSource()).mCarte.description());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
