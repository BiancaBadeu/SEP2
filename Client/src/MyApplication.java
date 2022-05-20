import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import model.ModelManager;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    System.out.println("Application start.");
    Model model = new ModelManager();
    System.out.println("created model");
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    System.out.println("created viewmodel factory");
    ViewHandler view = new ViewHandler(viewModelFactory);
    System.out.println("created view handler");
    view.start(primaryStage);
    System.out.println("application done");
  }
}
