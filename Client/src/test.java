import model.Model;
import model.ModelManager;

public class test
{

  public static void main(String[] args)
  {
    Model model = new ModelManager();
    model.addPerson("Steffen", "user", "SVA", "+123456789", "29-10-1969", "user");
  }
}
