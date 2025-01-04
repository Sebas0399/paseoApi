package org.acme.repo.Entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.Data;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Paseo extends PanacheMongoEntity {
    public BigDecimal precio;
    public String ubicacion;
    public Boolean activo;
    public ObjectId perroId;
    public ObjectId paseadorId;

    public static List listAll() {
        return findAll().list();
    }

    public static Paseo insert(Paseo paseo) {
        paseo.persist();
        return paseo;
    }

    public static Paseo findById(ObjectId id) {
        return findById(id);
    }

    public static Paseo findByPaseadorId(ObjectId id) {
        return find("paseadorId", id).firstResult();
    }

    public static Paseo findByPerroId(ObjectId id) {
        return find("perroId", id).firstResult();
    }

    public static Paseo findByPerroIdAndActive(ObjectId id) {
        return find("perroId", id, "activo", true).firstResult();
    }
}
