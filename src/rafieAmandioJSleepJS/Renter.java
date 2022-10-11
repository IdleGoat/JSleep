package rafieAmandioJSleepJS;


/**
 * Write a description of class Renter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Renter extends Serializable
{
    public int phoneNumber;
    public String address;
    public String username;

    public Renter( String username)
    {
        super();
        this.username = username;
        this.phoneNumber = 0;
        this.address = "";
    }

    public Renter( String username, String address){
        super();
        this.username = username;
        this.phoneNumber = 0;
        this.address = address;
    }

    public Renter( String username, int phoneNumber){
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = "";
    }

    public Renter(String username, int phoneNumber, String address)
    {
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }


}
