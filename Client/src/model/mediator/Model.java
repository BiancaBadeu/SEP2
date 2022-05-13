package model.mediator;

import model.domain.Movie;
import model.domain.Rental;
import model.domain.User;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;

/**
 * a class representing a model interface
 */
public interface Model extends UnnamedPropertyChangeSubject
{
  /**
   * @return the top 10 rated movies
   */
  ArrayList<Movie> getTop10TopRatedMovies();

  /**
   * @return the trending movies
   */
  ArrayList<Movie> getTrendingMovies();

  /**
   * @return all the movies
   */
  ArrayList<Movie> getAllMovies();
  /**
   * @param name the person's name
   * @param username the person's username
   * @param password the person's password
   * @param phoneNumber the person's phone number
   * @param age the person's age
   * @param type the person's type
   */
  void addPerson(String name, String username, String password, String phoneNumber, int age, String type);
  /**
   * @param movie the movie to be added
   */
  void addMovie(Movie movie);

  void removeMovie(Movie movie);
  /**
   * @param title the movie's title
   */
  void rentMovie(String title, User user);

  /**
   * @param listener the listener to be added
   */
  void addListener(PropertyChangeListener listener);

  /**
   * @param movie the movie to be rented
   * @param expirationDate  the expiration date of the rental
   */
  void addRental(Movie movie, Date expirationDate, User user);
  /**
   * @return all rentals
   */
  ArrayList<Rental> getAllRentals();

 /*
  --For the next sprint :)
  ArrayList<Rental> getRentalsWithUser(User user);
  ArrayList<Rental> getRentalsWithMovie(Movie movie);
*/
  /**
   * @param username the username of the user
   * @param password the password of the user
   */
  void login(String username, String password);
  /**
   * @param name the name of the user
   * @param userName the username of the user
   * @param password the password of the user
   * @param phoneNumber the phone number of the user
   * @param dob the date of birth of the user
   */
  void createUser(String name, String userName, String password, String phoneNumber, String age);

  String checkPerson(String name, String password);

  void cancelRental(String title, User user);

  User getUser(String username);

}

