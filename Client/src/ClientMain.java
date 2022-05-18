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
    System.out.print("Enter a string to convert to uppercase: ");
    String line = input.nextLine();
   //String convertedLine = client.convert(line, true);
   // System.out.println("Uppercase version: " + convertedLine);
    System.out.print("Enter a string to capitalize first letter: ");
    line = input.nextLine();
    //convertedLine = client.convert(line, false);
    //System.out.println("Capitalized version: " + convertedLine);
  }

}
