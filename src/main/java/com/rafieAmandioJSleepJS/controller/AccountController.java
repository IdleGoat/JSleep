package com.rafieAmandioJSleepJS.controller;

import com.rafieAmandioJSleepJS.Account;
import com.rafieAmandioJSleepJS.Algorithm;
import com.rafieAmandioJSleepJS.Renter;
import com.rafieAmandioJSleepJS.dbjson.JsonAutowired;
import com.rafieAmandioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{


    public final static String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public final static String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    @JsonAutowired(value=Account.class,filepath = "src/main/java/com/json/account.json")
    public static JsonTable<Account> accountTable;
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD) ;
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);


    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/login")
    Account login(
        @RequestParam String email,
        @RequestParam String password
    ){
        String encryptedPassword = null;

        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
            }
            encryptedPassword = sb.toString();

        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        String finalEncryptedPassword = encryptedPassword;
        Account temp = Algorithm.<Account>find(accountTable, pred -> email.equals(pred.email) && finalEncryptedPassword.equals(pred.password));
        return temp;
    }

    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ){
        String encryptedPassword = null;
        boolean emailstatus = REGEX_PATTERN_EMAIL.matcher(email).find();
        boolean passwordstatus = REGEX_PATTERN_PASSWORD.matcher(password).find();

        if(passwordstatus && emailstatus && !name.isBlank()){
            try{
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] bytes = md.digest(password.getBytes());
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++){
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
                }
                encryptedPassword = sb.toString();

            }catch (NoSuchAlgorithmException e){
                e.printStackTrace();
            }
            accountTable.add(new Account(name,email,encryptedPassword));
            return new Account(name, email, encryptedPassword);
        }
        else{
            return null;
        }

    }

    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(@PathVariable int id, @RequestParam String username, @RequestParam String address,
            @RequestParam String phoneNumber ){

        Account temp = Algorithm.<Account>find(accountTable,pred -> pred.id == id);
        if(temp.renter == null && temp != null){
            temp.renter = new Renter(username, address, phoneNumber);
            return temp.renter;
        }
        else{
            return null;
        }
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance ){
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if (account != null){
            account.balance += balance;
            return true;
        }else{
            return false;
        }
    }

}
