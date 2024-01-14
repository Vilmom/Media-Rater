package ratings.datastructures;

import ratings.Song;

public class SongBayesianRatingComparator extends Comparator<Song> {
@Override
    public boolean compare(Song a, Song b) {
        double aba = a.bayesianAverageRating(2,3);
        double bba = b.bayesianAverageRating(2,3);
        if (aba>bba){
            return true;
        }
        return false;
    }

}