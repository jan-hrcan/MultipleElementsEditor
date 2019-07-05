package org.tfzr.entities.elements.htmlstring;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.HTMLEditor;

public class HTMLStringElementFormController {

    @FXML
    private BorderPane root;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnExit;
    @FXML
    private HTMLEditor htmlEditor;
    @FXML
    private TextArea taHtmlText;

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

    }

    @FXML
    void btnExitOnAction(ActionEvent event) {

    }   

    @FXML
    void onKeyPressed(KeyEvent event) {
    	taHtmlText.setText(htmlEditor.getHtmlText());
    }
}
