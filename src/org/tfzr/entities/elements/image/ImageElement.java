package org.tfzr.entities.elements.image;

import org.tfzr.entities.elements.Element;

import javafx.scene.image.Image;

public class ImageElement extends Element {
	
	private Image img;

	public ImageElement(int x, int y, Image img) {
		super(x, y);
		this.img = img;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	
}
