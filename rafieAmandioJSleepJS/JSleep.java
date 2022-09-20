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
        Room testroom = createRoom();
        System.out.println(testroom.name);
        System.out.println(testroom.size);
        System.out.println(testroom.price.price);
        System.out.println(testroom.facility);
    }

    public static Room createRoom(){
        Price price = new Price(100000.0,5);
        Room room = new Room("Restaurant",30,price,Facility.AC);
        return room;
    }

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
