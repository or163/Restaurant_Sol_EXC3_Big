package application;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.TreeSet;

import Model.DeliveryArea;
import Model.DeliveryPerson;
import Model.Order;
import Model.RegularDelivery;
import Utils.Expertise;
import Utils.Gender;
import Utils.Neighberhood;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class AddDeliveryController {

    @FXML
    private DatePicker date;

    @FXML
    private RadioButton isDeliverdYes;

    @FXML
    private ToggleGroup deliveyTG;

    @FXML
    private RadioButton isDeliverdNo;

    @FXML
    private Label lblStatus;

    @FXML
    private ListView<Order> orders;

    @FXML
    private ListView<Order> selected;

    @FXML
    private ChoiceBox<DeliveryPerson> deliveryPersons;

    @FXML
    private ChoiceBox<DeliveryArea> deliveryArea;

    @FXML
    void addOrder(ActionEvent event) {
    	if(selected.getItems().contains(orders.getSelectionModel().getSelectedItem())) {
    		lblStatus.setText("Can't contain duplications");
			lblStatus.setTextFill(Color.RED);
    	}
		else if(orders.getSelectionModel().getSelectedItem()==null)
		{
			lblStatus.setText("Please select at list 1 order");
			lblStatus.setTextFill(Color.RED);
		}
		else {
			selected.getItems().add(orders.getSelectionModel().getSelectedItem());
			lblStatus.setText("Order added to the chosen order list");
			lblStatus.setTextFill(Color.BLACK);
		}
    }

    @FXML
    void removeOrder(ActionEvent event) {
    	selected.getItems().remove(selected.getSelectionModel().getSelectedItem());
		lblStatus.setText("Order removed from the chosen order list");
		lblStatus.setTextFill(Color.BLACK);
    }

    @FXML
    void save(ActionEvent event) {
    	LocalDate datte = date.getValue();
    	boolean isDel = false;
		if (isDeliverdYes.isSelected())
			isDel = true;
		else if (isDeliverdNo.isSelected())
			isDel = false;
    	DeliveryPerson delPer = deliveryPersons.getSelectionModel().getSelectedItem();
    	DeliveryArea delAre = deliveryArea.getSelectionModel().getSelectedItem();
    	if(delPer == null || delAre == null || selected.getItems().isEmpty()|| selected.getItems() == null 
    		|| datte == null || deliveyTG.getSelectedToggle() == null)
		{
			lblStatus.setText("Please fill all fields");//maybe we should put all as execptions?
			lblStatus.setTextFill(Color.RED);
		}
    	else {
    	TreeSet<Order> ts = new TreeSet<Order>();
		ts.addAll(selected.getItems());
		RegularDelivery d = new RegularDelivery(delPer,delAre,isDel,datte);
		lblStatus.setText("Delivery Area was added successfully");
		lblStatus.setTextFill(Color.GREEN);
		Main.restaurant.addDelivery(d);
		initData();
		System.out.println(Main.restaurant.getAreas());
    	}
    }
	

    public void initData() {
		// TODO Auto-generated method stub
		Utils.Utils.initDate(date);
		deliveryPersons.getItems().addAll(Main.restaurant.getDeliveryPersons().values());
		deliveryArea.getItems().addAll(Main.restaurant.getAreas().values());
		orders.getItems().addAll(Main.restaurant.getOrders().values());
		orders.getSelectionModel().clearSelection();
//		deliveyTG.getSelectedToggle().setSelected(false);
		selected.getItems().clear();
	}
}
