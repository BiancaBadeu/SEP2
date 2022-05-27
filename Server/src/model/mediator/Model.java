package model.mediator;

import model.domain.Movie;
import model.domain.Rental;
import model.domain.Review;
import model.domain.User;
import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * a class representing a model interface
 */
public interface Model extends UnnamedPropertyChangeSubject
{

  /**
   * @throws SQLException exception
   *         A method to get the movies from the database and store it
   */
  void getDatabaseMovies() throws SQLException;

  /**
   * @throws SQLException exception
   * A method to set the lists from the database in the model
   */
  void getAllInfo() throws SQLException;
  /**
   * @return an array list containing the movies that are not rented
   */
  ArrayList<Movie> getNotRentedMovies();
  /**
   * @param title the title of the movie
   * @return a boolean true if the movie is rented, false if it isn't
   */
  boolean checkMovieIsRented(String title);
  /**
   * @return the top 10 rated movies
   */
  ArrayList<Movie> getTop10TopRatedMovies();

  /**
   * @param title the title of the movie
   * @return an array list of movies that contain that title
   */
  ArrayList<Movie> getMovieLike(String title);

  /**
   * @param title the title of the movie
   * @return a movie object with that title (title is unique)
   */
  Movie getMovieWithTitle(String title);

  /**
   * @return the trending movies
   */
  ArrayList<Movie> getTrendingMovies();

  /**
   * @return all the movies
   */
  ArrayList<Movie> getAllMovies();

  /**
   * @param genre the genre
   * @return array list of movies for that genre.
   */
  ArrayList<Movie> getMoviesWithGenre(String genre);
  /**
   * @param name the person's name
   * @param username the person's username
   * @param password the person's password
   * @param phoneNumber the person's phone number
   * @param age the person's age
   * @param type the person's type
   *             A method to add a person
   */
  void addPerson(String name, String username, String password, String phoneNumber, int age, String type);
  /**
   * @param movie the movie to be added
   *              A method to add a movie
   */
  void addMovie(Movie movie);

  /**
   * @param movie the movie to be removed
   *              A method to remove a movie
   */
  void removeMovie(Movie movie);

  /**
   * @param title the movie's title
   *              A method to rent a movie
   */
  void rentMovie(String title, User user);

  /**
   * @param listener the listener to be added
   *                 A method to add a listener
   */
  void addListener(PropertyChangeListener listener);

  /**
   * @param movie the movie to be rented
   * @param expirationDate  the expiration date of the rental
   *                        A method to add a rental
   */
  void addRental(Movie movie, Date expirationDate, User user);
  /**
   * @return all rentals
   */
  ArrayList<Rental> getAllRentals();

  /**
   * @param username the username
   * @return an array list with the rentals for the user
   */
  ArrayList<Rental> getRentalsWithUser(String username);

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
   * @param username the username
   *
   * A method to cancel a rental
   */
  void cancelRental(String title, String username);

  /**
   * @param username the username of the user
   * @return a User variable
   *
   * A method to get the user by username (username is unique)
   */
  User getUser(String username);
  /**
   * @param title the title of the movie
   * @return a boolean value if we can add the movie
   */
  boolean validateAddMovie(String title);

  /**
   * @param movie the movie
   * @return an array list of the comments for the movie
   */
  ArrayList<Review> getReviewsForMovie(Movie movie);

  /**
   * @param comment the comment
   * @param star the rating
   * @param title the title of the movie
   *              A method to leave a review
   */
  void leaveReview(String comment, int star, String title, String user);
}

