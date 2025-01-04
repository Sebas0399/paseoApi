package org.acme.repo.Entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;
@Data
@MongoEntity(collection = "Perro") // Opcional: Define el nombre de la colección en MongoDB

public class Perro extends PanacheMongoEntity {
    public String nombre;
    public String raza;
    public String foto;
    public ObjectId userId;
    public static List listAll(){
        return findAll().list();
    }

    public static Perro insert(Perro perro){
        perro.persist();
        return perro;
    }
    public static Perro findById(ObjectId id){
        return findById(id);
    }
    public static List<Perro> findByUserId(ObjectId id){
        return find("userId",id).list();
    }

}
