package org.tfzr.helperclasses;

import java.util.List;
import java.util.Optional;

import org.tfzr.entities.GridElement;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class StaticDialog {

	public static void deleteDialog(GridElement _ge)
	{
        ButtonType btnYes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType btnNo = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.NONE, "Are you sure you want to delete this element?", btnYes, btnNo);
        alert.setTitle("Element deletion");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == btnYes){
        	_ge.getChildren().remove(1);
        }
	}
}
