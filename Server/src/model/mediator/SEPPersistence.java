package model.mediator;

import model.domain.*;

import java.sql.*;
import java.util.ArrayList;

/**
 * A class representing a persistence interface
 */
public interface SEPPersistence
{
  /**
   * @param name        the name of the user
   * @param phoneNumber the phone number of the user
   * @param userName    the username of the user
   * @param password    the password of the user
   * @param age         the age of the user
   * @throws SQLException exception
   *           A method to add a user to database
   */
  void addUser(String name, String phoneNumber, String userName, String password, int age) throws SQLException;

  /**
   * @param movie adds movie to database
   * @throws SQLException exception
   * A method to add a movie to database
   */
  void addMovie(Movie movie) throws SQLException; 
  /**
   * @param movie the movie to be removed
   * @throws SQLException exception
   * A method to remove a movie form database
   */
  void removeMovie(Movie movie) throws SQLException;

  /**
   * @return an arraylist with all the movies from the database
   * @throws SQLException exception
   */
  ArrayList<Movie> getAllMovies() throws SQLException;

  /**
   * @param expirationDate the date the rental expires
   * @param user the user
   * @param rentedMovie the rented movie
   * @throws SQLException exception
   * A method to add a rental to database
   */
  void addRental(java.util.Date expirationDate, User user, Movie rentedMovie) throws SQLException;
  /**
   * @return an arraylist with all the rentals from the database
   * @throws SQLException exception
   */
  ArrayList<Rental> getAllRentals() throws SQLException;

  /**
   * @param title the title
   * @return a movie object
   * @throws SQLException exception
   */
  Movie getMovieWithTitle(String title) throws SQLException;

  /**
   * @param userName the username
   * @return a user object
   * @throws SQLException exception
   */
  User getUser(String userName) throws SQLException;

  /**
   * @return Array list of person
   * @throws SQLException exception
   */
  ArrayList<Person> getAllPersons() throws SQLException;

  /**
   * @param title the title
   * @param star the rating
   * @param comment the comment
   * @param user the username
   * @throws SQLException
   * A method to add a review to database
   */
  void addReview(String title, int star, String comment, String user) throws SQLException;

  /**
   * @param avgRating the average rating
   * @param title the title
   * @throws SQLException exception
   *      A method to update the average rating of a movie
   */
  void updateAvgRating(double avgRating, String title) throws SQLException;

  /**
   * @param title the title of the movie
   * @return an array list with the reviews for the movie
   * @throws SQLException exception
   */
  ArrayList<Review> getAllReviewForMovie(String title) throws SQLException;

  /**
   * @param title the title
   * @param username the username
   * @throws SQLException exception
   * A method to remove a rental from database.
   */
  void removeRental(String title, String username) throws SQLException;
}
