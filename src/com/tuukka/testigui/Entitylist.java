package com.tuukka.testigui;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.Root;

@Root
public class Entitylist {
	
	@Attribute
	private int length;
	private int i = 0;

	@ElementArray(entry="entity")
	private Entity[] entities;
	
	public Entitylist(@Attribute(name="length")int length) {
		
		this.length = length;
		this.entities = new Entity[length];
		
		
	}


	public Entity[] getEntities() {
		return entities;
	}
	
	public boolean add(Entity e) {
		if (i < length) {
			entities[i] = e;
			i++;
			return true;
		} else {
			// fuck you i won't do what you tell me 
			// srsly this should return a bool
			return false;

		}
		
	}
	public int getLength() {
		return this.length;
	}
}
