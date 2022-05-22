package model.domain;

/**
 * This class represents a user.
 */
public class User extends Person
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
  }


}
