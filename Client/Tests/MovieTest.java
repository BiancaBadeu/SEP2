import model.domain.Movie;
import model.domain.Review;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

import java.util.ArrayList;

//import static org.junit.jupiter.api.Assertions.*;

class MovieTest
{

 private Movie movie;

 //@BeforeEach void setUp()
  {

    movie = new Movie("Test test test", "Test test test", 0,
       "Test test test", 0, 0, "Test test test", new ArrayList<Review>());
  }

// @AfterEach void tearDown()
  {
  }

  //@Test void setInvalidName()
  {
   // assertThrows(IllegalArgumentException.class, () -> {
      movie.setTitle("");
   // });
  }

 // @Test void setInvalidDescription()
  {
  //  assertThrows(IllegalArgumentException.class, () -> {
      movie.setDescription("");
  //  });
  }

 // @Test void setInvalidRating()
  {
   // assertThrows(IllegalArgumentException.class, () -> {
      movie.setAvgRating(6);
   // });
  }

 // @Test void setInvalidDirector()
  {
    //assertThrows(IllegalArgumentException.class, () -> {
      movie.setDirector("");
    //});
  }

 // @Test void setInvalidLength()
  {
   // assertThrows(IllegalArgumentException.class, () -> {
      movie.setLength(0);
   // });
  }

 // @Test void setInvalidGenre()
  {
  //  assertThrows(IllegalArgumentException.class, () -> {
      movie.setGenres("");
   // });
  }

  //@Test void setInvalidReleaseYear()
  {
   // assertThrows(IllegalArgumentException.class, () -> {
      movie.setReleaseYear(0);
   // });
  }

 // @Test void setNullName()
  {
   // assertThrows(IllegalArgumentException.class, () -> {
      movie.setTitle(null);
   // });
  }

//  @Test void setNullDescription()
  {
  //  assertThrows(IllegalArgumentException.class, () -> {
      movie.setDescription(null);
  //  });
  }

 // @Test void setNullDirector()
  {
  //  assertThrows(IllegalArgumentException.class, () -> {
      movie.setDirector(null);
  //  });
  }

 // @Test void setNullGenres()
  {
 //   assertThrows(IllegalArgumentException.class, () -> {
      movie.setGenres(null);
  //  });
  }

}