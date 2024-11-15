package com.matthieudeglon.javafx.Client;

import java.io.IOException;

public class MainClient {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("java client.Client <address> <port>");
            } else {
                String address = args[0];
                int port = Integer.parseInt(args[1]);
                new Client(address, port);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}