package model.mediator;

import model.domain.Movie;
import model.domain.Rental;
import model.domain.User;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * A class that represents the server. Implements the Remote model interface
 */
public class Server implements RemoteModel
{

  private Model model;

  /**
   * @param model the model
   *     A constructor for the server
   */
  public Server(Model model)
  {
    this.model = model;
  }

  /**
   * @throws RemoteException  exception
   * @throws AlreadyBoundException exception
   *            A method to start the server
   */
  public void startServer () throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1098);
    UnicastRemoteObject.exportObject(this,0);
    registry.bind("Server", this);

    try
    {
      model.getAllInfo();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @param title the title of the movie
   * @return a boolean true if the movie is rented, false if it isn't
   */
  public boolean checkMovieIsRented(String title)
  {
    return model.checkMovieIsRented(title);
  }
    /**
     * @return the top 10 top-rated movies
     */
    @Override public ArrayList<Movie> getTop10TopRatedMovies () {
    return model.getTop10TopRatedMovies();
  }

    /**
     * @return the trending movies
     */
    @Override public ArrayList<Movie> getTrendingMovies () {
    return model.getTrendingMovies();
  }

    /**
     * @return all movies
     */
    @Override public ArrayList<Movie> getAllMovies () {
    return model.getAllMovies();
  }

    /**
     * @param name        the name of the person
     * @param username    the username of the person
     * @param password    the password of the person
     * @param phoneNumber the phone number of the person
     * @param age         the age of the person
     * @param type        the type of the person (user, admin)
     *                    A method to add a person
     */
    @Override public void addPerson (String name, String username, String
    password, String phoneNumber,int age, String type)
    {
      model.addPerson(name, username, password, phoneNumber, age, type);
    }

    /**
     * @param movie the movie to be added
     */
    @Override public void addMovie (Movie movie)
    {
      model.addMovie(movie);
    }

    /**
     * @param movie the movie to be removed
     */
    @Override public void removeMovie (Movie movie)
    {
      model.removeMovie(movie);
    }

    /**
     * @param title the title of the movie
     * @param user  the user
     *              A method to rent a movie
     */
    @Override public void rentMovie (String title, User user)
    {
      model.rentMovie(title, user);
    }

    /**
     * @param movie          the movie to be rented
     * @param expirationDate the date the rental expires
     * @param user           the user renting
     *                       A method to add a rental
     */
    @Override public void addRental (Movie movie, Date expirationDate, User user)
    {
      model.addRental(movie, expirationDate, user);
    }

    /**
     * @return all rentals
     */
    @Override public ArrayList<Rental> getAllRentals () {
    return model.getAllRentals();
  }

    /**
     * @param username the username
     * @param password the password
     *                 A method to login
     */
    @Override public void login (String username, String password)
    {
      model.login(username, password);
    }

    /**
     * @param name        the name of the user
     * @param userName    the username of the user
     * @param password    the password of the user
     * @param phoneNumber the phone number of the user
     * @param age         the age of the user
     *                    A method to create a user
     */
    @Override public void createUser (String name, String userName, String
    password, String phoneNumber, String age)
    {
      model.createUser(name, userName, password, phoneNumber, age);
    }

    /**
     * @param name     the name of the person
     * @param password the password of the person
     * @return the type of the person (user, admin)
     */
    @Override public String checkPerson (String name, String password)
    {
      return model.checkPerson(name, password);
    }

    /**
     * @param title the title of the movie
     * @param user  the user
     *              A method to cancel a rental
     */
    @Override public void cancelRental (String title, User user)
    {
      model.cancelRental(title, user);
    }

    /**
     * @param username the username of the user
     * @return the user
     */
    @Override public User getUser (String username)
    {
      return model.getUser(username);
    }

    /**
     * @param title the title of the movie
     * @return the movie with that title (title is unique)
     */
    @Override public Movie getMovieWithTitle (String title)
    {
      return model.getMovieWithTitle(title);
    }

    /**
     * @param title the title of the movie
     * @return a boolean value
     */
    @Override public boolean validateAddMovie (String title)
    {
      return model.validateAddMovie(title);
    }

    /**
     * @param user the user
     * @return the user's rentals
     */
    @Override public ArrayList<Rental> getRentalsWithUser (User user)
    {
      return model.getRentalsWithUser(user);
    }

    /**
     * @param movie the movie
     * @return the movie's comments
     */
    @Override public ArrayList<String> getCommentsForMovie (Movie movie)
    {
      return model.getCommentsForMovie(movie);
    }

    /**
     * @param comment the comment
     * @param rating  the rating
     * @param title the title
     */
    @Override public void leaveReview (String comment,int rating, String title)
    {
      model.leaveReview(comment, rating, title);
    }

  /**
   * @param title the title
   * @return an array list
   */
    @Override public ArrayList<Movie> getMovieLike (String title)
    {
      return model.getMovieLike(title);
    }

  }
