package com.tuukka.testigui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * these are located on the map
 * @author tuukka
 *
 */

public class MappedEntity extends Entity implements Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int X, Y;
	private int draggedAtX;
	private int draggedAtY;
	private boolean selected = false;

	public MappedEntity() {
		  addMouseListener(new MouseListener(){
		        public void mousePressed(MouseEvent e){
		            draggedAtX = e.getX() - getLocation().x;
		            draggedAtY = e.getY() - getLocation().y;
		        }

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if (e.getButton()==1) // BUTTON1 
						selected = (!selected);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
		    });

		    addMouseMotionListener(new MouseMotionListener(){

				public void mouseDragged(MouseEvent e){
		            setLocation(e.getX() - draggedAtX, e.getY() - draggedAtY);
		        }

				@Override
				public void mouseMoved(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
		    });
		
		
		
	}
}
