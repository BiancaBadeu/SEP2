package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;
import model.Movie;

/**
 * A viewModel class that represents the functionality of the Controller class MovieViewController
 * @see view.MovieViewController
 */
public class MovieViewModel
{
  private Model model;
  private StringProperty title;
  private StringProperty length;
  private StringProperty director;
  private StringProperty description;
  private StringProperty averageRating;
  private StringProperty comment;
  private StringProperty numberOfReviews;
  private StringProperty errorLabel;

  /**
   * @param model a Model variable so that the viewModel has access to the model's methods
   * @param state a ViewModel State variable so that the view Model has acces to what has been selected in another GUI window
   *
   * A 2 arguments constructor that initializes the instance variables
   */
  public MovieViewModel(Model model, ViewModelState state)
  {
    Movie selected  = state.getSelectedMovie();
    this.model = model;
    if(selected != null)
    {
      this.title = new SimpleStringProperty(selected.getTitle());
      this.length = new SimpleStringProperty(""+selected.getLength());
      this.director = new SimpleStringProperty(selected.getDirector());
      this.description = new SimpleStringProperty(selected.getDescription());
      this.averageRating = new SimpleStringProperty(""+selected.getAvgRating());
      this.numberOfReviews = new SimpleStringProperty(""+selected.getNumberOfReviews());
    }
    this.comment = new SimpleStringProperty();
    this.errorLabel = new SimpleStringProperty();
  }

  /**
   * A method to reset the instance variables everytime we open the window
   */
  public void reset()
  {
    //everything set to the selected movie info

    //title.set();
    //length.set();
    //director.set();
    //description.set();
    //averageRating.set();
    comment.set("");
    //numberOfReviews.set();
    errorLabel.set("");
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
   *  @return a boolean value that is true if the model doesn't throw an exception and false if this method catches an exception
   *  @see model.Model
   */
  public boolean rentMovie()
  {
    try
    {
      model.rentMovie(title.get(), averageRating.get()); //suppose there are no 2 movies with the same name and same rating
      return true;
    }
    catch (Exception e)
    {
      errorLabel.set(e.getMessage());
      return false;
    }
  }

  //not for this sprint
  /*public boolean leaveReview()
  {
      try
      {
          model.leaveReview(comment.get());
          return true;
      }
      catch (Exception e)
      {
          errorLabel.set(e.getMessage());
          return false;
      }
  }*/
}
