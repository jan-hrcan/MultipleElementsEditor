package org.tfzr.entities.elements.htmlstring;

import org.tfzr.entities.elements.Element;

public class HTMLStringElement extends Element{
	
	private String text;
	private boolean bold;
	private boolean italic;
	
	public HTMLStringElement(int x, int y, String text, boolean bold, boolean italic) {
		super(x, y);
		this.text = text;
		this.bold = bold;
		this.italic = italic;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isBold() {
		return bold;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public boolean isItalic() {
		return italic;
	}

	public void setItalic(boolean italic) {
		this.italic = italic;
	}

	

}
