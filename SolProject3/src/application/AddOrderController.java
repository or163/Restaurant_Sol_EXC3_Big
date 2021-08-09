package application;

import java.util.ArrayList;
import java.util.List;

import Model.Component;
import Model.Customer;
import Model.Delivery;
import Model.Dish;
import Model.Order;
import Utils.DishType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AddOrderController {

	@FXML
	private Label message;

	@FXML
	private ListView<Dish> selected;

	@FXML
	private ListView<Customer> custV;

	@FXML
	private ListView<Dish> dishV;

	@FXML
	private ListView<Delivery> delV;

	@FXML
    void save(ActionEvent event) {
    	Customer cust = custV.getSelectionModel().getSelectedItem();
    	Delivery del = delV.getSelectionModel().getSelectedItem();
    	List<Dish> list = selected.getItems();
		ArrayList<Dish> dishes = new ArrayList<>(list);
		if (cust == null || del == null || list == null) {
			message.setText("you have fields that are empty");
		} else {
			Order order = new Order(cust, dishes, del);
			Main.restaurant.addOrder(order);
			message.setText("saved succesfully");
			custV.getSelectionModel().clearSelection();
			dishV.getSelectionModel().clearSelection();
			selected.getItems().clear();
			System.out.println(Main.restaurant.getOrders());
		}
    }
		

	public void initData() {
		// TODO Auto-generated method stub
		for (Customer c : Main.restaurant.getCustomers().values())
			custV.getItems().add(c);
		for (Dish d : Main.restaurant.getDishes().values())
			dishV.getItems().add(d);
		for (Delivery d : Main.restaurant.getDeliveries().values())
			delV.getItems().add(d);
	}

	@FXML
	private void addDish(ActionEvent e) {
		selected.getItems().add(dishV.getSelectionModel().getSelectedItem());
	}

	@FXML
	private void removeDish(ActionEvent e) {
		selected.getItems().remove(selected.getSelectionModel().getSelectedItem());
	}

}
