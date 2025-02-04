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
            String movieName;
            Date ReleaseDate;
            String ageRestriction;
            int capacity;
            double price;
            //running loop until there's no more data left in database to store
            while(rs.next())
            {
                movieID = rs.getInt("MovieID");
                movieName = rs.getString("MovieName");
                ReleaseDate = rs.getDate("ReleaseDate");
                ageRestriction = rs.getString("AgeRestriction");
                capacity = rs.getInt("Capacity");
                price = rs.getDouble("Price");

                mArr[count] = new Movie(movieID, movieName, ReleaseDate, ageRestriction, capacity, price);
                //increment size of arrary tracking how many movies stored
                count++;
            }
            rs.close();
        }
        //handling sql exception error
        catch(SQLException e)
        {
            System.out.println("Error:" + e);
        }
    }
    //method to view all records in the table
    public ResultSet displayMovies()
    {
        //sql query to run
        String sql = "SELECT* FROM tblMovie";
        ResultSet rs = null;
        //dangeorus code to run
        try
        {
            //running query
            rs = dbManager.queryDatabase(sql);
        }
        //handling exception errors
        catch(SQLException e)
        {
            //printing error
            System.out.println("Error: " + e);
        }
        //returning rs
        return rs;
    }
    //method to create/update table
    public void editMovies(Movie movie, int movieID, String movieName, String ageRestriction, Date ReleaseDate, int capacity, double price)
    {
        //running sql query to update fields
        String sql = "UPDATE tblMovies SET MovieName = '" + movieName + "', AgeRestrcition = '" + ageRestriction + "', ReleaseDate = '" + ReleaseDate
                + "', Capacity = " + capacity + "', Price = " + price + ", WHERE MovieID = " + movieID + ";";

        try
        {
            dbManager.updateQuery(sql);
            int pos = searchMovies(movieID -  1);
            mArr[pos] = new Movie(movieID, movieName, ReleaseDate, ageRestriction, capacity, price);
        }
        catch(SQLException e)
        {
            System.out.println("Error: " + e);
        }
    }
    //int method to search for specific movies in MS database table
    public int searchMovies(int p)
    {
        boolean findPos = false;
        int in = 0;
        int out = 0;

        while(in<count)
        {
            while(findPos == false)
            {
                //searching using movieID int
                if(p == mArr[in].getMovieID())
                {
                    findPos = true;
                    out = in;
                }
                in++;
            }
        }
        return out;
    }
    //method to return int movie ID using movie name
    public int getMovieID(String movieName)
    {
        //sql query to run to find corresponding movie name from database
        String sql = "SELECT MovieID FROM tblMovie WHERE MovieName = '" + movieName + "';";
        //dangerous code
        try
        {
            //running query
            ResultSet rs = dbManager.queryDatabase(sql);
            //running until there's no more data from database
            while(rs.next())
            {
                return rs.getInt("MovieID");
            }
        }
        //handling exceptions
        catch(SQLException e)
        {
            //printing exception
            System.out.println("Error: " + e);
        }
        //return if not found
        return -1;
    }
    //method to remove th position
    public void remove(int r)
    {
        for(int i = r; i<count-1; i++)
        {
            mArr[i] = mArr[i+1];
        }
        count--;
    }
    //method to return string name of movie using movie ID
    public String getMovieName(int movieID)
    {
        //query to run in database
        String sql = "SELECT MovieName FROM tblMovie WHERE MovieID = '" + movieID + "';";
        //dangerous code
        try
        {
            //running query
            ResultSet rs = dbManager.queryDatabase(sql);
            //running until all data in database has been gone through
            while(rs.next())
            {
                //returning movie name from database
                return rs.getString("MovieName");
            }
        }
        //handing exception
        catch(SQLException e)
        {
            //printing error
            System.out.println("Error: " + e);
        }
        //returning if nothing is found
        return "Not found";
    }
    //method to return string age restriction of movie using movie ID
    public String getAgeRestriction(int movieID)
    {
        //query to run in database
        String sql = "SELECT AgeRestriction FROM tblMovie WHERE MovieID = '" + movieID + "';";
        //dangerous code
        try
        {
            //running query
            ResultSet rs = dbManager.queryDatabase(sql);
            //running until all data in database has been gone through
            while(rs.next())
            {
                //returning movie name from database
                return rs.getString("AgeRestriction");
            }
        }
        //handing exception
        catch(SQLException e)
        {
            //printing error
            System.out.println("Error: " + e);
        }
        //returning if nothing is found
        return "Not found";
    }
    //method to sort movies in table in ascending or descending order
    public ResultSet sortMovie(String field, String order)
    {
        if(order.equals("Ascending"))
        {
            //order is already in ascending
            order = "";
        }
        else
        {
            //order in descending
            order = "DESC";
        }
        //sql query to sort tblMovies in database
        String sql = "SELECT* FROM tblMovies ORDER BY " + field + " " + order;
        ResultSet rs = null;
        //dangerous code
        try
        {
            //run query to sort
            rs = dbManager.queryDatabase(sql);
        }
        //handling exception
        catch(SQLException e)
        {
            //printing errors
            System.out.println("Error: " + e);
        }
        return rs;
    }
}
