package rafieAmandioJSleepJS;
import java.util.Calendar;
import java.util.Date;


public class Invoice extends Serializable
{
    public int buyerId;
    public int renterId;
    public Date time;
    public PaymentStatus status;
    public RoomRating rating;

    protected Invoice(int id, int buyerId, int renterId)
    {
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = new Date();
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }

    public Invoice(int id,Account buyer, Renter renter)
    {
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = new Date();
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
    }

    public String print()
    {
        return "Id :" + id + " BuyerId :" + buyerId + " RenterId : " + renterId +
        " Time : " + time ;

    }
    
    public enum RoomRating{
        NONE,BAD,NEUTRAL,GOOD
    }
    
    public enum PaymentStatus{
        FAILED,WAITING,SUCCESS
    }
    
    
}
