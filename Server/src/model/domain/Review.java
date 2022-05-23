package model.domain;

/**
 * Review class
 */
public class Review
{

  private String comment;
  private double rating;

  /**
   * @param comment the comment to set
   * @param rating the rating to set
   *
   * Constructor for Review
   */
  public Review(String comment, double rating){
    this.comment = comment;
    this.rating = rating;
  }

  /**
   * @return the comment
   *
   * Getter for comment
   */
  public String getComment(){
    return comment;
  }

  /**
   * @return the rating
   *
   * Getter for rating
   */
  public double getRating(){
    return rating;
  }

  /**
   * @param comment
   */
  public void setComment(String comment)
  {
    this.comment = comment;
  }

  /**
   * @param rating
   */
  public void setRating(double rating)
  {
    this.rating = rating;
  }
}
