package com.example.mongo.controller;

import com.example.mongo.service.Item;
import com.example.mongo.service.ItemDB;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ItemController {
    private final ItemDB itemDB;

    public ItemController(ItemDB itemDB) {
        this.itemDB = itemDB;
    }

    @RequestMapping(value = "/itemDetails", method = RequestMethod.GET)
    public ResponseEntity getItemDetails(@RequestHeader("userid") final String uidx) {

//        final ResponseEntity itemDetailsEntry = categoryService.findCategoryByUidxMongo(uidx);
//        final ResponseEntity itemDetailsEntry = categoryService.findItemByUidxMongo(uidx);
        return null;
    }

    @RequestMapping(value = "/createItem", method = RequestMethod.POST)
    public ResponseEntity createItem(@RequestBody Item item) throws Exception {

//        final ResponseEntity categoryDetailsEntry = categoryService.createCategoryItems(categoryDocument);
//        final ResponseEntity categoryDetailsEntry = itemService.createCategoryItems(itemDocument);
//        categoryService.createCategoryItems(itemDocument);

        return new ResponseEntity(itemDB.storeObject(item), HttpStatus.OK);
    }

    @RequestMapping(value = "/getItemById", method = RequestMethod.GET)
    public Item getItemById(@RequestHeader("id") final String id) {
        Item item = itemDB.getObjectByID(id);
        return item;
    }

    @RequestMapping(value = "/getItemByName", method = RequestMethod.GET)
    public Item getItemByName(@RequestHeader("name") final String name) {
        Item item = itemDB.getObjectByName(name);
        return item;
    }

    @RequestMapping(value = "/listItemByKind", method = RequestMethod.GET)
    public List<Item> getItemByKind(@RequestHeader("kind") final String kind) {
        List<Item> item = itemDB.listObjects(kind);
        return item;
    }

    @RequestMapping(value = "/deleteItemById", method = RequestMethod.DELETE)
    public boolean deleteItemById(@RequestHeader("id") final String id) {
        boolean isDeleted = itemDB.deleteObject(id);
        return isDeleted;
    }

}
