package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import viewmodel.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
  @FXML private TextField phoneNumber;
  @FXML private PasswordField passwordSignup;
  @FXML private DatePicker dob;
  @FXML private Label errorSignup;

  @FXML private Label dateLabel;

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
   *    FXML variables to their respective properties from the viewModel
   *  @see viewmodel.StartViewModel
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
    usernameSignup.textProperty().bindBidirectional(viewModel.getUsernameSignupProperty());
    phoneNumber.textProperty().bindBidirectional(viewModel.getPhoneProperty());

    LocalDate date = dob.getValue();
    String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    dateLabel.setText(formattedDate);
    dateLabel.textProperty().bind(viewModel.getDateLabelProperty());

    errorSignup.textProperty().bind(viewModel.getErrorSignupProperty());
    passwordSignup.textProperty().bindBidirectional(viewModel.getPasswordSignupProperty());
  }

  /**
   * A method calling the viewModel because controllers are not supposed to have functionality(single purpose)
   * @see viewmodel.StartViewModel
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
   *  It cals the method login in the viewModel and if the method returns true(the user is allowed to log in),
   *  it will call the method openView in the viewHandler.
   *  @see viewmodel.StartViewModel
   *  @see view.ViewHandler
   */
  @FXML private void loginPressed()
  {
    boolean logedin = viewModel.login();
    if(logedin)
    {
      viewHandler.openView("home");
    }
  }
  /**
   * A FXML method called when the button named Sign up is pressed
   *
   *  It cals the method createUser in the viewModel and if the method returns true(the actor is allowed to create a new user),
   *  it will call the method openView in the viewHandler.
   *  @see viewmodel.StartViewModel
   *  @see view.ViewHandler
   */
  @FXML private void signupPressed()
  {
    boolean created = viewModel.createUser();
    if (created)
    {
      viewHandler.openView("home");
    }
  }
  /**
   * A FXML method called when the user pressed the Enter key on their keyboard
   *
   *  If the user was inside the usernameLogin TextField, when they press the Enter key
   *   the cursor will be transferred to the passwordLogin TextField
   *
   *  If the user was inside the name TextField, when they press the Enter key
   *   the cursor will be transferred to the usernameSignup TextField
   *
   *  If the user was inside the usernameSignup TextField, when they press the Enter key
   *   the cursor will be transferred to the phoneNumber TextField
   *
   *  If the user was inside the phoneNumber TextField, when they press the Enter key
   *   the cursor will be transferred to the passwordSignup TextField
   */
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
