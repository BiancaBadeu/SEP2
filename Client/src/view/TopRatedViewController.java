package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import viewmodel.MovieViewModel;
import viewmodel.TopRatedViewModel;
import javafx.scene.control.ListView;

/**
 * Controller for the top rated view.
 */
public class TopRatedViewController
{
  @FXML private ListView<String> topratedList;

  private ViewHandler viewHandler;
  private Region root;
  private TopRatedViewModel topRatedViewModel;


  /**
   * @param viewHandler  the viewHandler to set
   * @param topratedViewModel the topRatedViewModel to set
   * @param root the root to set
   *
   * Initializes the controller class. This method is automatically called
   */

  public void init(ViewHandler viewHandler,TopRatedViewModel topratedViewModel, Region root)
  {

    this.viewHandler = viewHandler;
    this.root = root;
    this.topRatedViewModel = topratedViewModel;

   /* topratedList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
          topRatedViewModel.setSelected(newValue));
*/


    topratedList.setItems(topRatedViewModel.getTopRatedMovies());
  }

  /**
   * Empty 0 argument constructor
   */
  public TopRatedViewController() {}

  /**
   * Resets the view
   */
  public void reset()
  {
    topRatedViewModel.reset();
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

  @FXML private void detailsPressed(){

    topRatedViewModel.showDetails();
    viewHandler.openView("movie");

  }

}
