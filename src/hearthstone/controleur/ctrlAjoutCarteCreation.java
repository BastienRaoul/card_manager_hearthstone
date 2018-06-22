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
			File destination = new File("./cachedPics/");
			// copier(ctrlAjoutImageCreation.fileImage(), destination);

			// String url = ctrlAjoutImageCreation.fileImage();
			// String urldoree = ctrlAjoutImageCreation.fileImage().toString();

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
				Race race = typeRace(mVue.creationRace.getSelectedItem().toString());

				newCarte = new Serviteur(nom, mana, desc, rarete, classe, degats, pointsDeVie, race);
				System.out.print("Création carte réussi " + ((Serviteur) newCarte).toString2());
			}

			mVue.collection.ajouter(newCarte);
			mVue.collection.buildDenombrement();

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

	/**
	 * @param jsonString
	 *            la chaine de caractères
	 * @return la race du serviteur
	 */
	public static Race typeRace(String jsonString) {

		try {
			switch (jsonString) {

			case "BETE":
				return Race.BETE;
			case "DEMON":
				return Race.DEMON;
			case "DRAGON":
				return Race.DRAGON;
			case "ELEMENTAIRE":
				return Race.ELEMENTAIRE;
			case "MECA":
				return Race.MECA;
			case "MURLOC":
				return Race.MURLOC;
			case "PIRATE":
				return Race.PIRATE;
			case "TOTEM":
				return Race.TOTEM;
			default:
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.print("");
		}
		return null;
	}

	/**
	 * @param jsonString
	 *            la chaine de caractères
	 * @return la rarete de la carte
	 */
	public static Rarete typeRarete(String jsonString) {

		try {
			switch (jsonString) {
			case "BASIQUE":
				return Rarete.BASIQUE;
			case "COMMUNE":
				return Rarete.COMMUNE;
			case "RARE":
				return Rarete.RARE;
			case "EPIC":
				return Rarete.EPIQUE;
			case "LEGENDAIRE":
				return Rarete.LEGENDAIRE;
			default:
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.print("");
		}
		return null;
	}

	/**
	 * @param jsonString
	 *            la chaine de caractères
	 * @return le classe de la carte
	 */
	public static Classe typeClasse(String jsonString) {

		try {

			switch (jsonString) {
			case "NEUTRE":
				return Classe.NEUTRE;
			case "DRUIDE":
				return Classe.DRUIDE;
			case "CHASSEUR":
				return Classe.CHASSEUR;
			case "MAGE":
				return Classe.MAGE;
			case "PALADIN":
				return Classe.PALADIN;
			case "PRETRE":
				return Classe.PRETRE;
			case "CHAMAN":
				return Classe.CHAMAN;
			case "DEMONISTE":
				return Classe.DEMONISTE;
			case "VOLEUR":
				return Classe.VOLEUR;
			case "GUERRIER":
				return Classe.GUERRIER;
			default:
				System.out.println("");
			}
		} catch (Exception e) {
			System.out.print("");
		}
		return null;
	}

	/**
	 * Changer dossier image
	 */
	public static boolean copier(File source, File dest) {
		try {
			// Declaration et ouverture des flux
			java.io.FileInputStream sourceFile = new java.io.FileInputStream(source);

			try {
				java.io.FileOutputStream destinationFile = null;

				try {
					destinationFile = new FileOutputStream(dest);

					// Lecture par segment de 0.5Mo
					byte buffer[] = new byte[512 * 1024];
					int nbLecture;

					while ((nbLecture = sourceFile.read(buffer)) != -1) {
						destinationFile.write(buffer, 0, nbLecture);
					}
				} finally {
					destinationFile.close();
				}
			} finally {
				sourceFile.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false; // Erreur
		}

		return true; // Résultat OK
	}
}