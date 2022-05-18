package model.domain;

/**
 * This class represents a person which can be a user or an admin.
 */
public abstract class Person
{

  private String name;
  private String userName;
  private String phoneNumber;
  private String password;
  private int age;
  private String type;

  /**
   * @param name the name of the person
   * @param phoneNumber the phone number of the person
   * @param userName the username of the person
   * @param password the password of the person
   * @param age the age of the person
   * @param type the type of the person (user, admin)
   *
   * Constructor for the Person class.
   */
  public Person(String name, String userName, String password, String phoneNumber, int age, String type){
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.userName = userName;
    this.password = password;
    this.age = age;
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
   * @return the username of the person
   *
   * Getter for the username of the person.
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

  /**
   * @return the age of the person
   *
   * Getter for the age of the person.
   */
  public int getAge(){return age;}

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
   * @param age
   * Setter for the age of the person
   */
  public void setAge(int age)
  {
    this.age = age;
  }

  @Override public String toString()
  {
    return "name='" + name + '\'' + ", userName='" + userName + '\''
        + ", phoneNumber='" + phoneNumber + '\'' + ", password='" + password
        + '\'' + ", age=" + age + ", type='" + type + '\'' + '}';
  }
}
