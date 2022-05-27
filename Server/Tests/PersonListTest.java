import model.domain.Admin;
import model.domain.Person;
import model.domain.PersonList;
import model.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonListTest
{

  Person user;
  Person admin;
  PersonList personList;


  @BeforeEach void setUp()
  {

     user= new User("Test", "Test", "Test test test",
       "12345678", 0);
     admin= new Admin("Test", "Test", "Test test test", "12345678", 18);

     personList= new PersonList();
  }

  @AfterEach void tearDown()
  {
  }

  @Test void addNullPerson(){

    assertThrows(IllegalArgumentException.class, () -> {

      for(int i=0; i<10; i++){
        personList.addPerson(null, null, null, null, 0, "user");
      }
    });
  }

  @Test void addEmptyPerson(){

    assertThrows(IllegalArgumentException.class, () -> {

      for(int i=0; i<10; i++){
        personList.addPerson("", "", "", "", 0, "user");
      }
    });
  }


}