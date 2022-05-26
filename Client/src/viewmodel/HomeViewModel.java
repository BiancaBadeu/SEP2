package viewmodel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javafx.application.Platform;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.mediator.Model;
import model.domain.Movie;

/**
 * TopRatedViewModel is a ViewModel for the TopRatedView.
 */
public class HomeViewModel implements PropertyChangeListener
{
  private Model model;
  private ObservableList<String> topRatedList;
  private ObservableList<String> trendingList;

  private ViewModelState state;

  /**
   * @param model the model to set
   * @param state the state to get the movie
   *              Constructor for TopRatedViewModel.
   */
  public HomeViewModel(Model model, ViewModelState state)
  {
    this.model = model;
    this.topRatedList = FXCollections.observableArrayList();
    this.trendingList= FXCollections.observableArrayList();
    this.state = state;
  }

  /**
   * A method to reset the list view
   */
  public void reset()
  {
    topRatedList.clear();
    getTopRatedMovies();
    trendingList.clear();
    getTrendingMovies();
  }

  /**
   * @return the topRatedList
   * Method returns the topRatedList.
   */
  public ObservableList<String> getTopRatedMovies()
  {
    ArrayList<Movie> movies = model.getTop10TopRatedMovies();
    if(!movies.isEmpty())
    {
      for (int i = 0; i < movies.size(); i++)
      {
        topRatedList.add(movies.get(i).getTitle());
      }
      return topRatedList;
    }
    return null;
  }

  /**
   * @return the trendingList
   *
   * Method returns the trendingList.
   */
  public ObservableList<String> getTrendingMovies()
  {
    ArrayList<Movie> movies = model.getTrendingMovies();
    if(!movies.isEmpty())
    {
      for (int i = 0; i < movies.size(); i++)
      {
        trendingList.add(movies.get(i).getTitle());
      }
      return trendingList;
    }
    return null;
  }

  /**
   * @param evt the PropertyChangeEvent
   *            When a property changes, update the topRatedList.
   */
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      topRatedList.add(0, evt.getNewValue() + "");
    });
  }

  /**
   * @param string the string to set
   * @param type the type of the list (top-rated, trending)
   * @return true or false
   *
   * Method where the selected property is gathered and checked with the movies in the movieList. Such information is sent to the ViewModelState to be used by
   * the MovieViewModel.
   * @see ViewModelState
   * @see MovieViewModel
   */
  public boolean showDetails (String string, String type)
  {
    Movie movie = null;

    if(type.equals("toprated"))
    {
      ArrayList<Movie> toprated = model.getTop10TopRatedMovies();
      for (int i = 0; i < toprated.size(); i++)
      {
        if (toprated.get(i).getTitle().equals(string))
        {
          movie = toprated.get(i);
        }
      }
    }
    else if(type.equals("trending"))
    {
      ArrayList<Movie> trending = model.getTrendingMovies();
      for (int i = 0; i < trending.size(); i++)
      {
        if (trending.get(i).getTitle().equals(string))
        {
          movie = trending.get(i);
        }
      }
    }
    if (movie != null)
    {
      state.setMovie(movie);
      return true;
    }
    else
    {
      state.setMovie(null);
      return false;
    }
  }
}
