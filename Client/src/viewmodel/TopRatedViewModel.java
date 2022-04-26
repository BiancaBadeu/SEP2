package viewmodel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;

/**
 * TopRatedViewModel is a ViewModel for the TopRatedView.
 */
public class TopRatedViewModel implements PropertyChangeListener
{
  private Model model;
  private ObservableList<String> topRatedList;

  /**
   * @param model the model to set
   *
   *
   * Constructor for TopRatedViewModel.
   */
  public TopRatedViewModel(Model model)
  {
    this.model = model;
    this.model.addListener(this);
    topRatedList = FXCollections.observableArrayList();

  }

  /**
   * @return the topRatedList
   *
   * Method returns the topRatedList.
   */
  public ObservableList<String> getTopRatedMovies(){


    return topRatedList;
  }

  /**
   * @param evt the PropertyChangeEvent
   *
   * When a property changes, update the topRatedList.
   */
  @Override
  public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      topRatedList.add(0, evt.getNewValue() + "");
    });
  }
}