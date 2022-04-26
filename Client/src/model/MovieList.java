package model;

import java.util.ArrayList;

public class MovieList
{
  private ArrayList<Movie> movies;

  public MovieList()
  {
    this.movies = new ArrayList<>();
  }

  public ArrayList<Movie> getTop10TopRatedMovies()
  {
    ArrayList<Movie> topRatedMovies = new ArrayList<>();
    double topRating = 5.00;
    while(topRating>=0 && topRatedMovies.size()<10)
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
}
