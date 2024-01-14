package ratings;

import ratings.datastructures.LinkedListNode;

public class Ratable{
    private String title;
    private LinkedListNode<Rating> ratings;

    public Ratable(String title){
        this.title=title;
        this.ratings = null;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void addRating(Rating rating){
        if(didReviewerRateSong(rating.getReviewerID()) == false) {
            if (ratings != null) {
                ratings.append(rating);
            } else {
                ratings = new LinkedListNode<>(rating, null);
            }
        }
    }
    public LinkedListNode<Rating> getRatings(){
        return ratings;
    }
    public double averageRating(){
        LinkedListNode<Rating> temp = ratings;
        double total = 0.0;
        int var = 0;
        while(temp != null){
            if (temp.getValue().getRating()>=0){
                total += temp.getValue().getRating();
                temp = temp.getNext();
                var++;
            }
        }
        if(var == 0){
            return 0;
        }
        return total / var;
    }
    public Boolean didReviewerRateSong(String reviewerID){
        LinkedListNode<Rating> temp = ratings;
        while(temp != null){
            if(temp.getValue().getReviewerID() == reviewerID){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public void removeRatingByReviewer(Reviewer reviewer){
        LinkedListNode<Rating> Temp = ratings;
        LinkedListNode<Rating> Temp2 = null;
        while (Temp!=null) {
            if (Temp.getValue().getReviewerID() == reviewer.getReviewerID()) {
                if (Temp2 == null) {
                    ratings = Temp.getNext();
                } else {
                    Temp2.setNext(Temp.getNext());
                }
            }
            Temp2 = Temp;
            Temp = Temp.getNext();
        }
    }
    public double ratingsTotal(LinkedListNode<Rating> ratings){
        double out = 0.0;
        if(ratings.getNext() == null){
            out = ratings.getValue().getRating();
        }else{
            out = ratings.getValue().getRating();
            out += ratingsTotal(ratings.getNext());
        }
        return out;
    }
    public double bayesianAverageRating(int numExtra, int valExtra){
        double out = 0.0;
        if(ratings == null && (numExtra == 0 && valExtra == 0)){
        }else if(ratings == null && (numExtra != 0 && valExtra != 0)){
            out = (numExtra * valExtra)/numExtra;
        }else{
            int numTotal = ratings.size() + numExtra;
            double ratingTotal  = ratingsTotal(ratings);
            int fakeValTotal = numExtra * valExtra;
            double temp = ratingTotal + fakeValTotal;
            out = temp / numTotal;
        }
        return out;
    }
}
