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

  public  StringProperty getUsernameLoginProperty()
  {
    return usernameLogin;
  }

  public StringProperty getPasswordLoginProperty()
  {
    return passwordLogin;
  }

  public StringProperty getErrorLabelLoginProperty()
  {
    return errorLabelLogin;
  }

  public StringProperty getNameProperty()
  {
    return name;
  }

  public StringProperty getUsernameSignupProperty()
  {
    return usernameSignup;
  }

  public StringProperty getErrorUsernameProperty()
  {
    return errorUsername;
  }

  public StringProperty getPhoneProperty()
  {
    return phoneNumber;
  }

  public StringProperty getPasswordSignupProperty()
  {
    return passwordSignup;
  }

  public StringProperty getErrorDobProperty()
  {
    return errorDob;
  }
}
