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

//    public void print(){
//        for (int i = 0; i < quantity; i++){
//            System.out.println(itemsInStore[i].toString());
//        }
//    }
}
