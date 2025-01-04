package org.acme.socket;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.acme.repo.Entity.Paseo;
import org.acme.repo.Entity.Perro;
import org.acme.repo.Entity.Ubicacion;
import org.acme.service.UbicacionService;
import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static io.quarkus.arc.ComponentsProvider.LOG;

@ServerEndpoint("/realtime/{clienteId}")
@ApplicationScoped
public class PaseoWebSocket {
    @Inject
    UbicacionService ubicacionService;


    private Map<String, Session> clienteSessions = new HashMap<>();

    @OnOpen
    public void onOpen(@PathParam("clienteId") String clienteId, Session session) {
        clienteSessions.put(clienteId, session);
        System.out.println("Cliente " + clienteId + " conectado.");
    }

    @OnClose
    public void onClose(@PathParam("clienteId") String clienteId, Session session) {
        // Elimina la sesión cuando el cliente se desconecta
        clienteSessions.remove(clienteId);
        System.out.println("Cliente " + clienteId + " desconectado.");
    }

    @OnMessage
    public void onMessage(String message, @PathParam("clienteId") String clienteId) {

        //buscamos el paseo por el id del paseador
        List<Perro> perros= Perro.findByUserId(new ObjectId(clienteId));
        LOG.info(perros);
        for(Perro perro:perros){
            LOG.info(perro.id);

            var paseo = Paseo.findByPerroIdAndActive(perro.id);
            if(paseo!=null){
                clienteSessions.forEach((id, session) -> {
                    session.getAsyncRemote().sendText("algo");
                });
            }
        }



    }
}
