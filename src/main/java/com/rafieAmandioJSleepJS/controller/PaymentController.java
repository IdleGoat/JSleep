package com.rafieAmandioJSleepJS.controller;

import com.rafieAmandioJSleepJS.Account;
import com.rafieAmandioJSleepJS.Payment;
import com.rafieAmandioJSleepJS.dbjson.JsonAutowired;
import com.rafieAmandioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value= Account.class,filepath = "src/json/account.json")
    public static JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/payment/accept")
    public boolean accept(
            @RequestParam int id
    ){
        return false;
    }

    @PostMapping("/payment/cancel")
    public boolean cancel(
            @RequestParam int id
    ){
        return false;
    }

    @PostMapping("/payment/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ){
        return null;
    }

    @PostMapping("/payment/submit")
    public boolean submit(
            @RequestParam int id
    ){
        return false;
    }





}
