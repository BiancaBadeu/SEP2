import javafx.application.Application;
import javafx.stage.Stage;
import model.*;
import view.*;
import viewmodel.*;

public class MyApplication extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    Model model = new ModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(stage);
  }
}
