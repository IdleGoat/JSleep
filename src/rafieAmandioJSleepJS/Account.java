package rafieAmandioJSleepJS;


/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Serializable implements FileParser
{
    public String name;
    public String email;
    public String password;
    public Account(String name,String email,String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String toString(){
        return "Account\nId: " + super.id + "\nName: " + name + "\nEmail: " + email + "\nPassword: " + password;
    }

    public Object write(){
        return null;
    }
    public boolean read(String string){
        return false;
    }


}