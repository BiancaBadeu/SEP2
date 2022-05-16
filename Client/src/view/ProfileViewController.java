package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import viewmodel.ProfileViewModel;

/**
 * A class representing a controller for the profile.fxml file @see view.profile.fxml
 */
public class ProfileViewController
{
  @FXML ListView<String> list;
  @FXML Label usernameLabel;
  @FXML Label nameLabel;
  @FXML Label phoneNoLabel;
  @FXML Label ageLabel;

  private ViewHandler viewHandler;
  private Region root;
  private ProfileViewModel viewModel;

  /**
   * @param viewHandler a ViewHandler variable for control over the GUI
   * @param viewModel a ProfileViewModel variable for control over the functionality
   * @param root a Region variable for location within the GUI
   *
   * A method to initiate the GUI windows and initializing the parameters previously mentioned, plus binding all the
   * FXML variables to their respective properties from the viewModel
   * @see viewmodel.ProfileViewModel
   */
  public void init(ViewHandler viewHandler, ProfileViewModel viewModel, Region root)
  {

    this.viewHandler = viewHandler;
    this.root = root;
    this.viewModel = viewModel;

    list.setItems(viewModel.getRentedMovies());

    usernameLabel.textProperty().bind(viewModel.getUsernameProperty());
    usernameLabel.textProperty().bind(viewModel.getNameProperty());
    usernameLabel.textProperty().bind(viewModel.getPhoneNoProperty());
    usernameLabel.textProperty().bind(viewModel.getAgeProperty());
  }

  /**
   * Empty 0 argument constructor
   */
  public ProfileViewController() {}

  /**
   * A method calling the viewModel because controllers are not supposed to have functionality(single purpose)
   * @see viewmodel.ProfileViewModel
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
   * A FXML method called when the button named "<-" is pressed. It cals the method openView in the viewHandler
   * @see view.ViewHandler
   */
  @FXML private void goBackPressed()
  {
    viewHandler.openView("home");
  }

  /**
   * A FXML method called when the button named "Show details" is pressed
   * It cals the method showDetails in the viewModel and if the method returns true(the user is allowed to see the movie),
   *   it will call the method openView in the ViewHandler
   *   @see viewmodel.ProfileViewModel
   *   @see view.ViewHandler
   */
  @FXML private void showDetailsPressed(){

    boolean ok= viewModel.showDetails(list.getFocusModel().getFocusedItem());

    if(ok){viewHandler.openView("movie");}
  }
}
