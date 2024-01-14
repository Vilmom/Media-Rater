package ratings.datastructures;

import ratings.Song;
public class SongTitleComparator extends Comparator<Song>{
@Override
    public boolean compare(Song a, Song b) {
        String TitleA = a.getTitle();
        String TitleB = b.getTitle();
        if (TitleA.compareToIgnoreCase(TitleB)<0){
            return true;
        }
        return false;
    }

}