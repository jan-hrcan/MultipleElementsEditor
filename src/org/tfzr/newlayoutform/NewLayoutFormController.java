package org.tfzr.newlayoutform;

import org.tfzr.appform.MainFormController;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class NewLayoutFormController{

    @FXML
    private BorderPane root;
    @FXML
    private Button btnCreate;
    @FXML
    private Button btnExit;
    @FXML
    private TextField txtNumberOfRows;
    @FXML
    private TextField txtNumberOfColumns;
    @FXML
    private TextField txtSizeOfACellX;
    @FXML
    private TextField txtSizeOfACellY;
    @FXML
    private CheckBox chbDefValX;
    @FXML
    private CheckBox chbDefValY;
    
    public void initialize()
    {
    	limitTextFieldsToIntegers();
    	setButtonIcons();
    	addChangeListenersToCheckBoxes();
    }
    
    private void setButtonIcons()
    {
    	Image image1 = new Image(getClass().getResourceAsStream("/org/tfzr/resources/CreateImage.png"));
    	btnCreate.setGraphic(new ImageView(image1));
    	Image image2 = new Image(getClass().getResourceAsStream("/org/tfzr/resources/CloseWindowImage.png"));
    	btnExit.setGraphic(new ImageView(image2));
    }
    
    private void addChangeListenersToCheckBoxes()
    {
    	chbDefValX.selectedProperty().addListener(e -> {
    		if (chbDefValX.isSelected())
    		{
    			txtSizeOfACellX.setDisable(true);
    			txtSizeOfACellX.setText("200");
    		}
    		else
    		{
    			txtSizeOfACellX.setDisable(false);
    			txtSizeOfACellX.setText("200");
    		}
    	});
    	
    	chbDefValY.selectedProperty().addListener(e -> {
    		if (chbDefValY.isSelected())
    		{
    			txtSizeOfACellY.setDisable(true);
    			txtSizeOfACellY.setText("200");
    		}
    		else
    		{
    			txtSizeOfACellY.setDisable(false);
    			txtSizeOfACellY.setText("200");
    		}
    	});
    }
    
    private void limitTextFieldsToIntegers()
    {
    	txtNumberOfRows.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	        	txtNumberOfRows.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    	
    	txtNumberOfColumns.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	        	txtNumberOfColumns.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    	
    	txtSizeOfACellX.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	        	txtSizeOfACellX.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    	
    	txtSizeOfACellY.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	        	txtSizeOfACellY.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    }
    
    @FXML
    void btnCreateOnAction(ActionEvent event) {
    	MainFormController.setCOLUMN_SIZE(Integer.valueOf(txtNumberOfColumns.getText()));
    	MainFormController.setROW_SIZE(Integer.valueOf(txtNumberOfRows.getText()));
    	MainFormController.setCELL_SIZE_X(Integer.valueOf(txtSizeOfACellX.getText()));
    	MainFormController.setCELL_SIZE_Y(Integer.valueOf(txtSizeOfACellY.getText()));
    	
		Stage stg = (Stage) root.getScene().getWindow();
		stg.fireEvent(new WindowEvent(stg, WindowEvent.WINDOW_CLOSE_REQUEST));
		stg.close();
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {	
		Stage stg = (Stage) root.getScene().getWindow();
		stg.fireEvent(new WindowEvent(stg, WindowEvent.WINDOW_CLOSE_REQUEST));
		stg.close();
    }

}
