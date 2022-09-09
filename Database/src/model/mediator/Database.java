package model.mediator;

import model.domain.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Database implements RemoteDatabase
{
  private SEPPersistence persistence;

  public Database(SEPPersistence model)
  {
    this.persistence = model;
  }

  public void startDatabaseConnection () throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1098);
    UnicastRemoteObject.exportObject(this,0);
    registry.bind("Database", this);

    persistence.getAllInfo();
  }

  @Override public void getAllInfo()
  {

  }

  @Override public ArrayList<Movie> getMoviesWithGenre(String genre)
  {
    return new ArrayList<>();
  }

  @Override public ArrayList<Movie> getMovieLike(String title)
  {
    return new ArrayList<>();
  }

  @Override public void leaveReview(String comment, int rating, String title,
      String user)
  {

  }

  @Override public ArrayList<Review> getReviewsForMovie(Movie movie)
  {
    return new ArrayList<>();
  }

  @Override public ArrayList<Rental> getRentalsWithUser(String username)
  {
    return new ArrayList<>();
  }

  @Override public boolean validateAddMovie(String title)
  {
    return true;
  }

  @Override public Movie getMovieWithTitle(String title)
  {
    return null;
  }

  @Override public User getUser(String username)
  {
    return null;
  }

  @Override public void cancelRental(String title, String username)
  {

  }

  @Override public String checkPerson(String name, String password)
  {
    return null;
  }

  @Override public void createUser(String name, String userName,
      String password, String phoneNumber, String age)
  {

  }

  @Override public void login(String username, String password)
  {

  }

  @Override public ArrayList<Rental> getAllRentals()
  {
    return new ArrayList<>();
  }

  @Override public void addRental(Movie movie, Date expirationDate, User user)
  {

  }

  @Override public void rentMovie(String title, User user)
  {

  }

  @Override public void removeMovie(Movie movie)
  {

  }

  @Override public void addMovie(Movie movie)
  {

  }

  @Override public void addPerson(String name, String username, String password,
      String phoneNumber, int age, String type)
  {

  }

  @Override public ArrayList<Movie> getAllMovies()
  {
    return new ArrayList<>();
  }

  @Override public ArrayList<Movie> getTrendingMovies()
  {
    return new ArrayList<>();
  }

  @Override public ArrayList<Movie> getTop10TopRatedMovies() throws SQLException
  {
    return persistence.getTop10RatedMovies();
  }

  @Override public boolean checkMovieIsRented(String title)
  {
    return false;
  }

  @Override public ArrayList<Movie> getNotRentedMovies()
  {
    return new ArrayList<>();
  }

  @Override public ArrayList<Person> getAllPersons()
      throws RemoteException, SQLException
  {
    return persistence.getAllPersons();
  }

}
