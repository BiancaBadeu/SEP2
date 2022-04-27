package model;

/**
 * Review class
 */
public class Review
{

  private String comment;
  private int rating;

  /**
   * @param comment the comment to set
   * @param rating the rating to set
   *
   * Constructor for Review
   */
  public Review(String comment, int rating){
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
  public int getRating(){
    return rating;
  }


}
