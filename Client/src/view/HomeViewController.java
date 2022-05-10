package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import viewmodel.HomeViewModel;
import javafx.scene.control.ListView;

/**
 * Controller for the home view.
 */
public class HomeViewController
{
  @FXML private ListView<String> topratedList;
  @FXML private ListView<String> trendingList;

  private ViewHandler viewHandler;
  private Region root;
  private HomeViewModel viewModel;


  /**
   * @param viewHandler  the viewHandler to set
   * @param viewModel the topRatedViewModel to set
   * @param root the root to set
   *
   * Initializes the controller class. This method is automatically called the first time we load the view.
   */

  public void init(ViewHandler viewHandler,HomeViewModel viewModel, Region root)
  {

    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = viewModel;

   /* topratedList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
          topRatedViewModel.setSelected(newValue));
*/
    topratedList.setItems(viewModel.getTopRatedMovies());
    trendingList.setItems(viewModel.getTrendingMovies());
  }

  /**
   * Empty 0 argument constructor
   */
  public HomeViewController() {}

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
   * A FXML method called when the button named "View top-rated movie details" is pressed
   * It cals the method showDetails in the viewModel and if the method returns true(the user is allowed to see the movie),
   *   it will call the method openView in the ViewHandler
   *   @see viewmodel.HomeViewModel
   *   @see view.ViewHandler
   */
  @FXML private void topratedDetailsPressed(){

    boolean idk= viewModel.showDetails(topratedList.getFocusModel().getFocusedItem());

    if(idk){viewHandler.openView("movie");}
  }

  /**
   * A FXML method called when the button named "View trending movie details" is pressed
   * It cals the method showDetails in the viewModel and if the method returns true(the user is allowed to see the movie),
   *   it will call the method openView in the ViewHandler
   *   @see viewmodel.HomeViewModel
   *   @see view.ViewHandler
   */
  @FXML private void trendingDetailsPressed(){

    boolean idk= viewModel.showDetails(trendingList.getFocusModel().getFocusedItem());

    if(idk){viewHandler.openView("movie");}
  }

}
