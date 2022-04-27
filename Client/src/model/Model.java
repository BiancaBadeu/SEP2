package model;

import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface Model extends UnnamedPropertyChangeSubject
{
  ArrayList<Movie> getTop10TopRatedMovies();

  @Override void addListener(PropertyChangeListener listener);

  void rentMovie(String title, String averageRating);
}
