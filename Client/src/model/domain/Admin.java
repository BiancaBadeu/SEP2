package model.domain;

import java.util.Date;

/**
 * This class represents an administrator of the system that is an extension from the class Person.
 * @see Person
 */
public class Admin extends Person
{
  private String adminID;

  /**
   * @param name the first name of the administrator
   * @param phoneNumber the phone number of the administrator
   * @param userName the username of the administrator
   * @param password the password of the administrator
   * @param dob the date of birth of the administrator
   *
   * Constructor for the class Admin. Initializes instance variables with the super method.
   *
   * @see Person
   */
  public Admin(String name, String userName, String password, String phoneNumber, Date dob){
    super(name, userName, password, phoneNumber, dob, "admin");
    this.adminID = userName;
  }

  /**
   * @return the ID of the administrator
   *
   * Getter for the instance variable adminID.
   */
  public String getAdminID(){
    return adminID;
  }

  /**
   * @param adminID the ID of the administrator
   *
   *                Setter for the instance variable adminID.
   */
  public void setAdminID(String adminID){
    this.adminID = adminID;
  }

  /**
   * @return a string representation of the administrator
   */
  public String toString(){
    return "Admin: " + super.toString() + " " + adminID;
  }
}
