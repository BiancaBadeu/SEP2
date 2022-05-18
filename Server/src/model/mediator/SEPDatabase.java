package model.mediator;

import model.domain.Movie;
import model.domain.Rental;
import model.domain.User;
import utility.persistence.MyDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Locale;

/**
 * The SEPDatabase class is responsible for managing the connection with Database.
 */
public class SEPDatabase implements SEPPersistence
{
  private MyDatabase db;
  private static final String DRIVER = "org.postgresql.Driver";
  private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
  private static final String USER = "postgres";
  private static final String PASSWORD = "Perfect@gamer333";

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
   * @param age         the age of the user
   *                    adds user to database
   * @throws SQLException
   */
  @Override public void addUser(String name, String phoneNumber,
      String userName, String password, int age) throws SQLException
  {
    String sql =
        "insert into sep.person(name, phoneNumber, userName, password, age)  "
            + "VALUES (?, ?, ?, ?, ?);";
    db.update(sql, name, phoneNumber, userName, password, age);

  }

  @Override public User getUser(String userName) throws SQLException
  {
    String sql = "select * from sep.person;";
    ArrayList<Object[]> results = db.query(sql);
    User user = new User("","","","",0);
    for (int i = 0; i < results.size(); i++)
    {
      Object[] row = results.get(i);
      for (int j = 0; j < row.length; j++)
      {
        if(row[2].equals(userName))
        {
          switch (j)
          {
            case 0:
              user.setName(String.valueOf(row[j]));
              break;
            case 1:
              user.setPhoneNumber(String.valueOf(row[j]));
              break;
            case 2:
              user.setUserName(String.valueOf(row[j]));
              break;
            case 3:
              user.setPassword(String.valueOf(row[j]));
              break;
            case 4:
              user.setAge(Integer.parseInt(String.valueOf(row[j])));
              break;
          }
        }
      }
    }
    return user;
  }
  /**
   * @param movie adds movie to database
   * @throws SQLException
   */
  @Override public void addMovie(Movie movie) throws SQLException
  {
    String sql =
        " insert into sep.movies(movieName, director, length, movieDescription, avgRating, releaseYear, genre)"
            + "VALUES (?, ?, ?, ?, ?,?,?);";
    db.update(sql, movie.getTitle(), movie.getDirector(), movie.getLength(),
        movie.getDescription(), movie.getAvgRating(),
        movie.getReleaseYear(), movie.getGenres());
  }
  @Override public void removeMovie(Movie movie) throws SQLException
  {
    String sql =" delete from sep.movies where movieName=?";
    Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
    PreparedStatement statement= connection.prepareStatement(sql);
    statement.setString(1,movie.getTitle());
    statement.executeUpdate();
    connection.close();
  }
  /**
   * @return an arraylist with the top 10 highest rated movies from the database
   * @throws SQLException
   */
  @Override public ArrayList<Movie> getTop10TopRatedMovies() throws SQLException
  {
    String sql = "select * from sep.movies order by avgRating DESC limit 10;";
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
      Movie movie = new Movie("", "", 0, "", 0.0, 0, "", new ArrayList<>());

      Object[] row = results.get(i);
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
              movie.setLength(Integer.parseInt(String.valueOf(row[j])));
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
            case 6:
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

  @Override public Movie getMovieWithTitle(String title) throws SQLException
  {
    String sql = "select * from sep.movies;";

    ArrayList<Object[]> results = db.query(sql);
    Movie movie = new Movie("", "", 0, "", 0.0, 0, "", new ArrayList<>());
    for (int i = 0; i < results.size(); i++)
    {
      Object[] row = results.get(i);
      for (int j = 0; j < row.length; j++)
      {
        if (row[0].equals(title))
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
              movie.setLength(Integer.parseInt(String.valueOf(row[j])));
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
            case 6:
              movie.setGenres(String.valueOf(row[j]));
              break;
            default:
              break;
          }
        }
      }
    }
      return movie;
  }

  /**
   * @param expirationDate
   * @param user
   * @param rentedMovie
   * @throws SQLException
   */
  @Override public void addRental(Date expirationDate, User user,
      Movie rentedMovie) throws SQLException
  {
    String sql = "insert into sep.rentals(expirationDate, userName, movieTitle)"
        + "VALUES (?, ?, ?);";
    java.sql.Date expirationDateInString
        = new java.sql.Date(expirationDate.getTime());

    db.update(sql, expirationDateInString, user.getUserName(), rentedMovie.getTitle());

  }

  /**
   * @return an arraylist with all the rentals from the database
   * @throws SQLException
   */
  @Override public ArrayList<Rental> getAllRentals() throws SQLException
  {
    String sql = "select * from sep.rentals;";
    ArrayList<Object[]> results = db.query(sql);
    ArrayList<Rental> all = new ArrayList<>();
    for (int i = 0; i < results.size(); i++)
    {
      Object[] row = results.get(i);

      Rental rental = new Rental(null, null, null);
      for (int j = 0; j < row.length; j++)
      {
        switch (j)
        {
          case 0:
            try
            {
              SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy",
                  Locale.ENGLISH);
              String dateInString = String.valueOf(row[j]);
              Date date = (Date) formatter.parseObject(dateInString);
              rental.setExpirationDate(date);
            }
            catch (ParseException e)
            {
              e.printStackTrace();
            }
            break;
          case 1:
            rental.setUser(getUser(String.valueOf(row[j])));
            break;
          case 2:
           rental.setRentedMovie(getMovieWithTitle((String.valueOf(row[j]))));
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
    String sql = "select * from sep.rentals r join sep.movies m on m.movieName = r.movieTitle ;";
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
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy",
                Locale.ENGLISH);
            String dateInString = String.valueOf(row[j]);
            Date date = null;
            try
            {
              date = (Date) formatter.parseObject(dateInString);
            }
            catch (ParseException e)
            {
              e.printStackTrace();
            }
            rental.setExpirationDate(date);
            break;
          case 1:
            rental.setUserName(String.valueOf(row[j]));
            break;
          case 3:
            rentedMovie.setTitle(String.valueOf(row[j]));
            break;
          case 4:
            rentedMovie.setDirector(String.valueOf(row[j]));
          break;
          case 5:
            rentedMovie.setLength(Integer.parseInt((String.valueOf(row[j]))));
            break;
          case 6:
            rentedMovie.setDescription(String.valueOf(row[j]));
            break;
          case 7:
            rentedMovie.setAvgRating(Double.parseDouble(String.valueOf(row[j])));
            break;
          case 8:
            rentedMovie.setReleaseYear(Integer.parseInt((String.valueOf(row[j]))));
            break;
          case 9:
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



}