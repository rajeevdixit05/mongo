package com.example.mongo.repository;

import com.example.mongo.entity.ItemDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("itemDocumentRepository")
public interface ItemDocumentRepository extends MongoRepository<ItemDocument, String> {

    @Query("{name:'?0'}")
    ItemDocument findItemByName(String name);

    List<ItemDocument> findAllByKind(String kind);
}
