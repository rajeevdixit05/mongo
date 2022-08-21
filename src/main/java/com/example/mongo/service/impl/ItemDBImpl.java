package com.example.mongo.service.impl;

import com.example.mongo.entity.ItemDocument;
import com.example.mongo.repository.ItemDocumentRepository;
import com.example.mongo.service.Item;
import com.example.mongo.service.ItemDB;
import com.example.mongo.service.ItemFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemDBImpl implements ItemDB {
    private final ItemDocumentRepository itemDocumentRepository;

    public ItemDBImpl(ItemDocumentRepository itemDocumentRepository) {
        this.itemDocumentRepository = itemDocumentRepository;
    }

    @Override
    public String storeObject(Item item) {
        ItemDocument document = ItemDocument.builder()
                .name(item.getName()).kind(item.getKind()).build();

        document = itemDocumentRepository.save(document);
        return document.getId();
    }

    @Override
    public Item getObjectByID(String id) {
        Optional<ItemDocument> document = itemDocumentRepository.findById(id);

        if (document.isPresent()) {
            ItemFactory factory = new ItemFactory(document.get());
            return factory.getItemObject();
        }
        return null;
    }

    @Override
    public Item getObjectByName(String name) {
        ItemDocument document = itemDocumentRepository.findItemByName(name);
        // TODO handle nulls
        ItemFactory factory = new ItemFactory(document);
        return factory.getItemObject();
    }

    @Override
    public List<Item> listObjects(String kind) {
        return itemDocumentRepository.findAllByKind(kind).stream().map(itemDocument -> {
            // TODO handle nulls
            ItemFactory factory = new ItemFactory(itemDocument);
            return factory.getItemObject();
        }).collect(Collectors.toList());
    }

    @Override
    public boolean deleteObject(String id) {
        itemDocumentRepository.deleteById(id);
        //TODO return false incase of exceptions
        return true;
    }
}
