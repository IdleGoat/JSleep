package com.rafieAmandioJSleepJS;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This class is used to represent a payment
 * @author Rafie Amandio
 * @see Invoice
 */
public class Payment extends Invoice
{
    public Date to;
    public Date from;
    private int roomId;

    /**
     * Payment Constructor
     * @param buyerId id of the buyer
     * @param renterId id of the renter
     * @param roomId id of the room
     * @param from date of the start of the booking
     * @param to date of the end of the booking
     */
    public Payment(int buyerId, int renterId,int roomId,Date from,Date to)
    {
        super(buyerId, renterId);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    /**
     * Payment Constructor
     * @param buyer account of the buyer
     * @param renter account of the renter
     * @param roomId id of the room
     * @param from date of the start of the booking
     * @param to date of the end of the booking
     */
    public Payment(Account buyer,Renter renter,int roomId,Date from,Date to){
        super(buyer,renter);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }
    
    public String print(){
        return "Id :" + this.id + " BuyerId :" + buyerId + " RenterId : " + renterId +
          " RoomId : " + roomId + " From : " + from + " To : " + to;
    }
    
    public int getRoomId(){
        return roomId;
    }
    
//    public String getTime(){
//        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
//
//        return "Formatted Date = " + sdf.format(this.time.getTime());
//    }

    public static boolean makeBooking(Date from,Date to,Room room){
        if(availability(from, to, room)){

            while (from.before(to)){
                room.booked.add(from); // Assign ke array
                Calendar tempVar = Calendar.getInstance();
                tempVar.setTime(from);
                tempVar.add(Calendar.DATE, 1); //Increment 1
                from = tempVar.getTime();
            }
            return true;
        }
        else{
            return false;
        }

    }

    //Todo : logic for checking availability and booking
    public static boolean availability(Date from,Date to,Room room){


        if(from.after(to) || from.equals(to)){
            return false;
        }

        for (Date i : room.booked) {
            if (from.equals(i)) {
                return false;
            } else if(from.before(i)){
                if(from.before(i) && to.after(i)){
                    return false;
                }
            }
        }
        return true;
    }




}
