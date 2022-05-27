import model.domain.Admin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest
{

  private Admin admin;

 @BeforeEach void setUp()
  {
     admin= new Admin("admin","admin","admin","12345678",18);
  }

  @AfterEach void tearDown()
  {
  }


  @Test void setInvalidName()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      admin.setName("");
    });
  }

  @Test void setInvalidUsername()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      admin.setUserName("");
    });
  }

  @Test void setInvalidPhoneNumber()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      admin.setPhoneNumber("");
    });
  }

  @Test void setNullName()
  {
    assertThrows(IllegalArgumentException.class, () -> {
      admin.setName(null);
    });
  }


  }


