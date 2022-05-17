import model.mediator.*;

public class ServerMain
{
  public static void main(String[] args)
  {
      Model model = new ModelManager();

        System.out.println(model.getMovieWithTitle("Eli"));

      }
  }


