package model.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * This class represents a rental.
 */
public class Rental implements Serializable
{
  private Date expirationDate;
  private User user;
  private Movie rentedMovie;

  /**
   * @param expirationDate the expiration date of the rental
   * @param user the user who rented the movie
   * @param rentedMovie the movie rented
   *
   * Constructor for the rental class.
   */
  public Rental(Date expirationDate, Movie rentedMovie, User user){
    this.expirationDate = expirationDate;
    this.user = user;
    this.rentedMovie = rentedMovie;
  }

  /**
   * @return the expiration date of the rental
   *
   * Getter for the expiration date of the rental.
   */
  public Date getExpirationDate(){
    return expirationDate;
  }

  /**
   * @return the user who rented the movie
   *
   * Getter for the user who rented the movie.
   */
  public User getUser(){
    return user;
  }

  /**
   * @return the movie rented
   *
   * Getter for the movie rented.
   */
  public Movie getRentedMovie(){
    return rentedMovie;
  }

  /**
   * @param expirationDate the expiration date
   * Setter for the expiration date of the rental
   */
  public void setExpirationDate(Date expirationDate)
  {
    if(expirationDate == null)
    {
      throw new IllegalArgumentException("Expiration date cannot be null");
    }
    else
      this.expirationDate = expirationDate;
  }

  /**
   * @param user the user
   * Setter for the user of the rental
   */
  public void setUser(User user)
  {
    if(user == null)
    {
      throw new IllegalArgumentException("User cannot be null");
    }
    else
    this.user = user;
  }

  /**
   * @return the username of the user
   * Getter for the username of the rental
   */
  public String getUserName(){
    return user.getUserName();
  }

  /**
   * @param userName the username
   * Setter for the username of the rental
   */
  public void setUserName(String userName){
    user.setUserName(userName);
  }

  /**
   * @param rentedMovie the rented movie
   * Setter for the rented movie of the rental
   */
  public void setRentedMovie(Movie rentedMovie)
  {
    if(rentedMovie == null)
    {
      throw new IllegalArgumentException("The movie cannot be null");
    }
    else
      this.rentedMovie = rentedMovie;
  }

  /**
   * @return a string representation of the rental
   */
  @Override public String toString()
  {
    return "Rental{" + "expirationDate=" + expirationDate + ", user=" + user
        + ", rentedMovie=" + rentedMovie + '}';
  }
}
