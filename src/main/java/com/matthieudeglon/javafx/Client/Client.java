package com.matthieudeglon.javafx.Client;

import com.matthieudeglon.javafx.Common.Message;
import java.io.*;
import java.net.Socket;

public class Client {
    private String address;
    private int port;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Client(String address, int port) throws IOException {
        this.address = address;
        this.port = port;
        this.socket = new Socket(address, port);
        this.out = new ObjectOutputStream(socket.getOutputStream());

        new Thread(new ClientSend(this.socket, this.out)).start();
        new Thread(new ClientReceive(this, this.socket)).start();
    }

    public void messageReceived(Message mess) {
        System.out.println(mess);
    }

    public void disconnectedServer() {
        try {
            if (in != null) in.close();
            out.close();
            socket.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}