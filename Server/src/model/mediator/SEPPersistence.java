package model.mediator;

import model.domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

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
   *                    adds user to database
   * @throws SQLException exception
   */
  void addUser(String name, String phoneNumber, String userName, String password, int age) throws SQLException;

  /**
   * @param movie adds movie to database
   * @throws SQLException exception
   * adds a movie to database
   */
  void addMovie(Movie movie) throws SQLException; 
  /**
   * @param movie the movie to be removed
   * @throws SQLException exception
   * removes a movie form database
   */
  void removeMovie(Movie movie) throws SQLException;
  /**
   * @return an arraylist with the top 10 highest rated movies from the database
   * @throws SQLException exception
   */
  ArrayList<Movie> getTop10TopRatedMovies() throws SQLException;

  /**
   * @return an arraylist with all the movies from the database
   * @throws SQLException exception
   */
  ArrayList<Movie> getAllMovies() throws SQLException;

  /**
   * @param expirationDate the date the renatl expires
   * @param user the user
   * @param rentedMovie the rented movie
   * @throws SQLException exception
   * adds rental to database
   */
  void addRental(java.util.Date expirationDate, User user, Movie rentedMovie) throws SQLException;
  /**
   * @return an arraylist with all the rentals from the database
   * @throws SQLException exception
   */
  ArrayList<Rental> getAllRentals() throws SQLException;
  /**
   * @param user the user
   * @return an arraylist with all the rentals of the user from the database
   * @throws SQLException exception
   */
  ArrayList<Rental> getRentalsWithUser(User user) throws SQLException;
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
   * @throws SQLException
   */
  ArrayList<Person> getAllPersons() throws SQLException;

  /**
   * @param title
   * @param star
   * @param comment
   * @param user
   * @throws SQLException
   * adds a review to database
   */
  void addReview(String title, int star, String comment, String user) throws SQLException;

  /**
   * @param avgRating the average rating
   * @param title the title
   * @throws SQLException exception
   */
  void updateAvgRating(double avgRating, String title) throws SQLException;


  ArrayList<Review> getAllReviewForMovie(String title) throws SQLException;

  /**
   * @param title the title
   * @param username the usename
   * @throws SQLException exception
   * removes rental from database.
   */
  void removeRental(String title, String username) throws SQLException;
}
