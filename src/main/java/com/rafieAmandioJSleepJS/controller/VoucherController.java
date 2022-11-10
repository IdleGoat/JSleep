package com.rafieAmandioJSleepJS.controller;

import com.rafieAmandioJSleepJS.Algorithm;
import com.rafieAmandioJSleepJS.Price;
import com.rafieAmandioJSleepJS.Room;
import com.rafieAmandioJSleepJS.Voucher;
import com.rafieAmandioJSleepJS.dbjson.JsonAutowired;
import com.rafieAmandioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {

    @JsonAutowired(value= Voucher.class,filepath = "src/main/java/com/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }

    @GetMapping("/getAvailable")
    List<Voucher> getAvailable(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Voucher>paginate(voucherTable, page, pageSize, pred ->  !pred.isUsed());
    }

    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id){
        Voucher voucher = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        return voucher.isUsed();
    }

    @GetMapping("/{id}/canApply")
    boolean canApply(
            @PathVariable int id,
            @RequestParam double price
                    ){
        Voucher voucher = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        if(voucher == null){
            return false;
        }
        return voucher.canApply(new Price(price));
    }



}

