package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Store {
    public static int MAX_QUANTITY = 50000;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_QUANTITY];
    private int quantity = 0;
    public void addDVD(DigitalVideoDisc disc){
        itemsInStore[quantity] = disc;
        quantity++;
        System.out.println("The disc has been added");
    }
    public void removeDVD(DigitalVideoDisc disc){
        for (int i = 0; i < quantity; i++){
            if (itemsInStore[i] == disc) {
                for (int j = i; j < quantity - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                quantity--;
                System.out.println("The disc has been removed");
                break;
            }
        }
    }
    public void print(){
        for (int i = 0; i < quantity; i++){
            System.out.println(itemsInStore[i].toString());
        }
    }
}
