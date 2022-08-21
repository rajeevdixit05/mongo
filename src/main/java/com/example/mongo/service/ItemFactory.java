package com.example.mongo.service;

import com.example.mongo.entity.Animal;
import com.example.mongo.entity.ItemDocument;
import com.example.mongo.entity.Person;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemFactory {
    private final ItemDocument itemDocument;

    public Item getItemObject() {
        //TODO validate constraints of itemdocument present, and kind not empty etc
        switch (this.itemDocument.getKind()) {
            case "Animal":
                return Animal.builder().id(itemDocument.getId()).name(itemDocument.getName()).build();
            case "Person":
                return Person.builder().id(itemDocument.getId()).name(itemDocument.getName()).build();
            default:
                //TODO throw invalid input argument
        }
        return null;
    }
}
