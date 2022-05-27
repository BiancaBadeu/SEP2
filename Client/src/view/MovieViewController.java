package view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import viewmodel.*;

/**
 * A class representing a controller for the start.fxml file @see view.movie.fxml
 */
public class MovieViewController
{

  @FXML private Label title;
  @FXML private Label length;
  @FXML private Label director;
  @FXML private Label releaseYear;
  @FXML private Label genre;
  @FXML private Label description;
  @FXML private ProgressBar progressBar;
  @FXML private Label averageRating;
  @FXML private TextArea comment;
  @FXML private Label numberOfReviews;
  @FXML private Label star;
  @FXML private ListView<String> comments;
  @FXML private Label errorLabel;
  @FXML private Button rentButton;
  @FXML private Button cancelButton;

  private Region root;
  private MovieViewModel viewModel;
  private ViewHandler viewHandler;

  /**
   * A 0 argument empty constructor
   */
  public MovieViewController() {}

  /**
   * @param viewHandler a ViewHandler variable for control over the GUI
   * @param viewModel   a StartViewModel variable for control over the functionality
   * @param root        a Region variable for location within the GUI
   *                    A method to initiate the GUI windows and initializing the parameters previously mentioned, plus binding all the
   *                    FXML variables to their respective properties from the viewModel
   * @see viewmodel.MovieViewModel
   */
  public void init(ViewHandler viewHandler, MovieViewModel viewModel,
      Region root)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;

    title.textProperty().bind(viewModel.getTitleProperty());
    length.textProperty().bind(viewModel.getLengthProperty());
    director.textProperty().bind(viewModel.getDirectorProperty());
    releaseYear.textProperty().bind(viewModel.getReleaseYearProperty());
    genre.textProperty().bind(viewModel.getGenreProperty());
    description.textProperty().bind(viewModel.getDescriptionProperty());
    numberOfReviews.textProperty().bind(viewModel.getNoOfReviewsProperty());
    averageRating.textProperty().bind(viewModel.getAvgRatingProperty());
    errorLabel.textProperty().bind(viewModel.getErrorProperty());
    comment.textProperty().bindBidirectional(viewModel.getCommentProperty());

    comments.setItems(viewModel.getComments());
    star.textProperty().bindBidirectional(viewModel.getStarProperty());

    reset();
  }

  /**
   * A method calling the viewModel because controllers are not supposed to have functionality(single purpose)
   *
   * @see viewmodel.MovieViewModel
   */
  public void reset()
  {
    boolean isRented = viewModel.reset();
    if (isRented)
    {
      rentButton.setDisable(true);
      cancelButton.setDisable(false);
    }
    else
    {
      rentButton.setDisable(false);
      cancelButton.setDisable(true);
    }

    String avgRating = viewModel.getAvgRatingProperty().get();
    double rating = Double.parseDouble(avgRating);
    rating /= 5;
    this.progressBar.setProgress(rating);
  }

  /**
   * @return the root
   * A method returning the root for the controller
   */
  public Region getRoot()
  {
    return root;
  }

  /**
   * A FXML method called when the button named <- is pressed. It cals the method openView in the viewHandler
   *
   * @see view.ViewHandler
   */
  @FXML private void goBackPressed()
  {
    viewHandler.openView("home");
  }

  /**
   * A FXML method called when the button named Rent movie is pressed
   * It cals the method rentMovie in the viewModel and if the method returns true(the user is allowed to rent the movie),
   * it will disable the button so that you cannot rent the same movie twice
   *
   * @see viewmodel.MovieViewModel
   */
  @FXML private void rentPressed()
  {
    boolean rent = viewModel.rentMovie();
    if (rent)
    {
      rentButton.setDisable(true);
      cancelButton.setDisable(false);
    }
  }

  /**
   * A FXML method called when the button named Rent movie is pressed
   * It cals the method rentMovie in the viewModel and if the method returns true(the user is allowed to rent the movie),
   * it will disable the button so that you cannot rent the same movie twice
   *
   * @see viewmodel.MovieViewModel
   */
  @FXML private void cancelPressed()
  {
    boolean cancel = viewModel.cancelMovie();
    if (cancel)
    {
      rentButton.setDisable(false);
      cancelButton.setDisable(true);
    }
  }

  /**
   * A FXML method called when the button named Leave review is pressed
   * It cals the method leaveReview in the viewModel
   * @see MovieViewModel
   */
  @FXML private void leaveReviewPressed()
  {
    viewModel.leaveReview();
  }

  /**
   * A FXML method called when the button 0 is pressed
   * It will set a label with the rating 0
   */
  @FXML private void star0Pressed()
  {
    this.star.setText("0");
  }

  /**
   * A FXML method called when the button 1 is pressed
   * It will set a label with the rating 1
   */
  @FXML private void star1Pressed()
  {
    this.star.setText("1");
  }

  /**
   * A FXML method called when the button 2 is pressed
   * It will set a label with the rating 2
   */
  @FXML private void star2Pressed()
  {
    this.star.setText("2");
  }

  /**
   * A FXML method called when the button 3 is pressed
   * It will set a label with the rating 3
   */
  @FXML private void star3Pressed()
  {
    this.star.setText("3");
  }

  /**
   * A FXML method called when the button 4 is pressed
   * It will set a label with the rating 4
   */
  @FXML private void star4Pressed()
  {
    this.star.setText("4");
  }

  /**
   * A FXML method called when the button 5 is pressed
   * It will set a label with the rating 5
   */
  @FXML private void star5Pressed()
  {
    this.star.setText("5");
  }
}
