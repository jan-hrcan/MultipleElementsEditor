package org.tfzr.entities.elements.image;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ImageElementFormController {

    @FXML
    private BorderPane root;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnExit;
    @FXML
    private ImageView imgPreview;
    @FXML
    private Button btnChooseImage;
    
    private FileChooser fc;
    private Stage thisStage;
  
    // IMAGE
    private static Image image;

    public void initialize()
    {
    	setButtonIcons(); 	
    	ExtensionFilter imageFilter
        = new ExtensionFilter("Image Files", "*.jpg", "*.png");
        fc = new FileChooser();
    	fc.getExtensionFilters().add(imageFilter);
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
    	if (image != null)
    	{
    		Stage stg = (Stage) root.getScene().getWindow();
    		stg.fireEvent(new WindowEvent(stg, WindowEvent.WINDOW_CLOSE_REQUEST));
    		stg.close();
    	}
    }

    @FXML
    void btnChooseImageOnAction(ActionEvent event) {
    	thisStage = (Stage) btnAdd.getScene().getWindow();
    	image = new Image(fc.showOpenDialog(thisStage).toURI().toString());
    	imgPreview.setImage(image);
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
		Stage stg = (Stage) root.getScene().getWindow();
		//stg.fireEvent(new WindowEvent(stg, WindowEvent.WINDOW_CLOSE_REQUEST));
		stg.close();
    }

	public static Image getImage() {
		return image;
	}

    
}
