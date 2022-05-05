import javafx.application.Application;
import model.*;

public class ClientMain
{
  public static void main(String[] args)
  {
    Model model = new ModelManager();
    model.addPerson("Steffen", "user", "SVA", "+123456789", "29-10-1969", "user");
    Application.launch(MyApplication.class);
  }

}
