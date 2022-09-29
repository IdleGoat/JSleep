package rafieAmandioJSleepJS;

public class Room extends Serializable
{
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public BedType bedType;
    public City city;

    public Room(int id,String name, int size, Price price, Facility facility,City city, String address){
        super(id);
        this.name = name;
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
}
