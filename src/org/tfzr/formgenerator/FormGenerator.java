package org.tfzr.formgenerator;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormGenerator {

	protected Stage generate(String _FXMLPath, String _title, Pane _reference, boolean _resizable)
	{
		FXMLLoader loader = new FXMLLoader();
        Stage stg = new Stage();
        Pane form = null;
		try {
			form = loader.load(getClass().getResource(_FXMLPath).openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        stg.initModality(Modality.WINDOW_MODAL);
        stg.initOwner(_reference.getScene().getWindow());
        stg.getIcons().add(new Image(getClass().getResourceAsStream("/org/tfzr/resources/WindowImage.png")));
        Scene scene = new Scene(form);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("org/tfzr/application/application.css").toExternalForm());
        stg.setTitle(_title);
        stg.setResizable(_resizable);
        stg.setScene(scene);
        
        return stg;
	}
	
}
