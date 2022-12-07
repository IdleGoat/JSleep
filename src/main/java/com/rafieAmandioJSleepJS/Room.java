package com.rafieAmandioJSleepJS;

import com.rafieAmandioJSleepJS.dbjson.Serializable;

import java.util.ArrayList;
import java.util.Date;

public class Room extends Serializable
{
    public BedType bedType;
    public int accountId;
    public ArrayList<Facility> facility = new ArrayList<Facility>();
    public City city;
    public int size;
    public String name;
    public ArrayList<Date> booked;
    public String address;
    public Price price;

    public Room(int accountId, String name, int size, Price price, ArrayList<Facility> facility, City city, String address){
        super();
        this.accountId = accountId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.bedType = BedType.SINGLE;
        this.booked = new ArrayList<Date>();

    }
    
    public String toString(){
        return "Room\nId: " + accountId + ", Name: " + name + ", Size: " + size + ", Price: " + price.price + ", Facility: " + facility + ", City: " + city + ", Address: " + address  + ", Bed Type: " + bedType;
    }
    
//    public Object write(){
//        return null;
//    }
//    public boolean read(String string){
//        return false;
//    }
}
