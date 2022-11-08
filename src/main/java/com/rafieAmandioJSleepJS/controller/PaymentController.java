package com.rafieAmandioJSleepJS.controller;

import com.rafieAmandioJSleepJS.Account;
import com.rafieAmandioJSleepJS.Payment;
import com.rafieAmandioJSleepJS.dbjson.JsonAutowired;
import com.rafieAmandioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value= Account.class,filepath = "src/json/account.json")
    public static JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/accept")
    public boolean accept( @RequestParam int id ){
        return false;
    }

    @PostMapping("/cancel")
    public boolean cancel(@RequestParam int id  ){
        return false;
    }

    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ){
        return null;
    }

    @PostMapping("/submit")
    public boolean submit( @RequestParam int id ){
        return false;
    }





}
