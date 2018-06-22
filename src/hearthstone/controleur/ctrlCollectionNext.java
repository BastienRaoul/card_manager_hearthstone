package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import hearthstone.exception.ClasseNeutreException;
import hearthstone.vue.vue;

//Controlleur permettant d'afficher le lot de 8 cartes de la page suivante
//Ou précédente selou la valeur du boolean position
public class ctrlCollectionNext implements ActionListener {
    
    vue mVue = null;

    /*
     * true = left false = right
     */
    boolean position = false;

    public ctrlCollectionNext(vue vue, boolean leftOrRight) {
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


	//Méthode tryLeft permettant d'afficher les 8 cartes à gauche (qui précèdent)
    private void tryleft() throws ClasseNeutreException, IOException {
		if (mVue.pageNumber > 0) {
			--mVue.pageNumber;
			mVue.drawCards(mVue.getCurrentImagePanels(), mVue.getClasseFromTabbedPaneTitle());
			System.out.println("right page : " + mVue.pageNumber + " " + mVue.applyFilterRace().size());
			mVue.resetDesciption();	
		}
    }

	//Méthode tryRight permettant d'afficher les 8 cartes à droite (qui suivent)
    private void tryright() throws ClasseNeutreException, IOException {
		if (((mVue.pageNumber + 1) * 8) < mVue.applyFilterRace().size()) {
			++mVue.pageNumber;
			mVue.drawCards(mVue.getCurrentImagePanels(), mVue.getClasseFromTabbedPaneTitle());
			System.out.println("right page : " + mVue.pageNumber + " " + mVue.applyFilterRace().size());
			mVue.resetDesciption();	
		}
    }
}
