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

    if(!isValidPhoneNumber(phoneNumber))
    {
      throw new IllegalArgumentException("Invalid phone number");
    }
    if(!isValidName(name))
    {
      throw new IllegalArgumentException("Invalid name");
    }
    if(!isValidUsername(userName))
    {
      throw new IllegalArgumentException("Invalid username");
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

    if(!isValidUsername(userName))
    {
      throw new IllegalArgumentException("Invalid username");
    }
    else

      super.setUserName(userName);
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
    if(username.length() < 2 )
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
