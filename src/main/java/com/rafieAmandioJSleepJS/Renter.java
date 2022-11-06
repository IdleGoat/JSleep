package com.rafieAmandioJSleepJS;


/**
 * Write a description of class Renter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Renter extends Serializable
{
    public String phoneNumber;
    public String address;
    public String username;
    //TODO: Check REGEX
    public final static String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{4,20}$";
    //create regex for phone number minimum 9 digits and maximum 12 digit
    public final static String REGEX_PHONE = "^[0-9]{9,12}$";

    public Renter(String username, String phoneNumber, String address){
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public boolean validate(){
        if(this.username.matches(REGEX_NAME) && this.phoneNumber.matches(REGEX_PHONE)){
            return true;
        }
        return false;
    }

//    public Renter( String username)
//    {
//        super();
//        this.username = username;
//        this.phoneNumber = 0;
//        this.address = "";
//    }
//
//    public Renter( String username, String address){
//        super();
//        this.username = username;
//        this.phoneNumber = 0;
//        this.address = address;
//    }
//
//    public Renter( String username, int phoneNumber){
//        super();
//        this.username = username;
//        this.phoneNumber = phoneNumber;
//        this.address = "";
//    }
//
//    public Renter(String username, int phoneNumber, String address)
//    {
//        super();
//        this.username = username;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//    }


}
