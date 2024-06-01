package hust.soict.dsai.aims.screen.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.screen.additem.AddBookToStoreScreen;
import hust.soict.dsai.aims.screen.additem.AddCompactDiscToStoreScreen;
import hust.soict.dsai.aims.screen.additem.AddDigitalVideoDiscToStoreScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StoreScreenController {
    private Store store;

    private Cart cart;

    private BorderPane rootPane;

    @FXML
    private GridPane gridPane;

    public StoreScreenController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    @FXML
    private void handleAddBook(ActionEvent event) {
        AddBookToStoreScreen addBookScreen = new AddBookToStoreScreen(store, new Cart());
    }

    @FXML
    private void handleAddCD(ActionEvent event) {
        AddCompactDiscToStoreScreen addCdScreen = new AddCompactDiscToStoreScreen(store, new Cart());
    }

    @FXML
    private void handleAddDVD(ActionEvent event) {
        AddDigitalVideoDiscToStoreScreen addDvdScreen = new AddDigitalVideoDiscToStoreScreen(store, new Cart());
    }

    @FXML
    private void btnViewCartPressed(ActionEvent event) {
        // Get the current stage from the GridPane
        Stage currentStage = (Stage) gridPane.getScene().getWindow();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/fxml/cart.fxml"));
            fxmlLoader.setController(new CartScreenController(store, cart));
            Parent root = fxmlLoader.load();
            Stage newStage = currentStage;
            newStage.setScene(new Scene(root));
            newStage.setTitle("Cart");
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void initialize(){
        int column = 0;
        int row = 1;
        for (int i = 0; i < store.getItemsInStore().size(); i++){
            try{
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/hust/soict/dsai/aims/screen/fxml/item.fxml"));
                ItemController itemController = new ItemController(cart);
                fxmlLoader.setController(itemController);
                AnchorPane anchorPane = fxmlLoader.load();
                itemController.setData(store.getItemsInStore().get(i));

                if (column == 3){
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10, 10, 10, 10));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
