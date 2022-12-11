package com.rafieAmandioJSleepJS;
import com.rafieAmandioJSleepJS.dbjson.Serializable;


/**
 * This class is used to store the information of an invoice.
 * @author Rafie Amandio
 */
public class Invoice extends Serializable
{

    public int buyerId;
    public int renterId;
    //public Date time;
    public PaymentStatus status;
    public RoomRating rating;

    /**
     * Invoice Constructor
     * @param buyerId id of the buyer
     * @param renterId id of the renter
     */
    protected Invoice(int buyerId, int renterId)
    {
        super();
        this.buyerId = buyerId;
        this.renterId = renterId;
        //this.time = new Date();
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }

    /**
     * Invoice Constructor
     * @param buyer account of the buyer
     * @param renter Renter of the renter
     */
    public Invoice(Account buyer, Renter renter)
    {
        super();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
       // this.time = new Date();
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }

    public String print()
    {
        return "Id :" + id + " BuyerId :" + buyerId + " RenterId : " + renterId;

    }

    /**
     * Enum for Room Rating
     */
    public enum RoomRating{
        NONE,BAD,NEUTRAL,GOOD
    }

    /**
     * Enum for Payment Status
     */
    public enum PaymentStatus{
        FAILED,WAITING,SUCCESS
    }
    
    
}
