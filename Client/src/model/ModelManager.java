package model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ModelManager implements Model
{
  private MovieList movieList;
  private RentalList rentalList;
  private PersonList personList;

  public ModelManager()
  {
    this.movieList = new MovieList();
    this.rentalList = new RentalList();
    this.personList = new PersonList();
  }
  @Override public ArrayList<Movie> getTop10TopRatedMovies()
  {
      return movieList.getTop10TopRatedMovies();
  }

  @Override public void addListener(PropertyChangeListener listener) {}

  @Override public void removeListener(PropertyChangeListener listener) {}

  @Override public void rentMovie(String title, String averageRating)
  {
      if(false)
        throw new IllegalStateException("Cannot rent this movie.");
  }
  
}
