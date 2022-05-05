package viewmodel;

import model.Movie;

public class ViewModelState
{

 private Movie movie;


 public ViewModelState(Movie movie){
   this.movie = movie;
 }

 public Movie getSelectedMovie(){
   return movie;
 }

 public void setMovie(Movie movie){
   this.movie = movie;
 }

}
