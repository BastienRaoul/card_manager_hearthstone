package hearthstone.controleur;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import hearthstone.carte.*;
import hearthstone.vue.*;
import hearthstone.cartes.*;

public class ctrlAjoutCarte implements ActionListener {

    vueCreation mVue = null;

    public ctrlAjoutCarte(vueCreation vue) {
	mVue = vue;
	}
	public void actionPerformed(ActionEvent e) {
           
		try {
			
			if(mVue.creationTypeCarte.getSelectedItem().toString().equals("Sort")) {				
				
				//Problème ici

				String nom = mVue.textFieldNomCreation.getText();
				
				int mana = mVue.creationNbMana.getSelectedIndex();
				//Rarete rarete = typeRarete(mVue.creationRarete.getSelectedItem().toString()); 			
				//Classe classe = typeClasse(mVue.creationClasse.getSelectedItem().toString());				
								
				//int mana = 2;
				String desc = "Je suis une description";    
				Rarete rarete = Rarete.COMMUNE;
				Classe classe = Classe.DRUIDE;

				Sort sort = new Sort(nom, mana, desc, rarete, classe);	
				System.out.print("Sa fonctionne");	

			} else if(mVue.creationTypeCarte.getSelectedItem().toString().equals("Arme")){

			} else if(mVue.creationTypeCarte.getSelectedItem().toString().equals("Serviteur")){

			}
		} catch (Exception e1) {
			System.out.print("Error : catch ");
		}            
	}             
	
	 /** 
	 * @param jsonString la chaine de caractères
	 * @return la rarete de la carte
	 */
	public static Rarete typeRarete(String jsonString) {

		try{		
			switch(jsonString) {
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
		}catch(Exception e) {
			System.out.print("");
		}
		return null;
	}

	/** 
	 * @param jsonString la chaine de caractères
	 * @return le classe de la carte
	 */
	public static Classe typeClasse(String jsonString) {

		try{		
		
			switch(jsonString) {
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
		}catch(Exception e) {
			System.out.print("");
		}
		return null;
	}

    
}