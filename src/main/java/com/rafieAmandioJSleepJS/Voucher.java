package com.rafieAmandioJSleepJS;

import com.rafieAmandioJSleepJS.dbjson.Serializable;

/**
 * This class is used to store the information of a voucher.
 * @author Rafie Amandio
 */
public class Voucher extends Serializable
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    /**
     * Voucher Constructor
     * @param name name of the voucher
     * @param code code of the voucher
     * @param type type of the voucher
     * @param used voucher status
     * @param minimum minimum price to use the voucher
     * @param cut cut of the voucher
     */
    public Voucher(String name, int code, Type type,boolean used, double minimum, double cut){
        super();
        this.name = name;
        this.used = used;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
    }

    /**
     * to know if the voucher is used or not
     * @return true if it is used, false if it is not
     */
    public boolean isUsed(){
        return used;
    }

    /**
     * to know if we can use the voucher or not
     * @param price price of the room
     * @return true if we can use the voucher, false if we can't
     */
    public boolean canApply(Price price){
        if((price.price > this.minimum) && (!this.used)){
            return true;
        }
            return false;
    }

    /**
     * to apply the voucher
     * @param price price of the room
     * @return price after the voucher is applied
     */
    public double apply(Price price){
        this.used = true;
        if(this.type == Type.DISCOUNT){
            if(this.cut > 100.0) {
                this.cut = 100.0;
            }
                return price.price - (price.price*(this.cut/100.0));
        }
        else{
            if(this.cut > price.price){
                this.cut = price.price;
            }
                return price.price - this.cut;
        }
    }

}
