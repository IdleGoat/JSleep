package rafieAmandioJSleepJS;

import java.util.Arrays;
import java.util.Iterator;

public class Algorithm {

    private Algorithm(){

    }
    public  static <T> int count(Iterator<T> iterator,T val){
        final Predicate<T> pred =val::equals;
        return count(iterator,pred);
    }

    public  static <T> int count(T[] arr,T val){
        final Iterator<T> it = Arrays.stream(arr).iterator();
        return count(it,val);
    }

    public  static <T> int count(Iterable<T> iterable,Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return count(it,pred);
    }

    public  static <T> int count(T[] arr,Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(arr).iterator();
        return count(it,pred);
    }

    public static <T> int count(Iterable<T> iterable,T val){
        final Iterator<T> it = iterable.iterator();
        return count(it,val);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int count = 0;
        while (iterator.hasNext()) {
            if (pred.predicate(iterator.next())) {
                count++;
            }
        }
        return count;
    }

    public static <T> boolean exists(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it,value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return exists(it,value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value){
        final Predicate<T> pred =value::equals;
        return exists(iterator,pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it,pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return exists(it,pred);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
        while(iterator.hasNext()){
            if(pred.predicate(iterator.next())){
                return true;
            }
        }
        return false;
    }

    public static <T> T find(T[] arr, T val){
        final Iterator<T> it = Arrays.stream(arr).iterator();
        return find(it,val);
    }

    public static <T> T find(Iterable<T> iterable, T val){
        final Iterator<T> it = iterable.iterator();
        return find(it,val);
    }

    public static <T> T find(Iterator<T> iterator, T val){
        final Predicate<T> pred =val::equals;
        return find(iterator,pred);
    }

    public static <T> T find(T[] arr, Predicate<T> predicate){
        final Iterator<T> it = Arrays.stream(arr).iterator();
        return find(it,predicate);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> predicate){
        final Iterator<T> it = iterable.iterator();
        return find(it,predicate);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> predicate){
        while(iterator.hasNext()){
            T obj = iterator.next();
            if(predicate.predicate(obj)){
                return obj;
            }
        }
        return null;
    }


}
