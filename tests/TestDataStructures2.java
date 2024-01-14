package tests;

import org.junit.Test;
import static org.junit.Assert.*;
import ratings.Playlist;
import ratings.Rating;
import ratings.Song;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import static org.junit.Assert.assertTrue;

public class TestDataStructures2 {

    public void compareSongs(Song result, Song expected) {
        assertTrue(result.getTitle().equalsIgnoreCase(expected.getTitle()));
        assertTrue(result.getArtist().equalsIgnoreCase(expected.getArtist()));
        assertTrue(result.getSongID().equalsIgnoreCase(expected.getSongID()));
    }
    public void checkSongsList(LinkedListNode<Song> actual, LinkedListNode<Song> expected){
        if (expected == null) {
            assertEquals(actual,null);
        } else {
            Song actualSong = actual.getValue();
            Song expectedSong = expected.getValue();
            assertTrue(actual != null);
            compareSongs(actualSong, expectedSong);
            checkSongsList(actual.getNext(), expected.getNext());
        }
    }
    public void addAllSongs(Playlist playlist, LinkedListNode<Song> songs) {
        if (songs != null) {
            Song song = songs.getValue();
            playlist.addSong(song);
            addAllSongs(playlist, songs.getNext());
        }
    }

    @Test
    public void testPlaylist(){
        Playlist alphabetical1 = new Playlist(new SongTitleComparator());
        LinkedListNode<Song> random1 = new LinkedListNode<>((new Song("Counting Stars", "OneRepublic", "CSO" )), null);
        random1.append(new Song("Idgaf", "Sik World", "ISW"));
        random1.append(new Song("Treat You Better", "Shawn Mendes", "TUBSM"));

        LinkedListNode<Song> expected1 = new LinkedListNode<>((new Song("Counting Stars", "OneRepublic", "CSO" )), null);
        expected1.append(new Song("Idgaf", "Sik World", "ISW"));
        expected1.append(new Song("Treat You Better", "Shawn Mendes", "TUBSM"));
        addAllSongs(alphabetical1, random1);
        checkSongsList(alphabetical1.getSongList(), expected1);

        Playlist alphabetical2 = new Playlist(new SongTitleComparator());
        LinkedListNode<Song> random2 = new LinkedListNode<>((new Song("Villain", "LOAT!", "VL!" )), null);
        random2.append(new Song("Ease Off", "YNG Martyr", "EOYM"));
        random2.append(new Song("Ghost", "Dirtyxan", "GD"));
        random2.append(new Song("Devil Lady", "Rev & LOAT!", "DLR&L!"));
        random2.append(new Song("CHROME BERRETA", "TooLong", "CBT"));

        LinkedListNode<Song> expected2 = new LinkedListNode<>((new Song("CHROME BERRETA", "TooLong", "CBT")), null);
        expected2.append(new Song("Devil Lady", "Rev & LOAT!", "DLR&L!"));
        expected2.append(new Song("Ease Off", "YNG Martyr", "EOYM"));
        expected2.append(new Song("Ghost", "Dirtyxan", "GD"));
        expected2.append(new Song("Villain", "LOAT!", "VL!" ));
        addAllSongs(alphabetical2, random2);
        checkSongsList(alphabetical2.getSongList(), expected2);



    }
}