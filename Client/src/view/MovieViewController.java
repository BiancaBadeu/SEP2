package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

/**
 * A class representing a controller for the start.fxml file @see view.start.fxml
 */
public class MovieViewController
{
  @FXML private Label title;
  @FXML private Label length;
  @FXML private Label director;
  @FXML private Label description;
  @FXML private ProgressBar progressBar;
  @FXML private Label averageRating;
  @FXML private TextArea comment;
  @FXML private Label numberOfReviews;
  @FXML private ListView comments;

  private Region root;
  private MovieViewModel viewModel;
  private ViewHandler viewHandler;

  /**
   * A 0 argument empty constructor
   */
  public MovieViewController(){}

  /**
   * @param viewHandler a ViewHandler variable for control over the GUI
   * @param viewmodel a
   * @param root a
   *
   * A method to initiate the GUI windows and initializing the parameters previously mentioned
   */
  public void init(ViewHandler viewHandler, MovieViewModel viewmodel, Region root)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;

    title.textProperty().bind(viewModel.getTitleProperty());
    length.textProperty().bind(viewModel.getLengthProperty());
    director.textProperty().bind(viewModel.getDirectorProperty());
    description.textProperty().bind(viewModel.getDescriptionProperty());
    numberOfReviews.textProperty().bind(viewModel.getNoOfReviewsProperty());
    averageRating.textProperty().bind(viewModel.getAvgRatingProperty());
    comment.textProperty().bindBidirectional(viewModel.getCommentProperty());
  }

  public void reset()
  {
    viewModel.reset();
  }

  public Region getRoot() {return root;}

  /**
   * A FXML method called when the button named Log in is pressed. what is does
   */
  @FXML private void goBackPressed()
  {
    viewHandler.openView("home");
  }
  @FXML private void leaveReviewPressed()
  {

  }
}
