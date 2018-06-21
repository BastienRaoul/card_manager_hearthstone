package hearthstone.controleur;

import java.awt.event.*;
import java.io.IOException;

import hearthstone.exception.ClasseNeutreException;
import hearthstone.vue.*;

public class ctrlCollectionNextCreation implements ActionListener {
    vueCreation mVue = null;

    /*
     * true = left false = right
     */
    boolean position = false;

    public ctrlCollectionNextCreation(vueCreation vue, boolean leftOrRight) {
	mVue = vue;
	position = leftOrRight;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	if (position) {
	    // if left
	    try {
		tryleft();
	    } catch (ClasseNeutreException | IOException e1) {
		e1.printStackTrace();
	    }
	} else {
	    // if right
	    try {
		tryright();
	    } catch (ClasseNeutreException | IOException e1) {
		e1.printStackTrace();
	    }
	}
    }

    private void tryleft() throws ClasseNeutreException, IOException {
	if (mVue.pageNumber > 0) {
	    --mVue.pageNumber;
	    mVue.drawCards(mVue.getImagePanelFromTabbedPaneId(), mVue.getClasseFromTabbedPaneId());
	    System.out.println("right page : " + mVue.pageNumber + " " + mVue.applyFilterRace().size());
	}
    }

    private void tryright() throws ClasseNeutreException, IOException {
	if (((mVue.pageNumber + 1) * 8) < mVue.applyFilterRace().size()) {
	    ++mVue.pageNumber;
	    mVue.drawCards(mVue.getImagePanelFromTabbedPaneId(), mVue.getClasseFromTabbedPaneId());
	    System.out.println("right page : " + mVue.pageNumber + " " + mVue.applyFilterRace().size());
	}
    }
}
