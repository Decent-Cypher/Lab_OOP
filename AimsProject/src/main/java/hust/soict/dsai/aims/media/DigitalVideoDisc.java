package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
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
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
        this.setId(nbDigitalVideoDiscs);
        nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(int i, String title, String category, float cost, int length, String director) {
        super(title, category, cost, length, director);
        this.setId(i);
    }

    @Override
    public String toString() {
        return "DigitalVideoDisc{" +
                "title='" + this.getTitle() + '\'' +
                ", category='" + this.getCategory() + '\'' +
                ", director='" + this.getDirector() + '\'' +
                ", length=" + this.getLength() +
                ", cost=" + this.getCost() +
                ", id=" + this.getId() +
                "}\n";
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0){
            throw new PlayerException("ERROR: DVD legnth is non-positive");
        }
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
