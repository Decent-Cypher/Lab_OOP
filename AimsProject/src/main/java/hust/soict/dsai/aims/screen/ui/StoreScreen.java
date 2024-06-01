package hust.soict.dsai.aims.screen.ui;

import hust.soict.dsai.aims.screen.controller.StoreScreenController;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StoreScreen {
    private Store store;

    public StoreScreen(Store store) {
        this.store = store;

        Stage stage = new Stage();
        stage.setTitle("Store");
        stage.setWidth(1024);
        stage.setHeight(768);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/fxml/store.fxml"));
            loader.setController(new StoreScreenController(store, new Cart()));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
