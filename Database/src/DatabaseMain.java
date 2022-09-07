import model.mediator.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class DatabaseMain
{
  public static void main(String[] args) throws ClassNotFoundException
  {
    SEPPersistence model = new SEPDatabase();
    RemoteDatabase server = new Database(model);
    try
    {
      server.startDatabaseConnection();
    }
    catch (RemoteException | AlreadyBoundException e)
    {
      e.printStackTrace();
    }
    System.out.println("Server started...");

  }
}


