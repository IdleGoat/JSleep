package rafieAmandioJSleepJS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Algorithm {

    private Algorithm(){

    }
    public static <T> List<T> collect(T[] arr, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(arr).iterator();
        return collect(it,pred);
    }
    public static <T> List<T> collect(T[] arr,T val){
        final Iterator<T> it = Arrays.stream(arr).iterator();
        return collect(it,val);
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return collect(it,pred);
    }
    public static <T> List<T> collect(Iterable<T> iterable,T val){
        final Iterator<T> it = iterable.iterator();
        return collect(it,val);
    }

    public static <T> List<T> collect(Iterator<T> iterator,T val){
        final Predicate<T> pred =val::equals;
        return collect(iterator,pred);
    }

    public static <T> List<T> collect(Iterator<T> iterator,Predicate<T> pred){
        List<T> listres = new ArrayList<T>();
        T val;
        if (iterator.hasNext()) {
            do {
                val = iterator.next();
                if (pred.predicate(val)) {
                    listres.add(val);
                }
            } while (iterator.hasNext());
        }
        return listres;
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

    public static <T> List<T> paginate(T[] arr, int page, int pageSize, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(arr).iterator();
        return paginate(it,page,pageSize,pred);
    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return paginate(it,page,pageSize,pred);
    }

    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred){
        List<T> listres = new ArrayList<T>();
        int count = 0;
        int startindex = page * pageSize;
        int endindex = startindex + pageSize;
        if (iterator.hasNext()) {
            do {
                T obj = iterator.next();
                if (pred.predicate(obj)) {
                    if (count >= startindex && count < endindex) {
                        listres.add(obj);
                    }
                    count++;
                }
            } while (iterator.hasNext());
        }
        return listres;
    }
}
