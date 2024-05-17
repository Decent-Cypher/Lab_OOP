package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;
    public DigitalVideoDisc(String title) {
        this.setTitle(title);
        this.setId(nbDigitalVideoDiscs);
        nbDigitalVideoDiscs++;
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.setId(nbDigitalVideoDiscs);
        nbDigitalVideoDiscs++;
    }
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
        this.setId(nbDigitalVideoDiscs);
        nbDigitalVideoDiscs++;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
        this.setId(nbDigitalVideoDiscs);
        nbDigitalVideoDiscs++;
    }

    @Override
    public String toString() {
        return "DigitalVideoDisc{" +
                "title='" + this.getTitle() + '\'' +
                ", category='" + this.getCategory() + '\'' +
                ", director='" + director + '\'' +
                ", length=" + length +
                ", cost=" + this.getCost() +
                ", id=" + this.getId() +
                "}\n";
    }
    @Override
    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
