package com.rafieAmandioJSleepJS.controller;

import java.util.List;
import com.rafieAmandioJSleepJS.Algorithm;
import com.rafieAmandioJSleepJS.dbjson.Serializable;
import com.rafieAmandioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**.
 * This interface is used to represent a basic get controller.
 * @author Rafie Amandio
 * @param <T> The type of the object that will be handled by the controller
 *           (e.g. Account, Room, etc.)
 */
@RestController
public interface BasicGetController <T extends Serializable> {

    /**
     * This method is used to get the object with the specified id.
     * @param id The id of the object that will be returned
     * @return The object with the specified id or null if the object is not found
     * @see JsonTable
     * @author Rafie Amandio
     */
    @GetMapping("/{id}")
    public default T getById(
            @PathVariable int id
    ){
        T object = (T) Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
        return object;
    }

    /**
     * This method is used to get all the objects in the table.
     * @return A list of all the objects in the table
     * @see JsonTable
     * @author Rafie Amandio
     */
    public abstract JsonTable<T> getJsonTable();

    /**
     * This method is used to get all the objects in the table.
     * @return A list of all the objects in the table
     * @see JsonTable
     * @author Rafie Amandio
     */
    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam  int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }


}
