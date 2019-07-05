package org.tfzr.appform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.tfzr.entities.GridElement;
import org.tfzr.formgenerator.FormGenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainFormController extends FormGenerator{

    @FXML
    private BorderPane root;
    @FXML
    private MenuItem miNewLayout;
    @FXML
    private MenuItem miOpen;
    @FXML
    private Menu mOpenRecent;
    @FXML
    private MenuItem miSave;
    @FXML
    private MenuItem miSaveAs;
    @FXML
    private MenuItem miClose;
    @FXML
    private MenuItem miAbout;
    @FXML
    private ScrollPane spRoot;
    @FXML
    private MenuItem miGenerate;
    @FXML
    private MenuItem miRandGenerate;
    
    // Attributes
    
    // Grid bed
    private Pane gridBed;
    
    // Grid size
    private static int ROW_SIZE;
    private static int COLUMN_SIZE;
    private static int CELL_SIZE_X;
    private static int CELL_SIZE_Y;
    
    private int layoutX;
    private int layoutY;
    
    // Grid list
    private static List<GridElement> alGridElement;
    
    // tButton list
    private List<ToggleButton> tBtnList;

    public void initialize()
    {
    	gridBed = new Pane();
    	spRoot.setContent(gridBed);
    	alGridElement = new ArrayList<GridElement>();
    	tBtnList = new ArrayList<ToggleButton>();
    }
    
    /*
     * PRIVATE 
     * METHODS
     */
    
    private void constructTheGrid()
    {
    	layoutX = 60;
    	layoutY = 40;
    	
    	for (int i=0; i<ROW_SIZE; i++)
    	{
    		Label rowNum = new Label("Row #" + (i+1) + ":");
    		rowNum.setUnderline(true);
    		rowNum.setLayoutX(10);
    		rowNum.setLayoutY(layoutY+(CELL_SIZE_Y/2));
    		gridBed.getChildren().add(rowNum);
    		
    		for (int j=0; j<COLUMN_SIZE; j++)
    		{

    			if (i == 0)
    			{
    				ToggleButton b = new ToggleButton("Bind row #" + (j+1) + " to one element");
    				tBtnList.add(b);
    				b.setLayoutX(layoutX);
    				b.setLayoutY(layoutY-30);
    				gridBed.getChildren().add(b);
    			}
    			
    			GridElement ge = new GridElement(i, j);
    			ge.setLayoutX(layoutX);
    			ge.setLayoutY(layoutY);
    			alGridElement.add(ge);
    			gridBed.getChildren().add(ge);
    			
    			layoutX += (CELL_SIZE_X + 10); // width of pane is 200 plus additional 10 for space
    		}
    		
    		layoutY += (CELL_SIZE_Y + 10);
    		layoutX = 60;
    	}
    	
    	CurrentProjectInfo.setROW_SIZE(ROW_SIZE);
    	CurrentProjectInfo.setCOLUMN_SIZE(COLUMN_SIZE);
    	CurrentProjectInfo.setCELL_SIZE_X(CELL_SIZE_X);
    	CurrentProjectInfo.setCELL_SIZE_Y(CELL_SIZE_Y);
    }
    
    /*
     * FXML 
     * ACTION 
     * EVENTS
     */
    
    @FXML
    void mOpenRecentOnAction(ActionEvent event) {

    }

    @FXML
    void miAboutOnAction(ActionEvent event) {

    }

    @FXML
    void miCloseOnAction(ActionEvent event) {
    	
    }

    @FXML
    void miNewLayoutOnAction(ActionEvent event) throws IOException {
    	Stage stage = generate("/org/tfzr/newlayoutform/NewLayoutForm.fxml", "New layout", root, false);
    	stage.show();
    	stage.setOnCloseRequest(e -> {
    		gridBed.getChildren().clear();
    		constructTheGrid();
    	});
    }

    @FXML
    void miOpenOnAction(ActionEvent event) {

    }

    @FXML
    void miSaveAsOnAction(ActionEvent event) {
    	Stage stage = generate("/org/tfzr/projects/ObjectSaveDialog.fxml", "Save as ...", root, false);
    	stage.show();
    }

    @FXML
    void miSaveOnAction(ActionEvent event) {

    }
    
    @FXML
    void miGenerateOnAction(ActionEvent event) {

    }

    @FXML
    void miRandGenerateOnAction(ActionEvent event) {

    }
    
    
    /*
     * GETTERS 
     * AND 
     * SETTERS
     */

	public static int getROW_SIZE() {
		return ROW_SIZE;
	}

	public static void setROW_SIZE(int rOW_SIZE) {
		ROW_SIZE = rOW_SIZE;
	}

	public static int getCOLUMN_SIZE() {
		return COLUMN_SIZE;
	}

	public static void setCOLUMN_SIZE(int cOLUMN_SIZE) {
		COLUMN_SIZE = cOLUMN_SIZE;
	}

	public static List<GridElement> getAlGridElement() {
		return alGridElement;
	}

	public static int getCELL_SIZE_X() {
		return CELL_SIZE_X;
	}

	public static void setCELL_SIZE_X(int cELL_SIZE_X) {
		CELL_SIZE_X = cELL_SIZE_X;
	}

	public static int getCELL_SIZE_Y() {
		return CELL_SIZE_Y;
	}

	public static void setCELL_SIZE_Y(int cELL_SIZE_Y) {
		CELL_SIZE_Y = cELL_SIZE_Y;
	}
    
    

}
