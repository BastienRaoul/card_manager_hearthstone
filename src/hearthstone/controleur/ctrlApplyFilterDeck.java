package hearthstone.controleur;

import java.awt.event.*;
import java.io.IOException;

import hearthstone.exception.ClasseNeutreException;
import hearthstone.vue.*;

public class ctrlApplyFilterDeck implements ActionListener {
    
    vueDeck mVue = null;

    public ctrlApplyFilterDeck(vueDeck vue) {
	mVue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	try {
	    mVue.drawCards(mVue.getImagePanelFromTabbedPaneId(), mVue.getClasseFromTabbedPaneId());
	} catch (ClasseNeutreException | IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
    }
}
