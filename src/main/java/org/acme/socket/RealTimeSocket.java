package org.acme.socket;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.websocket.server.ServerEndpoint;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/realtime")
@ApplicationScoped
public class RealTimeSocket {
    private Set<Session> sessions = ConcurrentHashMap.newKeySet();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public void onMessage(String message) {
        // Difundir mensaje a todos los clientes conectados
        for (Session session : sessions) {
            session.getAsyncRemote().sendText(message);
        }
    }
}
