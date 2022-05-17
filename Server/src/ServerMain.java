import model.mediator.*;

public class ServerMain
{
  public static void main(String[] args)
  {
      Model model = new ModelManager();
      for(int i=0; i<100;i++)
      {
        System.out.println(model.getAllMovies().get(i).getTitle());
      }
  }

}
