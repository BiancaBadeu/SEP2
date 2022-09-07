package model.mediator;

import model.domain.*;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Database implements RemoteDatabase
{
  private SEPPersistence persistence;

  public Database(SEPPersistence model)
  {
    this.persistence = model;
  }

  public void startDatabaseConnection () throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1098);
    UnicastRemoteObject.exportObject(this,0);
    registry.bind("Database", this);

    persistence.getAllInfo();
  }



}
