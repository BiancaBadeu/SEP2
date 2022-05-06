package viewmodel;

import model.*;

/**
 * A class representing the model factory for the view models
 */
public class ViewModelFactory
{
  private MovieViewModel movieViewModel;
  private StartViewModel startViewModel;
  private TopRatedViewModel topRatedViewModel;
  private ViewModelState state = null;

  /**
   * @param model a Model variable that we need to create the viewModels
   *
   *  An 1 argument constructor that creates the viewModels
   */
  public ViewModelFactory(Model model)
  {
      this.state= new ViewModelState();
      movieViewModel = new MovieViewModel(model, state);
      startViewModel = new StartViewModel(model);
      topRatedViewModel = new TopRatedViewModel(model, state);
  }

  /**
   * @return the viewModel
   *
   * A getter for the MovieViewModel
   * @see viewmodel.MovieViewModel
   */
  public MovieViewModel getMovieViewModel()
  {
    return movieViewModel;
  }

  /**
   * @return the viewModel
   *
   * A getter for the StartViewModel
   * @see viewmodel.StartViewModel
   */
  public StartViewModel getStartViewModel()
  {
    return startViewModel;
  }

  /**
   * @return the viewModel
   *
   * A getter for the TopRatedViewModel
   * @see viewmodel.TopRatedViewModel
   */
  public TopRatedViewModel getTopRatedViewModel()
  {
    return topRatedViewModel;
  }
}
