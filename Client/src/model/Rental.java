package model;

import java.util.Date;

/**
 * This class represents a rental.
 */
public class Rental
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
  public Rental(Date expirationDate, User user, Movie rentedMovie){
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
}
