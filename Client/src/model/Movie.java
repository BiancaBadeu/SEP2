package model;

import java.util.ArrayList;

/**
 * Movie class
 */
public class Movie
{
  private String title;
  private String director;
  private String description;
  private int length;
  private double avgRating;
  private int numberOfReviews;
  private ArrayList<Genre> genres;
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
  public Movie(String title, String director, String description, int length, double avgRating, int numberOfReviews, ArrayList<Genre> genres, ArrayList<Review> reviews)
  {
    this.title = title;
    this.director = director;
    this.description = description;
    this.length = length;
    this.avgRating = avgRating;
    this.genres = genres;
    this.reviews = reviews;
    this.numberOfReviews = numberOfReviews;
  }

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
  public ArrayList<Genre> getGenres()
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

}
