package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media){
        if (itemsOrdered.size() == 20){
            System.out.println("The cart is already full");
            return;
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

    public float totalCost(){
        float cost = 0;
        int qtyOrdered = itemsOrdered.size();
        for (int i = 0; i < qtyOrdered; i++){
            cost += itemsOrdered.get(i).getCost();
        }
        return cost;
    }
    public void searchCartByTitle(String title){
        boolean check = false;
        int qtyOrdered = itemsOrdered.size();
        for (int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered.get(i).isMatch(title)){
                System.out.println(itemsOrdered.get(i).toString());
                check = true;
            }
        }
        if (!check){
            System.out.println("There is no DVD like that");
        }
    }
    public void searchCartByID(int id){
        boolean check = false;
        int qtyOrdered = itemsOrdered.size();
        for (int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered.get(i).isMatch(id)){
                System.out.println(itemsOrdered.get(i).toString());
                check = true;
            }
        }
        if (!check){
            System.out.println("There is no DVD like that");
        }
    }
}
