package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media {
    private String director;
    private int length;
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
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
        super(title, category, cost);
        this.director = director;
        this.length = length;
        this.setId(nbDigitalVideoDiscs);
        nbDigitalVideoDiscs++;
    }
    public boolean isMatch(String search) {
        boolean matched = false;
        String[] searchArr = search.split(" ", 0);
        for (String word: searchArr) {
            String title = this.getTitle();
            String lowerCaseTitle = title.toLowerCase();
            int index = lowerCaseTitle.indexOf(word.toLowerCase());
            if (index != -1) {
                matched = true;
                break;
            }
        }
        return matched;
    }
    public boolean isMatch(int id){
        if (this.getId() == id){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "hust.soict.dsai.aims.media.DigitalVideoDisc{" +
                "title='" + this.getTitle() + '\'' +
                ", category='" + this.getCategory() + '\'' +
                ", director='" + director + '\'' +
                ", length=" + length +
                ", cost=" + this.getCost() +
                ", id=" + this.getId() +
                '}';
    }
}
