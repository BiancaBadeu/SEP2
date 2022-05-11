package model.mediator;

import model.domain.Movie;
import model.domain.Rental;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SEPPersistence
{

  void addUser(String name, String phoneNumber, String userName, String password, Date dob) throws SQLException; //update Person (maybe user and admin too)to match database
  void addMovie(Movie movie) throws SQLException; // update movie to match database
  ArrayList<Movie> getTop10TopRatedMovies() throws SQLException;
  ArrayList<Movie> getAllMovies() throws SQLException;
  void addRental(Date expirationDate, String userName, int movieID) throws SQLException;
  ArrayList<Rental> getAllRentals() throws SQLException;
}
