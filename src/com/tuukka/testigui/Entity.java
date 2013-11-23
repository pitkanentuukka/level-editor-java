package com.tuukka.testigui;

/**
 * This is what the entity list xml file gives us. We will have a list of these somewhere
 * in the gui where you can choose and drag and drop these to the canvas (map).
 */

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
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

		//texture = new BufferedImage();
		
	}

}
