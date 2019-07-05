package org.tfzr.projects;

import java.util.ArrayList;
import java.util.List;

import org.tfzr.appform.CurrentProjectInfo;
import org.tfzr.appform.MainFormController;
import org.tfzr.entities.GridElement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ObjectSaveDialogController {

    @FXML
    private BorderPane root;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnExit;
    @FXML
    private TextField txtProjectName;
    @FXML
    private TextField txtProjectTag;
    @FXML
    private TextArea txaProjectDescription;
    
    private ObjectSaver os;

    public void initialize()
    {
    	setButtonIcons();
    }
    
    private void setButtonIcons()
    {
    	Image image1 = new Image(getClass().getResourceAsStream("/org/tfzr/resources/SaveImage.png"));
    	btnSave.setGraphic(new ImageView(image1));
    	Image image2 = new Image(getClass().getResourceAsStream("/org/tfzr/resources/CloseWindowImage.png"));
    	btnExit.setGraphic(new ImageView(image2));
    }
    
    @FXML
    void btnExitOnAction(ActionEvent event) {
    	Stage stg = (Stage) root.getScene().getWindow();
    	stg.close();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
    	List<Object> objList = new ArrayList<Object>();
    	objList.add(CurrentProjectInfo.class);
    	
    	int c = 0;
    	for (GridElement ge: MainFormController.getAlGridElement())
    	{
    		c++;
    		objList.add(ge.getElement());
    		System.out.println(c);
    	}
    	
    	os = new ObjectSaver(objList, txtProjectName.getText(), txaProjectDescription.getText(), txtProjectTag.getText());
    	
    	if (os.save())
    	{
        	Stage stg = (Stage) root.getScene().getWindow();
        	stg.close();
    	}
    }

}
