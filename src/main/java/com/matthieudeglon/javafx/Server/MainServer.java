package com.matthieudeglon.javafx.Server;

import javafx.application.Application;
import java.io.IOException;

public class MainServer {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("java server.Server <port>");
            } else {
                int port = Integer.parseInt(args[0]);
                new Server(port);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}