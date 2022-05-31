package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.mediator.Model;
import model.domain.Movie;

/**
 *  SearchViewModel class
 */
public class SearchViewModel
{

  private Model model;
  private ObservableList<String> searchList;
  private StringProperty searchBar;
  private ViewModelState state;

  /**
   * @param model  model
   * @param state state
   *
   *              SearchViewModel constructor
   */
  public SearchViewModel(Model model, ViewModelState state)
  {
    this.model = model;
    this.searchList = FXCollections.observableArrayList();
    this.searchBar = new SimpleStringProperty();
    this.state = state;
  }

  /**
   * Reset method for SearchViewController
   */
  public void reset()
  {
    searchList.clear();
    searchBar.set("");
  }

  /**
   * @return searchBar contents
   */
  public StringProperty getSearchBarProperty()
  {
    return searchBar;
  }

  /**
   * @return searchlist based on the filter criteria (title)
   *
   *        Search method for SearchViewController
   */
  public ObservableList<String> getMoviesWithTitle()
  {
    searchList.clear();
    for(int i=0; i<model.getAllMovies().size(); i++)
    {
      String title = model.getAllMovies().get(i).getTitle();
      if(title.contains(searchBar.get()))
      {
        searchList.add(title);
      }
    }
    return searchList;
  }

  /**
   * @return searchlist based on the filter criteria (genre)
   *
   *       Search method for SearchViewController
   */
  public ObservableList<String> getMoviesWithGenre()
  {
    searchList.clear();
    for(int i=0; i<model.getAllMovies().size(); i++)
    {
      String genre = model.getAllMovies().get(i).getGenres();
      String title = model.getAllMovies().get(i).getTitle();
      if(genre.contains(searchBar.get())){
        searchList.add(title);
      }
    }
    return searchList;
  }

  /**
   * @param title title
   * @return True if a movie was selected from the listview
   *
   *       Select method for showDetails in searchViewController
   */
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
    System.out.println(movie);
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
