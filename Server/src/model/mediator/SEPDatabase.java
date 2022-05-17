package model.mediator;

import model.domain.Movie;
import model.domain.Rental;
import model.domain.User;
import utility.persistence.MyDatabase;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The SEPDatabase class is responsible for managing the connection with Database.
 */
public class SEPDatabase implements SEPPersistence
{
  private MyDatabase db;
  private static final String DRIVER = "org.postgresql.Driver";
  private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
  private static final String USER = "postgres";
  private static final String PASSWORD = "ladubuleve39";

  /**
   * Empty constructor which initializes the db and connects the database
   */
  public SEPDatabase() throws ClassNotFoundException
  {
    this.db = new MyDatabase(DRIVER, URL, USER, PASSWORD);
  }

  /**
   * @param name        the name of the user
   * @param phoneNumber the phone number of the user
   * @param userName    the username of the user
   * @param password    the password of the user
   * @param dob         the date of birth of the user
   *                    adds user to database
   * @throws SQLException
   */
  @Override public void addUser(String name, String phoneNumber,
      String userName, String password, Date dob) throws SQLException
  {
    String sql =
        "insert into person(name, phoneNumber, userName, password, birthDate)  "
            + "VALUES (?, ?, ?, ?, ?);";
    db.update(sql, name, phoneNumber, userName, password, dob);

  }

  /**
   * @param movie adds movie to database
   * @throws SQLException
   */
  @Override public void addMovie(Movie movie) throws SQLException
  {
    String sql =
        " insert into movies(movieName, director, length, movieDescription, avgRating, releaseYear)"
            + "VALUES (?, ?, ?, ?, ?);";
    db.update(sql, movie.getTitle(), movie.getDirector(), movie.getLength(),
        movie.getDescription(), movie.getAvgRating(),
        movie.getReleaseYear()); //add a release year to movie class. make movie class match database
  }

  /**
   * @return an arraylist with the top 10 highest rated movies from the database
   * @throws SQLException
   */
  @Override public ArrayList<Movie> getTop10TopRatedMovies() throws SQLException
  {
    String sql = "select * from movies order by avgRating DESC limit 10;";
    ArrayList<Object[]> results = db.query(sql);
    ArrayList<Movie> top = new ArrayList<>();
    for (int i = 0; i < results.size(); i++)
    {
      Object[] row = results.get(i);
      //movie should have movieName, director, length, movieDescription, avgRating, releaseYear
      Movie movie = new Movie("","",0,"",0,0,"", new ArrayList<>());
      for (int j = 0; j < row.length; j++)
      {
        switch (j)
        {
          case 0:
            movie.setTitle(String.valueOf(row[j]));
            break;
          case 1:
            movie.setDirector(String.valueOf(row[j]));
            break;
          case 2:
            movie.setLength(Integer.parseInt((String.valueOf(row[j]))));
            break;
          case 3:
            movie.setDescription(String.valueOf(row[j]));
            break;
          case 4:
            movie.setAvgRating(Double.parseDouble(String.valueOf(row[j])));
            break;
          case 5:
            movie.setReleaseYear(Integer.parseInt(String.valueOf(row[j])));
            break;
          default:
            break;
        }
      }
      top.add(movie);
    }
    return top;
  }

  /**
   * @return an arraylist with all the movies from the database
   * @throws SQLException
   */
  @Override public ArrayList<Movie> getAllMovies() throws SQLException
  {
    String sql = "select * from sep.movies;";
    ArrayList<Object[]> results = db.query(sql);
    ArrayList<Movie> all = new ArrayList<>();
    for (int i = 0; i < results.size(); i++)
    {
      Object[] row = results.get(i);
      Movie movie = new Movie("","",0,"",0.0,0,"", new ArrayList<>());
      for (int j = 0; j < row.length; j++)
      {
        switch (j)
        {
          case 1:
            movie.setTitle(String.valueOf(row[j]));
            break;
          case 2:
            movie.setDirector(String.valueOf(row[j]));
            break;
          case 3:
            movie.setLength(Integer.parseInt(String.valueOf(row[j])));
            break;
          case 4:
            movie.setDescription(String.valueOf(row[j]));
            break;
          case 5:
            movie.setAvgRating(Double.parseDouble(String.valueOf(row[j])));
            break;
          case 6:
            movie.setReleaseYear(Integer.parseInt(String.valueOf(row[j])));
            break;
          case 7:
            movie.setGenres(String.valueOf(row[j]));
            break;
          default:
            break;
        }
      }
      all.add(movie);
    }
    return all;
  }

