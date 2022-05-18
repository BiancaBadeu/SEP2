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
/*
        System.out.println(model.getMovieWithTitle("Eli"));
        System.out.println(model.getUser("bbc").toString());


    for (int i=0;i<3;i++)
    {
      System.out.println(model.getAllRentals().get(i));
    }
    User user = new User("Bianca", "bbc", "","",20);
    System.out.println(model.getRentalsWithUser(user));
    for (int i=0;i<10;i++)
    {
      System.out.println(model.getTop10TopRatedMovies().get(i).getTitle());
    }

    for (int i=0;i<100;i++)
    {
      System.out.println(model.getAllMovies().get(i).getTitle());
    }
    model.createUser("Bob Bobsyn", "boby","1234567890","+45 7752789","45");
 model.addMovie(movie);

    */

    Movie movie=new Movie("HSM 2","Kenny Ortega",99,"A continuation of HSM where our main characters find work at a summer resort that turns out to belong to the popular girl's family.",4.7,2007,"Musical", new ArrayList<>());
    User user = new User("Bianca", "bbc", "","",20);
    long rentalDate = System.currentTimeMillis() + (86400 * 7 * 1000);
    Date expirationDate = new Date(rentalDate);
    model.addRental(movie, expirationDate,user);


      }
  }


