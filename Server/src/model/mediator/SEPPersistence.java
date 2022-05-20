package model.mediator;

import model.domain.Movie;
import model.domain.Person;
import model.domain.Rental;
import model.domain.User;

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
   *                    adds user to database
   * @throws SQLException exception
   */
  void addUser(String name, String phoneNumber, String userName, String password, int age) throws SQLException; //update Person (maybe user and admin too)to match database

  /**
   * @param movie adds movie to database
   * @throws SQLException exception
   */
  void addMovie(Movie movie) throws SQLException; // update movie to match database
  /**
   * @param movie the movie to be removed
   * @throws SQLException exception
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

  ArrayList<Person> getAllPersons() throws SQLException;
}
