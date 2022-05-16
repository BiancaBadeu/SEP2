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
   * @param movie 
   * @param expirationDate
   * @param user
   */
  void addRental(Movie movie, Date expirationDate, User user);
  ArrayList<Rental> getAllRentals();
  void login(String username, String password);
  void createUser(String name, String userName, String password, String phoneNumber, String age);
  String checkPerson(String name, String password);
  void cancelRental(String title, User user);
  User getUser(String username);
}
