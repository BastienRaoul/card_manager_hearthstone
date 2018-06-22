package hearthstone.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import hearthstone.carte.Arme;
import hearthstone.carte.Carte;
import hearthstone.carte.Classe;
import hearthstone.carte.Race;
import hearthstone.carte.Rarete;
import hearthstone.carte.Serviteur;
import hearthstone.carte.Sort;
import hearthstone.cartes.Denombrement;
import hearthstone.exception.ClasseNeutreException;
import hearthstone.vue.vueCreation;

//Controlleur permettant de créer une carte selon les volontées de l'utilisateur
public class ctrlAjoutCarteCreation implements ActionListener {

	vueCreation mVue = null;

	public ctrlAjoutCarteCreation(vueCreation vue) {
		mVue = vue;
	}

	public void actionPerformed(ActionEvent e) {

		try {

			String nom = mVue.textFieldNomCreation.getText();
			int mana = mVue.creationNbMana.getSelectedIndex();
			String desc = mVue.textAreaExplication.getText();
			Rarete rarete = (Rarete) mVue.creationRarete.getSelectedItem();// typeRarete(mVue.creationRarete.getSelectedItem().toString());
			Classe classe = (Classe) mVue.creationClasse.getSelectedItem();// typeClasse(mVue.creationClasse.getSelectedItem().toString());

			Carte newCarte = null;

			// Image
			File destination = new File("./cachedPics/deapool.png");

			String url = "http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_072.png";
			String urldoree = "http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_072.png";

			//On récupère le type de carte que l'on veut créer puis on fabrique la carte

			if (mVue.creationTypeCarte.getSelectedItem().toString().equals("Sort")) {
				
				newCarte = new Sort(nom, mana, desc, rarete, classe);				
				System.out.print("Création carte réussi " + ((Sort) newCarte));

			} else if (mVue.creationTypeCarte.getSelectedItem().toString().equals("Arme")) {

				int degats = mVue.creationDegats.getSelectedIndex();
				int durabilite = mVue.creationPointVie.getSelectedIndex();

				newCarte = new Arme(nom, mana, desc, rarete, classe, degats, durabilite);
				System.out.print("Création carte réussi " + ((Arme) newCarte).toString2());

			} else if (mVue.creationTypeCarte.getSelectedItem().toString().equals("Serviteur")) {

				int degats = mVue.creationDegats.getSelectedIndex();
				int pointsDeVie = mVue.creationPointVie.getSelectedIndex();
				Race race = (Race) mVue.creationRace.getSelectedItem();

				newCarte = new Serviteur(nom, mana, desc, rarete, classe, url, urldoree, degats, pointsDeVie, race);
				System.out.print("Création carte réussi " + ((Serviteur) newCarte).toString2());
			}

			//On ajoute la carte fabriquée dans la collection

			mVue.collection.ajouter(newCarte);
			mVue.collection.buildDenombrement();

			//La carte est mise en 1 seul exemplaire

			for (Denombrement denomb : mVue.collection.decombrements()) {
				if (denomb.carte().equals(newCarte)) {
					denomb.setNombre(1);
				}
			}

			try {
				mVue.drawCards(mVue.getCurrentImagePanels(), mVue.getClasseFromTabbedPaneTitle());
			} catch (ClasseNeutreException | IOException e1) {
				e1.printStackTrace();
			}

			System.out.print("Création carte réussi " + newCarte);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}