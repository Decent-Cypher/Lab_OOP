package hust.soict.dsai.aims;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javafx.scene.control.*;

public class Aims {
    private static final Store mainStore = new Store();
    private static final Cart mainCart = new Cart();
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void storeMenu() {

        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    public static int getIntegerInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input
            }
        }

        return result;
    }
    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");

    }
    public static void seeMediaDetails() {
        String title = getStringInput("Your title: ");
        Media media = mainStore.searchStoreByTitle(title);
        if (media != null) {
            System.out.println(media);;  // Method to display media details
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found.");
        }
    }
    public static void mediaDetailsMenu(Media media) {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof Playable) {
                System.out.println("2. Play");
            }
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");

            int choice = getIntegerInput("Pick your option");
            switch (choice) {
                case 1:
                    try {
                        mainCart.addMedia(media);
                    } catch (LimitExceededException ignored) {
                    }
                    System.out.println("Added to cart.");
                    break;
                case 2:
                    if (media instanceof Playable) {
                        try {
                            ((Playable) media).play();
                        } catch (PlayerException e) {
                            e.printStackTrace();
                            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                            errorAlert.setTitle("Illegal Length");
                            errorAlert.setHeaderText(null);
                            errorAlert.setContentText("Length of item is less than or equal to 0");
                            errorAlert.showAndWait();
                        }
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void addMediaToCart() {
        String title = getStringInput("Your title: ");
        Media media = mainStore.searchStoreByTitle(title);
        if (media != null) {
            try {
                mainCart.addMedia(media);
            } catch (LimitExceededException ignored) {
            }
            System.out.println("Added to cart.");
        } else {
            System.out.println("Media not found.");
        }
    }
    public static void playMedia() {
        String title = getStringInput("Enter the title of the media:");
        Media media = mainStore.searchStoreByTitle(title);
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                e.printStackTrace();
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Illegal Length");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Length of item is less than or equal to 0");
                errorAlert.showAndWait();
            }
        } else {
            System.out.println("This media cannot be played or was not found.");
        }
    }
    public static void seeCurrentCart() {
        mainCart.display();  // Method to display cart contents
        while (true) {
            cartMenu();
            int choice = getIntegerInput("Pick your option: ");
            switch (choice) {
                case 1:
                    int filterBy = getIntegerInput("Which filter option would you like?\n1.  id\n2. title");
                    if (filterBy == 1){
                        int id = getIntegerInput("Input the ID to filter: ");
                        mainCart.filterMedias(id);
                    }
                    else{
                        String title = getStringInput("Input your title to filter: ");
                        mainCart.filterMedias(title);
                    }
                    break;
                case 2:
                    int sortBy = getIntegerInput("Which sort option would you like?\n1.  cost\n2. title");
                    mainCart.sortMedias(sortBy);
                    break;
                case 3:
                    System.out.println("Enter the title of the media to remove:");
                    String title = getStringInput("Enter the title of the media to remove:");

                    mainCart.removeMedia(mainCart.searchCartByTitle(title));
                    System.out.println("Removed from cart.");
                    break;
                case 4:
                    playMediaInCart();
                    break;
                case 5:
                    mainCart.placeOrder();
                    System.out.println("Order placed.");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void playMediaInCart() {
        String title = getStringInput("Enter the title of the media:");
        Media media = mainCart.searchCartByTitle(title);
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                e.printStackTrace();
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Illegal Length");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Length of item is less than or equal to 0");
                errorAlert.showAndWait();
            }
        } else {
            System.out.println("This media cannot be played or was not found.");
        }
    }
    public static void viewStore() {
        while (true) {
            mainStore.display();  // Method to display all items in the store
            storeMenu();
            int choice = getIntegerInput("Pick your option: ");
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void updateStore() {
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        int choice = getIntegerInput("Pick your option: ");
        switch (choice) {
            case 1:
                // Code to add media to the store
                break;
            case 2:
                String title = getStringInput("Enter the title of the media to remove:");
                mainStore.removeMedia(mainStore.searchStoreByTitle(title));
                System.out.println("Removed from store.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    public static void main(String[] args) {
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book(1, "Game of Thrones", "Adventure", 30.6f, new ArrayList<String>(Arrays.asList("Binh", "Khanh")));
        CompactDisc cd = new CompactDisc("A case in Bohemia", "Mystery", 30.2f);
        List<Media> mediae = new ArrayList<Media>();
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        while (true) {
            showMenu();
            int choice = getIntegerInput("Input your option");
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
