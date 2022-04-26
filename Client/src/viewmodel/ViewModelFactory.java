package viewmodel;

import model.*;

public class ViewModelFactory
{
  private MovieViewModel movieViewModel;

  public ViewModelFactory(Model model)
  {
      movieViewModel = new MovieViewModel(model);
  }

  public MovieViewModel getMovieViewModel()
  {
    return movieViewModel;
  }
}
