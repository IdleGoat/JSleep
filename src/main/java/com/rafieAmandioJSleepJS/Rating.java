package com.rafieAmandioJSleepJS;


public class Rating
{
    private long total;
    private long count;

    public Rating(){
        total = 0;
        count = 0;
    }

    public void insert(int rating){
        total = total + rating;
        count++;
    }

    public double getAverage(){
        if(count == 0){
            return 0;
        }
        else{
            return ((double)total)/((double)count);
        }
    }

    public long getCount(){
        return count;
    }

    public long getTotal(){
        return total;
    }

    public String toString(){
        return "Rating\nTotal: " + total + "\nCount: " + count;
    }

}
