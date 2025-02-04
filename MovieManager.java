package Manager;
import Object.Movie;
import Object.DBManager;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MovieManager
{
    //movie object array to store movie details
    private Movie[] mArr = new Movie[100];
    //keeping track of movies there are in array
    private int count = 0;
    //db manager to store data in MS database
    private DBManager dbManager = new DBManager();
    //constructor retrieving all data from MS database
    public MovieManager()
    {
        //string query to run in database
        String sql = "SELECT* FROM tblMovie";
        //trying dangerous code
        try
        {
            //querying database for info
            ResultSet rs = dbManager.queryDatabase(sql);
            //movie temp variables
            int movieID;
            String strMoviename;
            Date ReleaseDate;
            String strAgerestriction;
            int capacity;
            double price;
            //running loop until there's no more data left in database to store
            while(rs.next())
            {
                movieID = rs.getInt("MovieID");
                strMoviename = rs.getString("MovieName");
                strAgerestriction = rs.getString("AgeRestriction");
                ReleaseDate = rs.getDate("ReleaseDate");
                capacity = rs.getInt("Capacity");
                price = rs.getDouble("Price");

                mArr[count] = new Movie(movieID, strMoviename, strAgerestriction, ReleaseDate, capacity, price);

            }
        }
        //handling sql exception error
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    //method to view all records in the table
    public ResultSet displayMovies()
    {

    }
    //method to create/update table
    public void editMovies(Movie movie, int m, String n, String a, Date r, int capacity, double price)
    {

    }
    //method to return int movie ID using movie name
    public int getMovieID(String n)
    {

    }
    //method to return string name of movie using movie ID
    public String getMovieName(int n)
    {

    }
    //method to return string age restriction of movie using movie ID
    public String getAgeRestriction(int n)
    {

    }
    //method to sort movies in table in ascending or descending order
    public ResultSet sortMovie(String field, String order)
    {

    }
}
