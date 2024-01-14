package tests;

import org.junit.Test;
import ratings.FileReader;
import ratings.Movie;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDataStructures3 {
    @Test
    public void TestMovieFile(){
        assertEquals(FileReader.readMovies(""),new ArrayList<>());
        ArrayList<Movie> movie = FileReader.readMovies("data/movies.csv");
        Movie test = movie.get(2582);
        ArrayList<String> cast = test.getCast();
        assertEquals(test.getTitle(),"Batman: Gotham Knight");
        assertEquals(cast.get(0),"Kevin Conroy");
        assertEquals(cast.get(1),"Gary Dourdan");
        assertEquals(cast.get(2),"Jason Marsden");
        assertEquals(cast.get(3),"Jim Meskimen");
        assertEquals(cast.get(4),"David McCallum");
        assertEquals(cast.get(5),"Andrea Romano");
        assertEquals(cast.get(6),"Corey Burton");
        assertEquals(cast.get(7),"Scott Menville");
        assertEquals(cast.get(8),"George Newbern");
        assertEquals(cast.get(9),"Alanna Ubach");
        assertEquals(cast.get(10),"Hynden Walch");
        assertEquals(cast.get(11),"Pat Musick");
        assertEquals(cast.get(12),"Kevin Michael Richardson");
        assertEquals(cast.get(13),"Brian George");
        assertEquals(cast.get(14),"Rob Paulsen");
    }
}
