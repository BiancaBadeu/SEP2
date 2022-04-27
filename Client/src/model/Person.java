package model;

import java.util.Date;

/**
 * This class represents a person which can be a user or an admin.
 */
public abstract class Person
{

  private String name;
  private long phoneNumber;
  private String userName;
  private String password;
  private Date birthDate;
  private String type;

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
  public long getPhoneNumber()
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
   * @return the birth date of the person
   *
   * Getter for the birth date of the person.
   */
  public Date getBirthDate()
  {
    return birthDate;
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
}
