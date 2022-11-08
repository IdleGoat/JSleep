package com.rafieAmandioJSleepJS;


import com.rafieAmandioJSleepJS.dbjson.Serializable;

/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Serializable
{
    public double balance;
    public Renter renter;
    public String name;
    public String email;
    public String password;
    public  static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public  static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
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

    public boolean validate(){
        return this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD);
    }

}