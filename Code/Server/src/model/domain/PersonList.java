package model.domain;

import java.util.ArrayList;

/**
 * This class represents a list of persons.
 */
public class PersonList
{
  private ArrayList<Person> persons;

  /**
   * Constructor for the person list class.
   */
  public PersonList()
  {
    this.persons = new ArrayList<>();
  }

  /**
   * @return the array list of persons
   */
  public ArrayList<Person> getPersons()
  {
    return persons;
  }

  /**
   * @param name the name of the person
   * @param username the username of the person
   * @param password the password of the person
   * @param phoneNumber the phone number of the person
   * @param age the age of the person
   * @param type the type of the person (user, admin)
   *
   *   A method adding a person in the person list. It checks for the type and adds the corresponding type.
   */
  public void addPerson(String name, String username, String password, String phoneNumber, int age, String type)
  {
    if(name==null || username==null || password==null || phoneNumber==null || type==null)
      throw new IllegalArgumentException("Person cannot be null");

    else if(name.equals("") || username.equals("") || password.equals("") || phoneNumber.equals("") || type.equals(""))
      throw new IllegalArgumentException("Person cannot be empty");



    Person person = null;
    if(type.equals("user"))
    {person = new User(name, username, password, phoneNumber, age);}
    if(type.equals("admin"))
    {person = new Admin(name, username, password, phoneNumber, age);}
    persons.add(person);
  }
}
