import model.domain.Review;
import model.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest
{
  private Review review;

  @BeforeEach void setUp()
  {

    review = new Review("Test test test", 0);
  }

  @AfterEach void tearDown()
  {
  }

  @Test void setInvalidRating()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      review.setRating(6);
    });
  }

  @Test void setInvalidComment()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      review.setComment("");
    });

  }

  @Test void setNullComment()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      review.setComment(null);
    });
  }




}
