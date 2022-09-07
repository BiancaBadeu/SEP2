package model.mediator;

import model.domain.*;

import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * A class that represents the server. Implements the Remote model interface
 * @see RemoteModel
 */
public class Server implements RemoteModel
{

  private Model model;
  private RemoteDatabase remoteDatabase;

  public Server()
  {
    try
    {
      remoteDatabase = (RemoteDatabase) Naming.lookup("rmi://localhost:1098/Database");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @param model the model
   *     A constructor for the server
   */
  public Server(Model model)
  {
    this.model = model;
  }

  /**
   * @throws RemoteException  exception
   * @throws AlreadyBoundException exception
   *            A method to start the server
   */
  public void startServer () throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1097);
    UnicastRemoteObject.exportObject(this,0);
    registry.bind("Server", this);

    try
    {
      model.getAllInfo();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @return an array list containing the movies that are not rented
   * @throws RemoteException  exception
   */
  @Override public ArrayList<Movie> getNotRentedMovies() throws RemoteException
  {
    return model.getNotRentedMovies();
  }

  /**
   * @param title the title of the movie
   * @return a boolean true if the movie is rented, false if it isn't
   * @throws RemoteException  exception
   */
  public boolean checkMovieIsRented(String title) throws RemoteException
  {
    return model.checkMovieIsRented(title);
  }
    /**
     * @return the top 10 top-rated movies
     * @throws RemoteException  exception
     */
    @Override public ArrayList<Movie> getTop10TopRatedMovies() throws RemoteException
    {
    return model.getTop10TopRatedMovies();
  }

    /**
     * @return the trending movies
     * @throws RemoteException  exception
     */
    @Override public ArrayList<Movie> getTrendingMovies()  throws RemoteException
    {
    return model.getTrendingMovies();
  }

    /**
     * @return all movies
     * @throws RemoteException  exception
     */
    @Override public ArrayList<Movie> getAllMovies () throws RemoteException
    {
    return model.getAllMovies();
  }

    /**
     * @param name        the name of the person
     * @param username    the username of the person
     * @param password    the password of the person
     * @param phoneNumber the phone number of the person
     * @param age         the age of the person
     * @param type        the type of the person (user, admin)
     * @throws RemoteException  exception
     *                    A method to add a person
     */
    @Override public void addPerson (String name, String username, String
    password, String phoneNumber,int age, String type) throws RemoteException
    {
      model.addPerson(name, username, password, phoneNumber, age, type);
    }

    /**
     * @param movie the movie to be added
     * @throws RemoteException  exception
     *        A method to add a movie
     */
    @Override public void addMovie  (Movie movie) throws RemoteException
    {
      model.addMovie(movie);
    }

    /**
     * @param movie the movie to be removed
     * @throws RemoteException  exception
     *        A method to remove a movie
     */
    @Override public void removeMovie (Movie movie) throws RemoteException
    {
      model.removeMovie(movie);
    }

    /**
     * @param title the title of the movie
     * @param user  the user
     * @throws RemoteException  exception
     *              A method to rent a movie
     */
    @Override public void rentMovie (String title, User user) throws RemoteException
    {
      model.rentMovie(title, user);
    }

    /**
     * @param movie          the movie to be rented
     * @param expirationDate the date the rental expires
     * @param user           the user renting
     * @throws RemoteException  exception
     *                       A method to add a rental
     */
    @Override public void addRental (Movie movie, Date expirationDate, User user) throws RemoteException
    {
      model.addRental(movie, expirationDate, user);
    }

    /**
     * @return all rentals
     * @throws RemoteException  exception
     */
    @Override public ArrayList<Rental> getAllRentals ()  throws RemoteException
    {
    return model.getAllRentals();
  }

    /**
     * @param username the username
     * @param password the password
     * @throws RemoteException  exception
     *                 A method to login
     */
    @Override public void login (String username, String password) throws RemoteException
    {
      model.login(username, password);
    }

    /**
     * @param name        the name of the user
     * @param userName    the username of the user
     * @param password    the password of the user
     * @param phoneNumber the phone number of the user
     * @param age         the age of the user
     * @throws RemoteException  exception
     *                    A method to create a user
     */
    @Override public void createUser (String name, String userName, String
    password, String phoneNumber, String age) throws RemoteException
    {
      model.createUser(name, userName, password, phoneNumber, age);
    }

    /**
     * @param name     the name of the person
     * @param password the password of the person
     * @return the type of the person (user, admin)
     * @throws RemoteException  exception
     */
    @Override public String checkPerson (String name, String password) throws RemoteException
    {
      return model.checkPerson(name, password);
    }

    /**
     * @param title the title of the movie
     * @param username  the username
     * @throws RemoteException  exception
     *              A method to cancel a rental
     */
    @Override public void cancelRental (String title, String username) throws RemoteException
    {
      model.cancelRental(title, username);
    }

    /**
     * @param username the username of the user
     * @return the user
     * @throws RemoteException  exception
     */
    @Override public User getUser (String username) throws RemoteException
    {
      return model.getUser(username);
    }

    /**
     * @param title the title of the movie
     * @return the movie with that title (title is unique)
     * @throws RemoteException  exception
     */
    @Override public Movie getMovieWithTitle (String title) throws RemoteException
    {
      return model.getMovieWithTitle(title);
    }

    /**
     * @param title the title of the movie
     * @return a boolean value
     * @throws RemoteException  exception
     */
    @Override public boolean validateAddMovie (String title) throws RemoteException
    {
      return model.validateAddMovie(title);
    }

    /**
     * @param username the username
     * @return the user's rentals
     * @throws RemoteException  exception
     */
    @Override public ArrayList<Rental> getRentalsWithUser (String username) throws RemoteException
    {
      return model.getRentalsWithUser(username);
    }

    /**
     * @param movie the movie
     * @return the movie's comments
     * @throws RemoteException  exception
     */
    @Override public ArrayList<Review> getReviewsForMovie (Movie movie) throws RemoteException
    {
      return model.getReviewsForMovie(movie);
    }

    /**
     * @param comment the comment
     * @param rating  the rating
     * @param title the title
     * @throws RemoteException  exception
     *        A method to leave a review
     */
    @Override public void leaveReview (String comment,int rating, String title, String user) throws RemoteException
    {
      model.leaveReview(comment, rating, title, user);
    }

  /**
   * @param title the title
   * @return an array list
   * @throws RemoteException  exception
   */
    @Override public ArrayList<Movie> getMovieLike (String title) throws RemoteException
    {
      return model.getMovieLike(title);
    }

  /**
   * @param genre the genre
   * @return an array list of movies with that genre
   * @throws RemoteException exception
   */
  @Override public ArrayList<Movie> getMoviesWithGenre(String genre) throws RemoteException
  {
    return model.getMoviesWithGenre(genre);
  }

  public ArrayList<Person> getAllPersons()
  {
    return new ArrayList<>();
  }

  public void removeRental(String title, String userName)
  {
  }

  public void addUser(String name, String phoneNumber, String userName, String password, int parseInt)
  {
  }

  public void addReview(String title, int star, String comment, String user)
  {
  }
}
