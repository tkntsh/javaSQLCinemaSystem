package Object;

import java.sql.*;

public class DBManager
{
    //storing database location to locate database
    private String url = "jdbc:ucanaccess://CinemaSystem.accdb";
    //initiating a connection between database and java
    private Connection conn = null;
    //db constructor
    public DBManager()
    {
        //try catch handling exceptions
        try
        {
            //establishing connection
            conn = DriverManager.getConnection(url);
            System.out.println("Connection Successful!");
        }
        //error handling
        catch (SQLException e)
        {

            throw new RuntimeException(e);
        }
    }
    //method to run to execute queries on database
    public ResultSet queryDatabase(String sql) throws SQLException
    {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet set = preparedStatement.executeQuery();
        return set;
    }
    //method to run to execute update query on database
    public void updateQuery(String sql) throws SQLException
    {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.execute();
    }
}
