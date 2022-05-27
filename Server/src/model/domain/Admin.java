package model.domain;

/**
 * A class representing an administrator of the system that is an extension from the class Person.
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
   * @param age the age of the administrator
   *
   * Constructor for the class Admin. Initializes instance variables with the super method.
   *
   * @see Person
   */
  public Admin(String name, String userName, String password, String phoneNumber, int age){
    super(name, userName, password, phoneNumber, age, "admin");
    this.adminID = userName;



    if(phoneNumber.equals("")){
      throw new IllegalArgumentException("Phone number cannot be empty");
    }

    if(name.equals("")){
      throw new IllegalArgumentException("Name cannot be empty");
    }

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

  public void setUserName(String userName){

    if(userName.equals("")){
      throw new IllegalArgumentException("Username cannot be empty");
    }

    else

      super.setUserName(userName);
  }


}
