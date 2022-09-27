package rafieAmandioJSleepJS;


/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;
    public Account(int id,String name,String email,String password){
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }




}
