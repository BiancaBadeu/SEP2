package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;
import model.Movie;

import java.util.ArrayList;

/**
 * The AdminViewModel class is the view model for the admin view.
 */
public class AdminViewModel
{
  private Model model;
  private ViewModelState state;
  private StringProperty title;
  private StringProperty length;
  private StringProperty director;
  private StringProperty genre;
  private StringProperty description;
  private StringProperty avgRating;
  private StringProperty error;
  private StringProperty releaseYear;


  private ObservableList<String> allMovies;

  /**
   * @param model The model to set.
   * @param state The state to set.
   *              Constructor setting the model and state. Also initializes the properties.
   */
  public AdminViewModel(Model model, ViewModelState state)
  {
    this.model = model;
    this.state = state;
    this.allMovies = FXCollections.observableArrayList();

    this.title = new SimpleStringProperty();
    this.length = new SimpleStringProperty();
    this.director = new SimpleStringProperty();
    this.genre = new SimpleStringProperty();
    this.description = new SimpleStringProperty();
    this.avgRating = new SimpleStringProperty();
    this.error = new SimpleStringProperty();
    this.releaseYear = new SimpleStringProperty();
  }

  /**
   * @return the release year property
   * Getter for the release year property.
   */
  public StringProperty getReleaseYearProperty() {return releaseYear;}

  /**
   * @return The title property.
   * Getter for the title property.
   */
  public StringProperty getTitleProperty()
  {
    return title;
  }

  /**
   * @return The length property.
   * Getter for the length property.
   */
  public StringProperty getLengthProperty()
  {
    return length;
  }

  /**
   * @return The state.
   * Getter for the state.
   */
  public StringProperty getDirectorProperty()
  {
    return director;
  }

  /**
   * @return The genre.
   * Getter for the genre.
   */
  public StringProperty getGenreProperty()
  {
    return genre;
  }

  /**
   * @return The state.
   * Getter for the state.
   */
  public StringProperty getDescriptionProperty()
  {
    return description;
  }

  /**
   * @return The state.
   * Getter for the state.
   */
  public StringProperty getAvgRatingProperty()
  {
    return avgRating;
  }

  /**
   * @return The state.
   * Getter for the state.
   */
  public StringProperty getErrorProperty()
  {
    return error;
  }

  /**
   * @return all the movies.
   * Sets the listview to the movies in the model.
   */
  public ObservableList<String> getAllMovies()
  {
    for (int i = 0; i < model.getAllMovies().size(); i++)
    {
      allMovies.add(model.getAllMovies().get(i).toString());
    }
    return allMovies;
  }

  /**
   * Resets the gui window
   * If the properties are not empty the movie is added.
   */
  public void reset()
  {
    if (addMovie())
    {
      Movie newMovie = new Movie(title.get(), director.get(), Integer.parseInt(length.get()), description.get(),
          Double.parseDouble(avgRating.get()), Integer.parseInt(releaseYear.get()),
          genre.get(), new ArrayList<>());

      model.addMovie(newMovie);
    }

    allMovies.clear();
    for (int i = 0; i < model.getAllMovies().size(); i++)
    {
      allMovies.add(i, String.valueOf(model.getAllMovies().get(i)));
    }

    title.set("");
    length.set("");
    director.set("");
    description.set("");
    avgRating.set("");
    error.set("");
    releaseYear.set("");
  }

  /**
   * @return a boolean
   * A method to see if we can add the movie. Return true if everything is ok.
   */
  public boolean addMovie()
  {

    if (title.get().isEmpty() || length.get().isEmpty() || director.get().isEmpty()
        || description.get().isEmpty() || avgRating.get().isEmpty()
        || releaseYear.get().isEmpty())
    {
      error.set("Please fill in all fields.");
      return false;
    }

    else
      return model.validateAddMovie(title.get());
  }

  /**
   * @param title the title of the movie
   * @return a boolean variable
   *
   * A method to see if we can edit the movie. Return true if everything is ok.
   */
  public boolean getEdit(String title)
  {
    boolean smol = true;
    if (title.isEmpty())
    {
      error.set("Please select a movie.");
      smol = false;
    }
    return smol;
  }

  /**
   * @param focusedItem the movie selected from the list
   *
   * A method to get the movie's information and store it into the text fields, so that the admin can edit them. It also removes the
   *                    movie from the movie list, to be added later when the edit is done
   */
  public void getMovieToEdit(String focusedItem)
  {
    for (int i = 0; i < model.getAllMovies().size(); i++)
    {
      if (model.getAllMovies().get(i).getTitle().equals(focusedItem))
      {

        this.title.set(model.getAllMovies().get(i).getTitle());
        this.length.set(
            Integer.toString(model.getAllMovies().get(i).getLength()));
        this.director.set(model.getAllMovies().get(i).getDirector());
        this.description.set(model.getAllMovies().get(i).getDescription());
        this.avgRating.set(
            Double.toString(model.getAllMovies().get(i).getAvgRating()));
        this.releaseYear.set(Integer.toString(model.getAllMovies().get(i).getReleaseYear()));
        model.removeMovie(model.getAllMovies().get(i));
      }
    }
  }

  /**
   * @return a boolean value if we can edit the movie
   *
   * A method to see if we can edit the movie. Return true if everything is ok.
   */
  public boolean editMovie()
  {
    if (title.getValue().isEmpty() || length.getValue().isEmpty() || director.getValue()
        .isEmpty() || description.getValue().isEmpty() || avgRating.getValue().isEmpty() || releaseYear.getValue().isEmpty())
    {
      error.set("Please fill in all fields.");
      return false;
    }
    else
      return true;
  }

  /**
   * @param focusedItem the movie selected from the list
   * @return a boolean value if we can remove the movie
   *
   * A method that removes the movie from the movie list. Returns true if everything went ok.
   */
  public boolean removeMovie(String focusedItem)
  {
    for (int i = 0; i < model.getAllMovies().size(); i++)
    {
      if (model.getAllMovies().get(i).getTitle().equals(focusedItem))
      {
        model.removeMovie(model.getAllMovies().get(i));
        return true;
      }
    }
    return false;
  }
}



