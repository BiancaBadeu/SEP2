import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.mediator.Model;
import model.mediator.ModelManager;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

import java.io.IOException;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    Model model = new ModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);
  }
}
