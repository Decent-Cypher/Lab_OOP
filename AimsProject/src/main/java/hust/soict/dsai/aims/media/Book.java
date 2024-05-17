package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.setId(id);
        this.authors = authors;
    }
    public void addAuthor(String authorName){
        if (!authors.contains(authorName)){
            authors.add(authorName);
            System.out.println(authorName + " was added to the author list");
        }
        else{
            System.out.println(authorName + " was already in the author list");
        }
    }
    public void removeAuthor(String authorName){
        if (authors.contains(authorName)){
            authors.remove(authorName);
            System.out.println(authorName + " was removed from the author list");
        }
        else{
            System.out.println(authorName + "doesn't exist in the author list");
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "authors=" + authors + '\'' +
                ", id=" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", cost=" + getCost() +
                "}\n";
    }
}
