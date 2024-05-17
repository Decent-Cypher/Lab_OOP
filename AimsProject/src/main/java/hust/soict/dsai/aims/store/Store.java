package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    public static int MAX_QUANTITY = 50000;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia(Media media){
        if (itemsInStore.size() == MAX_QUANTITY){
            System.out.println("The store is already full");
            return;
        }
        itemsInStore.add(media);
        System.out.println("The media was added to the store");
    }
    public void removeMedia(Media media){
        if (itemsInStore.contains(media)){
            itemsInStore.remove(media);
            System.out.println("The media was removed from the store");
        }
        else{
            System.out.println("The media doesn't exist in the store");
        }
    }

    public Media searchStoreByTitle(String title){
        int qtyOrdered = itemsInStore.size();
        for (int i = 0; i < qtyOrdered; i++){
            if (itemsInStore.get(i).isMatch(title)){
                // System.out.println(itemsInStore.get(i).toString());
                return itemsInStore.get(i);
            }
        }
        return null;
    }
    public Media searchStoreByID(int id){
        int qtyOrdered = itemsInStore.size();
        for (int i = 0; i < qtyOrdered; i++){
            if (itemsInStore.get(i).isMatch(id)){
                // System.out.println(itemsInStore.get(i).toString());
                return itemsInStore.get(i);
            }
        }
        return null;
    }

    public void display(){
        for (int i = 0; i < itemsInStore.size(); i++){
            System.out.println(itemsInStore.get(i).toString());
        }
    }
}
