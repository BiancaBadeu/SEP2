package model.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents a list of rentals.
 */
public class RentalList
{
  private ArrayList<Rental> rentals;

  /**
   * Constructor for RentalList.
   */
  public RentalList()
  {
    this.rentals = new ArrayList<>();
  }
  /**
   * //@param user
   * @param movie
   * @param expirationDate
   * rental is added to the rental List
   */
  public void addRental(Movie movie, Date expirationDate){
    Rental rented = new Rental(expirationDate,movie);
    rentals.add(rented);
  }

  /**
   * @return arraylist of rentals
   */
  public ArrayList<Rental> getAllRentals()
  {
    return rentals;
  }
/*
-- for the next sprint :)
  public ArrayList<Rental> getRentalsWithUser(User user){
    ArrayList<Rental> userRentals = new ArrayList<>();
    for (int i = 0; i<rentals.size();i++)
    {
      if (rentals.get(i).getUser().equals(user))
      {userRentals.add(rentals.get(i));}
    }
    return userRentals;
  }

  public ArrayList<Rental> getRentalsWithMovie(Movie movie){
    ArrayList<Rental> movieRentals = new ArrayList<>();
    for (int i = 0; i<rentals.size();i++)
    {
      if (rentals.get(i).getRentedMovie().equals(movie))
      {movieRentals.add(rentals.get(i));}
    }
    return movieRentals;
  }
*/

}
