package hearthstone.controleur;

import java.awt.event.*;

import hearthstone.exception.CoutCreationException;
import hearthstone.exception.GainDesenchantementException;
import hearthstone.vue.ImagePanel;
import hearthstone.vue.*;

public class ctrlCardClickedDeck implements MouseListener {

    vueDeck mVue = null;

    public ctrlCardClickedDeck(vueDeck vue) {
	mVue = vue;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
	if (!((ImagePanel) e.getSource()).hasCard())
	    return;

	((ImagePanel) e.getSource()).setSelected(mVue.getCurrentImagePanels());

	mVue.textAreaDescription.setText("<html>" + ((ImagePanel) e.getSource()).mCarte.description() + "</html>");
	try {
	    mVue.coutDescription
		    .setText("Cout : " + Integer.toString(((ImagePanel) e.getSource()).mCarte.coutCreation()));
	} catch (CoutCreationException e1) {
	    e1.printStackTrace();
	}
	try {
	    mVue.valeurDesemDescription
		    .setText("Valeur : " + Integer.toString(((ImagePanel) e.getSource()).mCarte.gainDesenchantement()));
	} catch (GainDesenchantementException e1) {
	    e1.printStackTrace();
	}
	/*
	 * TODO try {
	 * mVue.nbExemplairesDescription.setText(Integer.toString(((ImagePanel) //
	 * e.getSource()).mCarte.qsdfqsdfqsdf)); } catch (GainDesenchantementException
	 * e1) { e1.printStackTrace(); }
	 */
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
