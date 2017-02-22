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
public class Jugador {
    class Nodo{
        //Atributos Nodo-------------------------------------------
             Nodo sig;
             String dato;
        //Fin Atributos Nodo------------------------------
        public Nodo(){
            sig=null;
            dato=null;
        }

        public Nodo(String da){
            sig=null;
            dato = da;
        }
    
    }
    
     Nodo primerNodo,ultimoNodo;
     int tamanio;
    
    public Jugador(){
        reiniciar();
    }
    
    public void reiniciar(){
    primerNodo=null;
    ultimoNodo=null;
    tamanio=0;
    }
    public boolean esVacia(){
    return primerNodo == null;
    }
    
    public void insertarInicio(String info){
    Nodo nuevo = new Nodo(info);
    
        if(primerNodo == null){
            primerNodo = nuevo;
            ultimoNodo = nuevo;
            tamanio++;
        }else{
            nuevo.sig= primerNodo;
            primerNodo=nuevo;
            tamanio++;
        }
      
       
    }
    
    public void insertar(String info){
       
        
    
        if((primerNodo == null) && (ultimoNodo == null)){
          
      Nodo nuevo = new Nodo(info);
            primerNodo = nuevo;
            ultimoNodo = nuevo;
            tamanio++;
        }else{
            Nodo aux  = primerNodo;
            while(aux!=null){
                if (!aux.dato.equals(info)){
                    
                    if (aux.sig == null){
                     Nodo nuev = new Nodo(info);
                        ultimoNodo.sig= nuev;
                     ultimoNodo=nuev;
                     tamanio++;
                    }else{
                     aux = aux.sig;
                    }
                      }else{
                
                    aux = null;
                    //System.out.println("ya existe jugador" + info );
            
                }
            
            
            
           
        }
        
        
       
    }
    }
     
     public int tamanio(){
        return tamanio;
     }
     public String obtenerPrimero(){
        String dat_aux;
        dat_aux = primerNodo.dato;
        return dat_aux;
     }
     public String obtenerPrimeroBorrando(){
        String dat_aux;
        Nodo nodAux= primerNodo;
        primerNodo = nodAux.sig;
        dat_aux = nodAux.dato;
        nodAux = null;
        tamanio--;
        return dat_aux;
     }
     public String obtenerUltimo(){
        String dat_aux;
        dat_aux = ultimoNodo.dato;
        return dat_aux;
     }
     public String obtenerUltimoBorrando(){
        String dat_aux = null;
        Nodo aux = primerNodo;
        while(aux != null){
            if(aux.sig == ultimoNodo){
                dat_aux = aux.sig.dato;
                aux.sig = null;
                ultimoNodo=aux;
                aux = null;
                tamanio--;
            }else{
            aux= aux.sig;
            }
        }
        return dat_aux;
     }
    public void volverCircular(){
        if(tamanio > 0){
            ultimoNodo.sig = primerNodo;
        }
    }
    
    public void imprimirLista(){
    Nodo aux = this.primerNodo;
    while(aux!=null){
        System.out.println("Mensaje:"+aux.dato);
        aux = aux.sig;
    }
    }
     /*public static void main(String[] args){
     
        ListaSE nu = new ListaSE();
        nu.insertar("holas");
        nu.insertar("ni mergas");
        nu.imprimirLista();
     }*/
     
}
