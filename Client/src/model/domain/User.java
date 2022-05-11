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
   * @param dob date of birth of the user
   *
   * Constructor for the user class
   */
  public User(String name, String username, String password, String phoneNumber, String dob)
  {
    super(name, username, password, phoneNumber, dob, "user");
  }
}
