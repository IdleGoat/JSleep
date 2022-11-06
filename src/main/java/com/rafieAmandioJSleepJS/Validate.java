package com.rafieAmandioJSleepJS;
import java.util.ArrayList;
/**
 * Write a description of class Validate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Validate
{
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
