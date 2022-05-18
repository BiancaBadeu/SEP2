package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * A class representing the model
 */
public interface Model
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

  /**
   * @param movie the movie to be removed
   */
  void removeMovie(Movie movie);
  /**
   * @param title the movie's title
   * @param user the user renting the movie
   */
  void rentMovie(String title, User user);

  /**
   * @param movie the movie to be rented
   * @param expirationDate  the expiration date of the rental
   * @param user the user renting the movie
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
   *
   *  A method to login the user
   */
  void login(String username, String password);
  /**
   * @param name the name of the user
   * @param userName the username of the user
   * @param password the password of the user
   * @param phoneNumber the phone number of the user
   * @param age the age of the user
   *
   *  A method to create a new user
   */
  void createUser(String name, String userName, String password, String phoneNumber, String age);

  /**
   * @param name the username of the person
   * @param password the password of the person
   * @return a String variable with the type of person (admin, user)
   */
  String checkPerson(String name, String password);

  /**
   * @param title the title of the movie
   * @param user the user
   *
   * A method to cancel a rental
   */
  void cancelRental(String title, User user);

  /**
   * @param username the username of the user
   * @return a User variable
   *
   * A method to get the user by username (username is unique)
   */
  User getUser(String username);

  /**
   * @param title the title of the movie
   * @return a boolean value
   */
  boolean validateAddMovie(String title);

  Rental getRentalsWithUser(User user);

  ArrayList<Review> getCommentsForMovie(Movie movie);

  void leaveReview(String comment, int star, String title);
}
