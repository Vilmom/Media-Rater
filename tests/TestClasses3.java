package tests;

import org.junit.Test;
import ratings.FileReader;
import ratings.Song;
import ratings.datastructures.LinkedListNode;
import ratings.Rating;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class TestClasses3 {

    @Test
    public void TestSongFile(){
        assertEquals(FileReader.readSongs(""),new ArrayList<>());
        ArrayList<Song> song = FileReader.readSongs("data/ratings.csv");
        Song test = song.get(0);
        for (Song i:song){
            if (i.getSongID().equals("4dKa5ZzlGqUy3Wo0yaXKNI")){
                test = i;
            }
        }
        LinkedListNode<Rating> ratings = test.getRatings();
        ArrayList<Rating> rate = new ArrayList<>();
        while (ratings.getNext() != null){
            rate.add(ratings.getValue());
            ratings = ratings.getNext();}
        rate.add(ratings.getValue());

        assertEquals(rate.size(),5);
        assertEquals(test.getSongID(),"4dKa5ZzlGqUy3Wo0yaXKNI");
        assertEquals(test.getArtist(), "FIFTY FIFTY");
        assertEquals(test.getTitle(), "Cupid");
        assertEquals(rate.get(0).getReviewerID(),"637");
        assertEquals(rate.get(1).getReviewerID(),"177");
        assertEquals(rate.get(2).getReviewerID(),"416");
        assertEquals(rate.get(3).getReviewerID(),"605");
        assertEquals(rate.get(4).getReviewerID(),"164");
        assertEquals(rate.get(0).getRating(),5);
        assertEquals(rate.get(1).getRating(),5);
        assertEquals(rate.get(2).getRating(),3);
        assertEquals(rate.get(3).getRating(),4);
        assertEquals(rate.get(4).getRating(),5);
    }
}
