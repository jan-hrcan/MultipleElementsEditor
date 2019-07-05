package org.tfzr.entities.elements.math;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MathHelpController {

    @FXML
    private Pane root;
    @FXML
    private ImageView imageView;
    
    public void initialize()
    {
    	Image image = new Image(getClass().getResourceAsStream("/org/tfzr/entities/elements/math/mathhelp.png"));
    	imageView.setImage(image);
    }

}
