package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private ViewModelFactory viewModelFactory;
  private StartViewController startViewController;
  private MovieViewController movieViewController;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    this.currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("start");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "start":
        root = loadStartView("start.fxml");
        break;
      case "movie":
        root = loadMovieView("movie.fxml");
        break;
     // case "home":
        //root = loadHomeView("home.fxml");
       // break;
    }
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadStartView(String fxmlFile)
  {
    Region root = null;
    if (startViewController == null)
    {
      // load from FXML
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        startViewController = loader.getController();
        startViewController.init(this, viewModelFactory.getStartViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      // reset window
      startViewController.reset();
    }
    return startViewController.getRoot();
  }

  private Region loadMovieView(String fxmlFile)
  {
    Region root = null;
    if (movieViewController == null)
    {
      // load from FXML
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        movieViewController = loader.getController();
        movieViewController.init(this, viewModelFactory.getMovieViewModel(), root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      // reset window
      movieViewController.reset();
    }
    return movieViewController.getRoot();
  }

}
