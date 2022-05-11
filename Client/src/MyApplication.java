import javafx.application.Application;
import javafx.stage.Stage;
import model.domain.Genre;
import model.domain.Movie;
import model.mediator.Model;
import model.mediator.ModelManager;
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
      Movie movie = new Movie("Title " + i, "Director "+i, "Description "+i, i, 5.0,i+1, genresForMovie1, new ArrayList<>());
      model.addMovie(movie);
    }
    System.out.println("All movies " + model.getAllMovies());
    System.out.println("Top rated: " + model.getTop10TopRatedMovies());
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);
  }
}
