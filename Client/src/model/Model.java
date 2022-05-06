package model;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;

/**
 * a class representing a model interface
 */
public interface Model extends UnnamedPropertyChangeSubject
{
  ArrayList<Movie> getTop10TopRatedMovies();
  ArrayList<Movie> getAllMovies();
  void addPerson(String name, String username, String password, String phoneNumber, String dob, String type);
  void addMovie(Movie movie);
  void rentMovie(String title);

  void addListener(PropertyChangeListener listener);

  void addRental(Movie movie, Date expirationDate);
  ArrayList<Rental> getAllRentals();
 /*
  --For the next sprint :)
  ArrayList<Rental> getRentalsWithUser(User user);
  ArrayList<Rental> getRentalsWithMovie(Movie movie);
*/
  void login(String username, String password);
  void createUser(String name, String userName, String password, String phoneNumber, String dob);
}

