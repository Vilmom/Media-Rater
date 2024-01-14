package ratings;

import java.util.*;
import java.nio.file.*;
import java.io.*;

public class FileReader {
    public static ArrayList<String> readFile(String filename){
        try {
            return new ArrayList<>(Files.readAllLines(Paths.get(filename)));
        } catch (IOException e){
            return new ArrayList<>();
        }
    }
    public static ArrayList<Song> readSongs(String filename){
        ArrayList<String> songs = readFile(filename);
        ArrayList<Song> playlist = new ArrayList<>();
        for (String i : songs) {
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(i.split(",")));
            String songID = splits.get(0);
            String artist = splits.get(1);
            String title = splits.get(2);
            String reviewerID = splits.get(3);
            int rating = Integer.parseInt(splits.get(4));
            Song s = new Song(title, artist, songID);
            s.addRating(new Rating(reviewerID, rating));
            boolean notfound = true;
            if (playlist.isEmpty()){
                playlist.add(s);
                notfound = false;
            } else {
                for (Song p:playlist){
                    if (p.getSongID().equals(songID)){
                        notfound=false;
                        p.addRating(new Rating(reviewerID,rating));
                    }
                }
            }
            if (notfound){
                playlist.add(s);
            }
        }
        return playlist;
    }
    public static ArrayList<Movie> readMovies(String filename){
        ArrayList<String> movies = readFile(filename);
        ArrayList<Movie> movieList = new ArrayList<>();
        for (String i : movies){
            ArrayList<String> splits = new ArrayList<>(Arrays.asList(i.split(",")));
            String movieTitle = splits.get(0);
            ArrayList<String> cast = new ArrayList<>(splits);
            cast.remove(0);
            Movie movie = new Movie(movieTitle, cast);
            movieList.add(movie);
        }
        return movieList;
    }
}
