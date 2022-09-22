package rafieAmandioJSleepJS;


/**
 * Write a description of class Price here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Price
{
    // instance variables - replace the example below with your own
    public double rebate;
    public double price;
    public int discount;


    public Price(double price)
    {
        this.price = price;
        discount = 0;
        rebate = 0;
    }

    public Price(double price, int discount){
        this.price = price;
        this.discount = discount;
        rebate = 0;
    }

    public Price(double price, double rebate){
        this.price = price;
        this.rebate = rebate;
        discount = 0;
    }

    private double getDiscountedPrice(){
        if (discount >= 100.0) {
            return 0;
        }
        else{
            return price - ((double)price*(((double)discount)/100.0));
        }
    }

    private double getRebatedPrice(){
        if(rebate > price){
            rebate = price;
        }
        return price-rebate;
    }

}
