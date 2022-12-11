package com.rafieAmandioJSleepJS;

/**
 * CLass for Rating
 * This class is used to represent the rating of a room
 * @author Rafie Amandio
 */
public class Rating
{
    private long total;
    private long count;

    /**
     * Constructor for objects of class Rating
     */
    public Rating(){
        total = 0;
        count = 0;
    }

    /**
     * This method is used to add a rating
     * @param rating The rating to be added
     */
    public void insert(int rating){
        total = total + rating;
        count++;
    }

    /**
     * This method is used to get the average rating
     * @return The average rating
     */
    public double getAverage(){
        if(count == 0){
            return 0;
        }
        else{
            return ((double)total)/((double)count);
        }
    }

    /**
     * This method is used to get the rating count
     * @return The rating count
     */
    public long getCount(){
        return count;
    }

    /**
     * This method is used to get the total rating
     * @return The total rating
     */
    public long getTotal(){
        return total;
    }

    public String toString(){
        return "Rating\nTotal: " + total + "\nCount: " + count;
    }

}
