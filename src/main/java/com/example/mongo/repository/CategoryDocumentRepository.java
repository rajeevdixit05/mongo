package com.example.mongo.repository;

import com.example.mongo.entity.ItemDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CategoryDocumentRepository extends MongoRepository<ItemDocument, String> {

    @Query("{name:'?0'}")
    ItemDocument findItemByName(String name);

    @Query(value="{kind:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<ItemDocument> findAll(String category);

    @Query("{'id': ?0}")
    List<ItemDocument> findByCategoryId(String userId);

    @Query("{'id': ?0}")
    List<ItemDocument> findByUserId(String userId);

}
