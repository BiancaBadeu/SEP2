package model.mediator;

import model.domain.Movie;
import model.domain.Rental;
import model.domain.Review;
import model.domain.User;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * A class representing the client. Implements the model
 * @see Model ;
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
      remoteModel = (RemoteModel) Naming.lookup("rmi://localhost:1097/Server");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @return an array list containing the movies that are not rented
   */
  @Override public ArrayList<Movie> getNotRentedMovies()
  {
    try
    {
      return remoteModel.getNotRentedMovies();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

  /**
   * @param title the title of the movie
   * @return a boolean true if the movie is rented, false if it isn't
   */
  public boolean checkMovieIsRented(String title)
  {
    try
    {
      return remoteModel.checkMovieIsRented(title);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * @return the top 10 top-rated movies
   */
  @Override public ArrayList<Movie> getTop10TopRatedMovies()
  {
    try
    {
      return remoteModel.getTop10TopRatedMovies();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

  /**
   * @return the trending movies
   */
  @Override public ArrayList<Movie> getTrendingMovies()
  {
    try
    {
      return remoteModel.getTrendingMovies();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

  /**
   * @return all movies
   */
  @Override public ArrayList<Movie> getAllMovies()
  {
    try
    {
      return remoteModel.getAllMovies();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return new ArrayList<>();
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
    try
    {
      remoteModel.addPerson(name, username, password, phoneNumber, age, type);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @param movie the movie to be added
   *              A method to add a movie
   */
  @Override public void addMovie(Movie movie)
  {
    try
    {
      remoteModel.addMovie(movie);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @param movie the movie to be removed
   *              A method to remove a movie
   */
  @Override public void removeMovie(Movie movie)
  {
    try
    {
      remoteModel.removeMovie(movie);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @param title the movie's title
   * @param user  the user renting the movie
   *              A method to rent a movie
   */
  @Override public void rentMovie(String title, User user)
  {
    try
    {
      remoteModel.rentMovie(title, user);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @param movie          the movie to be rented
   * @param expirationDate the expiration date of the rental
   * @param user           the user renting the movie
   *                       A method do add a rental
   */
  @Override public void addRental(Movie movie, Date expirationDate, User user)
  {
    try
    {
      remoteModel.addRental(movie, expirationDate, user);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @return all rentals
   */
  @Override public ArrayList<Rental> getAllRentals()
  {
    try
    {
      return remoteModel.getAllRentals();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

  /**
   * @param username the username of the user
   * @param password the password of the user
   *                 A method to login
   */
  @Override public void login(String username, String password)
  {
    try
    {
      remoteModel.login(username, password);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
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
    try
    {
      remoteModel.createUser(name, userName, password, phoneNumber, age);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @param name     the username of the person
   * @param password the password of the person
   * @return the type of the person (user, admin)
   */
  @Override public String checkPerson(String name, String password)
  {
    try
    {
      return remoteModel.checkPerson(name, password);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return "";
  }

  /**
   * @param title the title of the movie
   * @param username  the username
   *              A method to cancel a rental
   */
  @Override public void cancelRental(String title, String username)
  {
    try
    {
      remoteModel.cancelRental(title, username);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @param username the username of the user
   * @return the User
   */
  @Override public User getUser(String username)
  {
    try
    {
      return remoteModel.getUser(username);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * @param title the title of the movie
   * @return a boolean value
   */
  @Override public boolean validateAddMovie(String title)
  {
    try
    {
      return remoteModel.validateAddMovie(title);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * @param title the title of the movie
   * @return the movie with that title (title is unique)
   */
  public Movie getMovieWithTitle(String title)
  {
    try
    {
      return remoteModel.getMovieWithTitle(title);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * @param user the user
   *
   * @return the user's rentals
   */
  @Override public ArrayList<Rental> getRentalsWithUser(User user)
  {
    try
    {
      return remoteModel.getRentalsWithUser(user);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

  /**
   * @param movie the movie
   *
   * @return the movie's comments
   */
  @Override public ArrayList<Review> getReviewsForMovie(Movie movie)
  {
    try
    {
      return remoteModel.getReviewsForMovie(movie);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return new ArrayList<>();
  }

  /**
   * @param comment the comment
   * @param rating the rating
   * @param title the title
   * @param user the username
   *              A method to leave a review
   */
  @Override public void leaveReview(String comment, int rating, String title, String user)
  {
    try
    {
      remoteModel.leaveReview(comment, rating, title, user);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
