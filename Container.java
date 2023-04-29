/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.lang.Comparable;
public class Container implements Comparable<Container>{
     private String UUID;
    private String shortName;
    private String longName;
    
    //Getters
    public String getUUID(){
        return UUID;
    }
    public String getShortName(){
        return shortName;
    }
    public String getLongName(){
        return longName;
    }
    
    //Setters
    public void setUUID( String UUID_){
        UUID = UUID_;
    }
    public void setShortName( String shortName_){
       shortName = shortName_;
    }
    public void setLongName( String longName_){
       longName = longName_;
    }
    
    //overriding some methods
    @Override
    public String toString(){
        // the backslashes allow me to use double quotes inside the string
        return " <CONTAINER UUID=\"" + UUID +  "\">\n" +
        "       <SHORT-NAME>" + shortName +  "</SHORT-NAME>\n" +
        "       <LONG-NAME>" + longName + "</LONG-NAME>\n" +
        " </CONTAINER>";
    }
    @Override
    //We want to compare using short name
    public int compareTo(Container c){
        String s1 = new String(this.shortName);
        String s2 = new String(c.getShortName());
        return s1.compareTo(s2);
    }

}
