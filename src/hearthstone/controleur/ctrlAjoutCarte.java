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
    
        if(mVue.creationTypeCarte.equals("Sort")) {
            String nom = mVue.textFieldNomCreation.getSelectedText();
            int mana = mVue.creationNbMana.getSelectedIndex();
            String desc =mVue.textAreaExplication.getSelectedText();           
            Rarete rarete = typeRarete( mVue.creationRarete.getSelectedItem().toString());   
            //Classe classe = mVue.creationClasse.getSelectedItem();

            //Sort sort = new Sort(nom, mana, desc, rarete, classe);
        }    
    }   
   
    /** 
	 * @param jsonString la chaine de caractères
	 * @return la rarete de la carte
	 */
	public static Rarete typeRarete(String jsonString) {

		try{		
			switch(jsonString) {
				case "Free":
					return Rarete.BASIQUE;
				case "Common":
					return Rarete.COMMUNE;
				case "Rare":
					return Rarete.RARE;				
				case "Epic":
					return Rarete.EPIQUE;
				case "Legendary":
					return Rarete.LEGENDAIRE;				
				default:
					System.out.println("");					
			}
		}catch(Exception e) {
			System.out.print("");
		}
		return null;
	}
}