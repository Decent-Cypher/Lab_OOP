package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc{
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public CompactDisc(String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
        super(title, category, cost, length, director);
        this.artist = artist;
        this.tracks = tracks;
    }
    public CompactDisc(String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }
    public void addTrack(Track track){
        if (!tracks.contains(track)){
            tracks.add(track);
            System.out.println("The track was added to the track list");
        }
        else{
            System.out.println("The track was already in the track list");
        }
    }
    public void removeTrack(Track track){
        if (tracks.contains(track)){
            tracks.remove(track);
            System.out.println("The track was removed from the track list");
        }
        else{
            System.out.println("That track doesn't exist in the track list");
        }
    }
    @Override
    public int getLength(){
        int sum = 0;
        for (Track track : tracks){
            sum += track.getLength();
        }
        return sum;
    }
}
