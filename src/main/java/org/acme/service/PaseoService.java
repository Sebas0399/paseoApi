package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.repo.Entity.Paseador;
import org.acme.repo.Entity.Paseo;
import org.acme.repo.Entity.Perro;
@ApplicationScoped
public class PaseoService {
    public Perro obtenerPerroDelPaseo(Paseo paseo) {
        return Perro.findById(paseo.perroId);
    }

    public Paseador obtenerPaseadorDelPaseo(Paseo paseo) {
        return Paseador.findById(paseo.paseadorId);
    }
}
