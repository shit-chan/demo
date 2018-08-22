package com.shit.demo.mongodb.service.impl;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.shit.demo.mongodb.service.MongoService;
import org.springframework.stereotype.Service;

@Service("mongoService")
public class MongoServiceImpl implements MongoService {
    private static MongoClient mongoClient = new MongoClient("localhost",27017);

    @Override
    public MongoDatabase getDatabase(String database){
        return mongoClient.getDatabase(database);
    }
}
