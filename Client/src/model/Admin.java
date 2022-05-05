package model;

import java.util.ArrayList;

/**
 * This class represents an administrator of the system that is an extension from the class Person.
 * @see model.Person
 */
public class Admin extends Person
{

  private String adminID;


  /**
   * @param name the first name of the administrator
   * @param phoneNumber the phone number of the administrator
   * @param userName the user name of the administrator
   * @param password the password of the administrator
   * @param adminID the ID of the administrator
   *
   * Constructor for the class Admin. Initializes instance variables with the super method.
   *
   * @see model.Person
   */
  public Admin(String name, String userName, String password, String phoneNumber, String dob, String adminID){
    super(name, userName, password, phoneNumber, dob, "admin");
    this.adminID = adminID;
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
