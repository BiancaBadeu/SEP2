package viewmodel;

import model.mediator.Model;

/**
 * A class representing the model factory for the view models
 */
public class ViewModelFactory
{
  private MovieViewModel movieViewModel;
  private StartViewModel startViewModel;
  private HomeViewModel homeViewModel;
  private AdminViewModel adminViewModel;
  private ProfileViewModel profileViewModel;
  private ViewModelState state = null;
  private ViewModelStateUser stateUser = null;
  private SearchViewModel searchViewModel;

  /**
   * @param model a Model variable that we need to create the viewModels
   *  An 1 argument constructor that creates the viewModels
   */
  public ViewModelFactory(Model model)
  {
    this.state = new ViewModelState();
    this.stateUser = new ViewModelStateUser();
    movieViewModel = new MovieViewModel(model, state, stateUser);
    startViewModel = new StartViewModel(model, stateUser);
    homeViewModel = new HomeViewModel(model, state);
    adminViewModel = new AdminViewModel(model, state);
    profileViewModel = new ProfileViewModel(model, state, stateUser);
    searchViewModel = new SearchViewModel(model, state);
  }

  /**
   * @return the viewModel
   * A getter for the MovieViewModel
   * @see MovieViewModel
   */
  public MovieViewModel getMovieViewModel()
  {
    return movieViewModel;
  }

  /**
   * @return the viewModel
   * A getter for the StartViewModel
   * @see StartViewModel
   */
  public StartViewModel getStartViewModel()
  {
    return startViewModel;
  }

  /**
   * @return the viewModel
   * A getter for the HomeViewModel
   * @see HomeViewModel
   */
  public HomeViewModel getHomeViewModel()
  {
    return homeViewModel;
  }

  /**
   * @return the viewModel
   * A getter for the AdminViewModel
   * @see AdminViewModel
   */
  public AdminViewModel getAdminViewModel(){ return adminViewModel;}

  /**
   * @return the viewModel
   * A getter for the ProfileViewModel
   * @see ProfileViewModel
   */
  public ProfileViewModel getProfileViewModel(){ return profileViewModel;}

  /**
   * @return the viewModel
   *
   * A getter for the SearchViewModel
   * @see SearchViewModel
   */
  public SearchViewModel getSearchViewModel(){ return searchViewModel;}
}
