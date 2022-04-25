package model;

/**
 * This class represents a list of persons.
 */
public class PersonList
{

  private Person[] persons;
  private int size;

  /**
   * Constructor for the person list class.
   */
  public PersonList()
  {
    size = 0;
    persons = new Person[size];
  }
}
