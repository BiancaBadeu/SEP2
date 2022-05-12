package model.domain;

import java.util.Date;

/**
 * This class represents a person which can be a user or an admin.
 */
public abstract class Person
{

  private String name;
  private String phoneNumber;
  private String userName;
  private String password;
  private Date dob;
  private String type;

  private RentalList rentalList;

  /**
   * @param name the name of the person
   * @param phoneNumber the phone number of the person
   * @param userName the username of the person
   * @param password the password of the person
   *
   * Constructor for the Person class.
   */
  public Person(String name, String userName, String password, String phoneNumber, Date dob, String type){
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.userName = userName;
    this.password = password;
    this.dob = dob;
    this.type = type;
  }

  /**
   * @return the name of the person
   *
   * Getter for the name of the person.
   */
  public String getName()
  {
    return name;
  }

  /**
   * @return the phone number of the person
   *
   * Getter for the phone number of the person.
   */
  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  /**
   * @return the user name of the person
   *
   * Getter for the user name of the person.
   */
  public String getUserName()
  {
    return userName;
  }

  /**
   * @return the password of the person
   *
   * Getter for the password of the person.
   */
  public String getPassword()
  {
    return password;
  }

  /**
   * @return the type of the person
   *
   * Getter for the type of the person.
   */
  public String getType()
  {
    return type;
  }

  public Date getDob(){return dob;}

  /**
   * @return the rental list
   *
   * Getter for the rental list
   */
  public RentalList getRentalList(){return rentalList;}

  /**
   * @param name
   * Setter for the name of the person
   */
  public void setName(String name)
  {
    this.name = name;
  }

  /**
   * @param phoneNumber
   * Setter for the phone number of the person
   */
  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  /**
   * @param userName
   * Setter for the username of the person
   */
  public void setUserName(String userName)
  {
    this.userName = userName;
  }

  /**
   * @param password
   * Setter for the password of the person
   */
  public void setPassword(String password)
  {
    this.password = password;
  }

  /**
   * @param dob
   * Setter for the date of birth of the person
   */
  public void setDob(Date dob)
  {
    this.dob = dob;
  }

}
