package com.shit.demo.mongodb.service;

import com.mongodb.client.MongoDatabase;

public interface MongoService {
    public MongoDatabase getDatabase(String database);
}
