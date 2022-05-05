package model;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * a class representing a model interface
 */
public interface Model extends UnnamedPropertyChangeSubject
{
  ArrayList<Movie> getTop10TopRatedMovies();

  void addPerson(String name, String username, String password, String phoneNumber, String dob, String type);
  void addMovie(Movie movie);
  void addListener(PropertyChangeListener listener);

  void rentMovie(String title, String averageRating);
  void login(String username, String password);
  void createUser(String name, String userName, String password, String phoneNumber, String dob);
}

