package com.rafieAmandioJSleepJS.controller;

import com.rafieAmandioJSleepJS.Account;
import com.rafieAmandioJSleepJS.Algorithm;
import com.rafieAmandioJSleepJS.Renter;
import com.rafieAmandioJSleepJS.dbjson.JsonAutowired;
import com.rafieAmandioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**.
 * This class is used to handle /account  requests from the client.
 * @author Rafie Amandio
 * @see Account
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{

    /**
     * Regex for the password. Password should be at least 8 characters long
     * and contain at least 1 uppercase letter, 1 lowercase letter, 1 number, and no whitespace
     */
    public final static String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    /**
     * Regex for the email. Email should be in the format of
     * in the format of local@domain, example : amandio@ui.ac.id
     * local only contains alphanumeric characters and can't contain
     * any special characters or whitespace. domain can't contain any number
     */
    public final static String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    /**
     * The table of accounts.
     */
    @JsonAutowired(value=Account.class,filepath = "src/main/java/com/json/account.json")
    public static JsonTable<Account> accountTable;
    /**
     * Pattern for password REGEX
     */
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD) ;
    /**
     * Pattern for email REGEX
     */
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);



    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    /**
     * This method is used to handle /account/login requests from the client.
     * @param email The email of the account.
     * @param password The password of the account.
     * @return The account that has the same email and password as the parameter.
     *         If the account doesn't exist, it will return null.
     * @author Rafie Amandio
     */
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

    /**
     * This method is used to handle /account/register requests from the client.
     * @param name The name of the account that will be registered.
     * @param email The email of the account that will be registered.
     * @param password The password of the account that will be registered.
     * @return The account that has been registered and if the account already exists,
     *        it will return null. If the email or password doesn't match the REGEX,
     *        it will return null.
     * @author Rafie Amandio
     */
    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ){
        String encryptedPassword = null;
        boolean emailstatus = REGEX_PATTERN_EMAIL.matcher(email).find();
        boolean passwordstatus = REGEX_PATTERN_PASSWORD.matcher(password).find();

        Account isUsed = Algorithm.<Account>find(getJsonTable(),pred -> pred.email.equals(email));
        System.out.println(passwordstatus);
        System.out.println(emailstatus);
        System.out.println(!name.isBlank());
        System.out.println(isUsed == null);
        if(passwordstatus && emailstatus && !name.isBlank() && isUsed == null){
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


    /**
     * This method is used to handle /{id}/registerRenter requests from the client.
     * @param id The id of the account that will be registered as a renter.
     * @param username The username of the renter that will be registered.
     * @param address The address of the renter that will be registered.
     * @param phoneNumber The phone number of the renter that will be registered.
     * @return The renter that has been registered and if the renter already exists,
     *      it will return null. If the username or address or phone number is blank,
     *      it will return null. If the account doesn't exist, it will return null.
     *      If the account already have a renter, it will return null.
     */
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

    /**
     * This method is used to handle /{id}/topUp requests from the client.
     * @param id The id of the account that will be topped up.
     * @param balance The amount of money that will be topped up.
     * @return true if the account has been topped up and false if the account doesn't exist.
     * @author Rafie Amandio
     */
    @PostMapping("/{id}/topUp")
    Boolean topUp(@PathVariable int id, @RequestParam double balance ){
        System.out.println(balance);
        System.out.println(id);
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if (account != null){
            account.balance += balance;
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

}
