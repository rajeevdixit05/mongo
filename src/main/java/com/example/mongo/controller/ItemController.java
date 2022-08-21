package com.example.mongo.controller;

import com.example.mongo.responseEntry.ItemResponse;
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

    @RequestMapping(value = "/createItem", method = RequestMethod.POST)
    public ItemResponse createItem(@RequestBody Item item) {
        return ItemResponse.builder()
                .statusEntry(HttpStatus.OK)
                .data(itemDB.storeObject(item))
                .build();
    }

    @RequestMapping(value = "/getItemById", method = RequestMethod.GET)
    public ItemResponse getItemById(@RequestHeader("id") final String id) {
        Item item = itemDB.getObjectByID(id);
        if (item == null) {
            return ItemResponse.builder()
                    .statusEntry(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ItemResponse.builder()
                .statusEntry(HttpStatus.OK)
                .data(item)
                .build();
    }

    @RequestMapping(value = "/getItemByName", method = RequestMethod.GET)
    public ItemResponse getItemByName(@RequestHeader("name") final String name) {
        Item item = itemDB.getObjectByName(name);
        if (item == null) {
            return ItemResponse.builder()
                    .statusEntry(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ItemResponse.builder()
                .statusEntry(HttpStatus.OK)
                .data(item)
                .build();
    }

    @RequestMapping(value = "/listItemByKind", method = RequestMethod.GET)
    public ItemResponse getItemByKind(@RequestHeader("kind") final String kind) {
        List<Item> item = itemDB.listObjects(kind);
        return ItemResponse.builder()
                .statusEntry(HttpStatus.OK)
                .data(item)
                .build();
    }

    @RequestMapping(value = "/deleteItemById", method = RequestMethod.DELETE)
    public ItemResponse deleteItemById(@RequestHeader("id") final String id) {
        boolean isDeleted = itemDB.deleteObject(id);
        return ItemResponse.builder()
                .statusEntry(HttpStatus.OK)
                .data(isDeleted)
                .build();
    }

}
