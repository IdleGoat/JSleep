package rafieAmandioJSleepJS;

import java.sql.Date;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.*;

/**
 * Write a description of class JSleep here.
 *
 * @author Rafie Amandio Fauzan
 * @version 13-09-2022
 */
public class JSleep
{
//    class Country{
//        public String name;
//        public int population;
//        public List<String> listOfStates;
//    }
    public static void main(String[] args) {

//        Account testRegex = new Account("Rafie","rafieamandio@gmail.com","Rmandio2022");
//        Account testRegexfalse = new Account("Rafie Gagal","amandio@ui.ac.id","Amandio2022");
//        System.out.println(testRegex.validate());
//        System.out.println(testRegexfalse.validate());

        try {
            String filepath = "src\\json\\account.json";
            JsonTable<Account> tableAccount = new JsonTable<Account>(Account.class, filepath);
            Account account = new Account("name","email","password");
            tableAccount.add(account);
            tableAccount.writeJson();

        }
        catch (Throwable t) {
            t.printStackTrace();
        }

        for(int i =0; i < 10; i++){
            ThreadingObject thread = new ThreadingObject("Thread " + i);
        }
    }
    //Todo: check filtering logic
    public static Room createRoom(){
        Price price = new Price(100000.0,5);
        Room room = new Room(2,"Restaurant",30,price,Facility.AC,City.JAKARTA,"Jl.Medan");
        return room;
    }

    public static List<Room> filterByCity(List<Room> list, String city,int page,int pagesize){
        List<Room> filtered = new ArrayList<Room>();
        filtered = Algorithm.<Room>paginate(list,page,pagesize,kamar -> kamar.city == City.valueOf(city.toUpperCase()));
        return filtered;
    }

    public static List<Room> filterByPrice(List<Room> list, double min,double max){
        List<Room> filtered = new ArrayList<Room>();
        filtered = Algorithm.<Room>collect(list,i -> ((i.price.price >= min) && (i.price.price <= max)));
        return filtered;
    }

    public static List<Room> filterByAccountId(List<Room> list,int accountId,int page,int pagesize){
        List<Room> filtered = new ArrayList<Room>();
        filtered = Algorithm.<Room>paginate(list,page,pagesize,i -> i.accountId == accountId);
        return filtered;
    }
}





//    public static Account createAccount(){
//        return new Account("Rafie","Amandio","Fauzan");}


//    public static int getHotelId(){
//        return 0;
//    }
//    public static String getHotelName(){
//        return "hotel";
//    }
//
//    public static boolean isDiscount(){
//        return true;
//    }
//
//    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
//        if(beforeDiscount < afterDiscount){
//            return 0;
//        } else if (beforeDiscount == 0) {
//            return 0;
//        } else {
//            float selisih = beforeDiscount - afterDiscount;
//            return (selisih/beforeDiscount)*100;
//        }
//    }
//
//    public static int getDiscountedPrice(int price, float discountPercentage){
//        if (discountPercentage > 100.0f){
//            return 0;
//        } else {
//            return (int)(price*((100.0f-discountPercentage)/100.0f));
//        }
//    }
//
//    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
//        float discount = (100.0f-discountPercentage)/100.0f;
//        return (int)(discountedPrice/discount);
//    }
//
//    public static float getAdminFeePercentage(){
//        return 0.05f;
//    }
//
//    public static int getAdminFee(int price){
//        return (int)(price*getAdminFeePercentage());
//    }
//
//    public static int getTotalPrice(int price,int numberOfNight){
//        int perNight = price* numberOfNight;
//        return perNight + getAdminFee(perNight);
//    }
