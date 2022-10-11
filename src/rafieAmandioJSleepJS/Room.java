package rafieAmandioJSleepJS;

import java.util.ArrayList;
import java.util.Date;

public class Room extends Serializable implements FileParser
{
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked;

    public Room(String name, int size, Price price, Facility facility,City city, String address){
        super();
        this.name = name;
        this.booked = new ArrayList<Date>();
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.bedType = BedType.SINGLE;
    }
    
    public String toString(){
        return "Room\nId: " + super.id + "\nName: " + name + "\nSize: " + size + "\nPrice: " + price.price + "\nFacility: " + facility + "\nCity: " + city + "\nAddress: " + address  + "\nBed Type: " + bedType;
    }
    
    public Object write(){
        return null;
    }
    public boolean read(String string){
        return false;
    }
}
