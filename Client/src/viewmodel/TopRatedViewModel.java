package viewmodel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.application.Platform;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;

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
   * Constructor for TopRatedViewModel.
   */
  public TopRatedViewModel(Model model, ViewModelState state)
  {
    this.model = model;
    this.model.addListener(this);
    this.topRatedList = FXCollections.observableArrayList();
    this.state= state;

  }

  /**
   * A method to reset the list view
   */
  public void reset()
  {
    topRatedList.setAll(getTopRatedMovies());
  }

  /**
   * @return the topRatedList
   * Method returns the topRatedList.
   */
  public ObservableList<String> getTopRatedMovies()
  {

    topRatedList.add(String.valueOf(model.getTop10TopRatedMovies()));
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
}