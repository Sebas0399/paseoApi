package org.acme.repo.Entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

import java.util.List;

public class Paseador extends PanacheMongoEntity {
    public String cedula;
    public String foto;
    public String nombre;

    public static List listAll(){
        return findAll().list();
    }

    public static Paseador insert(Paseador paseador){
        paseador.persist();
        return paseador;
    }
}
