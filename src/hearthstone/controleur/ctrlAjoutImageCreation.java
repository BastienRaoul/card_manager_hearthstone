package hearthstone.controleur;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import hearthstone.vue.vueCreation;

public class ctrlAjoutImageCreation implements ActionListener{

    FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("png.","png");

    JFileChooser chooser;

    vueCreation mVue = null;    

	public ctrlAjoutImageCreation(vueCreation vue) {
		mVue = vue;
	}  

    public void actionPerformed(ActionEvent e) {

        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.addChoosableFileFilter(imageFilter);
        chooser.setFileFilter(imageFilter);

        // Permet d'afficher les fichiers et les répertoires
        chooser.setAcceptAllFileFilterUsed(false);
        //   
        if (chooser.showOpenDialog(mVue) == JFileChooser.APPROVE_OPTION) {
    
              System.out.println("getSelectedFile() : "
                 +  chooser.getSelectedFile());               
              }
            else {
              System.out.println("Pas de fichier séléctioné ");
              }
    }
}
