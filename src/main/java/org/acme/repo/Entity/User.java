package org.acme.repo.Entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.util.List;

public class User extends PanacheMongoEntity{
        public String name;
        public String email;
        public String password;
        public static User findByName(String name){
                return  find("name",name).firstResult();
        }
        public static List listAll(){
                return findAll().list();
        }

        public static User insert(User user){
                user.persist();
                return user;
        }



}
