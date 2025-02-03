package Object;

public class User
{
    //user object characteristics taken from MS database
    private int userID;
    private int age;
    private String password;
    private String name;
    private String surname;
    private boolean bManager;
    //constructor for User object
    public User(boolean bManager, String surname, String name, String password, int age, int userID)
    {
        this.bManager = bManager;
        this.surname = surname;
        this.name = name;
        this.password = password;
        this.age = age;
        this.userID = userID;
    }
    //getter and setter methods for User object
    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public boolean isbManager()
    {
        return bManager;
    }

    public void setbManager(boolean bManager)
    {
        this.bManager = bManager;
    }

    //to string method printing user details
    @Override
    public String toString()
    {
        return "User{" +
                "userID=" + userID +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", bManager=" + bManager +
                '}';
    }
}
