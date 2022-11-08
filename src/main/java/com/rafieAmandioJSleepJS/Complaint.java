package com.rafieAmandioJSleepJS;


import com.rafieAmandioJSleepJS.dbjson.Serializable;

public class Complaint extends Serializable
{
    public String desc;
    public String date;
    
    public Complaint(String date,String desc){
        super();
        this.desc = desc;
        this.date = date;
    }

    public String toString(){
        return "Complaint\nId:" + super.id + "\nDesc: " + desc + "\nDate:" + date;
    }
}
