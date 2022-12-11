package com.rafieAmandioJSleepJS.controller;

import com.rafieAmandioJSleepJS.*;
import com.rafieAmandioJSleepJS.dbjson.JsonAutowired;
import com.rafieAmandioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Payment Controller class
 * This class is used to payment room API
 */
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value= Payment.class,filepath = "src/main/java/com/json/payment.json")
    public static JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    /**
     * accept payment status
     * @param id payment id
     * @return boolean status if the accept is success or not
     */
    @PostMapping("/{id}/accept")
    public boolean accept( @PathVariable int id ){

        Payment payment = Algorithm.<Payment>find(paymentTable,payment1 -> payment1.id == id);
        if(payment == null || payment.status != Invoice.PaymentStatus.WAITING){
            return false;
        }
        else{
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }

    }

    /**
     * reject payment status
     * @param id payment id
     * @return boolean status if the reject is success or not
     */
    @PostMapping("/{id}/cancel")
    public boolean cancel(@PathVariable int id ){
        Payment payment = Algorithm.<Payment>find(paymentTable,payment1 -> payment1.id == id);
        if(payment == null || payment.status != Invoice.PaymentStatus.WAITING){
            return false;
        }
        Account buyer = Algorithm.<Account>find(AccountController.accountTable,account -> account.id == payment.buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable,room1 -> room1.id == payment.getRoomId());
        payment.status = Invoice.PaymentStatus.FAILED;
        buyer.balance += room.price.price;
        return true;

    }

    /**
     * Creating new payment
     * @param buyerId buyer id
     * @param renterId renter id
     * @param roomId room id
     * @param from from date
     * @param to to date
     * @return Payment object of the newly made payment
     * @author Rafie Amandio
     * @throws ParseException
     */
    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ) throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);
        Account buyer = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == roomId);
        System.out.println(Payment.availability(fromDate,toDate,room));
        System.out.println(buyer.balance);
        System.out.println(room.price.price);

        if (buyer == null || room == null || buyer.balance <= room.price.price || !Payment.availability(fromDate, toDate, room)) {
            return null;
        }
        else{

            if(Payment.makeBooking(fromDate, toDate, room)){
                try{
                    Payment payment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
                    long diff = toDate.getTime() - fromDate.getTime();
                    long diffDays = diff / (24 * 60 * 60 * 1000);
                    buyer.balance -= (room.price.price * diffDays);
                    payment.status = Invoice.PaymentStatus.WAITING;
                    paymentTable.add(payment);
                    return payment;
                }catch (Exception e){
                    return null;
                }
            }
            else{
                return null;
            }
        }

    }
    @PostMapping("/submit")
    public boolean submit( @RequestParam int id ){
        return false;
    }

    /**
     * Get All Payment by renter Id
     * @param renterId renter id
     * @param page page number
     * @param pageSize page size
     * @return List of Payment that belong to renter Id
     */
   @GetMapping("/getOrderForRenter")
    public List<Payment> getOrderForRenter(
            @RequestParam int renterId,
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Payment>paginate(getJsonTable(),page,pageSize,pred -> pred.renterId == renterId);
    }

    /**
     * Get All Payment by buyer Id
     * @param buyerId buyer id
     * @return List of Payment that belong to buyer Id
     */
    @GetMapping("/getOrderForBuyer")
    public List<Payment> getOrderForBuyer(
            @RequestParam int buyerId
    ){
        return Algorithm.<Payment>collect(getJsonTable(),pred -> pred.buyerId == buyerId);
    }


}
