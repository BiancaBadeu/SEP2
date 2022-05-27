package model.domain;

import java.io.Serializable;

/**
 * This class represents a user.
 */
public class User extends Person implements Serializable
{

  /**
   * @param name the name of the user
   * @param username the username chosen
   * @param password the password of the user
   * @param phoneNumber the phone number of the user
   * @param age the age of the user
   *
   * Constructor for the user class
   */
  public User(String name, String username, String password, String phoneNumber, int age)
  {
    super(name, username, password, phoneNumber, age, "user");

    if(!isValidPhoneNumber(phoneNumber))
    {
      throw new IllegalArgumentException("Invalid phone number");
    }
    if(!isValidName(name))
    {
      throw new IllegalArgumentException("Invalid name");
    }
    if(!isValidUsername(username))
    {
      throw new IllegalArgumentException("Invalid username");
    }
  }

  /**
   * @return a string representation of the user
   */
  @Override public String toString()
  {
    return super.toString();
  }

  private boolean isValidPhoneNumber(String phoneNumber)
  {
    if(phoneNumber.length() != 8)
    {
      return false;
    }
    for(int i = 0; i < phoneNumber.length(); i++)
    {
      if(!Character.isDigit(phoneNumber.charAt(i)))
      {
        return false;
      }
    }
    return true;
  }

  private boolean isValidName(String name)
  {
    if(name.length() < 2)
    {
      return false;
    }
    for(int i = 0; i < name.length(); i++)
    {
      if(!Character.isLetter(name.charAt(i)))
      {
        return false;
      }
    }
    return true;
  }

  private boolean isValidUsername(String username)
  {
    if(username.length() < 2)
    {
      return false;
    }
    for(int i = 0; i < username.length(); i++)
    {
      if(!Character.isLetter(username.charAt(i)) && !Character.isDigit(username.charAt(i)))
      {
        return false;
      }
    }
    return true;
  }
}
