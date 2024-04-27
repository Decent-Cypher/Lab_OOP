import java.sql.Wrapper;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        Wrap wo1 = new Wrap(jungleDVD);
        Wrap wo2 = new Wrap(cinderellaDVD);
        swap(wo1, wo2);
        System.out.println("jungle dvd title: " + wo1.a.getTitle());
        System.out.println("cinderella dvd title: " + wo2.a.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Wrap o1, Wrap o2) {
        DigitalVideoDisc tmp = o1.a;
        o1.a = o2.a;
        o2.a = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
class Wrap {
    DigitalVideoDisc a;
    Wrap(DigitalVideoDisc a){ this.a = a;}
}