import javafx.application.Application;
import mediator.Client;
import java.util.Scanner;

public class ClientMain extends MyApplication
{
  public static void main(String[] args)
  {
    Client client = new Client();
    Application.launch(MyApplication.class);

    Scanner input = new Scanner(System.in);
  }

}
