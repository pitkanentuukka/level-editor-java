package com.tuukka.testigui;

/**
 * This is what the entity list xml file gives us. We will have a list of these somewhere
 * in the gui where you can choose and drag and drop these to the canvas (map).
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
@Element
public class Entity extends JComponent implements Transferable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Image texture;
	@Attribute
	protected String type;
	@Attribute
	protected int texturerows; 
	@Attribute
	protected int texturecols;
	@Attribute
	protected String texturefile;
	
	protected String basepath;
	protected String fullpath;
	
	protected DataFlavor myFlavor = new DataFlavor(Entity.class, "entity");
	
	protected int textureHeight;
	protected int textureWidth;
	
	protected ImageIcon icon;
	
	public Entity(@Attribute(name="type")String type, @Attribute(name="texturerows")int texturerows, 
			@Attribute(name="texturecols")int texturecols, @Attribute(name="texturefile")String texturefile) {
		this.type = type;
		this.texturerows = texturerows;
		this.texturecols = texturecols;
		this.texturefile = texturefile;
	}
	
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	public String toString() {
		String string = "type :" + this.type + ", texture: " + this.texturefile + ", rows & cols : " + texturerows + ", " + texturecols;
		return string;
	}

	public void prepareThySelf(String basepath) {
		this.basepath = basepath;
		fullpath = basepath + texturefile;
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(basepath + texturefile));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(fullpath);
		}
		if (texturecols > 1 || texturerows > 1) {
			int imageHeight = img.getHeight();
			int imageWidth = img.getWidth();
			textureHeight = imageHeight / texturerows;
			textureWidth = imageWidth / texturecols;
			texture = img.getSubimage(0, (imageHeight-textureHeight), textureWidth, textureHeight);
		} else {
			textureWidth = img.getWidth();
			textureHeight = img.getHeight();
			texture = img;

		}
		//this.createImage(textureWidth, textureHeight);
		
		//texture = new BufferedImage();
		
		icon = new ImageIcon(texture);
	}

    protected void paintComponent(Graphics g) {
        if (isOpaque()) { //paint background
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        if (icon != null) {
            Graphics2D g2d = (Graphics2D)g.create();

            g2d.drawImage(texture, 0, 0, null);
            //icon.paintIcon(this, g2d, 0, this.textureHeight);
         
            g2d.dispose(); //clean up
        }
    }
}