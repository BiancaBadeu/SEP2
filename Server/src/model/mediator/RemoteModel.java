package model.mediator;

import model.domain.*;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

/**
 * A class representing the remote model. Extends java.rmi.Remote;
 */
public interface RemoteModel extends Remote
{

  /**
   * A method to start the server
   */
  void startServer() throws RemoteException, AlreadyBoundException;

  /**
   * @param title the title of the movie
   * @return a boolean true if the movie is rented, false if it isn't
   */
  boolean checkMovieIsRented(String title) throws RemoteException;

  /**
   * @return the top 10 top-rated movies
   */
  ArrayList<Movie> getTop10TopRatedMovies()throws RemoteException;
  /**
   * @return the trending movies
   */
  ArrayList<Movie> getTrendingMovies()throws RemoteException;
  /**
   * @return all movies
   */
  ArrayList<Movie> getAllMovies()throws RemoteException;
  /**
   * @param name the name of the person
   * @param username the username of the person
   * @param password the password of the person
   * @param phoneNumber the phone number of the person
   * @param age the age of the person
   * @param type the type of the person (user, admin)
   *             A method to add a person
   */
  void addPerson(String name, String username, String password, String phoneNumber, int age, String type)throws RemoteException;
  /**
   * @param movie the movie to be added
   */
  void addMovie(Movie movie)throws RemoteException;
  /**
   * @param movie the movie to be removed
   */
  void removeMovie(Movie movie)throws RemoteException;
  /**
   * @param title the title of the movie
   * @param user the user
   *             A method to rent a movie
   */
  void rentMovie(String title, User user)throws RemoteException;
  /**
   * @param movie the movie to be rented
   * @param expirationDate the date the rental expires
   * @param user the user renting
   *             A method to add a rental
   */
  void addRental(Movie movie, Date expirationDate, User user)throws RemoteException;
  /**
   * @return all rentals
   */
  ArrayList<Rental> getAllRentals()throws RemoteException;
  /**
   * @param username the username
   * @param password the password
   *                 A method to login
   */
  void login(String username, String password)throws RemoteException;
  /**
   * @param name the name of the user
   * @param userName the username of the user
   * @param password the password of the user
   * @param phoneNumber the phone number of the user
   * @param age the age of the user
   *            A method to create a user
   */
  void createUser(String name, String userName, String password, String phoneNumber, String age)throws RemoteException;
  /**
   * @param name the name of the person
   * @param password the password of the person
   * @return the type of the person (user, admin)
   */
  String checkPerson(String name, String password)throws RemoteException;
  /**
   * @param title the title of the movie
   * @param user the user
   *             A method to cancel a rental
   */
  void cancelRental(String title, User user)throws RemoteException;
  /**
   * @param username the username of the user
   * @return the user
   */
  User getUser(String username)throws RemoteException;
  /**
   * @param title the title of the movie
   * @return the movie with that title (title is unique)
   */
  Movie getMovieWithTitle(String title)throws RemoteException;
  /**
   * @param title the title of the movie
   * @return a boolean value
   */
  boolean validateAddMovie(String title)throws RemoteException;

  /**
   * @param user the user
   * @return the user's rentals
   */
  ArrayList<Rental> getRentalsWithUser(User user)throws RemoteException;



  /**
   * @param comment the comment
   * @param rating the rating
   * @return Moderation of the comment
   */
  void leaveReview(String comment, int rating, String title)throws RemoteException;


  ArrayList<Movie> getMovieLike(String title)throws RemoteException;

  /**
 * @param movie the movie
 * @return the movie's comments
 */
  ArrayList<String> getCommentsForMovie(Movie movie)throws RemoteException;
}
