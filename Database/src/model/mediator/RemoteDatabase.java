package model.mediator;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteDatabase extends Remote
{
  void startDatabaseConnection() throws RemoteException, AlreadyBoundException;
}
