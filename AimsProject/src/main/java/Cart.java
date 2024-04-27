public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    public DigitalVideoDisc[] getItemsOrdered(){
        return itemsOrdered;
    }
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered == 20){
            System.out.println("Number of cart items has reached maximum");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("The disc has been added");
    }
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        if (qtyOrdered + dvdList.length <= 20){
            for (DigitalVideoDisc dvd: dvdList){
                addDigitalVideoDisc(dvd);
            }
            System.out.println("All the discs in the list have been added");
        }
        else{
            System.out.println("Maximum number of orders exceeded");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if (qtyOrdered <= 18) {
            addDigitalVideoDisc(dvd1);
            addDigitalVideoDisc(dvd2);
        }
        else{
            System.out.println("Maximum number of orders exceeded");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        for (int i = 0; i < MAX_NUMBERS_ORDERED; i++){
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < MAX_NUMBERS_ORDERED - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                qtyOrdered--;
                System.out.println("The disc has been removed");
                break;
            }
        }
    }
    public float totalCost(){
        float cost = 0;
        for (int i = 0; i < qtyOrdered; i++){
            cost += itemsOrdered[i].getCost();
        }
        return cost;
    }
}
