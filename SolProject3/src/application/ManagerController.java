package application;

import java.io.IOException;

import Remove.RemoveComponentController;
import Remove.RemoveCookController;
import Remove.RemoveCustomerController;
import Remove.RemoveDAController;
import Remove.RemoveDPController;
import Remove.RemoveDeliveryController;
import Remove.RemoveDishController;
import Remove.RemoveOrderController;
import Utils.SerializableWiz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ManagerController {

	private static int counter = 0;
	
	@FXML
	BorderPane pannelRoot;
	
	@FXML
	private VBox vbox;

	@FXML
	private AnchorPane anchor;
	
	@FXML
	void goHome(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/Manager.fxml"));
		Parent p = fx.load();
		Scene s = new Scene(p, 700, 500);
		Main.stage.setScene(s);
	}
	
	@FXML
    void GoLogin(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/Login.fxml"));
		Parent p = fx.load();
		Scene s = new Scene(p, 700, 500);
		Main.stage.setScene(s);
    }

	@FXML
	void goAddCook(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/AddCook.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		AddCookController ctrl = (AddCookController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}

	@FXML
	void goAddCustomer(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/AddCustomer.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		AddCustomerController ctrl = (AddCustomerController) fx.getController();
		ctrl.initData();
		pannelRoot.setBottom(null);
		pannelRoot.setCenter(pp);
	}

	@FXML
	void goAddDP(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/AddDeliveryPerson.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		AddDPController ctrl = (AddDPController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}

	@FXML
	void goAddComponent(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/AddComponent.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goAddDish(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/AddDish.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		AddDishController ctrl = (AddDishController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goAddOrder(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/AddOrder.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		AddOrderController ctrl = (AddOrderController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goAddDA(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/AddDA.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		AddDAController ctrl = (AddDAController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goAddDelivery(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/AddDelivery.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		AddDeliveryController ctrl = (AddDeliveryController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goRemoveCook(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/RemoveCook.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		RemoveCookController ctrl = (RemoveCookController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}

	@FXML
	void goRemoveCustomer(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/RemoveCustomer.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		RemoveCustomerController ctrl = (RemoveCustomerController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}

	@FXML
	void goRemoveDP(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/RemoveDeliveryPerson.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		RemoveDPController ctrl = (RemoveDPController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goRemoveComponent(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/RemoveComponent.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		RemoveComponentController ctrl = (RemoveComponentController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goRemoveDish(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/RemoveDish.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		RemoveDishController ctrl = (RemoveDishController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goRemoveOrder(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/RemoveOrder.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		RemoveOrderController ctrl = (RemoveOrderController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goRemoveDA(ActionEvent event) throws IOException{
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/RemoveDA.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		RemoveDAController ctrl = (RemoveDAController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goRemoveDelivery(ActionEvent event) throws IOException{
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/RemoveDelivery.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		RemoveDeliveryController ctrl = (RemoveDeliveryController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goGRLDList(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/GRLDishListManager.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		GRLDishListManagerController ctrl = (GRLDishListManagerController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goGetCooksByExpertise (ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/GetCookByExpertise.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		GetCookByExpertiseController ctrl = (GetCookByExpertiseController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goGetPopularComponents (ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/GetPopularComponents.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		GetPopularComponentsController ctrl = (GetPopularComponentsController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goOrderWaitingTime (ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/OrderWaitingTime.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		OrderWaitingTimeController ctrl = (OrderWaitingTimeController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goDeliver (ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/Deliver.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		DeliverController ctrl = (DeliverController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goCalcOrderRevenue (ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/CalcOrderRevenue.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		CalcOrderRevenueController ctrl = (CalcOrderRevenueController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goGetDeliveriesByPerson (ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/GetDeliveriesByPerson.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		GetDeliveriesByPersonController ctrl = (GetDeliveriesByPersonController) fx.getController();
		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goGetNumberOfDeliveriesPerType (ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/GetNumberOfDeliveriesPerType.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
//		GetNumberOfDeliveriesPerTypeController ctrl = (GetNumberOfDeliveriesPerTypeController) fx.getController();
//		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goRevenueFromExpressDeliveries (ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/RevenueFromExpressDeliveries.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
//		RevenueFromExpressDeliveriesController ctrl = (RevenueFromExpressDeliveriesController) fx.getController();
//		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goGetProfitRelation (ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/GetProfitRelation.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
//		GetProfitRelationController ctrl = (GetProfitRelationController) fx.getController();
//		ctrl.initData();
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goCreateAIMacine (ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/Add.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		AddController ctrl = (AddController) fx.getController();
		ctrl.setPannelRoot(pannelRoot);
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goAdd (ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/Add.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		AddController ctrl = (AddController) fx.getController();
		ctrl.setPannelRoot(pannelRoot);
		pannelRoot.setCenter(pp);
	}

	@FXML
	void goRemove (ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/Remove.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		RemoveController ctrl = (RemoveController) fx.getController();
		ctrl.setPannelRoot(pannelRoot);
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void goOut(ActionEvent event) throws IOException {
		FXMLLoader fx = new FXMLLoader(getClass().getResource("/View/Login.fxml"));
		Pane p = fx.load();
		AnchorPane pp = (AnchorPane) p;
		pannelRoot.setCenter(pp);
	}
	
	@FXML
	void showMenu(MouseEvent event) {
		if(ManagerController.counter % 2 == 0) {
			vbox.setVisible(false);
			anchor.setStyle("-fx-background-color: transparent");
		}
		else {
			vbox.setVisible(true);
			anchor.setStyle("-fx-background-color: darkblue");
			}
		ManagerController.counter++;
	}
	
	@FXML
	void SaveToSerelizebaleFile(ActionEvent event) {
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
