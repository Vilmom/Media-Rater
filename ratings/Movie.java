package ratings;
import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;
public class Movie extends Ratable{
    private String title;
    private ArrayList<String> cast;
    private LinkedListNode<Rating> ratings;
    public Movie(String title, ArrayList<String> cast){
        super(title);
        this.cast = cast;
    }
    public ArrayList<String> getCast(){
        return this.cast;
    }
}
