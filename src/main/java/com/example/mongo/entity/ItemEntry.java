package com.example.mongo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class ItemEntry implements Serializable {

    private String id;
    private String name;
}
