package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import viewmodel.TopRatedViewModel;
import javafx.scene.control.ListView;


public class TopRatedViewController
{



  @FXML private ListView<String> topratedList;

  private ViewHandler viewHandler;
  private Region root;
  private TopRatedViewModel topRatedViewModel;

  public void init(ViewHandler viewHandler,TopRatedViewModel topratedViewModel, Region root)
  {

    this.viewHandler = viewHandler;
    this.root = root;
    this.topRatedViewModel = topratedViewModel;

    topratedList.setItems(topratedViewModel.getTopRatedMovies());
  }

  public TopRatedViewController()
  {

  }

  public void reset()
  {
    // empty
  }

  public Region getRoot()
  {
    return root;
  }
}
