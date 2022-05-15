package model;
import mediator.*;

public class ModelManager implements Model
{
  private RentalList rentals;
  private Client client;

  public ModelManager()
  {
    this.rentals = new RentalList();
  }
}
