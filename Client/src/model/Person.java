package model;

/**
 * This class represents a person which can be a user or an admin.
 */
public abstract class Person
{

  private String name;
  private long phoneNumber;
  private String userName;
  private String password;

  /**
   * @param name the name of the person
   * @param phoneNumber the phone number of the person
   * @param userName the user name of the person
   * @param password the password of the person
   *
   * Constructor for the Person class.
   */
  public Person(String name, long phoneNumber, String userName, String password){
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.userName = userName;
    this.password = password;
  }
}
