//Программа принимает от клиента имя файла на сервере и передает его.

import java.net.*;
import java.io.*;

class SimpleFileServer {
    
    static public void done(Exception e) {
        System.err.println(e);
        System.exit(0);
    }
    
    static public void main(String[] args) {
        ServerSocket serverSocket = null;
        System.out.println("(ServerSocket creation)");
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException e) {
            done(e);
        }
        
        Socket clientSocket = null;
        System.out.println("(accepting)");
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            done(e);
        }
        System.out.println("(accepted)");
        
        BufferedReader netIn = null;
        System.out.println("(getting InputStream and BufferedReader creation)");
        try {
            netIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            done(e);
        }
        
        OutputStream netOut = null;
        System.out.println("(getting OutputStream)");
        try {
            netOut =  clientSocket.getOutputStream();
        } catch (IOException e) {
            done(e);
        }
        
        String file = null;
        System.out.println("(Recieving file name)");
        try {
            file = netIn.readLine();
        } catch (IOException e) {
            done(e);
        }
        System.out.format("(File name recieved. file: %s)%n", file);
        
        System.out.format("(Create FileInputStream. Opening %s)%n", file);
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            done(e);
        }
        
        
        System.out.println("(Begining file sending)");
        int buffer;
        try {
            while ((buffer = fileIn.read()) != -1) {
                netOut.write(buffer);
            }
        } catch (IOException e) {
            done(e);
        }
        System.out.println("(File sended)");  
        
        try {
            fileIn.close();
            netOut.close();
            clientSocket.close();
            serverSocket.close();  
            netIn.close();
        } catch (IOException e) {
            done(e);
        }            
        
        System.out.println("(Resurses closed)"); 
    }
}