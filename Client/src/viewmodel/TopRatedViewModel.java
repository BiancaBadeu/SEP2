package viewmodel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;

public class TopRatedViewModel implements PropertyChangeListener
{
  private Model model;
  private ObservableList<String> logs;
  private StringProperty message;



  public TopRatedViewModel(Model model)
  {
    this.model = model;
    this.model.addListener(this);
    logs = FXCollections.observableArrayList();

    message= new SimpleStringProperty();
  }



  public ObservableList<String> getTopRatedMovies(){


    return model.getTopratedMovies();
  }
  public ObservableList<String> getLogs()
  {
    return logs;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() -> {
      logs.add(0, evt.getNewValue() + "");
    });
  }
}