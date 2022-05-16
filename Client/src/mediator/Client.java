package mediator;

import model.Model;
import model.Movie;
import model.Rental;
import model.User;

import java.beans.PropertyChangeListener;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Date;

public class Client implements Model
{
  private RemoteModel remoteModel;

  public Client()
  {
    try
    {
      remoteModel = (RemoteModel) Naming.lookup("rmi://localhost:1099/Case");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  @Override public ArrayList<Movie> getTop10TopRatedMovies()
  {
    return null;
  }

  @Override public ArrayList<Movie> getTrendingMovies()
  {
    return null;
  }

  @Override public ArrayList<Movie> getAllMovies()
  {
    return null;
  }

  @Override public void addPerson(String name, String username, String password,
      String phoneNumber, int age, String type)
  {

  }

  @Override public void addMovie(Movie movie)
  {

  }

  @Override public void removeMovie(Movie movie)
  {

  }

  @Override public void rentMovie(String title, User user)
  {

  }

  @Override public void addListener(PropertyChangeListener listener)
  {

  }

  @Override public void addRental(Movie movie, Date expirationDate, User user)
  {

  }

  @Override public ArrayList<Rental> getAllRentals()
  {
    return null;
  }

  @Override public void login(String username, String password)
  {

  }

  @Override public void createUser(String name, String userName,
      String password, String phoneNumber, String age)
  {

  }

  @Override public String checkPerson(String name, String password)
  {
    return null;
  }

  @Override public void cancelRental(String title, User user)
  {

  }

  @Override public User getUser(String username)
  {
    return null;
  }
}
