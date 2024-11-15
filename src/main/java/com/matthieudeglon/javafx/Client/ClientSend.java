package com.matthieudeglon.javafx.Client;

import com.matthieudeglon.javafx.Common.Message;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientSend implements Runnable {
    private ObjectOutputStream out;

    public ClientSend(Socket socket, ObjectOutputStream out) {
        this.out = out;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Votre message >> ");
            String m = sc.nextLine();
            try {
                Message mess = new Message("client", m);
                out.writeObject(mess);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}