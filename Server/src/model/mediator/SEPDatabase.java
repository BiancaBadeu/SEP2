package model.mediator;

import model.domain.*;
import utility.persistence.MyDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Locale;

/**
 * The SEPDatabase class is responsible for managing the connection with Database. Implements SEPPersistence
 * @see SEPPersistence
 */
public class SEPDatabase implements SEPPersistence
{
  private MyDatabase db;
  private static final String DRIVER = "org.postgresql.Driver";
  private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
  private static final String USER = "postgres";
  private static final String PASSWORD = "admin";

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
   * @throws SQLException exception
   *                    A method to add user to database
   */
  @Override public void addUser(String name, String phoneNumber,
      String userName, String password, int age) throws SQLException
  {
    String sql =
        "insert into sep.person(name, phoneNumber, userName, password, age)  "
            + "VALUES (?, ?, ?, ?, ?);";
    db.update(sql, name, phoneNumber, userName, password, age);
  }

  /**
   * @return an array list of all persons in the database.
   * @throws SQLException exception
   */
  @Override public ArrayList<Person> getAllPersons() throws SQLException
  {
    String sql = "select * from sep.person;";
    ArrayList<Object[]> results = db.query(sql);
    ArrayList<Person> all = new ArrayList<>();
    int adminok = 0;

    for (int i = 0; i < results.size(); i++)
    {
      Person user = new User("test", "test", "test", "123456789", 0);
      Person admin = new Admin("test", "test1", "test", "987654321", 0);

      Object[] row = results.get(i);
      for (int j = 0; j < row.length; j++)
      {
        if(!row[2].equals("admin"))
        {
          adminok =1;
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
            default:
              break;
          }
        }
        if(row[2].equals("admin"))
        {
          adminok = 0;
          switch (j)
          {
            case 0:
              admin.setName(String.valueOf(row[j]));
              break;
            case 1:
              admin.setPhoneNumber(String.valueOf(row[j]));
              break;
            case 2:
              admin.setUserName(String.valueOf(row[j]));
              break;
            case 3:
              admin.setPassword(String.valueOf(row[j]));
              break;
            case 4:
              admin.setAge(Integer.parseInt(String.valueOf(row[j])));
              break;
            default:
              break;
          }
        }
      }
      if(adminok == 0)
        all.add(admin);
      else all.add(user);
    }
    return all;
  }



  /**
   * @param userName the username
   * @return a user object
   * @throws SQLException exception
   *        A method that gets a user with that username from the database
   */
  @Override public User getUser(String userName) throws SQLException
  {
    String sql = "select * from sep.person;";
    ArrayList<Object[]> results = db.query(sql);
    User user = new User("testt","test","test","123456789",0);
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
   * @throws SQLException exception
   *      A method that adds the movie to the database.
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

  /**
   * @param movie the movie to be removed
   * @throws SQLException exception
   *        A method that removes the movie from the database.
   */
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
   * @throws SQLException exception
   */
  @Override public ArrayList<Movie> getTop10TopRatedMovies() throws SQLException
  {
    String sql = "select * from sep.movies order by avgRating DESC limit 10;";
    ArrayList<Object[]> results = db.query(sql);
    ArrayList<Movie> top = new ArrayList<>();
    for (int i = 0; i < results.size(); i++)
    {
      Object[] row = results.get(i);
      Movie movie = new Movie("test","test",9,"test",0,1999,"test", new ArrayList<>());
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
      if (!getAllReviewForMovie(movie.getTitle()).isEmpty())
      {
        movie.setReviews(getAllReviewForMovie(movie.getTitle()));
      }
      top.add(movie);
    }
    return top;
  }

  /**
   * @return an arraylist with all the movies from the database
   * @throws SQLException exception
   */
  @Override public ArrayList<Movie> getAllMovies() throws SQLException
  {
    String sql = "select * from sep.movies;";
    ArrayList<Object[]> results = db.query(sql);
    ArrayList<Movie> all = new ArrayList<>();

    for (int i = 0; i < results.size(); i++)
    {
      Movie movie = new Movie("test", "test", 1, "test", 0.0, 1999, "test", new ArrayList<>());

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
      if (!getAllReviewForMovie(movie.getTitle()).isEmpty())
      {
        movie.setReviews(getAllReviewForMovie(movie.getTitle()));
      }
      all.add(movie);
    }
    return all;
  }

  /**
   * @param title the title
   * @return a movie object
   * @throws SQLException exception
   *      A method that returns a movie with that title from the database.
   */
  @Override public Movie getMovieWithTitle(String title) throws SQLException
  {
    String sql = "select * from sep.movies;";

    ArrayList<Object[]> results = db.query(sql);
    Movie movie = new Movie("test", "test", 8, "test", 0.0, 1999, "test", new ArrayList<>());
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
      if (!getAllReviewForMovie(movie.getTitle()).isEmpty())
      {
        movie.setReviews(getAllReviewForMovie(movie.getTitle()));
      }
    }
      return movie;
  }

  /**
   * @param avgRating the average rating
   * @param title     the title
   * @throws SQLException exception
   *      A method to update the average rating of a movie
   */
  @Override public void updateAvgRating(double avgRating, String title) throws SQLException
  {
    String sql = "update sep.movies set avgRating = ? WHERE movieName=?;";
    db.update(sql, avgRating, title);
  }

  /**
   * @param expirationDate the date the rental expires
   * @param user the user
   * @param rentedMovie the rented movie
   * @throws SQLException exception
   *      A method that adds a rental to the database.
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
   * @throws SQLException exception
   */
  @Override public ArrayList<Rental> getAllRentals() throws SQLException
  {
    String sql = "select * from sep.rentals;";
    ArrayList<Object[]> results = db.query(sql);
    ArrayList<Rental> all = new ArrayList<>();
    for (int i = 0; i < results.size(); i++)
    {
      Object[] row = results.get(i);

      Rental rental = new Rental(new Date(), new Movie("test","test",9,"test",0.0, 1999, "test", new ArrayList<>()), new User("test","test","test","123456789",0));
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
   * @param user the user
   * @return an arraylist with all the rentals of the user from the database
   * @throws SQLException exception
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
      Movie rentedMovie = new Movie("test","test",89,"test",0.0,1999,"test",new ArrayList<>());
      Rental rental = new Rental(new Date(), rentedMovie, user);

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

  /**
   * @param title the title
   * @return an array list of reviews of that movie
   * @throws SQLException exception
   */
  public ArrayList<Review> getAllReviewForMovie(String title) throws SQLException
{

  String sql = "select r.movieTitle,r.comment,r.rating from sep.reviewsAndRatings r;";
  ArrayList<Object[]> results = db.query(sql);
  ArrayList<Review> all = new ArrayList<>();

  for (int i = 0; i < results.size(); i++)
  {
    Object[] row = results.get(i);
    Review review = new Review("test",0);

    if (title.equals(String.valueOf(row[0]))){
      for (int j = 0; j < row.length; j++)
      {
        switch (j)
        {
          case 1:
            review.setComment(String.valueOf(row[j]));
            break;
          case 2:
            review.setRating(Integer.parseInt(String.valueOf(row[j])));
            break;
          default:
            break;
        }
      }
      all.add(review);
    }}
  return all;
}

  /**
   * @param title   the title
   * @param star    the rating
   * @param comment the comment
   * @param user    the username
   * @throws SQLException exception
   *        A method to add a review
   */
  @Override public void addReview(String title, int star, String comment, String user)
      throws SQLException
  {
    String sql =
        "insert into sep.reviewsAndRatings(movieTitle, rating ,comment, userName)  "
            + "VALUES (?, ?, ?, ?);";
    db.update(sql,title,star,comment,user);
  }

  /**
   * @param title the title
   * @param username the username
   * @throws SQLException exception
   *      A method that removes the rental for given title of the movie and for that user from the database.
   */
  public void removeRental(String title, String username) throws SQLException
  {
    String sql =" delete from sep.rentals where movietitle=? and username=?;";
    db.update(sql, title, username);
  }

}
