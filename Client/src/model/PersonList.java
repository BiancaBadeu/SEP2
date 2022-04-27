package model;

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
   * @param name the name of the user
   * @param username
   * @param password
   * @param phoneNumber
   * @param dob
   */
  public void addPerson(String name, String username, String password, String phoneNumber, String dob, String type)
  {
    Person person;
    if(type.equals("user"))
    {person = new User(name, username, password, phoneNumber, dob);}
    if(type.equals("admin"))
    {persons = new Admin(name, username, password, phoneNumber, dob, 1, ;}
    persons.add(person);
  }
}
