package com.rafieAmandioJSleepJS;


import com.rafieAmandioJSleepJS.dbjson.Serializable;

/**
 * This class is used to store the information of a user account.
 * @author Rafie Amandio
 * @see Serializable
 */
public class Account extends Serializable
{
    /**
     * The balance of the account.
     */
    public double balance;
    /**
     * The renter of the account.
     */
    public Renter renter;
    /**
     * The owner of the account.
     */
    public String name;
    /**
     * The email of the account.
     */
    public String email;
    /**
     * The password of the account.
     */
    public String password;
    /**
     * Regex for the email. Email should be in the format of
     * in the format of local@domain, example : amandio@ui.ac.id
     * local only contains alphanumeric characters and can't contain
     * any special characters or whitespace. domain can't contain any number
     */
    public  static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    /**
     * Regex for the password. Password should be at least 8 characters long
     * and contain at least 1 uppercase letter, 1 lowercase letter, 1 number, and no whitespace
     */
    public  static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    /**
     * This is the constructor for the Account class.
     * @author Rafie Amandio
     * @param name The name of the account.
     * @param email The email of the account.
     * @param password The password of the account.
     *                 The password must contain at least 8 characters, 1 uppercase, 1 lowercase, and 1 number
     */
    public Account(String name,String email,String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
    }


    public String toString(){
        return "Account\nId: " + super.id + "\nName: " + name + "\nEmail: " + email + "\nPassword: " + password;
    }
    /**
     * This method is used to validate the email and password of the account.
     * @author Rafie Amandio
     * @return Returns true if the email and password are valid.
     */
    public boolean validate(){
        return this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD);
    }

}
