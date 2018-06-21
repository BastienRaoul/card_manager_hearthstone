package hearthstone.vue;

import java.awt.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

/**
 * JPanel affichant une image en background
 * 
 * @author lanoix-a
 * @version 1
 */
public class ImagePanel extends JPanel {

	private Image image;

	public ImagePanel() {
		super();
		image = null;
	}

	public void loadPic(URL url) {
		System.out.println("loading image from " + url);
		try {
			image = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint();
	}
	
	public void loadPic(File file) {
		System.out.println("loading image from " + file.toString());
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint();
	}
	
	public void reset() {
		image = null;
		this.setBackground(Color.GRAY);
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (image != null) {
			g.drawImage(image, 0, 0, this.getSize().width, this.getSize().height, this);
		}
	}
}