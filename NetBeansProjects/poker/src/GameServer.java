/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maryam
 */

import java.io.*;
import java.net.*;
        
public class GameServer {
    
    private ServerSocket ss;
    private int numPlayers;
    private int maxPlayers;
     
    // creating constructor 
    public GameServer() {
        System.out.println("==Game Server==");
        numPlayers = 0;
        maxPlayers = 2; //Try with 4 Later
        
        try { 
            //instantiate server socket
            ss = new ServerSocket(8899);   
        }
        catch(IOException e) {
            System.out.println("Exception at GameServer()");
        }
    }
    
    public void acceptConnections() {
        try{
          System.out.println("Waiting for connections..");
          
          while (numPlayers < maxPlayers){
             // call to the accept method of the server socket, as long as no clients connect, the program stays in this line
             Socket s = ss.accept();
             DataInputStream in = new DataInputStream(s.getInputStream());
             DataOutputStream out = new DataOutputStream(s.getOutputStream());
             
             numPlayers++;
             out.writeInt(numPlayers); //use it to determine the players player# and send it to the client
             
             System.out.println("Player #" + numPlayers + " has connected!");
          }
          
          System.out.println("Maximum number of players have connected");
        }
        catch(IOException e) {
            System.out.println("Exception at acceptConnections()");
        }
    }
    
    public static void main(String[] args){
        GameServer gs = new GameServer();
        gs.acceptConnections();
    }
} 
