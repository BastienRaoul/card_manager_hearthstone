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
    
    private vueDeck mVue = null;

    public ctrlChangeClasse(vueDeck vue)
    {
        this.mVue = vue;
    }

    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        this.mVue.classeSupp();
        switch(e.getItem())
        {
        case Classe.DRUIDE: this.mVue.classeDruide();
            break;
        case Classe.CHASSEUR: this.mVue.classeChasseur();
            break;
        case Classe.MAGE: this.mVue.classeMage();
            break;
        case Classe.PALADIN: this.mVue.classePaladin();
            break;
        case Classe.PRETRE: this.mVue.classePretre();
            break;
        case Classe.VOLEUR: this.mVue.classeVoleur();
            break;
        case Classe.CHAMAN: this.mVue.classeChaman();
            break;
        case Classe.DEMONISTE: this.mVue.classeDemoniste();
            break;
        case Classe.GUERRIER: this.mVue.classeGuerrier();
            break;
        default: break;
        }
	}
}