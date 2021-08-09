package application;

import java.time.LocalDate;

import Model.Cook;
import Model.DeliveryArea;
import Model.DeliveryPerson;
import Utils.Expertise;
import Utils.Gender;
import Utils.Vehicle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddDPController {

    @FXML
    private Button save;

    @FXML
    private TextField txtFName;

    @FXML
    private TextField txtLName;

    @FXML
    private DatePicker date;

    @FXML
    private ChoiceBox<Gender> gender;

    @FXML
    private ChoiceBox<Vehicle> vehicle;

    @FXML
    private ChoiceBox<DeliveryArea> da;

    @FXML
    private Label message;

    
    @FXML
	public void save(ActionEvent e) {
		Gender gend = gender.getSelectionModel().getSelectedItem();
		Vehicle car = vehicle.getSelectionModel().getSelectedItem();
		DeliveryArea d = da.getSelectionModel().getSelectedItem();
		LocalDate bday = date.getValue();
		
		if (txtFName.getText() == null || txtFName.getText().isEmpty() || txtLName.getText() == null || txtLName.getText().isEmpty() ||
				gend == null || car == null || d == null || bday == null) {
			message.setText("you have fields that are empty");
		} else {
			DeliveryPerson dp = new DeliveryPerson(txtFName.getText(), txtLName.getText(), bday, gend, car, d);
			Main.restaurant.addDeliveryPerson(dp, d);
			message.setText("saved succesfully");
			initData();
			System.out.println(Main.restaurant.getCooks());
		}
	}

	public void initData() {
		// TODO Auto-generated method stub
		txtLName.clear();
		txtFName.clear();
		gender.getSelectionModel().clearSelection();
		vehicle.getSelectionModel().clearSelection();
		da.getSelectionModel().clearSelection();
		Utils.Utils.initDate(date);
		for (Gender g : Gender.values())
			gender.getItems().add(g);
		for (Vehicle v : Vehicle.values())
			vehicle.getItems().add(v);
		for (DeliveryArea d : Main.restaurant.getAreas().values())
			da.getItems().add(d);
	}
}
