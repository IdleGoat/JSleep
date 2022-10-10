package rafieAmandioJSleepJS;



public class Price
{
    public double price;
    public double discount;

    public Price(double price, double discount){
        this.price = price;
        this.discount = discount;
    }
    public Price(double price){
        this.price = price;
        this.discount = 0;
    }

    public String toString(){
        return "Price\nPrice: " + price + "\nDiscount: " + discount;
    }
    /*private double getDiscountedPrice(){
        if (discount >= 100.0) {
            return 0;
        }
        else{
            return price - ((double)price*(((double)discount)/100.0));
        }
    }*/

}
