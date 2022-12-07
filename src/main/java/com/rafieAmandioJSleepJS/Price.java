package com.rafieAmandioJSleepJS;


/**
 * This class is used to store the information of a price.
 * @author Rafie Amandio
 */
public class Price
{

    /**
     * Store the price information
     */
    public double price;
    /**
     * Store the discount information
     */
    public double discount;

    /**
     * Constructor for objects of class Price
     * @param price The price of a room
     * @param discount The discount of a room
     * @see Price
     */
    public Price(double price, double discount){
        this.price = price;
        this.discount = discount;
    }

    /**
     * Constructor for objects of class Price
     * @param price The price of a room
     */
    public Price(double price){
        this.price = price;
        this.discount = 0;
    }

    /**
     * This method is used to get the price of a room
     * @return String of price and discount
     */
    public String toString(){
        return "Price\nPrice: " + price + "\nDiscount: " + discount;
    }

}
