package model.domain;

import java.util.ArrayList;

/**
 * This class represents a list of movies.
 */
public class MovieList
{
  private ArrayList<Movie> movies;

  /**
   * Constructor for the MovieList class.
   */
  public MovieList()
  {
    this.movies = new ArrayList<>();
  }

  /**
   * @param movie
   * adds a movie to the list.
   */
  public void addMovie(Movie movie)
  {
    movies.add(movie);
  }

  /**
   * @param movie
   * removes a movie from the list.
   */
  public void removeMovie(Movie movie){
    movies.remove(movie);
  }

  /**
   * @return the top 10 movies
   * This method returns the top 10 movies in the list.
   */
  public ArrayList<Movie> getTop10TopRatedMovies()
  {
    ArrayList<Movie> topRatedMovies = new ArrayList<>();
    double topRating = 5.0;
    while (topRating >= 0 && topRatedMovies.size() < 10)
    {
      for (int i = 0; i < movies.size(); i++)
      {
        if (movies.get(i).getAvgRating() == topRating && topRatedMovies.size() < 10)
          topRatedMovies.add(movies.get(i));
      }
      topRating = topRating - 0.1;
    }
    return topRatedMovies;
  }

  /**
   * @param title the title of the movie
   * @return an array list of movies which contain the given string
   *      A method to get the movies that contain the string given
   */
  public ArrayList<Movie> getMovieLike(String title)
  {
    ArrayList<Movie> list = new ArrayList<>();
    for(int i = 0; i<movies.size();i++)
    {
      if(movies.get(i).getTitle().contains(title))
        list.add(movies.get(i));
    }
    return list;
  }
  /**
   * @return the trending movies
   * This method returns the trending movies in the list.
   */
  public ArrayList<Movie> getTrendingMovies(){
    ArrayList<Movie> trendingMovies = new ArrayList<>();
      for (int i = 0; i < movies.size(); i++)
      {
        if(trendingMovies.size() < 15)
            trendingMovies.add(movies.get(i));
      }
    return trendingMovies;
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
   * This method returns all the movies in the list that have the given director.
   * @return All the movies with the given director in the list.
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

    for(int i = 0; i < movies.size(); i++)
    {
      if(movies.get(i).getReviews().size() == 0)
      {
        moviesWithNoReviews.add(movies.get(i));
      }
    }
    return moviesWithNoReviews;
  }

  /**
   * @param genre The genre to search for
   * This method returns all the movies in the list that have the given genre.
   * @return The movies with the given genre
   */
  public ArrayList<Movie> getMoviesWithGenre(String genre){

    ArrayList<Movie> moviesWithGenre = new ArrayList<>();
    for(int i = 0; i < movies.size(); i++)
    {
      if(movies.get(i).getGenres().equals(genre))
      {
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
  public Movie getMovieWithTitle(String title){

    Movie movie = null;
    for(int i = 0; i < movies.size(); i++)
    {
      if(movies.get(i).getTitle().equals(title))
      {
        movie = movies.get(i);
      }
    }
    if(movie==null)
      throw new IllegalStateException("Cannot rent this movie.");

    return movie;
  }

  /**
   * @param movie the movie
   * @return an array list with the comments of the movie
   *            A method to return the comments of a movie
   */
  public ArrayList<String> getCommentsForMovie(Movie movie)
  {
    ArrayList<String> list= new ArrayList<>();
    for(int i=0;i<movies.size();i++)
    {
      if(movies.get(i).equals(movie))
        list = movies.get(i).getAllComments();
    }
    return list;
  }
}
