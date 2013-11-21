package com.tuukka.testigui;

/**
 * This is what the entity list xml file gives us. We will have a list of these somewhere
 * in the gui where you can choose and drag and drop these to the canvas (map).
 */

import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JComponent;

public class Entity extends JComponent implements Transferable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Image texture;
	protected String type;
	protected int columns, rows;
	protected String texturePath;
	
	
	
	
	
	
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

}
