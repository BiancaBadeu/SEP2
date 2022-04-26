package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

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

  public MovieViewModel(Model model)
  {
    this.model = model;
    this.title = new SimpleStringProperty();
    this.length = new SimpleStringProperty();
    this.director = new SimpleStringProperty();
    this.description = new SimpleStringProperty();
    this.averageRating = new SimpleStringProperty();
    this.comment = new SimpleStringProperty();
    this.numberOfReviews = new SimpleStringProperty();
    this.errorLabel = new SimpleStringProperty();
  }

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

  public  StringProperty getTitleProperty() {return title;}
  public  StringProperty getLengthProperty() {return length;}
  public  StringProperty getDirectorProperty() {return director;}
  public  StringProperty getDescriptionProperty() {return description;}
  public  StringProperty getAvgRatingProperty() {return averageRating;}
  public  StringProperty getCommentProperty() {return comment;}
  public  StringProperty getNoOfReviewsProperty() {return numberOfReviews;}
  public  StringProperty getErrorProperty() {return errorLabel;}

  public boolean leaveReview()
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
  }
}
