
public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();
        // Testing the addDigitalVideoDisc method
        DigitalVideoDisc dvd1 = new DigitalVideoDisc ("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc ("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        System.out.print("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        // Testing the removeDigitalVideoDisc method
        anOrder.removeDigitalVideoDisc(dvd3);
        System.out.print("Total cost after removing the disc is: ");
        System.out.println(anOrder.totalCost());
    }
}
