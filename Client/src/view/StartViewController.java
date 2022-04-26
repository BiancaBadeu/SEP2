package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import viewmodel.*;
/**
 * A class representing a controller for the start.fxml file @see view.start.fxml
 */
public class StartViewController
{
  @FXML private TextField usernameLogin;
  @FXML private PasswordField passwordLogin;
  @FXML private Label errorLabelLogin;

  @FXML private TextField name;
  @FXML private TextField usernameSignup;
  @FXML private Label errorUsername;
  @FXML private TextField phoneNumber;
  @FXML private PasswordField passwordSignup;
  @FXML private DatePicker dob;
  @FXML private Label errorDob;

  private Region root;
  private StartViewModel viewModel;
  private ViewHandler viewHandler;

  /**
   * A 0 argument empty constructor
   */
  public StartViewController(){}

  /**
   * @param viewHandler a ViewHandler variable for control over the GUI
   * @param viewModel a StartViewModel variable for control over the functionality
   * @param root a Region variable for location within the GUI
   *
   * A method to initiate the GUI windows and initializing the parameters previously mentioned, plus binding all the
   *             FXML variables to their respective properties from the viewModel @see viewmodel.StartViewModel
   */
  public void init(ViewHandler viewHandler, StartViewModel viewModel, Region root)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;

    usernameLogin.textProperty().bindBidirectional(viewModel.getUsernameLoginProperty());
    passwordLogin.textProperty().bindBidirectional(viewModel.getPasswordLoginProperty());
    errorLabelLogin.textProperty().bind(viewModel.getErrorLabelLoginProperty());

    name.textProperty().bindBidirectional(viewModel.getNameProperty());
    usernameSignup.textProperty().bindBidirectional(viewModel.getUsernameSingupProperty());
    errorUsername.textProperty().bind(viewModel.getErrorUsernameProperty());
    phoneNumber.textProperty().bindBidirectional(viewModel.getPhoneProperty());

    errorDob.textProperty().bind(viewModel.getErrorDobProperty());
    passwordSignup.textProperty().bindBidirectional(viewModel.getPasswordSingupProperty());
  }

  /**
   * A method calling the viewModel because controllers are not supposed to have functionality(single purpose) @see viewmodel.StartViewModel
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
  public Region getRoot() {return root;}

  /**
   * A FXML method called when the button named Log in is pressed
   *
   *
   */
  @FXML private void loginPressed()
  {
    boolean logedin = viewModel.login();
    if(logedin)
    {
      viewHandler.openView("home");
    }
  }
  @FXML private void signupPressed()
  {
    boolean created = viewModel.createUser();
    if (created)
    {
      viewHandler.openView("home");
    }
  }

  @FXML private void onEnter(ActionEvent actionEvent)
  {
    if (actionEvent.getSource() == usernameLogin)
    {
      passwordLogin.requestFocus();
    }
    else if (actionEvent.getSource() == name)
    {
      usernameSignup.requestFocus();
    }
    else if (actionEvent.getSource() == usernameSignup)
    {
      phoneNumber.requestFocus();
    }
    else if (actionEvent.getSource() == phoneNumber)
    {
      passwordSignup.requestFocus();
    }
  }
}
