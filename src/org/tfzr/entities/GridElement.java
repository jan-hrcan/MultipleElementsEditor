package org.tfzr.entities;

import java.io.IOException;
import java.net.URL;

import org.tfzr.appform.MainFormController;
import org.tfzr.entities.elements.Element;
import org.tfzr.entities.elements.htmlstring.HTMLStringElement;
import org.tfzr.entities.elements.image.ImageElement;
import org.tfzr.entities.elements.image.ImageElementFormController;
import org.tfzr.entities.elements.math.MathFormula;
import org.tfzr.entities.elements.math.MathFormulaFormController;
import org.tfzr.entities.elements.math.NativeMDMathFormula;
import org.tfzr.entities.elements.string.StringElement;
import org.tfzr.entities.elements.string.StringElementFormController;
import org.tfzr.formgenerator.StaticFormGenerator;
import org.tfzr.helperclasses.StaticDialog;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GridElement extends AnchorPane {

	// Attributes
	private int x;
	private int y;
	private Button btnClear;
	private ContextMenu cm;
	private MenuItem miHTMLStringElement;
	private MenuItem miStringElement;
	private MenuItem miImageElement;
	private Menu mMath;
	private MenuItem miMathElementAsAnImage;
	private MenuItem miMathElementNative;
	
	private static int currentX;
	private static int currentY;
	
	private Element element;
	
	public GridElement(int x, int y) {
		super();
		this.cm = new ContextMenu();
		this.miStringElement = new MenuItem("String element");
		this.miHTMLStringElement = new MenuItem("HTML String element");
		this.miImageElement = new MenuItem("Image element");
		this.miMathElementAsAnImage = new MenuItem("Math element as an image");
		this.miMathElementNative = new MenuItem("Native MD math element");
		this.mMath = new Menu("Math");
		this.mMath.getItems().addAll(miMathElementAsAnImage, miMathElementNative);
		this.cm.getItems().addAll(miStringElement, miHTMLStringElement, miImageElement, mMath);
		this.x = x;
		this.y = y;
		this.setStyle("-fx-border-color: black");
		this.setWidth(MainFormController.getCELL_SIZE_X());
		this.setHeight(MainFormController.getCELL_SIZE_Y());
		this.setPrefWidth(MainFormController.getCELL_SIZE_X());
		this.setPrefHeight(MainFormController.getCELL_SIZE_Y());
		this.setOnContextMenuRequested(e -> {
			cm.show(this, e.getScreenX(), e.getScreenY());
		});
		setMenuItemHandlers();
		addClearButton();
	}
	
	/*
	 * PRIVATE
	 * AND
	 * PUBLIC
	 * METHODS 
	 */
	
	public void addClearButton()
	{
		btnClear = new Button();
		btnClear.setPrefSize(16, 16);
    	Image image1 = new Image(getClass().getResourceAsStream("/org/tfzr/resources/ClearGridElement.png"));
    	btnClear.setGraphic(new ImageView(image1));
		setTopAnchor(btnClear, 0.0);
		setRightAnchor(btnClear, 0.0);
		this.getChildren().add(btnClear);
		btnClear.setOnAction(e -> {
			try {
				StaticDialog.deleteDialog(this);
			} catch (Exception ex) {}
		});
	}
	
	private void setMenuItemHandlers()
	{
		this.miStringElement.setOnAction(e -> {
			currentX = this.x;
			currentY = this.y;
			Stage stg;
	        stg = StaticFormGenerator.generate(getClass().getResource("/org/tfzr/entities/elements/string/StringElementForm.fxml"), 
	        		getClass().getResourceAsStream("/org/tfzr/resources/WindowImage.png"), getClass().getClassLoader().getResource("org/tfzr/application/application.css"), 
	        		this.getParent().getScene().getWindow(), "String element addition");
	        stg.show();
	        stg.setOnCloseRequest(ev -> {
	        	element = StringElementFormController.getStringElement();
	        	TextArea ta = new TextArea(StringElementFormController.getStringElement().getString());
	        	ta.setEditable(false);
	        	ta.setMaxWidth(this.getWidth()-20);
	        	ta.setMaxHeight(this.getHeight()-20);
	        	setBottomAnchor(ta, 0.0);
	        	this.getChildren().add(ta);
	        });
		});
		this.miHTMLStringElement.setOnAction(e -> {
			currentX = this.x;
			currentY = this.y;
			Stage stg;
	        stg = StaticFormGenerator.generate(getClass().getResource("/org/tfzr/entities/elements/htmlstring/HTMLStringElementForm.fxml"), 
	        		getClass().getResourceAsStream("/org/tfzr/resources/WindowImage.png"), getClass().getClassLoader().getResource("org/tfzr/application/application.css"), 
	        		this.getParent().getScene().getWindow(), "HTML String element addition");
	        stg.show();
	        stg.setOnCloseRequest(ev -> {
	        	
	        });
		});
		this.miImageElement.setOnAction(e -> {
			currentX = this.x;
			currentY = this.y;
			Stage stg;
	        stg = StaticFormGenerator.generate(getClass().getResource("/org/tfzr/entities/elements/image/ImageElementForm.fxml"), 
	        		getClass().getResourceAsStream("/org/tfzr/resources/WindowImage.png"), getClass().getClassLoader().getResource("org/tfzr/application/application.css"), 
	        		this.getParent().getScene().getWindow(), "Image element addition");
	        stg.show();
	        stg.setOnCloseRequest(ev -> {
	        	ImageView iv = new ImageView(ImageElementFormController.getImage());
	        	iv.setFitWidth(this.getWidth()-20);
	        	iv.setFitHeight(this.getHeight()-20);
	        	setBottomAnchor(iv, 0.0);
	        	this.getChildren().add(iv);
	        });
		});
		this.miMathElementAsAnImage.setOnAction(e -> {
			currentX = this.x;
			currentY = this.y;
			Stage stg;
	        stg = StaticFormGenerator.generate(getClass().getResource("/org/tfzr/entities/elements/math/MathFormulaForm.fxml"), 
	        		getClass().getResourceAsStream("/org/tfzr/resources/WindowImage.png"), getClass().getClassLoader().getResource("org/tfzr/application/application.css"), 
	        		this.getParent().getScene().getWindow(), "Math element addition");
	        stg.show();
	        stg.setOnCloseRequest(ev -> {
	        	ImageView iv = new ImageView(MathFormulaFormController.getFormulaImage());
	        	iv.setFitWidth(this.getWidth()-20);
	        	iv.setFitHeight(this.getHeight()-20);
	        	setBottomAnchor(iv, 0.0);
	        	this.getChildren().add(iv);
	        });
		});
		this.miMathElementNative.setOnAction(e -> {
			currentX = this.x;
			currentY = this.y;
			Stage stg;
	        stg = StaticFormGenerator.generate(getClass().getResource("/org/tfzr/entities/elements/math/NativeMDMathFormula.fxml"), 
	        		getClass().getResourceAsStream("/org/tfzr/resources/WindowImage.png"), getClass().getClassLoader().getResource("org/tfzr/application/application.css"), 
	        		this.getParent().getScene().getWindow(), "Math element addition");
	        stg.show();
	        stg.setOnCloseRequest(ev -> {
	        	/*
	        	TextArea ta = new TextArea(StringElementFormController.getContent());
	        	ta.setEditable(false);
	        	ta.setMaxWidth(this.getWidth()-20);
	        	ta.setMaxHeight(this.getHeight()-20);
	        	setBottomAnchor(ta, 0.0);
	        	this.getChildren().add(ta);
	        	*/
	        });
		});
	}
	
	/*
	 * GETTERS
	 * AND
	 * SETTERS
	 */

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static int getCurrentX() {
		return currentX;
	}

	public static int getCurrentY() {
		return currentY;
	}

	public Element getElement() {
		return element;
	}
}
