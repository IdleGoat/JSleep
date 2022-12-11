package com.rafieAmandioJSleepJS;
import java.util.ArrayList;


/**
 * This class is used to validate the input of the user
 * @author Rafie Amandio
 */
public class Validate
{
    /**
     * Method to filter
     * @param list The list of Price
     * @param value The value to be filtered
     * @param less The less than value
     * @return The filtered list
     */
    public static ArrayList filter(Price[] list,int value,boolean less){
        ArrayList filtered = new ArrayList();
        for(Price p : list){
            if(less == true){
                if(p.price <= value){
                    filtered.add(p.price);
                }
            }else{
                if(p.price > value){
                    filtered.add(p.price);
                }
            }
        }
        return filtered;
    }
}
