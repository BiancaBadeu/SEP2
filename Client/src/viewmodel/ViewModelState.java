package viewmodel;

import model.Movie;

/**
 * ViewModelState is a class that holds the state of the ViewModel.
 */
public class ViewModelState
{

  private Movie movie;

  /**
   * Constructor for ViewModelState.
   */
  public ViewModelState(){
    this.movie = null;
  }

  /**
   * @return the movie
   * A method that returns the movie.
   */
  public Movie getSelectedMovie(){
    return movie;
  }

  /**
   * @param movie the movie to set
   * A method that sets the movie.
   */
  public void setMovie(Movie movie){
    this.movie = movie;
  }

}
