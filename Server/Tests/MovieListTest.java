import model.domain.Movie;
import model.domain.MovieList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MovieListTest
{

  private MovieList movieList;
  private Movie movie;

  @BeforeEach void setUp()
  {
     movieList = new MovieList();
     movie = new Movie("The Godfather", "Crime", 197, "iweijwjwui", 9.2,
        1998, "pepe", new ArrayList<>());

  }

  @AfterEach void tearDown()
  {
  }

  @Test void add(){

    assertThrows(IllegalArgumentException.class, () -> {
      movieList.addMovie(movie);
    });
  }

}