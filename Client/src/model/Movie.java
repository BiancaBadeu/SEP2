package model;

public class Movie
{

  private String title;
  private String director;
  private String description;
  private int length;
  private float avgRating;
  private Genre genre;
  private Review review;

  /**
   * @param title the title of the movie
   * @param director the director of the movie
   * @param description the description of the movie
   * @param length the length of the movie
   * @param avgRating the average rating of the movie
   * @param genre the genre of the movie
   * @param review the review of the movie
   *
   * Constructor for the Movie class
   */
  public Movie(String title, String director, String description, int length, float avgRating, Genre genre, Review review)
  {
    this.title = title;
    this.director = director;
    this.description = description;
    this.length = length;
    this.avgRating = avgRating;
    this.genre = genre;
  }



}
