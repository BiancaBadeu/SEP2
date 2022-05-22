package model.mediator;

import model.domain.*;

import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * The ModelManager class is the main class of the model. It is responsible for managing the model.
 */
public class ModelManager implements Model
{
  private MovieList movieList;
  private RentalList rentalList;
  private PersonList personList;

  private SEPPersistence database;

  /**
   * Empty constructor which initializes the movieList, rentalList, personList, and database
   */
  public ModelManager()
  {
    this.movieList = new MovieList();
    this.rentalList = new RentalList();
    this.personList = new PersonList();
    try
    {
      this.database = new SEPDatabase();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @throws SQLException exception
   *                      A method to get the information from the database and store it
   */
  public void getAllInfo() throws SQLException
  {
    PersonList persons = new PersonList();
    if (!database.getAllPersons().isEmpty())
    {
      for (int i = 0; i < database.getAllPersons().size(); i++)
      {
        persons.addPerson(database.getAllPersons().get(i).getName(),
            database.getAllPersons().get(i).getUserName(),
            database.getAllPersons().get(i).getPassword(),
            database.getAllPersons().get(i).getPhoneNumber(),
            database.getAllPersons().get(i).getAge(),
            database.getAllPersons().get(i).getType());
      }
      this.personList = persons;
    }

    RentalList rentals = new RentalList();
    if (!database.getAllRentals().isEmpty())
    {
      for (int i = 0; i < database.getAllRentals().size(); i++)
      {
        rentals.addRental(database.getAllRentals().get(i).getRentedMovie(),
            database.getAllRentals().get(i).getExpirationDate(),
            database.getAllRentals().get(i).getUser());
      }
      this.rentalList = rentals;
    }

    MovieList movies = new MovieList();
    if (!database.getAllMovies().isEmpty())
    {
      for (int i = 0; i < database.getAllMovies().size(); i++)
      {
        movies.addMovie(database.getAllMovies().get(i));
      }
      this.movieList = movies;
    }
  }

  /**
   * @param name        the person's name to be added
   * @param username    the person's username to be added
   * @param password    the person's password to be added
   * @param phoneNumber the person's phone number to be added
   * @param age         the person's age to be added
   * @param type        the person's type to be added
   *                    A method to add a person to the person list
   */
  public void addPerson(String name, String username, String password,
      String phoneNumber, int age, String type)
  {
    personList.addPerson(name, username, password, phoneNumber, age, type);
  }

  /**
   * @return an array list containing the movies that are not rented
   */
  @Override public ArrayList<Movie> getNotRentedMovies()
  {
    int deleted = 0;
    ArrayList<Movie> allMovies = getAllMovies();
    for(int i=0;i<getAllMovies().size();i++)
    {
      deleted = 0;
      Movie toCheck = getAllMovies().get(i);
      for(int j=0; j<getAllRentals().size() && deleted == 0;j++)
      {
        if(toCheck.equals(getAllRentals().get(i).getRentedMovie()))
        {
          allMovies.remove(toCheck);
          deleted = 1;
        }
      }
    }
    return allMovies;
  }

  /**
   * @param title the title of the movie
   * @return a boolean true if the movie is rented, false if it isn't
   */
  public boolean checkMovieIsRented(String title)
  {
    ArrayList<Rental> rentals = rentalList.getRentalsWithMovie(
        getMovieWithTitle(title));
    return !rentals.isEmpty();
  }

  /**
   * @param movie the movie to be added to the movie list
   *              A method to add a movie to the movie list
   */
  public void addMovie(Movie movie)
  {
    try
    {
      database.addMovie(movie);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @param movie the movie to be removed
   *              A method to remove a movie from the movie list
   */
  @Override public void removeMovie(Movie movie)
  {
    {
      try
      {
        database.removeMovie(movie);
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }

  /**
   * @return the top 10 movies with the highest average ratings
   * A method to return the top 10 movies with the highest average ratings
   */
  @Override public ArrayList<Movie> getTop10TopRatedMovies()
  {
    return movieList.getTop10TopRatedMovies();
  }

  /**
   * @param title the title of the movie
   * @return an array list with movies that contain that title
   */
  @Override public ArrayList<Movie> getMovieLike(String title)
  {
    return movieList.getMovieLike(title);
  }

  /**
   * @param title the title of the movie
   * @return a movie object with that title
   */
  @Override public Movie getMovieWithTitle(String title)
  {
    /*try
    {
      return database.getMovieWithTitle(title);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

     */

    for(int i=0;i<movieList.getAllMovies().size();i++)
    {
      if(movieList.getAllMovies().get(i).getTitle().equals(title))
      {
        return movieList.getAllMovies().get(i);
      }
    }


    return null;
  }

  /**
   * @return the trending movies
   * A method to return the trending movies
   */
  @Override public ArrayList<Movie> getTrendingMovies()
  {
    return movieList.getTrendingMovies();
  }

  /**
   * @return the movie list
   * A method to return the movie list
   */
  public ArrayList<Movie> getAllMovies()
  {
    try
    {
      return database.getAllMovies();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public ArrayList<Movie> getMoviesWithGenre(String genre)
  {
    try
    {
      getAllInfo();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return movieList.getMoviesWithGenre(genre);
  }

  /**
   * @param listener the listener to be added
   *                 A method to add a listener
   */
  @Override public void addListener(PropertyChangeListener listener)
  {
  }

  /**
   * @param movie          the movie to be rented
   * @param expirationDate the expiration date of the rental
   *                       A method to add a rental to the rental list
   */
  @Override public void addRental(Movie movie, Date expirationDate, User user)
  {
    try
    {
      database.addRental(expirationDate, user, movie);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @return all rentals
   * A method to return all rentals
   */
  @Override public ArrayList<Rental> getAllRentals()
  {
    try
    {
      return database.getAllRentals();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * @param title the title of the movie
   * @param user  the user
   *              A method to remove a rental from the rental list
   */
  @Override public void cancelRental(String title, User user)
  {

    rentalList.removeRental(title, user);
  }

  /**
   * @param user the user
   * @return an array list with rental which contains the user
   */
  @Override public ArrayList<Rental> getRentalsWithUser(User user)
  {
    try
    {
      return database.getRentalsWithUser(user);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return rentalList.getRentalsWithUser(user);
  }
/*
--For the next sprint :)
  @Override public ArrayList<Rental> getRentalsWithMovie(Movie movie)
  {
    return rentalList.getRentalsWithMovie(movie);
  }
*/

  /**
   * @param listener the listener to be removed
   *                 A method to remove a listener
   */
  public void removeListener(PropertyChangeListener listener)
  {
  }

  /**
   * @param title a String variable representing the title of a movie
   * @param user  the user
   *              //@param averageRating a String variable representing the average rating of a movie
   *              A method to check if the user can rent the movie
   */
  @Override public void rentMovie(String title, User user)
  {
    long rentalDate = System.currentTimeMillis() + (86400 * 7 * 1000);
    Date expirationDate = new Date(rentalDate);
    addRental(movieList.getMovieWithTitle(title), expirationDate, user);
  }

  /**
   * @param username string variable
   * @param password string variable
   *                 Checks if the username exists and has a matching password
   */
  @Override public void login(String username, String password)
  {
    boolean exists = false;
    for (int i = 0; i < personList.getPersons().size(); i++)
    {
      if (username.equals(personList.getPersons().get(i).getUserName()))
      {
        exists = true;
        if (!(password.equals(personList.getPersons().get(i).getPassword())))
        {
          throw new IllegalArgumentException("password is incorrect");
        }
      }
    }
    if (!exists)
      throw new IllegalArgumentException("The username doesn't exist");
  }

  /**
   * @param name        a String variable representing the name of the user
   * @param userName    a String variable representing the username chosen
   * @param password    a String variable representing the password chosen
   * @param phoneNumber a String variable representing the phone number of the user
   * @param age         a String variable representing the age of the user
   *                    A method to create a new User and add it to the person list
   */
  @Override public void createUser(String name, String userName,
      String password, String phoneNumber, String age)
  {
    for (int i = 0; i < personList.getPersons().size(); i++)
    {
      if (personList.getPersons().get(i).getUserName().equals(userName))
        throw new IllegalStateException("Username already exists!");
    }
    try
    {
      database.addUser(name, phoneNumber, userName, password,
          Integer.parseInt(age));
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * @param userName the username of the person
   * @param password the password of the person
   * @return a String variable, the type of the person (admin, user) or null in case it does not found the person
   */
  @Override public String checkPerson(String userName, String password)
  {
    for (int i = 0; i < personList.getPersons().size(); i++)
    {
      if (personList.getPersons().get(i).getUserName().equals(userName))
      {
        if (personList.getPersons().get(i).getPassword().equals(password))
        {
          return personList.getPersons().get(i).getType();
        }
      }
    }
    return null;
  }

  /**
   * @param userName the username
   * @return a User variable
   * A method to get the user by username (username is unique). Returns null if it does not exist
   */
  @Override public User getUser(String userName)
  {
    for(int i=0;i<personList.getPersons().size();i++)
    {
      if(userName.equals(personList.getPersons().get(i).getUserName()))
        return (User) personList.getPersons().get(i);
    }
    return null;
  }

  /**
   * @param title the title of the movie
   * @return a boolean value to see it we can add a movie
   */
  @Override public boolean validateAddMovie(String title)
  {

    for (int i = 0; i < movieList.getAllMovies().size(); i++)
    {
      if (movieList.getAllMovies().get(i).getTitle().equals(title))
      {
        return false;
      }
    }
    return true;
  }

  /**
   * @param movie the movie
   * @return an array list with the comments for the movie
   */
  public ArrayList<String> getCommentsForMovie(Movie movie)
  {
    return movieList.getCommentsForMovie(movie);
  }

  /**
   * @param comment the comment
   * @param star    the rating
   * @param title   the title of the movie
   *                A method to leave a review
   */
  @Override public void leaveReview(String comment, int star, String title)
  {
    ArrayList<String> badwords = new ArrayList<>();

    badwords.add("fuck");
    badwords.add("shit");
    badwords.add("bitch");
    badwords.add("asshole");
    badwords.add("ass");
    badwords.add("dick");
    badwords.add("cock");
    badwords.add("pussy");
    badwords.add("nigger");
    badwords.add("nigga");
    badwords.add("hitler");
    badwords.add("Helvete");
    badwords.add("puta");
    badwords.add("Kurwa");
    badwords.add("penis");

    for (int i = 0; i < badwords.size(); i++)
    {
      if (comment.contains(badwords.get(i)))
      {
        throw new IllegalArgumentException("Swear words are not allowed!");
      }
    }
    try
    {
      database.addReview(title, star, comment);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }
}

