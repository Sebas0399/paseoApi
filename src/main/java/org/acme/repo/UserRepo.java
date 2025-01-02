package org.acme.repo;

import java.util.List;

import org.acme.repo.Entity.User;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepo {
    private final MongoClient mongoClient;
    private final MongoCollection<User> userCollection;
    public UserRepo(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
        this.userCollection = mongoClient.getDatabase("ExampleDB").getCollection("users", User.class);
    }

    public String create(User user) {
        userCollection.insertOne(user);
        return user.id.toHexString();
    }
    public List<User> list() {
        return userCollection.find().into(List.of());
    }
    public long delete(String id) {
        return userCollection.deleteOne(new org.bson.Document("_id", new org.bson.types.ObjectId(id))).getDeletedCount();
    }
    
}
