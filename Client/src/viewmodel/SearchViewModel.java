package viewmodel;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;
import model.Movie;

import java.util.ArrayList;

public class SearchViewModel
{

  private Model model;
  private ObservableList<String> searchList;
  private StringProperty searchBar;
  private ViewModelState state;



  public SearchViewModel(Model model, ViewModelState state)
  {
    this.model = model;
    this.searchList = FXCollections.observableArrayList();
    this.state = state;
  }

  public void reset(){

    searchList.clear();
    searchBar.set("");

  }


  public StringProperty getSearchBarProperty()
  {
    return searchBar;
  }

  public ObservableList<String> getMoviesWithTitle()
  {


    for(int i=0; i<model.getAllMovies().size(); i++){

      if(model.getAllMovies().get(i).getTitle().contains(searchBar.get())){
        searchList.add(model.getAllMovies().get(i).getTitle());
      }
    }

    return searchList;
  }

  public ObservableList<String> getMoviesWithGenre()
  {


    for(int i=0; i<model.getAllMovies().size(); i++){

      if(model.getAllMovies().get(i).getGenre().equals(searchBar.get())){
        searchList.add(model.getAllMovies().get(i).getTitle());
      }
    }

    return searchList;
  }

  public ObservableList<String> getMoviesWithDirector()
  {


    for(int i=0; i<model.getAllMovies().size(); i++){

      if(model.getAllMovies().get(i).getDirector().equals(searchBar.get())){
        searchList.add(model.getAllMovies().get(i).getTitle());
      }
    }

    return searchList;
  }

  public boolean showDetails(String title)
  {
    Movie movie = null;


      for (int i = 0; i < model.getAllMovies().size(); i++)
      {
        if (model.getAllMovies().get(i).getTitle().equals(title))
        {
          movie = model.getAllMovies().get(i);
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
