package org.tfzr.formgenerator;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class StaticFormGenerator {
	
	public static Stage generate(URL _formLocation, InputStream _iconInputStream, URL _cssLocation, Window _owner, String _stageTitle)
	{
        Stage stg = new Stage();
        Pane form = null;
		try {
			form = FXMLLoader.load(_formLocation);
		} catch (IOException e1) {e1.printStackTrace();}
		
        stg.initModality(Modality.WINDOW_MODAL);
        stg.initOwner(_owner);
        stg.getIcons().add(new Image(_iconInputStream));
        Scene scene = new Scene(form);
        scene.getStylesheets().add(_cssLocation.toExternalForm());
        stg.setTitle(_stageTitle);
        stg.setResizable(false);
        stg.setScene(scene);
        
        return stg;
	}
}
