import javafx.application.Application;
import mediator.Client;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientMain extends MyApplication
{
  public static void main(String[] args) throws RemoteException
  {
    Client client = new Client();
    Application.launch(MyApplication.class);

    Scanner input = new Scanner(System.in);
  }

}
