package hearthstone.controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import hearthstone.vue.vueDeck;

public class ctrlDragAndDrop implements MouseListener  {
    
    vueDeck mVue = null;

    public ctrlDragAndDrop(vueDeck vue)
    {
        mVue = vue;
    }

    @Override
	public void mousePressed(MouseEvent e) {
		
		/*
        try{
			

		} catch () {

		}
        */
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}	

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

    
}