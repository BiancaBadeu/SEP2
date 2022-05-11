package viewmodel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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
   *              Constructor for TopRatedViewModel.
   */
  public HomeViewModel(Model model, ViewModelState state)
  {
    this.model = model;
    this.model.addListener(this);
    this.topRatedList = FXCollections.observableArrayList();
    this.state = state;
  }

  /**
   * A method to reset the list view
   */
  public void reset()
  {
    topRatedList.clear();
    for(int i = 0; i < model.getTop10TopRatedMovies().size(); i++)
    {
      topRatedList.add(i, String.valueOf(model.getTop10TopRatedMovies().get(i)));
    }
  }

  /**
   * @return the topRatedList
   * Method returns the topRatedList.
   */
  public ObservableList<String> getTopRatedMovies()
  {
    for (int i = 0; i < model.getTop10TopRatedMovies().size(); i++)
    {
      topRatedList.add(model.getTop10TopRatedMovies().get(i).toString());
    }
    return topRatedList;
  }

  /**
   * @return the trendingList
   *
   * Method returns the trendingList.
   */
  public ObservableList<String> getTrendingMovies()
  {
    for (int i = 0; i < model.getTrendingMovies().size(); i++)
    {
      trendingList.add(model.getTrendingMovies().get(i).toString());
    }
    return trendingList;
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

    if(type.equals("Top Rated"))
    {
      for (int i = 0; i < model.getTop10TopRatedMovies().size(); i++)
      {
        if (model.getTop10TopRatedMovies().get(i).getTitle().equals(string))
        {
          movie = model.getTop10TopRatedMovies().get(i);
        }
      }
    }
    else if(type.equals("Trending")){

      for (int i = 0; i < model.getTrendingMovies().size(); i++)
      {
        if (model.getTrendingMovies().get(i).getTitle().equals(string))
        {
          movie = model.getTrendingMovies().get(i);
        }
      }
    }

      System.out.println(movie + "in show details");
      System.out.println(movie.getTitle() + " title in show details");
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
