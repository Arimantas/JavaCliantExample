package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static final String HOST = "192.168.3.126";
    // public static final String HOST_TEST = "192.168.3.125";
    public static final int PORT = 7000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Socket kanalas = new Socket(HOST, PORT);
            boolean testi = true;
            ObjectOutputStream isvedimas = new ObjectOutputStream(kanalas.getOutputStream());
            ObjectInputStream ivedimas = new ObjectInputStream(kanalas.getInputStream());
            Scanner skaitytuvas = new Scanner(System.in);
            while (testi) {
                if (ivedimas.available() > 0) {
                    System.out.println(ivedimas.readUTF());
                }
                String tekstas = sc.nextLine();
                if (!tekstas.isEmpty()) {
                    isvedimas.writeUTF(tekstas);
                    isvedimas.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}