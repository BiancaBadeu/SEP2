package model.domain;

import java.util.ArrayList;

/**
 * Movie class
 */
public class Movie
{
  private int movieID;
  private String title;
  private String director;
  private String description;
  private int length;
  private double avgRating;
  private int numberOfReviews;
  private int releaseYear;
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
  public Movie(int movieID,String title, String director, int length,String description,  double avgRating, int releaseYear, int numberOfReviews, ArrayList<Genre> genres, ArrayList<Review> reviews)
  {
    this.movieID=movieID;
    this.title = title;
    this.director = director;
    this.description = description;
    this.length = length;
    this.releaseYear=releaseYear;
    this.avgRating = avgRating;
    this.genres = genres;
    this.reviews = reviews;
    this.numberOfReviews = numberOfReviews;
  }

  public Movie(int movieID, String title, String director, int length, String description, int avgRating, int releaseYear)
  {
    this.movieID=movieID;
    this.title = title;
    this.director = director;
    this.description = description;
    this.length = length;
    this.releaseYear=releaseYear;
    this.avgRating = avgRating;
  }

  /**
   * @return the id of the movie
   * Getter for the id of the movie
   */
  public int getMovieID()
  {
    return movieID;
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

  /**
   * @param title
   * Setter for the title of the movie
   */
  public void setTitle(String title)
  {
    this.title = title;
  }

  /**
   * @param director
   * Setter for the director of the movie
   */
  public void setDirector(String director)
  {
    this.director = director;
  }

  /**
   * @param description
   * Setter for the description of the movie
   */
  public void setDescription(String description)
  {
    this.description = description;
  }

  /**
   * @param length
   * Setter for the length of the movie
   */
  public void setLength(int length)
  {
    this.length = length;
  }

  /**
   * @param avgRating
   * Setter for the average rating of the movie
   */
  public void setAvgRating(double avgRating)
  {
    this.avgRating = avgRating;
  }

  /**
   * @param movieID
   * Setter for the id of the movie
   */
  public void setMovieID(int movieID)
  {
    this.movieID = movieID;
  }

  /**
   * @param releaseYear
   * Setter for the release year of the movie
   */
  public void setReleaseYear(int releaseYear)
  {
    this.releaseYear = releaseYear;
  }

  /**
   * @return a string representation of the movie
   */
  public String toString()
  {
    return "" + title;
  }


}
