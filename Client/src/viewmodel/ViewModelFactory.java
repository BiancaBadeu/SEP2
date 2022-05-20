package viewmodel;

import model.Model;

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

  /**
   * @param model a Model variable that we need to create the viewModels
   *  An 1 argument constructor that creates the viewModels
   */
  public ViewModelFactory(Model model)
  {
    System.out.println("creating viewmodel state");
    this.state = new ViewModelState();
    System.out.println("creating viewmodel state user");

    this.stateUser = new ViewModelStateUser();
    movieViewModel = new MovieViewModel(model, state, stateUser);
    startViewModel = new StartViewModel(model, stateUser);
    homeViewModel = new HomeViewModel(model, state);
    adminViewModel = new AdminViewModel(model, state);
    profileViewModel = new ProfileViewModel(model, stateUser, state);
    System.out.println("done");

  }

  /**
   * @return the viewModel
   * A getter for the MovieViewModel
   * @see viewmodel.MovieViewModel
   */
  public MovieViewModel getMovieViewModel()
  {
    return movieViewModel;
  }

  /**
   * @return the viewModel
   * A getter for the StartViewModel
   * @see viewmodel.StartViewModel
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
   *
   * A getter for the AdminViewModel
   */
  public AdminViewModel getAdminViewModel(){ return adminViewModel;}

  /**
   * @return the viewModel
   *
   * A getter for the ProfileViewModel
   */
  public ProfileViewModel getProfileViewModel(){ return profileViewModel;}
}
