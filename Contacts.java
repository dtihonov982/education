//Программа читает файл google.csv, в который экспортированы контакты из Google аккаунта,
//и выводит данные в файл contacts.txt в более читаемом формате.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

class Contacts {
    static Scanner getFileScanner(String name) throws FileNotFoundException {
       return new Scanner(new FileInputStream(name));
    }
    
    public static void makeReadableView(String src, String dst) {
        Scanner fileScanner;
         try {
            fileScanner = getFileScanner(src);
        } catch (FileNotFoundException e) {
            System.out.println(e);
            return;
        }
        
        String firstLine = fileScanner.nextLine();
        String[] fieldsNames = firstLine.split(",");   
        
        String line;
        String[] fields = null;
        List<Map<String, String>> Table = new ArrayList<Map<String, String>>();
        Map<String, String> currRow;
        while (true) {
            try {
                line = fileScanner.nextLine();
                fields = line.split(",");
                currRow = new HashMap<String, String>();
                for(int i = 0; i < fields.length; i++) {
                    currRow.put(fieldsNames[i], fields[i]);
                }
                Table.add(currRow);
            } catch (NoSuchElementException e) {
                break;
            }
        }
        
        BufferedWriter outputStream;
        try {
            outputStream = new BufferedWriter(new FileWriter(dst));
        } catch(IOException e) {
            System.out.println(e);
            return;
        }
        
        
        String currFieldValue, currString;
        try {
            for (Map<String, String> Row: Table) {
                for (String field: fieldsNames) {
                    currFieldValue = Row.get(field);
                    if (currFieldValue != null && !currFieldValue.equals("")) {
                        currString = String.format("%s: %s%n", field, currFieldValue);
                        outputStream.write(currString, 0, currString.length());
                    }
                }
                outputStream.newLine();
            }
            outputStream.close();
        } catch (IOException e) {
            System.out.println(e);
            return;
        }
    }
    
    public static void main(String[] args) {
        makeReadableView("google.csv", "contacts.txt");
    }
    
}
        
        