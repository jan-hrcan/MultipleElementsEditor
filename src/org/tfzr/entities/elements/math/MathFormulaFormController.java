package org.tfzr.entities.elements.math;

import java.awt.Stroke;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.jfree.fx.FXGraphics2D;
import org.scilab.forge.jlatexmath.Box;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MathFormulaFormController {

    @FXML
    private BorderPane root;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnExit;
    @FXML
    private Canvas canvas;
    @FXML
    private ToggleButton tbtnListener;
    
    private FXGraphics2D g2;
    private Box box;
    private TeXFormula formula;
    private TeXIcon icon;
    
    private List<TeXFormula> historyFormulaList;
    
    private static Image formulaImage;
    
    public void initialize()
    {
    	historyFormulaList = new ArrayList<TeXFormula>();
        this.g2 = new FXGraphics2D(canvas.getGraphicsContext2D());
        this.g2.scale(2, 2);

        // TeXFormula formula = new TeXFormula("x=\\frac{-b \\pm \\sqrt {b^2-4ac}}{2a}");
        formula = new TeXFormula();
        historyFormulaList.add(formula);
        icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);

        this.box = icon.getBox();

        canvas.widthProperty().addListener(evt -> draw()); 
        canvas.heightProperty().addListener(evt -> draw()); 
        
        draw();
    }   
    
    private void reFormulate(String _str)
    {   	
        historyFormulaList.add(new TeXFormula(formula));
    	formula.append(_str);
        icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);
        this.box = icon.getBox();
        
        draw();
    }
    
    private void revertToPreviousFormula()
    {
    	formula = historyFormulaList.get(historyFormulaList.size()-1);
        icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);
        this.box = icon.getBox();
        
        draw();
        
        historyFormulaList.remove(historyFormulaList.size()-1);
    }

    private void draw() { 
        double width = canvas.getWidth(); 
        double height = canvas.getHeight();
        canvas.getGraphicsContext2D().clearRect(0, 0, width, height);
        box.draw(canvas.getGraphicsContext2D(), 5, 25);
    } 

    @FXML
    void onKeyPressedOnRoot(KeyEvent event) {
    	System.out.println(event.getCode());
    	if (tbtnListener.isSelected())
    	{	
    		KeyCode kc = event.getCode();
			if (event.isShiftDown())
    		{
				if (event.getCode() == KeyCode.OPEN_BRACKET && event.isShiftDown()) reFormulate("\\{ ");
				else if (event.getCode() == KeyCode.CLOSE_BRACKET && event.isShiftDown()) reFormulate(" \\}");
    		}
    		else if (event.getCode() == KeyCode.SLASH)
    		{
    			generateFractalStage();
    		}
    		else if (event.getCode() == KeyCode.EQUALS)
    		{
    			reFormulate(" = ");
    		}
    		else if (event.getCode() == KeyCode.COMMA)
    		{
    			reFormulate(" , ");
    		}
			else if (kc.isWhitespaceKey())
    		{
    			reFormulate(" ");
    		}
    		else if (kc.isLetterKey())
    		{        		
        		if (kc.getName().length() < 2)
        		{
        			reFormulate(kc.getName());
        		}
    		}
    		else if (kc.getName().equals("Backspace"))
    		{
    			revertToPreviousFormula();
    		}
    	}
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
    	//captureAndSaveDisplay();
        WritableImage writableImage = new WritableImage((int)canvas.getWidth() + 20,
                (int)canvas.getHeight() + 20);
        formulaImage = canvas.snapshot(null, writableImage);
        
		Stage stg = (Stage) root.getScene().getWindow();
		stg.fireEvent(new WindowEvent(stg, WindowEvent.WINDOW_CLOSE_REQUEST));
		stg.close();
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {

    }

    @FXML
    void tbtnListenerOnAction(ActionEvent event) {
    	if (tbtnListener.isSelected())
    	{
    		tbtnListener.setText("Listener ON");
    	}
    	else 
    	{
    		tbtnListener.setText("Listener OFF");
    	}
    }
    
    private void generateFractalStage()
    {
		Stage stg = new Stage();
		
		VBox vBox = new VBox(5);
		vBox.setAlignment(Pos.CENTER);
		
		TextField tfTop = new TextField();
		Line line = new Line();
		line.setStrokeWidth(3);
		line.setScaleX(100);
		TextField tfBottom = new TextField();
		
		vBox.getChildren().addAll(tfTop, line, tfBottom);
		
		Scene scene = new Scene(vBox, 300, 100);
		
		stg.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
	        if (ev.getCode() == KeyCode.ENTER) {
				reFormulate("\\frac{" + tfTop.getText() + "}{" + tfBottom.getText() + "}");
				stg.close();
	         }
	     });
		
		stg.getIcons().add(new Image(getClass().getResourceAsStream("/org/tfzr/resources/WindowImage.png")));
		stg.setTitle("Fractal settings");
		stg.setScene(scene);
		stg.setResizable(false);
		stg.show();
    }
    
    public void captureAndSaveDisplay(){
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));

        //Prompt user to select a file
        File file = fileChooser.showSaveDialog(null);

        if(file != null){
            try {
                //Pad the capture area
                WritableImage writableImage = new WritableImage((int)canvas.getWidth() + 20,
                        (int)canvas.getHeight() + 20);
                canvas.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                //Write the snapshot to the chosen file
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }

	public static Image getFormulaImage() {
		return formulaImage;
	}

    
}
