import model.domain.Movie;
import model.domain.User;
import model.mediator.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;

public class ServerMain
{
  public static void main(String[] args)
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


