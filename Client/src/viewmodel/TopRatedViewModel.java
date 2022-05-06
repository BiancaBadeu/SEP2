package viewmodel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.application.Platform;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import model.Model;
import model.Movie;

/**
 * TopRatedViewModel is a ViewModel for the TopRatedView.
 */
public class
TopRatedViewModel implements PropertyChangeListener
{
  private Model model;
  private ObservableList<String> topRatedList;
  private ViewModelState state;

  /**
   * @param model the model to set
   *              Constructor for TopRatedViewModel.
   */
  public TopRatedViewModel(Model model, ViewModelState state)
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
   * @param evt the PropertyChangeEvent
   *            When a property changes, update the topRatedList.
   */
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      topRatedList.add(0, evt.getNewValue() + "");
    });
  }

    public boolean showDetails (String string)
    {
    Movie movie = null;
    for (int i = 0; i < model.getTop10TopRatedMovies().size(); i++)
    {
      if (model.getTop10TopRatedMovies().get(i).getTitle().equals(string))
      {
        movie = model.getTop10TopRatedMovies().get(i);
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
