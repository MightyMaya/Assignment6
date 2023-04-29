/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    public static void main(String[] args) {
       try {
          String fileName = args[0];
          if (!fileName.endsWith(".arxml")){
            throw new NotValidAutosarFileException("This file does not have .arxml extension");
          }
          File file = new File(fileName );
          FileInputStream input = new FileInputStream(file);
          StringBuilder string = new StringBuilder();
          int b;
          b = input.read();
		  if (b==-1){
			  throw new EmptyAutosarFileException();
			  
		  }
          while(b != -1){
              string.append((char)b);
              b = input.read();
          }
          String allData = string.toString();
          ArrayList<Container> containers = new ArrayList<>();
          Scanner scanner = new Scanner(allData);
          while(scanner.hasNextLine()){
            String newLine = scanner.nextLine();
            /* if w e encounter a new conatiner we will store its info in a Container instance
            and add it to ArrayList*/
            if (newLine.contains("<CONTAINER")){
                String ID = newLine.substring(newLine.indexOf("UUID="),newLine.indexOf(">"));
                String shortName = scanner.nextLine();
                String shortN = shortName.substring(shortName.indexOf(">"),shortName.indexOf("</"));
                String longName = scanner.nextLine();
                String longN = longName.substring(longName.indexOf(">"),longName.indexOf("</"));
                Container c = new Container();
                c.setUUID(ID);
                c.setShortName(shortN);
                c.setLongName(longN);
                containers.add(c);
            }
           //sort the ArrayList according to short name
           Collections.sort(containers);
           String fileNameMod = fileName.substring(0,fileName.indexOf(".")) + "_mod.arxml";
;          FileOutputStream output = new FileOutputStream (fileNameMod); 
           output.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes());
           output.write("\n<AUTOSAR>\n".getBytes());
           for (int i=0; i<containers.size(); i++){
               output.write(containers.get(i).toString().getBytes());
           }
           output.write("\n</AUTOSAR>".getBytes());
          }
          
       }
       catch(NotValidAutosarFileException ex1){
         
       }
       catch(FileNotFoundException ex2){
           System.out.println("File not found");
       }
       catch(IOException ex3){
           System.out.println("IO Exception");
       }
	   catch (EmptyAutosarFileException ex4){
		   
		   
	   }
       
    }
}
