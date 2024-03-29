package hearthstone.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hearthstone.vue.ImagePanel;
import hearthstone.vue.vue;

//Controlleur permettant d'afficher la description d'une carte lorsque l'on clique dessus
public class ctrlCardClicked implements MouseListener {

    vue mVue = null;

    public ctrlCardClicked(vue vue) {
	mVue = vue;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
	if (!((ImagePanel) e.getSource()).hasCard())
	    return;

	((ImagePanel) e.getSource()).setSelected(mVue.getCurrentImagePanels());

	mVue.textEditorDescription.setText("<html>" + ((ImagePanel) e.getSource()).mCarte.description() + "</html>");

	try {
	    mVue.coutDescription
		    .setText("Cout : " + Integer.toString(((ImagePanel) e.getSource()).mCarte.coutCreation()));
	    mVue.valeurDesemDescription
		    .setText("Valeur : " + Integer.toString(((ImagePanel) e.getSource()).mCarte.gainDesenchantement()));
	} catch (Exception err) {

	}
	mVue.nbExemplairesDescription.setText(
		"Exemplaire : " + mVue.collection.getNbExemplaireFromDenombrement(((ImagePanel) e.getSource()).mCarte));

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
