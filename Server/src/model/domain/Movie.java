package model.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Movie class
 */
public class Movie implements Serializable
{
  private String title;
  private String director;
  private String description;
  private int length;
  private double avgRating;
  private int numberOfReviews;
  private int releaseYear;
  private String genres;
  private ArrayList<Review> reviews;

  /**
   * @param title the title of the movie
   * @param director the director of the movie
   * @param description the description of the movie
   * @param length the length of the movie
   * @param avgRating the average rating of the movie
   * @param genres the genres of the movie
   * @param reviews the reviews of the movie
   *
   * Constructor for the Movie class
   */
  public Movie(String title, String director, int length,String description,  double avgRating, int releaseYear, String genres, ArrayList<Review> reviews)
  {
    this.title = title;
    this.director = director;
    this.description = description;
    this.length = length;
    this.releaseYear=releaseYear;
    this.avgRating = avgRating;
    this.genres = genres;
    this.reviews = reviews;
    this.numberOfReviews = reviews.size();
  }

  /**
   * @return the average rating of the movie
   * Getter for the average rating of the movie
   */
  public double getAvgRating()
  {
    return avgRating;
  }

  /**
   * @return the title of the movie
   *
   * Getter for the title of the movie
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * @return the director of the movie
   *
   * Getter for the director of the movie
   */
  public String getDirector()
  {
    return director;
  }

  /**
   * @return the description of the movie
   *
   * Getter for the description of the movie
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * @return the length of the movie
   *
   * Getter for the length of the movie
   */
  public int getLength()
  {
    return length;
  }

  /**
   * @return the release year of the movie
   * Getter for the release year of the movie
   */
  public int getReleaseYear()
  {
    return releaseYear;
  }

  /**
   * @return the number of reviews for the movie
   *
   * Getter for the number of reviews of the movie
   */
  public int getNumberOfReviews(){return numberOfReviews;}

  /**
   * @return the genres of the movie
   *
   * Getter for the genres of the movie
   */
  public String getGenres()
  {
    return genres;
  }

  /**
   * @return the reviews of the movie
   *
   * Getter for the reviews of the movie
   */
  public ArrayList<Review> getReviews()
  {
    return reviews;
  }

  /**
   * @param title tht title
   * Setter for the title of the movie
   */
  public void setTitle(String title)
  {
    this.title = title;
  }

  /**
   * @param director the director
   * Setter for the director of the movie
   */
  public void setDirector(String director)
  {
    this.director = director;
  }

  /**
   * @param description the description
   * Setter for the description of the movie
   */
  public void setDescription(String description)
  {
    this.description = description;
  }

  /**
   * @param length the length
   * Setter for the length of the movie
   */
  public void setLength(int length)
  {
    this.length = length;
  }

  /**
   * @param avgRating the average rating
   * Setter for the average rating of the movie
   */
  public void setAvgRating(double avgRating)
  {
    this.avgRating = avgRating;
    /*
    if(!reviews.isEmpty()){
    double sum=avgRating;
    for (int i=0; i<reviews.size();i++){
      sum=sum+reviews.get(i).getRating();
    }
    sum= sum/numberOfReviews;
    this.avgRating= sum;
    }*/
  }

  /**
   * @param releaseYear the release year
   * Setter for the release year of the movie
   */
  public void setReleaseYear(int releaseYear)
  {
    this.releaseYear = releaseYear;
  }

  /**
   * @param genres the genre
   *  Setter for the genre
   */
  public void setGenres(String genres)
  {
    this.genres = genres;
  }

  public void setReviews(ArrayList<Review> reviews){
    this.reviews=reviews;
  }

  /**
   * @return an array list of comments
   * Getter for the comments
   */
  public ArrayList<String> getAllComments()
  {
    ArrayList<String> list = new ArrayList<>();
    for(int i=0;i<reviews.size();i++)
    {
      list.add(reviews.get(i).getComment());
    }
    return list;
  }

  /**
   * @return a string representation of the movie
   */
  public String toString()
  {
    return "" + title+ ", "+director+", "+ description+", "+ length+", "+avgRating+", "+ releaseYear+", "+ genres;
  }

  /**
   * @param comment the comment
   * @param stars the rating
   *            A method to add a review and update the average rating
   */
  public void addReview(String comment, int stars)
  {
    double oldRating = avgRating;
    int oldNoOfReviews = numberOfReviews;

    numberOfReviews++;
    double smth = oldRating * oldNoOfReviews;
    smth += stars;
    this.avgRating = smth / (double) numberOfReviews;

    Review review = new Review(comment, stars);
    reviews.add(review);
  }
}
