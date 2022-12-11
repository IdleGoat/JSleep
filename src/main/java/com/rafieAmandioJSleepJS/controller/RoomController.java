package com.rafieAmandioJSleepJS.controller;

import com.rafieAmandioJSleepJS.*;
import com.rafieAmandioJSleepJS.dbjson.JsonAutowired;
import com.rafieAmandioJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{

    @JsonAutowired(value= Room.class, filepath = "src/main/java/com/json/room.json")
    public static JsonTable<Room> roomTable;
    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    /**
     * Get all rooms by renter Id
     * @param id renter id
     * @param page page number
     * @param pageSize page size
     * @return list of rooms
     */
    @GetMapping("/{id}/renter")
     List<Room> getRoomByRenter(
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int pageSize

    ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> pred.accountId == id);
    }

    /**
     * Get all room but paginate
     * @param page page number
     * @param pageSize page size
     * @return list of room
     */
    @GetMapping("/getAllRoom")
    List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize

    ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

    /**
     * Create New Room
     * @param accountId Account Id
     * @param name Room Name
     * @param size Room Size
     * @param price Room Price
     * @param facility Room Facility
     * @param city Room City
     * @param address Room Address
     * @param bedType Room Bed Type
     * @return Room
     * @see Room
     * @see Account
     * @author Rafie Amandio
     */
    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam ArrayList<Facility> facility,
            @RequestParam City city,
            @RequestParam String address,
            @RequestParam BedType bedType
    ){
        Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId && pred.renter != null);
        if(account == null){
            return null;
        }
        Room room = new Room(accountId, name, size, new Price(price), facility, city, address,bedType);
        roomTable.add(room);
        return room;
    }

    /**
     * This method is used to filter by city
     * @param city the city to be filtered
     * @return the list of room that match the city
     * @see City
     * @see Room
     * @author Rafie Amandio
     */
    @GetMapping("/filterByCity")
    List<Room> filterByCity(
            @RequestParam City city
    ){
        return Algorithm.<Room>collect(getJsonTable(),kamar -> kamar.city == city);
    }

    /**
     * This method is used to filter room by Name
     * @param name name of the room that will be filtered
     * @return list of room that match the name
     * @author Rafie Amandio
     */
    @GetMapping("/collectByName")
    List<Room> filterByName(
            @RequestParam String name
    ){
        return Algorithm.<Room>collect(getJsonTable(),kamar -> kamar.name.contains(name));
    }

    /**
     * This method is used to filter room by price
     * @param min minimum price
     * @param max maximum price
     * @return list of room that match the price
     * @author Rafie Amandio
     */
    @GetMapping("/collectByPrice")
    List<Room> filterByPrice(
            @RequestParam int min,
            @RequestParam int max
    ){
        return Algorithm.<Room>collect(getJsonTable(),i -> ((i.price.price >= min) && (i.price.price <= max)));
    }

    /**
     * This method is used to collect all room
     * @return list of room that match the facility
     * @author Rafie Amandio
     */
    @GetMapping("/collectRoom")
    List<Room> collectRoom(
    ){
        return Algorithm.<Room>collect(getJsonTable(),pred -> true);
    }




}

