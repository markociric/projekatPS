/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marko
 */
public class StartServer extends Thread {

    private boolean running = true;
    private ServerSocket serverSocket;
    List<Socket> activeClients = new ArrayList<>();

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(9000);
            System.out.println("Server pokrenut na portu 9000.");

            while (running) {
                try {
                    System.out.println("Cekam...");
                    Socket s = serverSocket.accept();
                    System.out.println("Klijent povezan");

                    synchronized (activeClients) {
                        activeClients.add(s);  
                    }

                    ProcessingClientRequest pcr = new ProcessingClientRequest(s, this);
                    pcr.start();
                } catch (IOException e) {
                    if (running) {
                        System.out.println("Greška prilikom prihvatanja veze.");
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            stopServer();  
        }
    }

    public void stopServer() {
        running = false;

        
        synchronized (activeClients) {
            for (Socket client : activeClients) {
                try {
                    if (client != null && !client.isClosed()) {
                        client.close();
                    }
                } catch (IOException e) {
                    Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            activeClients.clear();  
        }

        
        if (serverSocket != null && !serverSocket.isClosed()) {
            try {
                serverSocket.close();
                System.out.println("Server zaustavljen.");
            } catch (IOException e) {
                Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public List<Socket> getActiveClients() {
        return activeClients;
    }
        
}
