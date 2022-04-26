package viewmodel;

import model.*;

/**
 * A class representing the model factory for the view models
 */
public class ViewModelFactory
{
  private MovieViewModel movieViewModel;

  /**
   * @param model a Model variable that we need to create the viewModels
   *
   *  An 1 argument constructor that creates the viewModels
   */
  public ViewModelFactory(Model model)
  {
      movieViewModel = new MovieViewModel(model);
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
}
