package model;

import java.util.ArrayList;

public class Movie
{
  private String title;
  private String director;
  private String description;
  private int length;
  private double avgRating;
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
  public Movie(String title, String director, String description, int length, double avgRating, ArrayList<Genre> genres, ArrayList<Review> reviews)
  {
    this.title = title;
    this.director = director;
    this.description = description;
    this.length = length;
    this.avgRating = avgRating;
    this.genres = genres;
    this.reviews = reviews;
  }

  public double getAvgRating()
  {
    return avgRating;
  }
}
