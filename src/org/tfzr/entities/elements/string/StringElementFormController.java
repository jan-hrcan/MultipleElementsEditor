package org.tfzr.entities.elements.string;

import org.tfzr.entities.GridElement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StringElementFormController {

    @FXML
    private BorderPane root;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnExit;
    @FXML
    private TextArea txaMain;
    
    private static StringElement stringElement;
    
    public void initialize()
    {
    	setButtonIcons();
    }
    
    private void setButtonIcons()
    {
    	Image image1 = new Image(getClass().getResourceAsStream("/org/tfzr/resources/CreateImage.png"));
    	btnAdd.setGraphic(new ImageView(image1));
    	Image image2 = new Image(getClass().getResourceAsStream("/org/tfzr/resources/CloseWindowImage.png"));
    	btnExit.setGraphic(new ImageView(image2));
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
    	stringElement = new StringElement(GridElement.getCurrentX(), GridElement.getCurrentY(), txaMain.getText());
    	
		Stage stg = (Stage) root.getScene().getWindow();
		stg.fireEvent(new WindowEvent(stg, WindowEvent.WINDOW_CLOSE_REQUEST));
		stg.close();
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
		Stage stg = (Stage) root.getScene().getWindow();
		//stg.fireEvent(new WindowEvent(stg, WindowEvent.WINDOW_CLOSE_REQUEST));
		stg.close();
    }

	public static StringElement getStringElement() {
		return stringElement;
	}

}
