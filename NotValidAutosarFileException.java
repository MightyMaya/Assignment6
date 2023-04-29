/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


//checked exception as it extends Exception class
public class NotValidAutosarFileException extends Exception {
    public NotValidAutosarFileException(String error){
      System.out.println(error);
    }
}