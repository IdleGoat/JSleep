package rafieAmandioJSleepJS;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Payment extends Invoice
{
    public Calendar to;
    public Calendar from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId,int roomId)
    {
        super(id, buyerId, renterId);
        this.to = Calendar.getInstance();
        this.from = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
        this.roomId = roomId;
    }
    
    public Payment(int id,Account buyer,Renter renter,int roomId){
        super(id,buyer,renter);
        this.to = Calendar.getInstance();
        this.from = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
        this.roomId = roomId;
    }
    
    public String print(){
        return "Id :" + id + " BuyerId :" + buyerId + " RenterId : " + renterId +
        " Time : " + time + " RoomId : " + roomId + " From : " + from + " To : " + to;
    }
    
    public int getRoomId(){
        return roomId;
    }
    
    public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

        return sdf.format(this.time.getTime());
    }

    public String getDuration(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

        return sdf.format(this.from.getTime()) + " - " + sdf.format(to.getTime());
    }

}
