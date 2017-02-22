/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd_practica1_scrabble;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author guillermo
 */
public class Fichas {
     class NodoD{
    int cantidad;
   // Producto producto;
    //double precio;
    String ficha;
    NodoD siguiente;
    int id;
    
    public NodoD(int c,String ficha){
    this.cantidad=c;
    this.ficha=ficha;
    
    }
    
    }
    
    NodoD primero,ultimo;
    int cN;
    int idCola;
    int idPos;
    
    public Fichas(int idn){
    this.primero= null;
    this.ultimo=null;
    this.cN=0;
    this.idCola=idn;
    }
    
   /* public void generarEstructuraCola(int ip,int cp,BufferedWriter a,boolean glob) throws IOException{
    
    NodoD aux=this.primero;
    while(aux!=null){
        if(aux.producto!=null)
            a.write("nodoD"+this.idCola+aux.id+" [label=\"Producto:"+aux.producto.id+"\\n Cantidad:"+aux.cantidad+" \\n Precio:"+aux.precio+" \"];\n");
        else
            a.write("nodoD"+this.idCola+aux.id+" [label=\"Producto:Eliminado \\n Cantidad:"+aux.cantidad+" \\n Precio:"+aux.precio+" \"];\n");
//System.out.println("El texto del detalle es"+es);
    aux = aux.siguiente;
    }
    aux = this.primero;
    if(aux!=null)
        a.write("nodoB"+ip+":p"+cp+" -> "+"nodoD"+this.idCola+aux.id+";\n");
    
    while(aux!=null){
        
        if(glob){
               //if(aux.producto!=null)
                  a.write(" nodoD"+this.idCola+aux.id+" -> "+aux.producto.id+"\n;");  
           
           }
        
        if(aux.siguiente!=null){
           a.write(" nodoD"+this.idCola+aux.id+" -> nodoD"+this.idCola+aux.siguiente.id+"\n;");
           
           
        }
    aux = aux.siguiente;
    }
    
    }*/
    public void insertarDetalle(int cant,String ficha){
        System.out.println("Llego a este punto cerote");
    NodoD nuevo = new NodoD(cant,ficha);
    nuevo.id=this.cN;
    
    if(this.primero==null){
    this.primero=nuevo;
    this.ultimo=nuevo;
    this.cN++;
    }else{
        this.ultimo.siguiente = nuevo;
        this.ultimo=nuevo;
        this.cN++;
    
    }
    }
    
    public String eliminarPorProducto(int codigo){
        NodoD aux;
        aux = this.primero;
        if(aux.id==codigo){
            this.primero = aux.siguiente;
            return aux.ficha;
        }else{
            while(aux!=null){
                if(aux.siguiente!=null){
                    if(aux.siguiente.id==codigo){
                        aux.siguiente = aux.siguiente.siguiente;
                        return aux.siguiente.ficha;
                    }
                }
            }
        }
         
        return "sin fichas";
    }
        
        
 
    
     public String obtenerPrimeroBorrando(){
        String dat_aux;
        NodoD nodAux= primero;
        primero= nodAux.siguiente;
        dat_aux = nodAux.ficha;
        if(nodAux==ultimo)
            ultimo=null;
        this.cN--;
        return dat_aux;
     }
     
     
    
     
     
    /* public void graficarCola() throws IOException{
     FileWriter destino;
    destino= new FileWriter("C:\\Users\\Wilson\\Documents\\NetBeansProjects\\TiendaOnline\\web\\Img\\colaP.dot");
    BufferedWriter ar= new BufferedWriter(destino);
    ar.write("digraph g { node [shape=rect;];\n labelloc=\"t\";\n" +
"    label=\""+this.uso+"\";");
        NodoD aux = this.primero;
        while(aux!=null){
            ar.write("nodo"+this.uso+aux.idNodoP+" [label=\"Producto:"+aux.producto.id+" \\n Cantidad:"+aux.cantidad+" \\n Precio:"+aux.producto.precio+" \"; ];\n");
        aux= aux.siguiente;
        }
        aux = this.primero;
        while(aux!=null){
        if(aux.siguiente!=null)
            ar.write("nodo"+this.uso+aux.idNodoP+" -> nodo"+this.uso+aux.siguiente.idNodoP+";\n");
        
        aux = aux.siguiente;
        }
        ar.write("}");
        ar.flush();
        ar.close();
        
        Runtime rt = Runtime.getRuntime();
        rt.exec("dot -Tpng C:\\Users\\Wilson\\Documents\\NetBeansProjects\\TiendaOnline\\web\\Img\\colaP.dot -o C:\\Users\\Wilson\\Documents\\NetBeansProjects\\TiendaOnline\\web\\Img\\colaP.png");
    
     }*/
     public void recorrerCola(){
     NodoD aux = this.primero;
     while(aux!=null){
         
         System.out.println("************************************");
         System.out.println("id: "+aux.id);
         System.out.println("ficha: "+aux.ficha);
         System.out.println("cant: "+aux.cantidad);
      
         
         
         aux = aux.siguiente;
     }
     }
    
}
