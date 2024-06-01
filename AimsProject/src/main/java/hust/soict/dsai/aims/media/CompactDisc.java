package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
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

    public CompactDisc(int i, String title, String category, float cost, int i1, String artist, String director) {
        super(title, category, cost);
        this.setId(i);
        this.artist = artist;
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

    @Override
    public String toString() {
        return "CompactDisc{" +
                "artist='" + artist + '\'' +
                ", tracks=" + tracks + '\'' +
                ", id=" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", cost=" + getCost() +
                "}\n";
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
    public String getArtist(){
        return artist;
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println(artist);
            for (Track track : tracks) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        }
        else{
            throw new PlayerException("ERROR: CD length is non-positive");
        }
    }
}
