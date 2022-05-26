package model.mediator;
import model.domain.Movie;
import model.domain.Rental;
import model.domain.Review;
import model.domain.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * A class representing a model manager. Implements the model
 * @see Model ;
 */
public class ModelManager implements Model
{
  private Client client;

  /**
   * A 0 argument constructor for the model manager creating a new client
   */
  public ModelManager()
  {
    this.client = new Client();
  }

  /**
   * @param name        the person's name to be added
   * @param username    the person's username to be added
   * @param password    the person's password to be added
   * @param phoneNumber the person's phone number to be added
   * @param age         the person's age to be added
   * @param type        the person's type to be added
   *  A method to add a person to the person list
   */
  public void addPerson(String name, String username, String password, String phoneNumber, int age, String type)
  {
    client.addPerson(name, username, password, phoneNumber, age, type);
  }

  /**
   * @return an array list containing the movies that are not rented
   */
  public ArrayList<Movie> getNotRentedMovies()
  {
    return client.getNotRentedMovies();
  }

  /**
   * @param title the title of the movie
   * @return a boolean true if the movie is rented, false if it isn't
   */
  public boolean checkMovieIsRented(String title)
  {
    return client.checkMovieIsRented(title);
  }

  /**
   * @param movie the movie to be added to the movie list
   *  A method to add a movie to the movie list
   */
  public void addMovie(Movie movie)
  {
    client.addMovie(movie);
  }

  /**
   * @param movie the movie to be removed
   *  A method to remove a movie from the movie list
   */
  @Override public void removeMovie(Movie movie)
  {
    client.removeMovie(movie);
  }

  /**
   * @return the top 10 movies with the highest average ratings
   * A method to return the top 10 movies with the highest average ratings
   */
  @Override public ArrayList<Movie> getTop10TopRatedMovies()
  {
    return client.getTop10TopRatedMovies();
  }

  /**
   * @return the trending movies
   * A method to return the trending movies
   */
  @Override public ArrayList<Movie> getTrendingMovies()
  {
    return client.getTrendingMovies();
  }

  /**
   * @return the movie list
   * A method to return the movie list
   */
  public ArrayList<Movie> getAllMovies()
  {
      return client.getAllMovies();
  }

  /**
   * @param movie the movie to be rented
   * @param expirationDate the expiration date of the rental
   *    A method to add a rental to the rental list
   */
  @Override public void addRental(Movie movie, Date expirationDate, User user)
  {
    client.addRental(movie, expirationDate, user);
  }

  /**
   * @return all rentals
   * A method to return all rentals
   */
  @Override public ArrayList<Rental> getAllRentals()
  {
    return client.getAllRentals();
  }

  /**
   * @param title the title of the movie
   * @param user  the user
   *
   *  A method to remove a rental from the rental list
   */
  @Override public void cancelRental(String title, User user)
  {
    client.cancelRental(title, user);
  }

/*
--For the next sprint :)
  @Override public ArrayList<Rental> getRentalsWithUser(User user)
  {
    return rentalList.getRentalsWithUser(user);
  }

  @Override public ArrayList<Rental> getRentalsWithMovie(Movie movie)
  {
    return rentalList.getRentalsWithMovie(movie);
  }
*/

  /**
   * @param title a String variable representing the title of a movie
   * @param user the user
   *  A method to check if the user can rent the movie
   */
  @Override public void rentMovie(String title, User user)
  {
    client.rentMovie(title,user);
  }

  /**
   * @param username string variable
   * @param password string variable
   * Checks if the username exists and has a matching password
   */
  @Override public void login(String username, String password)
  {
    client.login(username, password);
  }

  /**
   * @param name        a String variable representing the name of the user
   * @param userName    a String variable representing the username chosen
   * @param password    a String variable representing the password chosen
   * @param phoneNumber a String variable representing the phone number of the user
   * @param age         a String variable representing the age of the user
   *
   *  A method to create a new User and add it to the person list
   */
  @Override public void createUser(String name, String userName, String password, String phoneNumber, String age)
  {
    client.createUser(name, userName, password, phoneNumber, age);
  }

  /**
   * @param userName the username of the person
   * @param password the password of the person
   * @return a String variable, the type of the person (admin, user) or null in case it does not found the person
   */
  @Override public String checkPerson(String userName, String password)
  {
    return client.checkPerson(userName, password);
  }

  /**
   * @param userName the username
   * @return a User variable
   *
   * A method to get the user by username (username is unique). Returns null if it does not exist
   */
  @Override public User getUser(String userName)
  {
    return client.getUser(userName);
  }

  /**
   * @param title the title of the movie to be validated
   * @return a boolean variable, true if the movie title is not in the movie list, false otherwise
   */
  @Override public boolean validateAddMovie(String title)
  {
    return client.validateAddMovie(title);
  }

  /**
   * @param user the user
   * @return The users rentals
   */
  @Override public ArrayList<Rental> getRentalsWithUser(User user)
  {
    return client.getRentalsWithUser(user);
  }

  /**
   * @param movie a movie
   * @return the comments for a given movie
   */
  @Override public ArrayList<Review> getReviewsForMovie(Movie movie)
  {
    return client.getReviewsForMovie(movie);
  }

  /**
   * @param comment a comment
   * @param rating  a rating
   * @param title   title of the movie
   * @param user the username
   *                A method that creates a review for a movie
   */
  @Override public void leaveReview(String comment, int rating, String title, String user){

    client.leaveReview(comment, rating, title, user);
  }
}
