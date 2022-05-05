import javafx.application.Application;
import javafx.stage.Stage;
import model.*;
import view.*;
import viewmodel.*;

import java.util.ArrayList;

public class MyApplication extends Application
{
  @Override public void start(Stage primaryStage)
  {
    Model model = new ModelManager();
    model.addPerson("Steffen", "user", "SVA", "+123456789", "29-10-1969", "user");
    Genre genre = new Genre("Action");
    ArrayList<Genre> genresForMovie1 = new ArrayList<>();
    genresForMovie1.add(genre);
    for(int i=0;i<12;i++)
    {
      Movie movie = new Movie("Title " + i, "Director "+i, "Description "+i, i, 1.1,i+1, genresForMovie1, new ArrayList<>());
      model.addMovie(movie);
    }

    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);
  }
}
