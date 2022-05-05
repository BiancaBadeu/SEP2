package model;

import java.util.ArrayList;

public class MovieList
{
  private ArrayList<Movie> movies;

  public MovieList()
  {
    this.movies = new ArrayList<>();
  }

  public void addMovie(Movie movie)
  {
    movies.add(movie);
  }

  /**
   * @return the top 10 movies
   * This method returns the top 10 movies in the list.
   */
  public ArrayList<Movie> getTop10TopRatedMovies()
  {
    ArrayList<Movie> topRatedMovies = new ArrayList<>();
    double topRating = 5.00;
    while (topRating >= 0 && topRatedMovies.size() < 10)
    {
      for (int i = 0; i < movies.size(); i++)
      {
        if (movies.get(i).getAvgRating() == topRating)
          topRatedMovies.add(movies.get(i));
      }
      topRating = topRating - 0.01;
    }
    return topRatedMovies;
  }

  /**
   * @return All the movies in the list
   *
   * This method returns all the movies in the list.
   */
  public ArrayList<Movie> getAllMovies()
  {

    return movies;
  }

  /**
   * @param director The director to search for
   *
   *                  This method returns all the movies in the list that have the given director.
   * @return
   */
  public ArrayList<Movie> getMoviesWithDirector(String director)
  {
    ArrayList<Movie> moviesDirector = new ArrayList<>();

    for (int i = 0; i < movies.size(); i++)
    {

      if (movies.get(i).getDirector().equals(director))
      {

        moviesDirector.add(movies.get(i));

      }
    }
    return moviesDirector;
  }

  /**
   * @param length The length to search for
   *
   * This method returns all the movies in the list that have a bigger length than the given length.
   *
   * @return movies with length bigger than the given length
   */
  public ArrayList<Movie> getMoviesWithLengthBiggerThan(int length)
  {
    ArrayList<Movie> moviesArray = new ArrayList<>();

    for (int i = 0; i < movies.size(); i++)
    {

      if (movies.get(i).getLength() > length)
      {

        moviesArray.add(movies.get(i));
      }

    }

    return moviesArray;
  }

  /**
   * @param length The length to search for
   *
   * This method returns all the movies in the list that have a smaller length than the given length.
   *
   * @return movies with length smaller than the given length
   */
  public ArrayList<Movie> getMoviesWithLengthSmallerThan(int length)
  {
    ArrayList<Movie> moviesArray = new ArrayList<>();

    for (int i = 0; i < movies.size(); i++)
    {

      if (movies.get(i).getLength() < length)
      {

        moviesArray.add(movies.get(i));
      }

    }

    return moviesArray;
  }

  /**
   * @param rating The rating to search for
   *
   * This method returns all the movies in the list that have a smaller average rating than the given rating.
   *
   * @return movies with average rating smaller than the given rating
   */
  public ArrayList<Movie> getMoviesWithAverageRatingSmallerThan(double rating)
  {
    ArrayList<Movie> moviesArrayRating = new ArrayList<>();

    for (int i = 0; i < movies.size(); i++)
    {

      if (movies.get(i).getAvgRating() < rating)
      {

        moviesArrayRating.add(movies.get(i));
      }

    }

    return moviesArrayRating;
  }

  /**
   * @param rating The rating to search for
   *
   * This method returns all the movies in the list that have a bigger average rating than the given rating.
   *
   * @return movies with average rating bigger than the given rating
   */
  public ArrayList<Movie> getMoviesWithAverageRatingBiggerThan(double rating)
  {
    ArrayList<Movie> moviesArrayRating = new ArrayList<>();

    for (int i = 0; i < movies.size(); i++)
    {

      if (movies.get(i).getAvgRating() > rating)
      {

        moviesArrayRating.add(movies.get(i));
      }

    }

    return moviesArrayRating;
  }

  /**
   * @return The movies with no reviews
   *
   * This method returns all the movies in the list that have no reviews.
   */
  public ArrayList<Movie> getMoviesWithNoReviews(){

    ArrayList<Movie> moviesWithNoReviews = new ArrayList<>();


    for(int i = 0; i < movies.size(); i++){

      if(movies.get(i).getReviews().size() == 0){

        moviesWithNoReviews.add(movies.get(i));
      }
    }

    return moviesWithNoReviews;
  }

  /**
   * @param genre The genre to search for
   *
   * This method returns all the movies in the list that have the given genre.
   *
   * @return The movies with the given genre
   */
  public ArrayList<Movie> getMoviesWithGenre(String genre){

    ArrayList<Movie> moviesWithGenre = new ArrayList<>();

    for(int i = 0; i < movies.size(); i++){

      if(movies.get(i).getGenres().contains(genre)){

        moviesWithGenre.add(movies.get(i));
      }
    }

    return moviesWithGenre;
  }

  /**
   * @param title The title to search for
   *
   * This method returns all the movies in the list that have the given title.
   *
   * @return The movie with the given title
   */
  public ArrayList<Movie> getMoviesWithTitle(String title){

    ArrayList<Movie> moviesWithTitle = new ArrayList<>();

    for(int i = 0; i < movies.size(); i++){

      if(movies.get(i).getTitle().equals(title)){

        moviesWithTitle.add(movies.get(i));
      }
    }

    return moviesWithTitle;
  }
}
