package org.acme.repo.Entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import org.bson.types.ObjectId;

public class Ubicacion extends PanacheMongoEntity {
    public String latitud;
    public String longitud;
    public ObjectId paseoId;

    public static Ubicacion insert(Ubicacion ubicacion){
        ubicacion.persist();
        return ubicacion;
    }
    public static Ubicacion fromJson(String json) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Ubicacion.class);
    }
}
