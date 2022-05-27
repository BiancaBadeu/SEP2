import model.domain.Movie;
import model.domain.Rental;
import model.domain.Review;
import model.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest
{

  private Date date;
  private Movie movie;
  private User user;
  private Rental rental;

  @BeforeEach void setUp()
  {

    date = new Date();
     movie = new Movie("Test The Movie", "Test", 0,
        "Test", 0, 0, "Test", new ArrayList<Review>());
     user = new User("Test", "Test", "Test test test",
        "12345678", 0);
     rental = new Rental(date, movie, user);
  }

  @AfterEach void tearDown()
  {
  }

  @Test void setInvalidDate()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      rental.setExpirationDate(date);
    });
  }

  @Test void setInvalidMovie()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      rental.setRentedMovie(movie);
    });
  }

  @Test void setInvalidUser()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      rental.setUser(user);
    });
  }

  @Test void setNullDate()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      rental.setExpirationDate(null);
    });
  }

  @Test void setNullMovie()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      rental.setRentedMovie(null);
    });
  }

  @Test void setNullUser()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      rental.setUser(null);
   });
  }


}