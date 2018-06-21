package hearthstone.vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import hearthstone.carte.Carte;

/**
 * JPanel affichant une image en background
 * 
 * @author lanoix-a
 * @version 1
 */
public class ImagePanel extends JPanel {

    private Image image;

    public Carte mCarte = null;

    public ImagePanel() {
	super();
	image = null;
    }

    public void loadPic(Carte carte) throws MalformedURLException {
	mCarte = carte;

	URL url = null;
	try {
	    url = new URL(mCarte.urlImage());
	} catch (MalformedURLException e) {
	    this.setBackground(Color.GRAY);
	    throw new MalformedURLException(e.getMessage());
	}

	String fileName = url.getFile().substring(url.getFile().lastIndexOf("/") + 1);

	// if file is cached
	File pic = new File("./cachedPics/" + fileName);
	if (pic.exists() && !pic.isDirectory()) {
	    this.loadPicFile(pic);

	} else {
	    System.out.println("loading image from " + mCarte.urlImage());
	    // System.out.println("Working Directory = " + System.getProperty("user.dir"));
	    // download and cach
	    BufferedImage image;
	    try {
		image = ImageIO.read(url);
		ImageIO.write(image, "png", pic);
	    } catch (IOException e) {

		e.printStackTrace();
	    }
	    this.loadPicFile(pic);
	}

	this.setBackground(Color.getColor("Panel.background"));

	repaint();
    }

    private void loadPicFile(File file) {
	System.out.println("loading image from " + file.toString());
	try {
	    image = ImageIO.read(file);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	repaint();
    }

    public boolean hasCard() {
	return mCarte != null;
    }

    public void setSelected(ImagePanel[] panels) {
	if (hasCard()) {
	    for (ImagePanel panel : panels) {
		if (panel.equals(this) || !panel.hasCard())
		    continue;
		panel.setNotSelected();
	    }

	    this.setBackground(Color.LIGHT_GRAY);
	    repaint();
	}

    }

    public void setNotSelected() {
	this.setBackground(Color.getColor("Panel.background"));
	repaint();
    }

    public void reset() {
	System.out.println("Reset");
	image = null;
	mCarte = null;
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