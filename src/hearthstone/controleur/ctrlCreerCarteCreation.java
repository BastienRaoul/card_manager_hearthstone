package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hearthstone.vue.vueCreation;

public class ctrlCreerCarte implements ActionListener {

    vueCreation mVue = null;

    public ctrlCreerCarte(vueCreation vue) {
	mVue = vue;
    }

    public void actionPerformed(ActionEvent e) {
        /*

        if( mVue.coutDescription.getText(Integer.toString(mCarte.coutCreation()))<=Integer.toString(mVue.nbPoussiereEtoile.getselectedItem())){

        }
        */
    }

}