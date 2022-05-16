package viewmodel;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;
import model.Movie;

public class ProfileViewModel
{
  private Model model;
  private ViewModelStateUser userState;
  private StringProperty userNameLabel;
  private StringProperty nameLabel;
  private StringProperty phoneNoLabel;
  private StringProperty ageLabel;
  private ObservableList<String> rentedMovies;
  private ViewModelState state;

  public ProfileViewModel(Model model, ViewModelStateUser userState,
      ViewModelState state)
  {

    this.model = model;
    this.userState = userState;
    this.state = state;

    this.rentedMovies = FXCollections.observableArrayList();

  }

  public StringProperty getUsernameProperty()
  {
    return userNameLabel;
  }

  public StringProperty getNameProperty()
  {
    return nameLabel;
  }

  public StringProperty getPhoneNoProperty()
  {
    return phoneNoLabel;
  }

  public StringProperty getAgeProperty()
  {
    return ageLabel;
  }

  public void reset()
  {

    rentedMovies.clear();

  }

  public ObservableList<String> getRentedMovies()
  {

    rentedMovies.add(model.getRentalsWithUser(userState.getUser()).toString());

    return rentedMovies;

  }

  public boolean showDetails(String string)
  {
    Movie movie = null;

    for (int i = 0; i < model.getTop10TopRatedMovies().size(); i++)
    {
      if (model.getAllMovies().get(i).getTitle().equals(string))
      {
        movie = model.getTop10TopRatedMovies().get(i);

        if (movie != null)
        {
          state.setMovie(movie);
          return true;
        }
        else
        {
          state.setMovie(null);
          return false;
        }
      }

    }
    return false;
  }
}
