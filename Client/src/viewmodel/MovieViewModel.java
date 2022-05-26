package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.domain.Movie;
import model.domain.Rental;
import model.domain.Review;
import model.mediator.Model;

import java.util.ArrayList;

/**
 * A viewModel class that represents the functionality of the Controller class MovieViewController
 * @see view.MovieViewController
 */
public class MovieViewModel
{
  private Model model;
  private ViewModelState state;
  private ViewModelStateUser userState;
  private ObservableList<String> comments;
  private StringProperty title;
  private StringProperty length;
  private StringProperty director;
  private StringProperty genre;
  private StringProperty description;
  private StringProperty averageRating;
  private StringProperty comment;
  private StringProperty numberOfReviews;
  private StringProperty errorLabel;
  private StringProperty releaseYear;
  private StringProperty star;


  /**
   * @param model a Model variable so that the viewModel has access to the model's methods
   * @param state a ViewModelState variable so that the view Model has access to what has been selected in another GUI window
   * @param userState a ViewModelStateUser variable so that the view model knows which user is logged in
   *
   * A 3 arguments constructor that initializes the instance variables
   */
  public MovieViewModel(Model model, ViewModelState state, ViewModelStateUser userState)
  {
    this.model = model;
    this.state = state;
    this.userState= userState;

    this.comments = FXCollections.observableArrayList();

    Movie selected  = state.getSelectedMovie();
    if(selected != null)
    {
      this.title = new SimpleStringProperty(""+selected.getTitle());
      this.length = new SimpleStringProperty(""+selected.getLength());
      this.director = new SimpleStringProperty(""+selected.getDirector());
      this.releaseYear = new SimpleStringProperty(""+selected.getReleaseYear());
      this.genre = new SimpleStringProperty(""+selected.getGenres());
      this.description = new SimpleStringProperty(""+selected.getDescription());
      this.averageRating = new SimpleStringProperty(""+selected.getAvgRating());
      this.numberOfReviews = new SimpleStringProperty(""+selected.getNumberOfReviews());
    }
    else
    {
      this.title = new SimpleStringProperty("");
      this.length = new SimpleStringProperty("");
      this.director = new SimpleStringProperty("");
      this.releaseYear = new SimpleStringProperty("");
      this.genre = new SimpleStringProperty("");
      this.description = new SimpleStringProperty("");
      this.averageRating = new SimpleStringProperty("");
      this.numberOfReviews = new SimpleStringProperty("");
    }
    this.comment = new SimpleStringProperty("");
    this.errorLabel = new SimpleStringProperty("");
    this.star = new SimpleStringProperty("");
  }

  /**
   * @return a boolean value and reset the instance variables everytime we open the window.
   *          It returns true if the movie is rented already and false if not
   */
  public boolean reset()
  {
    //everything set to the selected movie info
    Movie selected = state.getSelectedMovie();
    this.title.set(""+selected.getTitle());
    this.length.set(""+selected.getLength());
    this.director.set(""+selected.getDirector());
    this.releaseYear.set(""+selected.getReleaseYear());
    this.genre.set(""+selected.getGenres());
    this.description.set(""+selected.getDescription());
    this.averageRating.set(""+selected.getAvgRating());
    this.numberOfReviews.set(""+selected.getNumberOfReviews());

    comment.set("");
    errorLabel.set("");
    star.set("");

    comments.clear();
    getComments();

    ArrayList<Rental> rentals = model.getAllRentals();
    if(!rentals.isEmpty())
    {
      for(int i=0;i<rentals.size();i++)
      {
        if(rentals.get(i).getRentedMovie().getTitle().equals(selected.getTitle()))
          return true;
      }
    }
    return false;
  }

  /**
   * @return the title property
   *
   * A getter for the title string property
   */
  public  StringProperty getTitleProperty() {return title;}
  /**
   * @return the length property
   *
   * A getter for the length string property
   */
  public  StringProperty getLengthProperty() {return length;}
  /**
   * @return the director property
   *
   * A getter for the director string property
   */
  public  StringProperty getDirectorProperty() {return director;}
  /**
   * @return the genre property
   *
   * A getter for the genre string property
   */
  public  StringProperty getGenreProperty() {return genre;}
  /**
   * @return the release year property
   *
   * A getter for the release year string property
   */
  public StringProperty getReleaseYearProperty() {return releaseYear;}
  /**
   * @return the description property
   *
   * A getter for the description string property
   */
  public  StringProperty getDescriptionProperty() {return description;}
  /**
   * @return the averageRating property
   *
   * A getter for the average rating string property
   */
  public  StringProperty getAvgRatingProperty() {return averageRating;}
  /**
   * @return the comment property
   *
   * A getter for the comment string property
   */
  public  StringProperty getCommentProperty() {return comment;}
  /**
   * @return the numberOfReviews property
   *
   * A getter for the number of reviews string property
   */
  public  StringProperty getNoOfReviewsProperty() {return numberOfReviews;}
  /**
   * @return the errorLabel property
   *
   * A getter for the error string property
   */
  public  StringProperty getErrorProperty() {return errorLabel;}
  /**
   * @return the star property
   *
   * A getter for the star string property
   */
  public  StringProperty getStarProperty() {return star;}
  /**
   * @return the comments
   *
   * Method returns the comments for the movie.
   */
  public ObservableList<String> getComments()
  {
    Movie selected = state.getSelectedMovie();
    comments.clear();
    ArrayList<Review> reviews = model.getReviewsForMovie(selected);
    for (int i = 0; i < reviews.size(); i++)
    {
      comments.add(reviews.get(i).toString());
    }
    return comments;
  }

  /**
   *  @return a boolean value that is true if the model doesn't throw an exception and false if this method catches an exception
   *  @see Model
   *
   *  A method to rent a movie
   */
  public boolean rentMovie()
  {
    try
    {
      model.rentMovie(title.get(), userState.getUser()); //suppose name is unique
      return true;
    }
    catch (Exception e)
    {
      errorLabel.set(e.getMessage());
      return false;
    }
  }

  /**
   * @return a boolean value that is true if the model doesn't throw an exception and false if this method catches an exception
   * @see Model
   *
   * A method to cancel a rental
   */
  public boolean cancelMovie(){

    try{
      model.cancelRental(title.get(), userState.getUser());
      return true;
    }

    catch(Exception e){
      errorLabel.set(e.getMessage());
      return false;
    }

  }

  /**
   * @return a boolean value that is true if the model doesn't throw an exception and false if this method catches an exception
   * @see Model
   *
   * A method to leave a review (rating + comment)
   */
  public boolean leaveReview()
  {
    try
    {
      model.leaveReview(comment.get(), Integer.parseInt(star.get()), title.get(), userState.getUser().getUserName());
      return true;
    }
    catch (Exception e)
    {
      errorLabel.set(e.getMessage());
      return false;
    }
  }
}
