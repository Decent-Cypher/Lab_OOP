package hust.soict.dsai.aims.screen.ui;

import hust.soict.dsai.aims.screen.controller.CartScreenController;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CartScreen {
    private Store store;
    private Cart cart;

    public CartScreen(Cart cart) {
        this.cart = cart;

        Stage stage = new Stage();
        stage.setTitle("Cart");
        stage.setWidth(1024);
        stage.setHeight(768);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/fxml/cart.fxml"));
            loader.setController(new CartScreenController(store, cart));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
