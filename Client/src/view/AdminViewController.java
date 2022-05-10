package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.AdminViewModel;

/**
 * A class representing a controller for the admin.fxml file @see view.admin.fxml
 */
public class AdminViewController
{
  @FXML ListView<String> list;
  @FXML TextField title;
  @FXML TextField length;
  @FXML TextField director;
  @FXML TextField avgRating;
  @FXML TextArea description;
  @FXML Label errorLabel;

  private ViewHandler viewHandler;
  private Region root;
  private AdminViewModel viewModel;

  /**
   * @param viewHandler a ViewHandler variable for control over the GUI
   * @param viewModel a AdminViewModel variable for control over the functionality
   * @param root a Region variable for location within the GUI
   *
   * A method to initiate the GUI windows and initializing the parameters previously mentioned, plus binding all the
   * FXML variables to their respective properties from the viewModel
   * @see viewmodel.AdminViewModel
   */
  public void init(ViewHandler viewHandler, AdminViewModel viewModel, Region root)
  {

    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = viewModel;

    list.setItems(viewModel.getAllMovies());

    title.textProperty().bind(viewModel.getTitleProperty());
    length.textProperty().bind(viewModel.getLengthProperty());
    director.textProperty().bind(viewModel.getDirectorProperty());
    description.textProperty().bind(viewModel.getDescriptionProperty());
    avgRating.textProperty().bind(viewModel.getAvgRatingProperty());
    errorLabel.textProperty().bind(viewModel.getErrorProperty());
  }

  /**
   * Empty 0 argument constructor
   */
  public AdminViewController() {}

  /**
   * A method calling the viewModel because controllers are not supposed to have functionality(single purpose)
   * @see viewmodel.AdminViewModel
   */
  public void reset()
  {
    viewModel.reset();
  }

  /**
   * @return the root
   *
   * A method returning the root for the controller
   */
  public Region getRoot()
  {
    return root;
  }

  /**
   * A FXML method called when the button named Add is pressed
   * It cals the method addMovie in the viewModel and if the method returns true(the admin is allowed to add the movie),
   *   it will reset the view so that the changes are visible immediately.
   *   @see viewmodel.AdminViewModel
   *
   */
  @FXML private void addPressed()
  {
      boolean add = viewModel.addMovie();

      if(add)
      {
        reset();
      }
  }

  /**
   * A FXML method called when the button named Edit is pressed
   * It cals the method getEdit in the viewModel and if the method returns true(the admin is allowed to edit the movie),
   *   it will call a method in the viewModel to get the information of the movie.
   *   @see viewmodel.AdminViewModel
   *
   */
  @FXML private void editPressed()
  {
    boolean edit = viewModel.getEdit(list.getFocusModel().getFocusedItem());

    if(edit)
    {
      viewModel.getMovieToEdit(list.getFocusModel().getFocusedItem());
    }
  }

  /**
   * A FXML method called when the button named Finish Edit is pressed
   * It cals the method editMovie in the viewModel and if the method returns true(the admin is allowed to edit the movie),
   *   it will reset the view so that the changes are visible immediately.
   *   @see viewmodel.AdminViewModel
   *
   */
  @FXML private void finishEditPressed()
  {
    boolean edit = viewModel.editMovie();

    if(edit)
    {
      reset();
    }
  }

  /**
   * A FXML method called when the button named Remove is pressed
   * It cals the method removeMovie in the viewModel and if the method returns true(the admin is allowed to remove the movie),
   *   it will reset the view so that the changes are visible immediately.
   *   @see viewmodel.AdminViewModel
   *
   */
  @FXML private void removePressed()
  {
    boolean remove = viewModel.removeMovie(list.getFocusModel().getFocusedItem());

    if(remove)
    {
      reset();
    }
  }
  /**
   * A FXML method called when the button named "Go back" is pressed. It cals the method openView in the viewHandler
   * @see view.ViewHandler
   */
  @FXML private void goBackPressed()
  {
    viewHandler.openView("start");
  }
}
