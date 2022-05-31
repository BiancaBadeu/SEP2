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

    if(movie==null)
      throw new IllegalArgumentException("Movie cannot be null");

    else

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

    for(int t = 0; t < 10; t++)
    {
      double highRating = 0;
      int index = -1;
      for (int i = t; i < movies.size(); i++)
      {
        if (movies.get(i).getAvgRating() > highRating)
        {
          highRating = movies.get(i).getAvgRating();
          index = i;
        }
      }
      Movie tempMovie = movies.get(t);
      movies.set(t, movies.get(index));
      movies.set(index, tempMovie);
      topRatedMovies.add(movies.get(t));
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
    for (int j = 0; j < 15; j++)
    {
      double noReviews = 0;
      int index = -1;
      for (int i = j; i < movies.size(); i++)
      {
        if (movies.get(i).getNumberOfReviews() > noReviews)
        {
          noReviews = movies.get(i).getNumberOfReviews();
          index = i;
        }
      }
      if (!(noReviews==0)){
      Movie tempMovie = movies.get(j);
      movies.set(j, movies.get(index));
      movies.set(index, tempMovie);
      }
      trendingMovies.add(movies.get(j));
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
   * @return an array list with the reviews of the movie
   *            A method to return the reviews of a movie
   */
  public ArrayList<Review> getReviewsForMovie(Movie movie)
  {
    return movie.getReviews();
  }
}
