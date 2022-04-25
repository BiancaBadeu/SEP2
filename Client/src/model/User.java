package model;

import java.util.Date;

/**
 * This class represents a user.
 */
public class User extends Person
{

  private Date dob;

  /**
   * @param name the name of the user
   * @param phoneNumber the phone number of the user
   * @param email the email of the user
   * @param password the password of the user
   * @param dob date of birth of the user
   *
   * Constructor for the user class
   */
  public User(String name, long phoneNumber, String email, String password, Date dob)
  {
    super(name, phoneNumber ,email, password);
    this.dob = dob;
  }
}
