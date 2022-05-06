package model;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;

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

  public void addPerson(String name, String username, String password, String phoneNumber, String dob, String type)
  {
    System.out.println("I am in the model manager method");
    personList.addPerson(name, username, password, phoneNumber, dob, type);
  }

  public void addMovie(Movie movie)
  {
    movieList.addMovie(movie);
  }

  @Override public ArrayList<Movie> getTop10TopRatedMovies()
  {
      return movieList.getTop10TopRatedMovies();
  }

  public ArrayList<Movie> getAllMovies()
  {
    return movieList.getAllMovies();
  }

  @Override public void addListener(PropertyChangeListener listener) {}

  @Override public void addRental(Movie movie, Date expirationDate)
  {
    rentalList.addRental(movie,expirationDate);
  }

  @Override public ArrayList<Rental> getAllRentals()
  {
    return rentalList.getAllRentals();
  }
/*
--For the next sprint :)
  @Override public ArrayList<Rental> getRentalsWithUser(User user)
  {
    return rentalList.getRentalsWithUser(user);
  }

  @Override public ArrayList<Rental> getRentalsWithMovie(Movie movie)
  {
    return rentalList.getRentalsWithMovie(movie);
  }
*/
  public void removeListener(PropertyChangeListener listener) {}

  /**
   * @param title a String variable representing the title of a movie
   * //@param averageRating a String variable representing the average rating of a movie
   *
   * A method to check if the user can rent the movie
   */
  @Override public void rentMovie(String title)
  {
    long rentalDate = System.currentTimeMillis() + (86400 * 7 * 1000);
    Date expirationDate = new Date(rentalDate);
    rentalList.addRental(movieList.getMovieWithTitle(title),expirationDate);
  }

  /**
   * @param username string variable
   * @param password string variable
   *
   *Checks if the username exists and has a matching password
   */
  @Override public void login(String username, String password)
  {
   System.out.println("I'm in the login model. Person list: " + personList.getPersons());
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
    if (!exists)
      throw new IllegalArgumentException("The username doesn't exist");
  }



  /**
   * @param name a String variable representing the name of the user
   * @param userName a String variable representing the username chosen
   * @param password a String variable representing the password chosen
   * @param phoneNumber a String variable representing the phone number of the user
   * @param dob a String variable representing the date of birth
   */
  @Override public void createUser(String name, String userName, String password, String phoneNumber, String dob)
  {
      for(int i=0;i<personList.getPersons().size();i++)
      {
        if(personList.getPersons().get(i).getUserName().equals(userName))
            throw new IllegalStateException("Username already exists!");
      }
      personList.addPerson(name, userName, password, phoneNumber, dob, "user");
  }
  
}
