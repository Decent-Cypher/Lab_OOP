package hust.soict.dsai.aims;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Aims {
    public static void main(String[] args) {
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book(1, "Game of Thrones", "Adventure", 30.6f, new ArrayList<String>(Arrays.asList("Binh", "Khanh")));
        CompactDisc cd = new CompactDisc("A case in Bohemia", "Mystery", 30.2f);
        List<Media> mediae = new ArrayList<Media>();
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);
        for (Media m: mediae){
            System.out.println(m.toString());
        }
    }
}
