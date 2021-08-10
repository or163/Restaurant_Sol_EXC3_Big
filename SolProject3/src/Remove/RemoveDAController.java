package Remove;

import java.util.Optional;

import Model.DeliveryArea;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;

public class RemoveDAController {

    @FXML
    private ListView<DeliveryArea> DALV;
    
    @FXML
    private ListView<DeliveryArea> DALV2;

    @FXML
    private Label message;

    @FXML
    void remove(ActionEvent event) {
    	DeliveryArea da = null;
    	DeliveryArea da2 = null;
		da = DALV.getSelectionModel().getSelectedItem();
		da2 = DALV2.getSelectionModel().getSelectedItem();
		
		if(DALV==null)
			message.setText("There are no areas to remove");
		else if(DALV.getSelectionModel().getSelectedItem() == null || DALV2.getSelectionModel().getSelectedItem()== null) 
			message.setText("Please Select areas");
		else { // (da!= null && da2!= null){
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation");
			alert.setHeaderText(DALV.getSelectionModel().getSelectedItem() + " has been chosen");
			alert.setContentText("Are you sure you want to delete this one?");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				Main.restaurant.removeDeliveryArea(da,da2);
				initData();
				message.setTextFill(Color.GREEN);
				message.setText("Removed successfully");
				
			}// else { // user chose CANCEL or closed the dialog
				//initData();
			   
			//}
		}
		initData();

    }
    
    public void initData(){
    	DALV.getItems().clear();
    	DALV2.getItems().clear();
    	DALV.getSelectionModel().clearSelection();
    	DALV.getItems().addAll(Main.restaurant.getAreas().values());
    	DALV2.getSelectionModel().clearSelection();
    	DALV2.getItems().addAll(Main.restaurant.getAreas().values());
	}

}
