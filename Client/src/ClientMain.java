import javafx.application.Application;
import model.Admin;
import model.Person;
import model.PersonList;

public class ClientMain
{
  public static void main(String[] args)
  {
    PersonList personList = new PersonList();
    personList.addPerson("Steffen", "admin", "SVA", "+123456789", "29-10-1969", "SVA");
    Application.launch(MyApplication.class);
  }

}
