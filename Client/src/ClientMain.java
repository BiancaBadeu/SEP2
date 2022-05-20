import javafx.application.Application;
import java.util.Scanner;

public class ClientMain extends MyApplication
{
  public static void main(String[] args)
  {
    System.out.println("in main");
    Application.launch(MyApplication.class);

    Scanner input = new Scanner(System.in);
    System.out.println("main done");
  }

}
