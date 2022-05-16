package viewmodel;

import model.User;

/**
 * ViewModelStateUser is a class that holds the state of the user.
 */
public class ViewModelStateUser
{

  private User user;

  /**
   * Constructor for ViewModelStateUser.
   */
  public ViewModelStateUser()
  {
    this.user = null;
  }

  /**
   * @return the user
   * A method that returns the user.
   */
  public User getUser(){

    return user;
  }

  /**
   * @param user the user to set
   * A method that sets the user.
   */
  public void setUser(User user)
  {
    this.user = user;
  }
}
