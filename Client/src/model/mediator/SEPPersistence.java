package model.mediator;

import model.domain.Movie;
import model.domain.Rental;

import java.sql.Date;
import java.sql.SQLException;
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
   * @param dob         the date of birth of the user
   *                    adds user to database
   * @throws SQLException
   */
  void addUser(String name, String phoneNumber, String userName, String password, Date dob) throws SQLException; //update Person (maybe user and admin too)to match database

  /**
   * @param movie adds movie to database
   * @throws SQLException
   */
  void addMovie(Movie movie) throws SQLException; // update movie to match database

  /**
   * @return an arraylist with the top 10 highest rated movies from the database
   * @throws SQLException
   */
  ArrayList<Movie> getTop10TopRatedMovies() throws SQLException;

  /**
   * @return an arraylist with all the movies from the database
   * @throws SQLException
   */
  ArrayList<Movie> getAllMovies() throws SQLException;

  /**
   * @param expirationDate
   * @param userName
   * @param movieID
   * adds a rental to the database
   * @throws SQLException
   */
  void addRental(Date expirationDate, String userName, int movieID) throws SQLException;

  /**
   * @return an arraylist with all the rentals from the database
   * @throws SQLException
   */
  ArrayList<Rental> getAllRentals() throws SQLException;
}
