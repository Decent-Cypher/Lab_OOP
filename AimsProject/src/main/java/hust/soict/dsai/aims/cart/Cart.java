package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;
import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered(){
        return this.itemsOrdered;
    }

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() == 20){
            throw new LimitExceededException("Error: The number of media has reached its limit");
        }
        itemsOrdered.add(media);
        System.out.println("The media was added to the cart");
    }
    public void removeMedia(Media media){
        if (itemsOrdered.contains(media)){
            itemsOrdered.remove(media);
            System.out.println("The media was removed from the cart");
        }
        else{
            System.out.println("The media doesn't exist in the cart");
        }
    }

    public void placeOrder(){
        System.out.println("The order has been created");
        itemsOrdered.clear();
    }

    public float totalCost(){
        float cost = 0;
        int qtyOrdered = itemsOrdered.size();
        for (int i = 0; i < qtyOrdered; i++){
            cost += itemsOrdered.get(i).getCost();
        }
        return cost;
    }
    public Media searchCartByTitle(String title){
        int qtyOrdered = itemsOrdered.size();
        for (int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered.get(i).isMatch(title)){
                // System.out.println(itemsOrdered.get(i).toString());
                return itemsOrdered.get(i);
            }
        }
        return null;
    }
    public Media searchCartByID(int id){
        int qtyOrdered = itemsOrdered.size();
        for (int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered.get(i).isMatch(id)){
                // System.out.println(itemsOrdered.get(i).toString());
                return itemsOrdered.get(i);
            }
        }
        return null;
    }
    public void filterMedias(int id){
        Media item = searchCartByID(id);
        System.out.println(item);
    }
    public void filterMedias(String title){
        Media item = searchCartByTitle(title);
        System.out.println(item);
    }
    public void sortMedias(int option){
        if (option == 1) {
            itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
        }
        else{
            itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
        }
        display();
    }
    public void display(){
        for (int i = 0; i < itemsOrdered.size(); i++){
            System.out.println(itemsOrdered.get(i).toString());
        }
    }

    public void clear() {
        this.itemsOrdered.clear();
    }
}
