package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.ui.StoreScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Platform.runLater(() -> {
            Store store = new Store();
//            store.addMedia(new DigitalVideoDisc(1, "Harry Potter and the Philosopher's Stone (2001)", "film", 3.0f, 90, "JKRowling"));
//            store.addMedia(new DigitalVideoDisc(2, "Harry Potter and the Chamber of Secrets (2002)", "film", 3.5f, 90, "JKRowling"));
//            store.addMedia(new DigitalVideoDisc(3, "Harry Potter and the Prisoner of Azkaban (2004)", "film", 5.0f, 90, "JKRowling"));
//            store.addMedia(new DigitalVideoDisc(4, "Harry Potter and the Goblet of Fire (2005)", "film", 4.5f, 90, "JKRowling"));
//            store.addMedia(new CompactDisc(5, "Fetch the Bolt Cutters", "pop", 10.39f, 10, "someone", "somebody"));
//            store.addMedia(new CompactDisc(6, "Future Nostalgia", "ballad", 9.6f, 20, "someone", "somebody"));
            store.addMedia(new Book(7, "The Hunger Games", "book", 5.5f));

            new StoreScreen(store);
        });
    }
}
