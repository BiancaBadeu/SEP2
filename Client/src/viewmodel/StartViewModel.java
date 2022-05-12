package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.domain.User;
import model.mediator.Model;

/**
 A viewModel class that represents the functionality of the Controller class StartViewController
 * @see view.StartViewController
 **/
public class StartViewModel
{
  private Model model;
  private StringProperty usernameLogin;
  private StringProperty passwordLogin;
  private StringProperty errorLabelLogin;
  private StringProperty name;
  private StringProperty usernameSignup;
  private StringProperty phoneNumber;
  private StringProperty passwordSignup;
  private StringProperty errorSignup;
  private StringProperty dateLabel;
  private ViewModelStateUser userState;

  /**
   * @param model a Model variable so that the viewModel has access to the model's methods
   *
   * An 1 argument constructor that initializes the instance variables
   */

  public StartViewModel(Model model, ViewModelStateUser userState)
  {
    this.model = model;
    this.usernameLogin = new SimpleStringProperty();
    this.passwordLogin = new SimpleStringProperty();
    this.errorLabelLogin = new SimpleStringProperty();
    this.name = new SimpleStringProperty();
    this.usernameSignup = new SimpleStringProperty();
    this.phoneNumber = new SimpleStringProperty();
    this.passwordSignup = new SimpleStringProperty();
    this.errorSignup = new SimpleStringProperty();
    this.dateLabel = new SimpleStringProperty();
    this.userState= userState;
  }

  /**
   * A method to reset the instance variables everytime we open the window
   */

  public void reset()
  {
    usernameLogin.set("");
    passwordLogin.set("");
    errorLabelLogin.set("");
    name.set("");
    usernameSignup.set("");
    phoneNumber.set("");
    passwordSignup.set("");
    errorSignup.set("");
    dateLabel.set("");
  }

  /**
   * @return the usernameLogin property
   *
   * A getter for the usernameLogin string property
   */

  public  StringProperty getUsernameLoginProperty()
  {
    return usernameLogin;
  }

  /**
   * @return the passwordLogin property
   *
   * A getter for the passwordLogin string property
   */

  public StringProperty getPasswordLoginProperty()
  {
    return passwordLogin;
  }

  /**
   * @return the errorLabelLogin property
   *
   * A getter for the errorLabelLogin string property
   */

  public StringProperty getErrorLabelLoginProperty()
  {
    return errorLabelLogin;
  }

  /**
   * @return the name property
   *
   * A getter for the name string property
   */

  public StringProperty getNameProperty()
  {
    return name;
  }

  /**
   * @return the usernameSignup property
   *
   * A getter for the usernameSignup string property
   */

  public StringProperty getUsernameSignupProperty()
  {
    return usernameSignup;
  }


  /**
   * @return the phoneNumber property
   *
   * A getter for the phoneNumber string property
   */

  public StringProperty getPhoneProperty()
  {
    return phoneNumber;
  }

  /**
   * @return the passwordSignup property
   *
   * A getter for the passwordSignup string property
   */

  public StringProperty getPasswordSignupProperty()
  {
    return passwordSignup;
  }

  /**
   * @return the errorSignup property
   *
   * A getter for the errorSignup string property
   */

  public StringProperty getErrorSignupProperty()
  {
    return errorSignup;
  }

  /**
   * @return the dateLabel property
   *
   * A getter for the dateLabel string property
   */

  public StringProperty getDateLabelProperty(){return dateLabel;}

  /**
   @return a boolean value that is true if the model doesn't throw an exception and false if this method catches an exception
   @see Model
   **/
  public boolean login()
  {
    try{
      model.login(usernameLogin.get(), passwordLogin.get());
      userState.setUser(model.getUser(usernameLogin.get()));
      return true;

    }
    catch(Exception e)
    {
      errorLabelLogin.set(e.getMessage());
      return false;
    }
  }

  public String checkType(){

    return model.checkPerson(usernameLogin.get(), passwordLogin.get());
  }



  /**
   * @return a boolean value that is true if the model doesn't throw an exception and false if this method catches an exception
   * @see Model
   */
  public boolean createUser()
  {
    try{
      model.createUser(name.get(), usernameSignup.get(), passwordSignup.get(), phoneNumber.get(), dateLabel.get());
      return true;
    }
    catch(Exception e)
    {
      errorSignup.set(e.getMessage());
      return false;
    }
  }


}
