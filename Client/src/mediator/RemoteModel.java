package mediator;

import model.Movie;
import model.Rental;
import model.User;

import java.rmi.Remote;
import java.util.ArrayList;
import java.util.Date;

/**
 * A class representing the remote model. Extends java.rmi.Remote;
 */
public interface RemoteModel extends Remote
{
  /**
   * @return the top 10 top-rated movies
   */
    ArrayList<Movie> getTop10TopRatedMovies();
  /**
   * @return the trending movies
   */
    ArrayList<Movie> getTrendingMovies();
  /**
   * @return all movies
   */
    ArrayList<Movie> getAllMovies();
  /**
   * @param name the name of the person
   * @param username the username of the person
   * @param password the password of the person
   * @param phoneNumber the phone number of the person
   * @param age the age of the person
   * @param type the type of the person (user, admin)
   *             A method to add a person
   */
    void addPerson(String name, String username, String password, String phoneNumber, int age, String type);
  /**
   * @param movie the movie to be added
   */
    void addMovie(Movie movie);
  /**
   * @param movie the movie to be removed
   */
    void removeMovie(Movie movie);
  /**
   * @param title the title of the movie
   * @param user the user
   *             A method to rent a movie
   */
  void rentMovie(String title, User user);
  /**
   * @param movie the movie to be rented
   * @param expirationDate the date the rental expires
   * @param user the user renting
   *             A method to add a rental
   */
  void addRental(Movie movie, Date expirationDate, User user);
  /**
   * @return all rentals
   */
  ArrayList<Rental> getAllRentals();
  /**
   * @param username the username
   * @param password the password
   *                 A method to login
   */
  void login(String username, String password);
  /**
   * @param name the name of the user
   * @param userName the username of the user
   * @param password the password of the user
   * @param phoneNumber the phone number of the user
   * @param age the age of the user
   *            A method to create a user
   */
  void createUser(String name, String userName, String password, String phoneNumber, String age);
  /**
   * @param name the name of the person
   * @param password the password of the person
   * @return the type of the person (user, admin)
   */
  String checkPerson(String name, String password);
  /**
   * @param title the title of the movie
   * @param user the user
   *             A method to cancel a rental
   */
  void cancelRental(String title, User user);
  /**
   * @param username the username of the user
   * @return the user
   */
  User getUser(String username);
  /**
   * @param title the title of the movie
   * @return the movie with that title (title is unique)
   */
  Movie getMovieWithTitle(String title);
  /**
   * @param title the title of the movie
   * @return a boolean value
   */
  boolean validateAddMovie(String title);
}
