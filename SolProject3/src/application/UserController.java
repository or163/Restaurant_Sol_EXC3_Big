package application;

import java.io.IOException;

import Model.Customer;
import Remove.RemoveDishController;
import Utils.SerializableWiz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class UserController {

	@FXML
	private BorderPane pannelRoot;

	@FXML
	private Label welcome;

	public void initData(Customer c) {
		welcome.setText("Welcome " + c.getFirstName());
	}
	
	@FXML
	private void goEdit(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/EditUser.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		EditUserController ctrl = (EditUserController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
    private void SaveToSerelizebaleFile(ActionEvent event) {
    	try {
			SerializableWiz.save(Main.restaurant);
			Alert a = new Alert(AlertType.CONFIRMATION);
			a.setTitle("Save");
			a.setContentText("you have saved your file to Rest.Ser");
			a.show();
		}catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
    }
}