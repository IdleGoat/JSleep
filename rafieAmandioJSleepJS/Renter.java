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

    public Renter(int id, String username)
    {
        super(id);
        this.username = username;
        this.phoneNumber = 0;
        this.address = "";
    }

    public Renter(int id, String username, String address){
        super(id);
        this.username = username;
        this.phoneNumber = 0;
        this.address = address;
    }

    public Renter(int id, String username, int phoneNumber){
        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = "";
    }

    public Renter(int id, String username, int phoneNumber, String address)
    {
        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }


}
