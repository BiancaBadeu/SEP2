package model.domain;

import java.io.Serializable;

/**
 * Review class
 */
public class Review implements Serializable
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

  /**
   * @param comment the comment
   */
  public void setComment(String comment)
  {
    this.comment = comment;
  }

  /**
   * @param rating the rating
   */
  public void setRating(int rating)
  {
    this.rating = rating;
  }

  /**
   * @return a string representation of the class
   */
  public String toString()
  {
    return rating + " stars. " + comment;
  }

}
