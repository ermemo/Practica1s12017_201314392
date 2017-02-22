/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_practica1_scrabble;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
/**
 *
 * @author guillermo
 */
public class Lector_ScrabbleSAX {
    public int dimensiont ;
  

    public Lector_ScrabbleSAX()  {
 
    }
    
     public void lectura() throws SAXException, IOException, ParserConfigurationException{
     SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
     SAXParser saxParser = saxParserFactory.newSAXParser();
     File file = new File("Scrabble.xml");
     ScrabbleHandler handler  = new  ScrabbleHandler();
     saxParser.parse(file, handler);
     
     
    ArrayList<Diccionario> diccionar = handler.getPalabras();
    ArrayList<Dobles> dobles = handler.getDobles();
    ArrayList<Triples> triples = handler.getTriples();
    
       
    dimensiont = handler.getDimension();
    
    System.out.println(dimensiont);
    diccionar.stream().forEach((dic) -> {
        System.out.println(dic);
        });
    dobles.stream().forEach((d) -> {
        System.out.println(d);
        });
    triples.stream().forEach((t) -> {
        System.out.println(t);
        });
        
    }

  
     
    
     
    
}
