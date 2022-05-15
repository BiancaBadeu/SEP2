package mediator;

import model.Model;

import java.rmi.Naming;

public class Client implements Model
{
  private RemoteModel remoteModel;

  public Client()
  {
    try
    {
      remoteModel = (RemoteModel) Naming.lookup("rmi://localhost:1099/Case");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

}
