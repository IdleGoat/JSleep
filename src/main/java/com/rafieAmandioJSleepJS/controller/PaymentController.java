package com.rafieAmandioJSleepJS.controller;

import com.rafieAmandioJSleepJS.*;
import com.rafieAmandioJSleepJS.dbjson.JsonAutowired;
import com.rafieAmandioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value= Payment.class,filepath = "src/main/java/com/json/payment.json")
    public static JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

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



        if (buyer == null || room == null || buyer.balance <= room.price.price || !Payment.availability(fromDate, toDate, room)) {
            return null;
        }
        else{
            Payment payment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
            buyer.balance -= room.price.price;
            payment.status = Invoice.PaymentStatus.WAITING;
            if(payment.makeBooking(fromDate, toDate, room)){
                paymentTable.add(payment);
                return payment;
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


}
