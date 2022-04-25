package view;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import java.awt.*;

/**
 * A class representing a controller for the start.fxml file @see view.start.fxml
 */
public class StartViewController
{
  @FXML private TextField usernameLogin;
  @FXML private PasswordField passwordLogin;

  @FXML private TextField name;
  @FXML private TextField usernameSignup;
  @FXML private TextField phoneNumber;
  @FXML private PasswordField passwordSignup;

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
  public void init()
  {

  }

  public void reset()
  {

  }

  /**
   * A FXML method called when the button named Log in is pressed. what is does
   */
  @FXML private void loginPressed()
  {

  }
  @FXML private void signupPressed()
  {

  }
}
