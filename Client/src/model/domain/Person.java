package model.domain;

/**
 * This class represents a person which can be a user or an admin.
 */
public abstract class Person
{

  private String name;
  private String phoneNumber;
  private String userName;
  private String password;
  private String dob;
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
  public Person(String name, String userName, String password, String phoneNumber, String dob, String type){
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

  public String getDob(){return dob;}

  /**
   * @return the rental list
   *
   * Getter for the rental list
   */
  public RentalList getRentalList(){return rentalList;}
}
