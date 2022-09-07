package model.mediator;

import java.rmi.Remote;

public interface RemoteDatabase extends Remote
{
  void startDatabaseConnection();
}
