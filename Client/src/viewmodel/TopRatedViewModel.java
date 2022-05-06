package viewmodel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.application.Platform;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
  private ObjectProperty<TopRatedViewModel> selectedMovieProperty;

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
    this.selectedMovieProperty= new SimpleObjectProperty<>();

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
    for(int i=0;i<model.getTop10TopRatedMovies().size();i++)
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

  public void setSelected(MovieViewModel movieViewModel){

    ;
  }

  public void showDetails(){

    Movie movie= null;

    for(int i=0;i<model.getAllMovies().size();i++){

      if(model.getAllMovies().get(i).getTitle().equals(selectedMovieProperty.toString())){

        movie= model.getAllMovies().get(i);
      }
    }



    if(movie!=null){
      state.setMovie(movie);
    }
    else {
      state.setMovie(null);
    }
  }
}