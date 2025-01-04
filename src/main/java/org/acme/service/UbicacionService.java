package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.repo.Entity.Ubicacion;

@ApplicationScoped
public class UbicacionService {

    public void guardarUbicacion(Ubicacion ubicacion) {
        Ubicacion.insert(ubicacion);
    }
}