  /**
   * @param expirationDate
   * @param userName
   * @param movieID
   * adds a rental to the database
   * @throws SQLException
   */
  @Override public void addRental(Date expirationDate, String userName,
      int movieID) throws SQLException
  {

    String sql = "insert into rentals(expirationDate, userName, movieID)"
        + "VALUES (?, ?, ?);";
    //db.update(sql, rental.getExpirationDate(), rental.getUserName(),
      //  rental.getMovieID()); //edit rental to match database and add getters + setters

  }

  /**
   * @return an arraylist with all the rentals from the database
   * @throws SQLException
   */
  @Override public ArrayList<Rental> getAllRentals() throws SQLException
  {
    String sql = "select * from rentals;";
    ArrayList<Object[]> results = db.query(sql);
    ArrayList<Rental> all = new ArrayList<>();
    for (int i = 0; i < results.size(); i++)
    {
      Object[] row = results.get(i);
      //rental should have expirationDate, userName, movieID
      Rental rental = new Rental(null, null, null);
      for (int j = 0; j < row.length; j++)
      {
        switch (j)
        {
          case 0:
            //rental.setExpirationDate(); no idea how to parse a date
            break;
          case 1:
            rental.setUserName(String.valueOf(row[j]));
            break;
          case 2:
           // rental.setMovieID(Integer.parseInt((String.valueOf(row[j]))));
            break;
          default:
            break;
        }
      }
      all.add(rental);
    }
    return all;

  }

  /**
   * @param user
   * @return an arraylist with all the rentals of the user from the database
   * @throws SQLException
   *
   */
  @Override public ArrayList<Rental> getRentalsWithUser(User user)
      throws SQLException
  {
    String sql = "select * from rentals r join movies m on m.movieName = r.movieTitle ;";
    ArrayList<Object[]> results = db.query(sql);
    ArrayList<Rental> all = new ArrayList<>();
    for (int i = 0; i < results.size(); i++)
    {
      Object[] row = results.get(i);

      Rental rental = new Rental(null, null, user);
      Movie rentedMovie = new Movie("","",0,"",0.0,0,"",new ArrayList<>());
      if (user.getUserName().equals(String.valueOf(row[1]))){
      for (int j = 0; j < row.length; j++)
      {
        switch (j)
        {
          case 0:
            rental.setExpirationDate(Date.valueOf((LocalDate) row[j]));//not sure how correct this is
            break;
          case 1:
            rental.setUserName(String.valueOf(row[j]));
            break;
          case 4:
            rentedMovie.setTitle(String.valueOf(row[j]));
            break;
          case 5:
            rentedMovie.setDirector(String.valueOf(row[j]));
          break;
          case 6:
            rentedMovie.setLength(Integer.parseInt((String.valueOf(row[j]))));
            break;
          case 7:
            rentedMovie.setDescription(String.valueOf(row[j]));
            break;
          case 8:
            rentedMovie.setAvgRating(Double.parseDouble(String.valueOf(row[j])));
            break;
          case 9:
            rentedMovie.setReleaseYear(Integer.parseInt((String.valueOf(row[j]))));
            break;
          case 10:
            rentedMovie.setGenres(String.valueOf(row[j]));
            break;
          default:
            break;
        }
      }
      rental.setRentedMovie(rentedMovie);
      all.add(rental);
    }}
    return all;

  }

  @Override public Movie getMovieWithTitle(String title) throws SQLException
  {
    return null;
  }

}
