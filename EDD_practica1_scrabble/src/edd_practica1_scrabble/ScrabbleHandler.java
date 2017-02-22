/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_practica1_scrabble;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author guillermo
 */
public class ScrabbleHandler extends DefaultHandler {
  private ArrayList<Dobles> dobles = new ArrayList();
    private Dobles doble;
    private ArrayList<Triples> triples = new ArrayList();
    private Triples triple;
   private ArrayList<Diccionario> palabras = new ArrayList();
    private Diccionario palabra;
    private int dimension;
    private boolean tipo_casilla,tri;

    public ArrayList<Diccionario> getPalabras() {
        return palabras;
    }


    
    public int getDimension() {
        return dimension;
    }

    public ArrayList<Dobles> getDobles() {
        return dobles;
    }

    public ArrayList<Triples> getTriples() {
        return triples;
    }
    

    
    private StringBuilder buffer = new StringBuilder();
    
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch,start, length);  
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "scrabble": 
                break;
            case "dimension":
                dimension =Integer.parseInt(buffer.toString());
                break;   
            case "x":
                if (tri == false){
                doble.setX(Integer.parseInt(buffer.toString()));
                }else{
                triple.setX(Integer.parseInt(buffer.toString()));
                }
                break;
            case "y":
                if (tri == false){
                doble.setY(Integer.parseInt(buffer.toString()));
                }else{
                triple.setY(Integer.parseInt(buffer.toString()));
                }
                break;
            case "palabra":
                palabra.setPalabra(buffer.toString());
                palabras.add(palabra);
                break;
            

                               
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "scrabble":
                break;
            case "dobles":
                tipo_casilla = false;
                break;
     
            case "triples":
                tipo_casilla =true;
                break;
            case "casilla":
                if (tipo_casilla == false){
                    doble = new Dobles();
                    dobles.add(doble);
                    tri = false;
                    
                }else if (tipo_casilla ==true){
                    triple = new Triples();
                    triples.add(triple);
                    tri = true;
                }
                break;
            case "x":
                 buffer.delete(0, buffer.length());
                break;
            case "y":
                buffer.delete(0, buffer.length());
                break;
            case "dimension":
                buffer.delete(0,buffer.length());
                break;          
            case "palabra":
                 palabra = new Diccionario();   
                  buffer.delete(0, buffer.length());          
                break;
            
                               
        }
    }
        
    
}
