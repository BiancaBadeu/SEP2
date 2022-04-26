package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

public class StartViewModel
{
  private Model model;
  private StringProperty usernameLogin;
  private StringProperty passwordLogin;
  private StringProperty errorLabelLogin;
  private StringProperty name;
  private StringProperty usernameSignup;
  private StringProperty errorUsername;
  private StringProperty phoneNumber;
  private StringProperty passwordSignup;
  private StringProperty errorDob;

  public StartViewModel(Model model)
  {
    this.model = model;
    this.usernameLogin = new SimpleStringProperty();
    this.passwordLogin = new SimpleStringProperty();
    this.errorLabelLogin = new SimpleStringProperty();
    this.name = new SimpleStringProperty();
    this.usernameSignup = new SimpleStringProperty();
    this.errorUsername = new SimpleStringProperty();
    this.phoneNumber = new SimpleStringProperty();
    this.passwordSignup = new SimpleStringProperty();
    this.errorDob = new SimpleStringProperty();

  }

  public void reset()
  {
    usernameLogin.set("");
    passwordLogin.set("");
    errorLabelLogin.set("");
    name.set("");
    usernameSignup.set("");
    errorUsername.set("");
    phoneNumber.set("");
    passwordSignup.set("");
    errorDob.set("");
  }

  public  StringProperty getUsernameLogin()
  {
    return usernameLogin;
  }

  public StringProperty getPasswordLogin()
  {
    return passwordLogin;
  }

  public StringProperty getErrorLabelLogin()
  {
    return errorLabelLogin;
  }

  public StringProperty getName()
  {
    return name;
  }

  public StringProperty getUsernameSignup()
  {
    return usernameSignup;
  }

  public StringProperty getErrorUsername()
  {
    return errorUsername;
  }

  public StringProperty getPhoneNumber()
  {
    return phoneNumber;
  }

  public StringProperty getPasswordSignup()
  {
    return passwordSignup;
  }

  public StringProperty getErrorDob()
  {
    return errorDob;
  }
}
