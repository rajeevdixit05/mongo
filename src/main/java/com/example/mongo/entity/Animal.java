package com.example.mongo.entity;

import com.example.mongo.service.Item;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonDeserialize(as = Animal.class)
public class Animal implements Item {
    private String id;
    private String name;

    @Override
    public String getKind() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setID(String id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Animal(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
