/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_practica1_scrabble;

/**
 *
 * @author guillermo
 */
class Diccionario {
    private String palabra;

    public Diccionario() {
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public String toString() {
        return "Diccionario{" + "palabra=" + palabra + '}';
    }
    
    
}
