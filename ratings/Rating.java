package ratings;

public class Rating {
    private String reviewerID;
    private int reviewerRating;

    public Rating(String reviewerID, int reviewerRating){
        this.reviewerID = reviewerID;
        setRating(reviewerRating);
    }

    public String getReviewerID(){
        return this.reviewerID;
    }
    public void setReviewerID(String reviewerID){
        this.reviewerID = reviewerID;
    }
    public int getRating(){
        return this.reviewerRating;
    }
    public void setRating(int reviewerRating){
        this.reviewerRating = -1;
        if(reviewerRating >= 1 && reviewerRating <= 5){
            this.reviewerRating = reviewerRating;
        }
    }
}
