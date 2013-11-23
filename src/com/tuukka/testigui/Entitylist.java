package com.tuukka.testigui;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.Root;

@Root
public class Entitylist {
	
	@Attribute
	private int length;

	@ElementArray(entry="entity")
	private Entity[] entities;        

	public Entity[] getEntities() {
		return entities;
	}
}
