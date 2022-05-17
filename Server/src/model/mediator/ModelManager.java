package model.mediator;

import model.domain.*;

import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * The ModelManager class is the main class of the model. It is responsible for managing the model.
 */
public class ModelManager implements Model
{
  private MovieList movieList;
  private RentalList rentalList;
  private PersonList personList;

  private SEPPersistence database;

  /**
   * Empty constructor which initializes the movieList, rentalList, and personList
   */
  public ModelManager()
  {
    this.movieList = new MovieList();
    this.rentalList = new RentalList();
    this.personList = new PersonList();
    try
    {
      this.database = new SEPDatabase();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @param name        the person's name to be added
   * @param username    the person's username to be added
   * @param password    the person's password to be added
   * @param phoneNumber the person's phone number to be added
   * @param age         the person's age to be added
   * @param type        the person's type to be added
   *  A method to add a person to the person list
   */
  public void addPerson(String name, String username, String password, String phoneNumber, int age, String type)
  {
    System.out.println("I am in the model manager method");
    personList.addPerson(name, username, password, phoneNumber, age, type);
  }

  /**
   * @param movie the movie to be added to the movie list
   *  A method to add a movie to the movie list
   */
  public void addMovie(Movie movie)
  {
    movieList.addMovie(movie);
  }

  /**
   * @param movie the movie to be removed
   *  A method to remove a movie from the movie list
   */
  @Override public void removeMovie(Movie movie)
  {
    movieList.removeMovie(movie);
  }

  /**
   * @return the top 10 movies with the highest average ratings
   * A method to return the top 10 movies with the highest average ratings
   */
  @Override public ArrayList<Movie> getTop10TopRatedMovies()
  {
    return movieList.getTop10TopRatedMovies();
  }

  /**
   * @return the trending movies
   * A method to return the trending movies
   */
  @Override public ArrayList<Movie> getTrendingMovies()
  {
    return movieList.getTrendingMovies();
  }

  /**
   * @return the movie list
   * A method to return the movie list
   */
  public ArrayList<Movie> getAllMovies()
  {
    try
    {
      return database.getAllMovies();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return  null;
  }

  /**
   * @param listener the listener to be added
   *  A method to add a listener
   */
  @Override public void addListener(PropertyChangeListener listener)
  {
  }

  /**
   * @param movie the movie to be rented
   * @param expirationDate the expiration date of the rental
   *    A method to add a rental to the rental list
   */
  @Override public void addRental(Movie movie, Date expirationDate, User user)
  {
    rentalList.addRental(movie, expirationDate, user);
  }

  /**
   * @return all rentals
   * A method to return all rentals
   */
  @Override public ArrayList<Rental> getAllRentals()
  {
    return rentalList.getAllRentals();
  }

  /**
   * @param title the title of the movie
   * @param user  the user
   *
   *  A method to remove a rental from the rental list
   */
  @Override public void cancelRental(String title, User user)
  {

    rentalList.removeRental(title, user);
  }



  @Override public ArrayList<Rental> getRentalsWithUser(User user)
  {
    return rentalList.getRentalsWithUser(user);
  }
/*
--For the next sprint :)
  @Override public ArrayList<Rental> getRentalsWithMovie(Movie movie)
  {
    return rentalList.getRentalsWithMovie(movie);
  }
*/

  /**
   * @param listener the listener to be removed
   *   A method to remove a listener
   */
  public void removeListener(PropertyChangeListener listener)
  {
  }

  /**
   * @param title a String variable representing the title of a movie
   * @param user the user
   * //@param averageRating a String variable representing the average rating of a movie
   *  A method to check if the user can rent the movie
   */
  @Override public void rentMovie(String title, User user)
  {
    long rentalDate = System.currentTimeMillis() + (86400 * 7 * 1000);
    Date expirationDate = new Date(rentalDate);
    addRental(movieList.getMovieWithTitle(title), expirationDate, user);
  }

  /**
   * @param username string variable
   * @param password string variable
   * Checks if the username exists and has a matching password
   */
  @Override public void login(String username, String password)
  {
    boolean exists = false;
    for (int i = 0; i < personList.getPersons().size(); i++)
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
   * @param name        a String variable representing the name of the user
   * @param userName    a String variable representing the username chosen
   * @param password    a String variable representing the password chosen
   * @param phoneNumber a String variable representing the phone number of the user
   * @param age         a String variable representing the age of the user
   *
   *  A method to create a new User and add it to the person list
   */
  @Override public void createUser(String name, String userName, String password, String phoneNumber, String age)
  {
    for (int i = 0; i < personList.getPersons().size(); i++)
    {
      if (personList.getPersons().get(i).getUserName().equals(userName))
        throw new IllegalStateException("Username already exists!");
    }
    personList.addPerson(name, userName, password, phoneNumber,Integer. parseInt(age), "user");
  }

  /**
   * @param userName the username of the person
   * @param password the password of the person
   * @return a String variable, the type of the person (admin, user) or null in case it does not found the person
   */
  @Override public String checkPerson(String userName, String password)
  {
    for (int i = 0; i < personList.getPersons().size(); i++)
    {
      if (personList.getPersons().get(i).getUserName().equals(userName))
      {
        if (personList.getPersons().get(i).getPassword().equals(password))
        {
          return personList.getPersons().get(i).getType();
        }
      }
    }
    return null;
  }

  /**
   * @param userName the username
   * @return a User variable
   *
   * A methof to get the user by username (username is unique). Returns null if it does not exist
   */
  @Override public User getUser(String userName)
  {
    for (int i = 0; i < personList.getPersons().size(); i++)
    {
      if (personList.getPersons().get(i).getUserName().equals(userName))
      {
        return (User) personList.getPersons().get(i);
      }
    }
    return null;
  }

  /*@Override public boolean validateAddMovie(String title){

    for (int i = 0; i < movieList.getMovies().size(); i++)
    {
      if (movieList.getMovies().get(i).getTitle().equals(title))
      {
        return false;
      }
    }
    return true;
  }*/
}
