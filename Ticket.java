package Object;

public class Ticket
{
    private int ticketID;
    private int movieID;
    private int userID;
    private String seatNo;
    //constructor for ticket variables
    public Ticket(int ticketID, int movieID, int userID, String seatNo)
    {
        this.ticketID = ticketID;
        this.movieID = movieID;
        this.userID = userID;
        this.seatNo = seatNo;
    }
    //getter and setter methods
    public int getTicketID()
    {
        return ticketID;
    }

    public void setTicketID(int ticketID)
    {
        this.ticketID = ticketID;
    }

    public int getMovieID()
    {
        return movieID;
    }

    public void setMovieID(int movieID)
    {
        this.movieID = movieID;
    }

    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public String getSeatNo()
    {
        return seatNo;
    }

    public void setSeatNo(String seatNo)
    {
        this.seatNo = seatNo;
    }
    //to string method to return ticket variables
    @Override
    public String toString()
    {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", movieID=" + movieID +
                ", userID=" + userID +
                ", seatNo='" + seatNo + '\'' +
                '}';
    }
}
