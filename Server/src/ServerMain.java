import model.mediator.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class ServerMain
{
  public static void main(String[] args) throws RemoteException
  {
    Model model = new ModelManager();
    RemoteModel server = new Server(model);
    try
    {
      server.startServer();
    }
    catch (RemoteException | AlreadyBoundException e)
    {
      e.printStackTrace();
    }
    System.out.println("Server started...");

  }
}


