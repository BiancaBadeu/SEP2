import model.domain.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RentalListTest
{

  private RentalList rentalList;
  private Movie movie;
  private Date date;
  private Person user;

  @BeforeEach void setUp()
  {
    rentalList = new RentalList();
    movie = new Movie("movie", "movie", 1, "2dsd", 5, 2003, "movie",
        new ArrayList<>());
    date = new Date();
    user= new User("name", "eeue","jjerfe", "12345678", 19 );


  }

  @AfterEach void tearDown()
  {
  }

  @Test void testAddRental()
  {
    rentalList.addRental(movie, date, (User) user);
    assertEquals(1, rentalList.getAllRentals().size());
  }

  @Test void removeRental()
  {
    rentalList.addRental(movie, date, (User) user);
    rentalList.removeRental(movie.getTitle(), user.getUserName());
    assertEquals(0, rentalList.getAllRentals().size());
  }

  @Test void addInvalidRental(){


      assertThrows(IllegalArgumentException.class, () -> {
        rentalList.addRental(null, null, null);

      });

  }
}