package model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ModelManager implements Model
{
  private MovieList movieList;
  private RentalList rentalList;
  private PersonList personList;

  public ModelManager()
  {
    this.movieList = new MovieList();
    this.rentalList = new RentalList();
    this.personList = new PersonList();
  }
  @Override public ArrayList<Movie> getTop10TopRatedMovies()
  {
      return movieList.getTop10TopRatedMovies();
  }

  @Override public void addListener(PropertyChangeListener listener) {}

   public void removeListener(PropertyChangeListener listener) {}

  @Override public void rentMovie(String title, String averageRating)
  {
      if(false)
        throw new IllegalStateException("Cannot rent this movie.");
  }

  /**
   * @param username string variable
   * @param password string variable
   *
   *Checks if the username exists and has a matching password
   */
  @Override public void login(String username, String password)
  {
    boolean exists = false;
    for (int i = 0; i<personList.getPersons().size(); i++)
    {
      if (username.equals(personList.getPersons().get(i).getUserName()))
      {
        exists = true;
        if (!(password.equals(personList.getPersons().get(i).getPassword())))
        {
          throw new IllegalArgumentException("password is incorrect");

        }
      }

    }
    if (exists == false)
      throw new IllegalArgumentException("The username doesn't exist");
  }

  @Override public void createUser(String name, String userName,
      String password, String phoneNumber, String dob)
  {

  }
  
}
