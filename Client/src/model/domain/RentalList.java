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
  public void addRental(Movie movie, Date expirationDate, User user){
    Rental rented = new Rental(expirationDate,movie,user);
    rentals.add(rented);
  }

  public void removeRental(String title, User user){

    for (int i = 0; i<rentals.size();i++)
    {
      if (rentals.get(i).getRentedMovie().getTitle().equals(title) && rentals.get(i).getUser().equals(user))
      {
        rentals.remove(i);
      }
    }
  }

  /**
   * @return arraylist of rentals
   * This method returns all the rentals in the list.
   */
  public ArrayList<Rental> getAllRentals()
  {
    return rentals;
  }

  /**
   * @param user
   * @return All the rentals of the given user in the list
   *This method returns all the rentals in the list that have the given user.
   */
  public ArrayList<Rental> getRentalsWithUser(User user){
    ArrayList<Rental> userRentals = new ArrayList<>();
    for (int i = 0; i<rentals.size();i++)
    {
      if (rentals.get(i).getUser().equals(user))
      {userRentals.add(rentals.get(i));}
    }
    return userRentals;
  }

  /**
   * @param movie
   * @return All the rentals of the given movie in the list
   * This method returns all the rentals in the list that have the given movie.
   */
  public ArrayList<Rental> getRentalsWithMovie(Movie movie){
    ArrayList<Rental> movieRentals = new ArrayList<>();
    for (int i = 0; i<rentals.size();i++)
    {
      if (rentals.get(i).getRentedMovie().equals(movie))
      {movieRentals.add(rentals.get(i));}
    }
    return movieRentals;
  }


}
