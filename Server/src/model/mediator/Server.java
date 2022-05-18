package model.mediator;

import model.domain.Movie;
import model.domain.Rental;
import model.domain.Review;
import model.domain.User;

import java.util.ArrayList;
import java.util.Date;

public class Server implements RemoteModel
{

  private ModelManager modelManager;

  public Server()
  {
    this.modelManager = new ModelManager();
  }
  /**
   * @return the top 10 top-rated movies
   */
  @Override public ArrayList<Movie> getTop10TopRatedMovies()
  {
    return modelManager.getTop10TopRatedMovies();
  }

  /**
   * @return the trending movies
   */
  @Override public ArrayList<Movie> getTrendingMovies()
  {
    return modelManager.getTrendingMovies();
  }

  /**
   * @return all movies
   */
  @Override public ArrayList<Movie> getAllMovies()
  {
    return modelManager.getAllMovies();
  }

  /**
   * @param name        the name of the person
   * @param username    the username of the person
   * @param password    the password of the person
   * @param phoneNumber the phone number of the person
   * @param age         the age of the person
   * @param type        the type of the person (user, admin)
   *                    A method to add a person
   */
  @Override public void addPerson(String name, String username, String password,
      String phoneNumber, int age, String type)
  {

  }

  /**
   * @param movie the movie to be added
   */
  @Override public void addMovie(Movie movie)
  {
    modelManager.addMovie(movie);
  }

  /**
   * @param movie the movie to be removed
   */
  @Override public void removeMovie(Movie movie)
  {
    modelManager.removeMovie(movie);
  }

  /**
   * @param title the title of the movie
   * @param user  the user
   *              A method to rent a movie
   */
  @Override public void rentMovie(String title, User user)
  {
    modelManager.rentMovie(title, user);
  }

  /**
   * @param movie          the movie to be rented
   * @param expirationDate the date the rental expires
   * @param user           the user renting
   *                       A method to add a rental
   */
  @Override public void addRental(Movie movie, Date expirationDate, User user)
  {
    modelManager.addRental(movie,expirationDate,user);
  }

  /**
   * @return all rentals
   */
  @Override public ArrayList<Rental> getAllRentals()
  {
    return modelManager.getAllRentals();
  }

  /**
   * @param username the username
   * @param password the password
   *                 A method to login
   */
  @Override public void login(String username, String password)
  {
    modelManager.login(username, password);
  }

  /**
   * @param name        the name of the user
   * @param userName    the username of the user
   * @param password    the password of the user
   * @param phoneNumber the phone number of the user
   * @param age         the age of the user
   *                    A method to create a user
   */
  @Override public void createUser(String name, String userName,
      String password, String phoneNumber, String age)
  {
    modelManager.createUser(name, userName, password, phoneNumber, age);
  }

  /**
   * @param name     the name of the person
   * @param password the password of the person
   * @return the type of the person (user, admin)
   */
  @Override public String checkPerson(String name, String password)
  {
    return modelManager.checkPerson(name, password);
  }

  /**
   * @param title the title of the movie
   * @param user  the user
   *              A method to cancel a rental
   */
  @Override public void cancelRental(String title, User user)
  {
    modelManager.cancelRental(title, user);
  }

  /**
   * @param username the username of the user
   * @return the user
   */
  @Override public User getUser(String username)
  {
    return modelManager.getUser(username);
  }

  /**
   * @param title the title of the movie
   * @return the movie with that title (title is unique)
   */
  @Override public Movie getMovieWithTitle(String title)
  {
    return modelManager.getMovieWithTitle(title);
  }

  /**
   * @param title the title of the movie
   * @return a boolean value
   */
  @Override public boolean validateAddMovie(String title)
  {
    return modelManager.validateAddMovie(title);
  }

  /**
   * @param user the user
   * @return the user's rentals
   */
  @Override public ArrayList<Rental> getRentalsWithUser(User user)
  {
    return modelManager.getRentalsWithUser(user);
  }

  /**
   * @param movie the movie
   * @return the movie's comments
   */
  @Override public ArrayList<String> getCommentsForMovie(Movie movie)
  {
    return modelManager.getCommentsForMovie(movie);
  }

  /**
   * @param comment the comment
   * @param rating  the rating
   * @return Moderation of the comment
   */
  @Override public void leaveReview(String comment, int rating, String title)
  {
    modelManager.leaveReview(comment, rating, title);
  }

  @Override public ArrayList<Movie> getMovieLike(String title)
  {
    return modelManager.getMovieLike(title);
  }

}
