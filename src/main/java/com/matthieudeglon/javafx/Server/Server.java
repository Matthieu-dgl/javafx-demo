package com.matthieudeglon.javafx.Server;

import com.matthieudeglon.javafx.Common.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Server {
    private int port;
    private List<ConnectedClient> clients;

    public Server(int port) throws IOException {
        this.port = port;
        this.clients = new ArrayList<>();
        Thread threadConnection = new Thread(new Connection(this));
        threadConnection.start();
    }

    public int getPort() {
        return port;
    }

    public synchronized int getNumClients() {
        return clients.size();
    }

    public synchronized void addClient(ConnectedClient newClient) {
        this.clients.add(newClient);
        broadcastMessage(new Message("Server", newClient.getId() + " vient de se connecter"), newClient.getId());
    }

    public synchronized void broadcastMessage(Message mess, int id) {
        for (ConnectedClient client : clients) {
            if (client.getId() != id) {
                client.sendMessage(mess);
            }
        }
    }

    public synchronized void disconnectedClient(ConnectedClient discClient) {
        discClient.closeClient();
        clients.remove(discClient);
        broadcastMessage(new Message("Server", discClient.getId() + " vient de se déconnecter"), discClient.getId());
    }
}