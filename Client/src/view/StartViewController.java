package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

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
   * @param viewmodel a
   * @param root a
   *
   * A method to initiate the GUI windows and initializing the parameters previously mentioned
   */
  public void init(ViewHandler viewHandler, StartViewModel viewmodel, Region root)
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

  public void reset()
  {
      viewModel.reset();
  }

  public Region getRoot() {return root;}

  /**
   * A FXML method called when the button named Log in is pressed. what is does
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
