package hearthstone.controleur;

import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ItemEvent;

import hearthstone.carte.Classe;
import hearthstone.exception.ClasseNeutreException;
import hearthstone.vue.vueDeck;
import sun.security.provider.JavaKeyStore.CaseExactJKS;

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
        switch((Classe)e.getItem())
        {
        case DRUIDE: this.mVue.classeDruide();
            break;
        case CHASSEUR: this.mVue.classeChasseur();
            break;
        case MAGE: this.mVue.classeMage();
            break;
        case PALADIN: this.mVue.classePaladin();
            break;
        case PRETRE: this.mVue.classePretre();
            break;
        case VOLEUR: this.mVue.classeVoleur();
            break;
        case CHAMAN: this.mVue.classeChaman();
            break;
        case DEMONISTE: this.mVue.classeDemoniste();
            break;
        case GUERRIER: this.mVue.classeGuerrier();
            break;
        default: break;
        }
	}
}