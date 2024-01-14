package tests;

import org.junit.Test;
import java.util.ArrayList;
import java.util.*;
import ratings.Rating;
import ratings.Song;
import ratings.Movie;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import static org.junit.Assert.*;

public class TestClasses2 {
    private final double EPSILON = .001;
    public void compareArray(ArrayList<String> result, ArrayList<String> expected){
        for(int i = 0; i < result.size(); i++){
            assertTrue(result.get(i).equalsIgnoreCase(expected.get(i)));
        }
    }
    @Test
    public void testbayesianAverageRating(){
        Song rating = new Song("","","");
        rating.averageRating();
        assertEquals(0.0,rating.bayesianAverageRating(0, 0),EPSILON);
        assertEquals(5.0,rating.bayesianAverageRating(1, 5),EPSILON);
        assertEquals(4.0,rating.bayesianAverageRating(1, 4),EPSILON);
        assertEquals(3.0,rating.bayesianAverageRating(1, 3),EPSILON);
        assertEquals(2.0,rating.bayesianAverageRating(1, 2),EPSILON);
        assertEquals(1.0,rating.bayesianAverageRating(1, 1),EPSILON);
        Rating R1 = new Rating("a",5);
        rating.addRating(R1);
        assertEquals(4.5,rating.bayesianAverageRating(1, 4),EPSILON);
    }
    @Test
    public void testMovie() {
        ArrayList<String> temp = new ArrayList<String>(Arrays.asList("Chris Pratt","Zoe Saldana","Dave Bautista"));
        Movie rating = new Movie("temp", temp);
        assertTrue(rating.getTitle().equals("temp"));
        compareArray(rating.getCast(),temp);
    }
    @Test
    public void testRating(){
        ArrayList<String> temp = new ArrayList<String>();
        temp.add("Chris Pratt");
        temp.add("Zoe Saldana");
        temp.add("Dave Bautista");
        Movie rating = new Movie("temp", temp);
        Rating R = new Rating("Jesse", 5);
        assertEquals("Jesse", R.getReviewerID());
        assertEquals(5, R.getRating());
        R.setReviewerID("Paul");
        assertEquals("Paul", R.getReviewerID());
        rating.addRating(R);
        assertEquals(5.0, rating.bayesianAverageRating(0, 0), EPSILON);
    }
    @Test
    public void TTest() {
        // Two songs with the same title
        Song a = new Song("a", "", "");
        Song b = new Song("a", "", "");
        SongTitleComparator TComparator = new SongTitleComparator();
        assertTrue(TComparator.compare(a, b) == false);

        // First song title comes before second song title
        a = new Song("a", "", "");
        b = new Song("b", "", "");
        assertTrue(TComparator.compare(a, b) == true);

        // Second song title comes before first song title
        a = new Song("b", "", "");
        b = new Song("a", "", "");
        assertTrue(TComparator.compare(a, b) == false);

        // Upper and lower case are the same
        a = new Song("A", "", "");
        b = new Song("a", "", "");
        assertTrue(TComparator.compare(a, b) == false);

        a = new Song("a", "", "");
        b = new Song("B", "", "");
        assertTrue(TComparator.compare(a, b) == true);

        // One string is a prefix of another
        a = new Song("aa", "", "");
        b = new Song("a", "", "");
        assertTrue(TComparator.compare(a, b) == false);

        // Empty string should come before any other string
        a = new Song("", "", "");
        b = new Song("a", "", "");
        assertTrue(TComparator.compare(a, b) == true);
    }
    @Test
    public void testCompareSongRating(){
        Song song = new Song("A","A", "A");
        Song song1 = new Song("B","B", "B");
        Song song2 = new Song("C","C", "C");
        Song song3 = new Song("D","D", "D");
        Song song4 = new Song("E", "E", "E");
        song.addRating(new Rating("A", 5));
        song.addRating(new Rating("B", 1));
        song.addRating(new Rating("C", 3));
        song1.addRating(new Rating("D", 3));
        song1.addRating(new Rating("E", 1));
        song1.addRating(new Rating("F", 5));
        song2.addRating(new Rating("G", 2));
        song2.addRating(new Rating("H",1 ));
        song3.addRating(new Rating("I", 5));
        song3.addRating(new Rating("J", 5));
        song3.addRating(new Rating("K", 5));
        song3.addRating(new Rating("L", 5));
        song4.addRating(new Rating("M", 5));
        SongBayesianRatingComparator comparator = new SongBayesianRatingComparator();
        assertFalse(comparator.compare(song, song1));
        assertTrue(comparator.compare(song,song2));
        assertTrue(comparator.compare(song3,song2));
        assertTrue(comparator.compare(song3,song4));
        assertTrue(comparator.compare(song4,song2));

    }
}
