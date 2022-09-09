package model.mediator;

import model.domain.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public interface RemoteDatabase extends Remote
{
  void startDatabaseConnection()throws RemoteException;
  void getAllInfo()throws RemoteException;
  ArrayList<Movie> getMoviesWithGenre(String genre)throws RemoteException;
  ArrayList<Movie> getMovieLike(String title)throws RemoteException;
  void leaveReview(String comment, int rating, String title, String user)throws RemoteException;
  ArrayList<Review> getReviewsForMovie(Movie movie)throws RemoteException;
  ArrayList<Rental> getRentalsWithUser(String username)throws RemoteException;
  boolean validateAddMovie(String title)throws RemoteException;
  Movie getMovieWithTitle(String title)throws RemoteException;
  User getUser(String username)throws RemoteException;
  void cancelRental(String title, String username)throws RemoteException;
  String checkPerson(String name, String password)throws RemoteException;
  void createUser(String name, String userName, String password, String phoneNumber, String age)throws RemoteException;
  void login(String username, String password)throws RemoteException;
  ArrayList<Rental> getAllRentals()throws RemoteException;
  void addRental(Movie movie, Date expirationDate, User user)throws RemoteException;
  void rentMovie(String title, User user)throws RemoteException;
  void removeMovie(Movie movie)throws RemoteException;
  void addMovie(Movie movie)throws RemoteException;
  void addPerson(String name, String username, String password, String phoneNumber, int age, String type)throws RemoteException;
  ArrayList<Movie> getAllMovies()throws RemoteException;
  ArrayList<Movie> getTrendingMovies()throws RemoteException;
  ArrayList<Movie> getTop10TopRatedMovies()throws RemoteException;
  boolean checkMovieIsRented(String title)throws RemoteException;
  ArrayList<Movie> getNotRentedMovies()throws RemoteException;
  ArrayList<Person> getAllPersons() throws RemoteException;
}
