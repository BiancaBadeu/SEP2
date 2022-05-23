package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.SearchViewModel;
import javafx.scene.control.ListView;

/**
 * Controller for the home view.
 */
public class SearchViewController
{
  @FXML private ListView<String> list;
  @FXML private TextField searchBar;

  private ViewHandler viewHandler;
  private Region root;
  private SearchViewModel viewModel;


  /**
   * @param viewHandler  the viewHandler to set
   * @param viewModel the topRatedViewModel to set
   * @param root the root to set
   *
   * Initializes the controller class. This method is automatically called the first time we load the view.
   */
  public void init(ViewHandler viewHandler,SearchViewModel viewModel, Region root)
  {

    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = viewModel;

    searchBar.textProperty().bindBidirectional(viewModel.getSearchBarProperty());
  }

  /**
   * Empty 0 argument constructor
   */
  public SearchViewController() {}

  /**
   * Resets the view
   */
  public void reset()
  {
    viewModel.reset();
  }

  /**
   * @return the root
   *
   * Returns the current root
   */
  public Region getRoot()
  {
    return root;
  }


  /**
   * A FXML method called when the button named "Search by title" is pressed
   * It calls the method getMoviesWithTitle in the viewModel and sets the list to those movies
   *   @see viewmodel.SearchViewModel
   */
  @FXML private void titlePressed()
  {
      list.setItems(viewModel.getMoviesWithTitle());
  }

  /**
   * A FXML method called when the button named "Search by genre" is pressed
   * It calls the method getMoviesWithGenre in the viewModel and sets the list to those movies
   *   @see viewmodel.SearchViewModel
   */
  @FXML private void genrePressed()
  {
    list.setItems(viewModel.getMoviesWithGenre());
  }

  /**
   * A FXML method called when the button named "See movie details" is pressed
   * It calls the method showDetails in the viewModel and if the method returns true(the user is allowed to see the movie),
   *   it will call the method openView in the ViewHandler
   *   @see viewmodel.SearchViewModel
   *   @see view.ViewHandler
   */
  @FXML private void detailsPressed()
  {
    boolean details= viewModel.showDetails(list.getFocusModel().getFocusedItem());
    System.out.println("details is" + details);
    if(details){viewHandler.openView("movie");}
  }

  /**
   * A FXML method called when the button named "<-" is pressed. It calls the method openView in the viewHandler
   * @see view.ViewHandler
   */
  @FXML private void goBackPressed()
  {
    viewHandler.openView("home");
  }

}
