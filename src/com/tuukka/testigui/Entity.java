package com.tuukka.testigui;

/**
 * This is what the entity list xml file gives us. We will have a list of these somewhere
 * in the gui where you can choose and drag and drop these to the canvas (map).
 */

import java.awt.Image;

import javax.swing.JComponent;

public class Entity extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Image texture;
	protected String type;
	protected int columns, rows;
	protected String texturePath;

}
