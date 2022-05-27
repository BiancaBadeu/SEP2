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

    if(!isValidRating(rating)){
      throw new IllegalArgumentException("Invalid rating");
    }

    if(!isValidComment(comment)){
      throw new IllegalArgumentException("Invalid comment");
    }
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

  public boolean isValidRating(int rating){
    if(rating < 0 || rating > 5){
      return false;
    }
    return true;
  }

  public boolean isValidComment(String comment){
    if(comment == null || comment.isEmpty()){
      return false;
    }
    return true;
  }

}
