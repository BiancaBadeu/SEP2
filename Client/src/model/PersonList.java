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

  public ArrayList<Person> getPersons()
  {
    return persons;
  }
}
