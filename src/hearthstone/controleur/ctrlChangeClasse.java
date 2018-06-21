package hearthstone.controleur;

import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ItemEvent;

import hearthstone.carte.Classe;
import hearthstone.exception.ClasseNeutreException;
import hearthstone.vue.vueDeck;

public class ctrlChangeClasse implements ItemListener{
    
    private VueDeck mVue = null;

    public ctrlChangeClasse(VueDeck vue)
    {
        this.mVue = vue;
    }

    @Override
    public void itemStateChanged(ItemEvent e) 
    {
		
	}
}