package org.tfzr.entities.elements.string;

import java.io.Serializable;

import org.tfzr.entities.elements.Element;

public class StringElement extends Element implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2005112549135302904L;
	private String string;

	public StringElement(int x, int y, String _string) {
		super(x, y);
		this.string = _string;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	
}
