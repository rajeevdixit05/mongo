package com.example.mongo.service;

import com.example.mongo.entity.ItemDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = ItemDeserializer.class)
public interface Item {
    //getKind() returns the kind (i.e., type) of the Item.
    String getKind();

    // getID() returns a unique UUID for the Item.
    String getID();

    // getName returns the name of the Item. Names are not unique.
    String getName();

    // setID sets the ID of the Item.
    void setID(String id);

    // setName sets the name of the Item.
    void setName(String name);

}
