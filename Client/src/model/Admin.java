package model;

/**
 * This class represents an administrator of the system that is an extension from the class Person.
 * @see model.Person
 */
public class Admin extends Person
{

  private String adminID;

  /**
   * @param firstName the first name of the administrator
   * @param phoneNumber the phone number of the administrator
   * @param userName the user name of the administrator
   * @param password the password of the administrator
   * @param adminID the ID of the administrator
   *
   * Constructor for the class Admin. Initializes instance variables with the super method.
   *
   * @see model.Person
   */
  public Admin(String firstName, long phoneNumber, String userName, String password, String adminID){
    super(firstName, phoneNumber, userName, password);
    this.adminID = adminID;
  }
}
