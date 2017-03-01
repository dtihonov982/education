//Программа просит ввести имя файла, который требуется получить, и загружает его с сервера.

import java.net.*;
import java.io.*;
import java.util.*;

class SimpleFileClient {
    public static void done(Exception e) {
        System.err.println(e);
        System.exit(0);
    }
    public static void main(String[] args) {
       
        System.out.println("(Socket creation)");
        Socket socket = null;
        try {
            socket = new Socket("localhost", 4444);
        } catch (UnknownHostException e) {
            done(e);
        } catch (IOException e) {
            done(e);
        }
        
        System.out.println("(InputStream creation)");
        InputStream netIn = null;
        try {
            netIn = socket.getInputStream();
        } catch (IOException e) {
            done(e);
        }
        
        System.out.println("(PrintWriter creation)");
        PrintWriter netOut = null;
        try {
            netOut = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            done(e);
        }
        
        System.out.println("(Getting file name)");
        String file = null;
        Scanner keyboard = new Scanner(System.in);
        try {
			System.out.println("Enter a file name on server: ");
            file = keyboard.nextLine();
        } catch (NoSuchElementException e) {
            done(e);
        } catch (IllegalStateException e) {
            done(e);
        }
        keyboard.close();
        
        System.out.println("(Sending file name on server)");
        netOut.println(file);
        
        System.out.println("(Opening new file)");
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            done(e);
        }
        
        System.out.println("(Recieving file from server)");
        int buffer;
        try {
            while((buffer = netIn.read()) != -1) {
                fileOut.write(buffer);
            }
        } catch (IOException e) {
            done(e);
        } 
        
        System.out.println("(The file has resieved)");
        
        System.out.println("(Close resources)");
        try {
            netIn.close();
            fileOut.close();
            netOut.close();
            socket.close();
        } catch (IOException e) {
            done(e);
        }
    }
}
        
        
        
        