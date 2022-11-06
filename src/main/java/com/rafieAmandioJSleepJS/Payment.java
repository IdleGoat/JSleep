package com.rafieAmandioJSleepJS;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Payment extends Invoice
{
    public Date to;
    public Date from;
    private int roomId;

    public Payment(int buyerId, int renterId,int roomId,Date from,Date to)
    {
        super(buyerId, renterId);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }
    
    public Payment(Account buyer,Renter renter,int roomId,Date from,Date to){
        super(buyer,renter);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }
    
    public String print(){
        return "Id :" + this.id + " BuyerId :" + buyerId + " RenterId : " + renterId +
        " Time : " + time + " RoomId : " + roomId + " From : " + from + " To : " + to;
    }
    
    public int getRoomId(){
        return roomId;
    }
    
    public String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

        return "Formatted Date = " + sdf.format(this.time.getTime());
    }

    public static boolean makeBooking(Date from,Date to,Room room){
        if(from.after(to)){
            return false;
        }
        if(availability(from,to,room)){
            for (Date date = from; date.before(to);) {
                room.booked.add(date);
                Calendar temp = Calendar.getInstance();
                temp.setTime(date);
                temp.add(Calendar.DATE, 1);
                date = temp.getTime();

            }
            return true;
        }
        return false;

    }

    //Todo : logic for checking availability and booking
    public static boolean availability(Date from,Date to,Room room){

        if(room.booked.size() == 0){
            return true;
        }
        for(Date i : room.booked){
            if( i.after(from) && i.before(to)){
                return false;
            }
        }
        return true;
    }




}
