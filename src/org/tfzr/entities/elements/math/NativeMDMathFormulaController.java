package org.tfzr.entities.elements.math;

import org.tfzr.formgenerator.StaticFormGenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NativeMDMathFormulaController {

    @FXML
    private BorderPane root;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnHelp;
    @FXML
    private TextArea txaMain;
    
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
    	Image image3 = new Image(getClass().getResourceAsStream("/org/tfzr/resources/HelpImage.png"));
    	btnHelp.setGraphic(new ImageView(image3));
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
    	
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
    	Stage stg = (Stage) root.getScene().getWindow();
    	stg.close();
    }

    @FXML
    void btnHelpOnAction(ActionEvent event) {
    	Stage stg = StaticFormGenerator.generate(getClass().getResource("/org/tfzr/entities/elements/math/mathhelp.fxml"), 
        		getClass().getResourceAsStream("/org/tfzr/resources/WindowImage.png"), getClass().getClassLoader().getResource("org/tfzr/application/application.css"), 
        		root.getScene().getWindow(), "HELP");
    	stg.initOwner(null);
    	stg.initModality(null);
    	stg.setAlwaysOnTop(true);
    	stg.show();
    }

}
