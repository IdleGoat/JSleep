package com.rafieAmandioJSleepJS.controller;

import com.rafieAmandioJSleepJS.Algorithm;
import com.rafieAmandioJSleepJS.Price;
import com.rafieAmandioJSleepJS.Room;
import com.rafieAmandioJSleepJS.Voucher;
import com.rafieAmandioJSleepJS.dbjson.JsonAutowired;
import com.rafieAmandioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * VoucherController class
 * This class is used to control voucher APi
 * @author Rafie Amandio
 */
@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher> {

    @JsonAutowired(value= Voucher.class,filepath = "src/main/java/com/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;
    public JsonTable<Voucher> getJsonTable() {
        return voucherTable;
    }

    /**
     * Get all voucher that is available and paginate it
     * @param page page number
     * @param pageSize page size
     * @return list of voucher that is available
     */
    @GetMapping("/getAvailable")
    List<Voucher> getAvailable(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Voucher>paginate(voucherTable, page, pageSize, pred ->  !pred.isUsed());
    }

    /**
     * Check if voucher is used or not
     * @param id voucher id
     * @return true if voucher is used, false if not
     */
    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id){
        Voucher voucher = Algorithm.<Voucher>find(voucherTable, pred -> pred.id == id);
        return voucher.isUsed();
    }

    /**
     * Check the validity of voucher
     * @param id voucher id
     * @param price price
     * @return true if voucher is valid, false if not
     */
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

