package viewmodel;

import model.domain.User;

public class ViewModelStateUser
{

  private User user;


  public ViewModelStateUser()
  {
    this.user = null;
  }

  public User getUser(){

    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }
}
