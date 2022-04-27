package model;

import java.util.ArrayList;

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
   * @return arraylist of rentals
   */
  public ArrayList<Rental> getAllRentals()
  {
    return rentals;
  }


}
