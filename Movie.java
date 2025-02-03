package Object;

import java.util.Date;

public class Movie
{
    //movie characteristics from MS database
    private int movieID;
    private String movieName;
    private Date ReleaseDate;
    private int ageRestriction;
    private int capacity;
    private double price;
    //constructor for movie
    public Movie(int movieID, String movieName, Date releaseDate, int ageRestriction, int capacity, double price)
    {
        this.movieID = movieID;
        this.movieName = movieName;
        ReleaseDate = releaseDate;
        this.ageRestriction = ageRestriction;
        this.capacity = capacity;
        this.price = price;
    }
    //getter and setter methods
    public int getMovieID()
    {
        return movieID;
    }

    public void setMovieID(int movieID)
    {
        this.movieID = movieID;
    }

    public String getMovieName()
    {
        return movieName;
    }

    public void setMovieName(String movieName)
    {
        this.movieName = movieName;
    }

    public Date getReleaseDate()
    {
        return ReleaseDate;
    }

    public void setReleaseDate(Date releaseDate)
    {
        ReleaseDate = releaseDate;
    }

    public int getAgeRestriction()
    {
        return ageRestriction;
    }

    public void setAgeRestriction(int ageRestriction)
    {
        this.ageRestriction = ageRestriction;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
    //to string method returning movie variables
    @Override
    public String toString()
    {
        return "Movie{" +
                "movieID=" + movieID +
                ", movieName='" + movieName + '\'' +
                ", ReleaseDate=" + ReleaseDate +
                ", ageRestriction=" + ageRestriction +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
