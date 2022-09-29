package rafieAmandioJSleepJS;


/**
 * Write a description of class JSleep here.
 *
 * @author Rafie Amandio Fauzan
 * @version 13-09-2022
 */
public class JSleep
{
    public static void main(String[] args) {
        Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Room testRoom = new Room(1, "Presidential Suite", 5, testPrice,
        Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        System.out.println(testComplain.toString());
        System.out.println(testRoom.toString());
        System.out.println(testAccount.toString());
        System.out.println(testPrice.toString());
        System.out.println(testRating.toString());
//        System.out.println(testInvoice.print());
        
    }

//    public static Room createRoom(){
//        Price price = new Price(100000.0,5);
//        Room room = new Room(12,"Restaurant",30,price,Facility.AC);
//        return room;
//    }

}

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
