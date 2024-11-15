package com.matthieudeglon.javafx.Client;

import com.matthieudeglon.javafx.Common.Message;
import com.matthieudeglon.javafx.Client.Client;

import java.io.*;
import java.net.Socket;

public class ClientReceive implements Runnable {
    private Client client;
    private ObjectInputStream in;

    public ClientReceive(Client client, Socket socket) throws IOException {
        this.client = client;
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        boolean isActive = true;
        while (isActive) {
            try {
                Message mess = (Message) in.readObject();
                if (mess != null) {
                    client.messageReceived(mess);
                } else {
                    isActive = false;
                    client.disconnectedServer();
                }
            } catch (EOFException e) {
                isActive = false;
                client.disconnectedServer();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}