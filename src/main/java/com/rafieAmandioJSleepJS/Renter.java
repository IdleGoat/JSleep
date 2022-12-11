package com.rafieAmandioJSleepJS;


import com.rafieAmandioJSleepJS.dbjson.Serializable;

/**
 * This class is used to store the information of a renter.
 * @author Rafie Amandio
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

    /**
     * Renter Constructor
     * @param username username of the renter
     * @param phoneNumber phone number of the renter
     * @param address address of the renter
     */
    public Renter(String username, String phoneNumber, String address){
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * to validate the renter name and phone
     * @return true if it is valid, false if it is not
     */
    public boolean validate(){
        if(this.username.matches(REGEX_NAME) && this.phoneNumber.matches(REGEX_PHONE)){
            return true;
        }
        return false;
    }



}
