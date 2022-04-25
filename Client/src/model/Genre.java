package model;

/**
 * class for genre
 */
public class Genre
{

  private String name;

  /**
   * @param name name of genre
   *
   * Genre constructor
   */
  public Genre(String name)
  {
    this.name = name;
  }

  /**
   * @return name of genre
   *
   * returns the name of the genre
   */
  public String getName()
  {
    return name;
  }

  /**
   * @param name name of genre
   *
   * sets the name of the genre
   */
  public void setName(String name)
  {
    this.name = name;
  }
}


