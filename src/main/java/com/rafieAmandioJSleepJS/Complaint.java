package com.rafieAmandioJSleepJS;


import com.rafieAmandioJSleepJS.dbjson.Serializable;

/**
 * This class is used to store the information of a complaint.
 * @author Rafie Amandio
 * @see Serializable
 */
public class Complaint extends Serializable
{
    public String desc;
    public String date;

    /**
     * Complaint Constructor
     * @param date date of the complaint
     * @param desc compaint description
     */
    public Complaint(String date,String desc){
        super();
        this.desc = desc;
        this.date = date;
    }

    public String toString(){
        return "Complaint\nId:" + super.id + "\nDesc: " + desc + "\nDate:" + date;
    }
}
