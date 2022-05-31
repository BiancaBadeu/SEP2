package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.mediator.Model;
import model.domain.Movie;

import java.time.LocalDate;
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

  private ObservableList<String> notRentedMovies;

  /**
   * @param model The model to set.
   * @param state The state to set.
   *              Constructor setting the model and state. Also initializes the properties.
   */
  public AdminViewModel(Model model, ViewModelState state)
  {
    this.model = model;
    this.state = state;
    this.notRentedMovies = FXCollections.observableArrayList();

    this.title = new SimpleStringProperty("");
    this.length = new SimpleStringProperty("");
    this.director = new SimpleStringProperty("");
    this.genre = new SimpleStringProperty("");
    this.description = new SimpleStringProperty("");
    this.avgRating = new SimpleStringProperty("");
    this.error = new SimpleStringProperty("");
    this.releaseYear = new SimpleStringProperty("");
  }

  /**
   * @return the release year property
   * Getter for the release year property.
   */
  public StringProperty getReleaseYearProperty()
  {
    return releaseYear;
  }

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
  public ObservableList<String> getNotRentedMovies()
  {
    if (!model.getNotRentedMovies().isEmpty())
    {
      for (int i = 0; i < model.getNotRentedMovies().size(); i++)
      {
        notRentedMovies.add(model.getNotRentedMovies().get(i).getTitle());
      }
      return notRentedMovies;
    }
    return null;
  }

  /**
   * Resets the gui window
   * If the properties are not empty the movie is added.
   */
  public void reset()
  {
    if (addMovie() || editMovie())
    {
      Movie newMovie = new Movie(title.get(), director.get(),
          Integer.parseInt(length.get()), description.get(),
          Double.parseDouble(avgRating.get()),
          Integer.parseInt(releaseYear.get()), genre.get(), new ArrayList<>());

      for (int i = 0; i < model.getNotRentedMovies().size(); i++)
      {
        if (newMovie.equals(model.getNotRentedMovies().get(i)))
        {
          model.removeMovie(model.getNotRentedMovies().get(i));
        }
      }

      model.addMovie(newMovie);
    }

    notRentedMovies.clear();
    getNotRentedMovies();

    title.set("");
    length.set("");
    director.set("");
    description.set("");
    avgRating.set("");
    error.set("");
    releaseYear.set("");
    genre.set("");
  }

  /**
   * @return a boolean
   * A method to see if we can add the movie. Return true if everything is ok.
   */
  public boolean addMovie()
  {

    LocalDate date = LocalDate.now();
    int currentYear = date.getYear();
    if (title.get().isEmpty() || length.get().isEmpty() || director.get()
        .isEmpty() || description.get().isEmpty() || avgRating.get().isEmpty()
        || releaseYear.get().isEmpty() || genre.get().isEmpty())
    {
      error.set("Please fill in all fields.");
      return false;
    }
    else if (description.get().length()>1000)
    {
      error.set("Description is too long!");
      return false;
    }
    else if (!length.get().matches("\\d+"))
    {
      error.set("Invalid length!");
      return false;
    }
    else if (!avgRating.get().matches("\\d+.\\d+") || Double.parseDouble(avgRating.get())>5)
    {
      error.set("Invalid rating!");
      return false;
    }
    else if (!releaseYear.get().matches("\\d+") || Integer.parseInt(releaseYear.get())<1800 || Integer.parseInt(releaseYear.get())>currentYear )
    {
      error.set("Invalid year!");
      return false;
    }
    else
      return model.validateAddMovie(title.get());
  }

  /**
   * @param title the title of the movie
   * @return a boolean variable
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
   *     A method to get the movie's information and store it into the text fields, so that the admin can edit them.
   *          It also removes the movie from the movie list, to be added later when the edit is done
   */
  public void getMovieToEdit(String focusedItem)
  {
    ArrayList<Movie> movies = model.getNotRentedMovies();
    for (int i = 0; i < movies.size(); i++)
    {
      if (movies.get(i).getTitle().equals(focusedItem))
      {

        this.title.set(movies.get(i).getTitle());
        this.length.set(Integer.toString(movies.get(i).getLength()));
        this.director.set(movies.get(i).getDirector());
        this.description.set(movies.get(i).getDescription());
        this.avgRating.set(Double.toString(movies.get(i).getAvgRating()));
        this.releaseYear.set(Integer.toString(movies.get(i).getReleaseYear()));
        this.genre.set(movies.get(i).getGenres());
        model.removeMovie(movies.get(i));

      }
    }
  }

  /**
   * @return a boolean value if we can edit the movie
   * A method to see if we can edit the movie. Return true if everything is ok.
   */
  public boolean editMovie()
  {
    LocalDate date = LocalDate.now();
    int currentYear = date.getYear();
    if (title.getValue().isEmpty() || length.getValue().isEmpty()
        || director.getValue().isEmpty() || description.getValue().isEmpty()
        || avgRating.getValue().isEmpty() || releaseYear.getValue().isEmpty()
        || genre.getValue().isEmpty())
    {
      error.set("Please fill in all fields.");
      return false;
    }
    else if (description.get().length()>1000)
    {
      error.set("Description is too long!");
      return false;
    }
    else if (!length.get().matches("\\d+"))
    {
      error.set("Invalid length!");
      return false;
    }
    else if (!avgRating.get().matches("\\d+.\\d+") || Double.parseDouble(avgRating.get())>5)
    {
      error.set("Invalid rating!");
      return false;
    }
    else if (!releaseYear.get().matches("\\d+") || Integer.parseInt(releaseYear.get())<1800 || Integer.parseInt(releaseYear.get())>currentYear )
    {
      error.set("Invalid year!");
      return false;
    }
    else
      return true;
  }

  /**
   * @param focusedItem the movie selected from the list
   * @return a boolean value if we can remove the movie
   * A method that removes the movie from the movie list. Returns true if everything went ok.
   */
  public boolean removeMovie(String focusedItem)
  {
    ArrayList<Movie> movies = model.getNotRentedMovies();
    for (int i = 0; i < movies.size(); i++)
    {
      if (movies.get(i).getTitle().equals(focusedItem))
      {
        model.removeMovie(movies.get(i));
        return true;
      }
    }
    return false;
  }
}



