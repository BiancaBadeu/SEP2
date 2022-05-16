package mediator;

import model.*;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Date;

/**
 * A class representing the client. Implements the model
 * @see model.Model;
 */
public class Client implements Model
{
  private RemoteModel remoteModel;

  /**
   * A 0 argument constructor that initializes the remote model
   */
  public Client()
  {
    try
    {
      remoteModel = (RemoteModel) Naming.lookup("rmi://localhost:1099/Case");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @return the top 10 top-rated movies
   */
  @Override public ArrayList<Movie> getTop10TopRatedMovies()
  {
    return remoteModel.getTop10TopRatedMovies();
  }

  /**
   * @return the trending movies
   */
  @Override public ArrayList<Movie> getTrendingMovies()
  {
    return remoteModel.getTrendingMovies();
  }

  /**
   * @return all movies
   */
  @Override public ArrayList<Movie> getAllMovies()
  {
    return remoteModel.getAllMovies();
  }

  /**
   * @param name        the person's name
   * @param username    the person's username
   * @param password    the person's password
   * @param phoneNumber the person's phone number
   * @param age         the person's age
   * @param type        the person's type
   *                    A method to add a person.
   */
  @Override public void addPerson(String name, String username, String password, String phoneNumber, int age, String type)
  {
      remoteModel.addPerson(name, username, password, phoneNumber, age, type);
  }

  /**
   * @param movie the movie to be added
   *              A method to add a movie
   */
  @Override public void addMovie(Movie movie)
  {
      remoteModel.addMovie(movie);
  }

  /**
   * @param movie the movie to be removed
   *              A method to remove a movie
   */
  @Override public void removeMovie(Movie movie)
  {
    remoteModel.removeMovie(movie);
  }

  /**
   * @param title the movie's title
   * @param user  the user renting the movie
   *              A method to rent a movie
   */
  @Override public void rentMovie(String title, User user)
  {
    remoteModel.rentMovie(title, user);
  }

  /**
   * @param movie          the movie to be rented
   * @param expirationDate the expiration date of the rental
   * @param user           the user renting the movie
   *                       A method do add a rental
   */
  @Override public void addRental(Movie movie, Date expirationDate, User user)
  {
    remoteModel.addRental(movie, expirationDate, user);
  }

  /**
   * @return all rentals
   */
  @Override public ArrayList<Rental> getAllRentals()
  {
    return remoteModel.getAllRentals();
  }

  /**
   * @param username the username of the user
   * @param password the password of the user
   *                 A method to login
   */
  @Override public void login(String username, String password)
  {
    remoteModel.login(username, password);
  }

  /**
   * @param name        the name of the user
   * @param userName    the username of the user
   * @param password    the password of the user
   * @param phoneNumber the phone number of the user
   * @param age         the age of the user
   *                    A method to create a user
   */
  @Override public void createUser(String name, String userName, String password, String phoneNumber, String age)
  {
      remoteModel.createUser(name, userName, password, phoneNumber, age);
  }

  /**
   * @param name     the username of the person
   * @param password the password of the person
   * @return the type of the person (user, admin)
   */
  @Override public String checkPerson(String name, String password)
  {
    return remoteModel.checkPerson(name, password);
  }

  /**
   * @param title the title of the movie
   * @param user  the user
   *              A method to cancel a rental
   */
  @Override public void cancelRental(String title, User user)
  {
    remoteModel.cancelRental(title, user);
  }

  /**
   * @param username the username of the user
   * @return the User
   */
  @Override public User getUser(String username)
  {
    return remoteModel.getUser(username);
  }

  /**
   * @param title the title of the movie
   * @return a boolean value
   */
  @Override public boolean validateAddMovie(String title)
  {
    return remoteModel.validateAddMovie(title);
  }

  /**
   * @param title the title of the movie
   * @return the movie with that title (title is unique)
   */
  public Movie getMovieWithTitle(String title)
  {
      return remoteModel.getMovieWithTitle(title);
  }

  @Override public Rental getRentalsWithUser(User user)
  {
    return remoteModel.getRentalsWithUser(user);
  }

  @Override public ArrayList<Review> getCommentsForMovie(Movie movie)
  {
    return remoteModel.getCommentsForMovie(movie);
  }
}
