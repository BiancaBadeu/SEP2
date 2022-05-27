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
   * @throws RemoteException exception
   * @throws AlreadyBoundException exception
   */
  void startServer() throws RemoteException, AlreadyBoundException;

  /**
   * @return an array list containing the movies that are not rented
   * @throws RemoteException exception
   */
  ArrayList<Movie> getNotRentedMovies() throws RemoteException;

  /**
   * @param title the title of the movie
   * @return a boolean true if the movie is rented, false if it isn't
   * @throws RemoteException exception
   */
  boolean checkMovieIsRented(String title) throws RemoteException;

  /**
   * @return the top 10 top-rated movies
   * @throws RemoteException exception
   */
  ArrayList<Movie> getTop10TopRatedMovies()throws RemoteException;
  /**
   * @return the trending movies
   * @throws RemoteException exception
   */
  ArrayList<Movie> getTrendingMovies()throws RemoteException;
  /**
   * @return all movies
   * @throws RemoteException exception
   */
  ArrayList<Movie> getAllMovies()throws RemoteException;
  /**
   * @param name the name of the person
   * @param username the username of the person
   * @param password the password of the person
   * @param phoneNumber the phone number of the person
   * @param age the age of the person
   * @param type the type of the person (user, admin)
   * @throws RemoteException exception
   *             A method to add a person
   */
  void addPerson(String name, String username, String password, String phoneNumber, int age, String type)throws RemoteException;
  /**
   * @param movie the movie to be added
   * @throws RemoteException exception
   *             A method to add a movie
   */
  void addMovie(Movie movie)throws RemoteException;
  /**
   * @param movie the movie to be removed
   * @throws RemoteException exception
   *              A method to remove a movie
   */
  void removeMovie(Movie movie)throws RemoteException;
  /**
   * @param title the title of the movie
   * @param user the user
   * @throws RemoteException exception
   *             A method to rent a movie
   */
  void rentMovie(String title, User user)throws RemoteException;
  /**
   * @param movie the movie to be rented
   * @param expirationDate the date the rental expires
   * @param user the user renting
   * @throws RemoteException exception
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
   * @throws RemoteException exception
   *                 A method to login
   */
  void login(String username, String password)throws RemoteException;
  /**
   * @param name the name of the user
   * @param userName the username of the user
   * @param password the password of the user
   * @param phoneNumber the phone number of the user
   * @param age the age of the user
   * @throws RemoteException exception
   *            A method to create a user
   */
  void createUser(String name, String userName, String password, String phoneNumber, String age)throws RemoteException;
  /**
   * @param name the name of the person
   * @param password the password of the person
   * @return the type of the person (user, admin)
   * @throws RemoteException exception
   */
  String checkPerson(String name, String password)throws RemoteException;
  /**
   * @param title the title of the movie
   * @param username the username
   * @throws RemoteException exception
   *             A method to cancel a rental
   */
  void cancelRental(String title, String username)throws RemoteException;
  /**
   * @param username the username of the user
   * @return the user
   * @throws RemoteException exception
   */
  User getUser(String username)throws RemoteException;
  /**
   * @param title the title of the movie
   * @return the movie with that title (title is unique)
   * @throws RemoteException exception
   */
  Movie getMovieWithTitle(String title)throws RemoteException;
  /**
   * @param title the title of the movie
   * @return a boolean value
   * @throws RemoteException exception
   */
  boolean validateAddMovie(String title)throws RemoteException;

  /**
   * @param username the username
   * @return the user's rentals
   * @throws RemoteException exception
   */
  ArrayList<Rental> getRentalsWithUser(String username)throws RemoteException;

  /**
   * @param comment the comment
   * @param rating the rating
   * @param title the title
   * @throws RemoteException exception
   *               A method to leave a review
   */
  void leaveReview(String comment, int rating, String title, String user)throws RemoteException;

  /**
   * @param title the title of the movie
   * @return an array list with the movies that contain that title
   *@throws RemoteException exception
   */
  ArrayList<Movie> getMovieLike(String title) throws RemoteException;

  /**
   * @param genre the genre
   * @return an array list with the movies that are from that genre
   * @throws RemoteException exception
   */
  ArrayList<Movie> getMoviesWithGenre(String genre) throws RemoteException;

  /**
   * @param movie the movie
   * @return the movie's comments
   * @throws RemoteException exception
   */
  ArrayList<Review> getReviewsForMovie(Movie movie) throws RemoteException;
}
