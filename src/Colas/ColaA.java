/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colas;

/**
 *
 * @author edi
 */
public class ColaA<T> implements ColaADT<T> {
    private int inicio;
    private int fin;
    private T coleccion[];
    private final int MAX_COLA = 20;
    
    public ColaA(){
        coleccion = (T[])new Object[MAX_COLA];
        inicio = -1;//porquer no tengo nada
        fin = -1;
    }
    
    public ColaA(int longitud){
        coleccion = (T[])new Object[longitud];
        inicio = -1;
        fin = -1;
    }


    
    private void expande(){
        T[] nuevo;
        int longitud, i;
        
        longitud = coleccion.length;
        nuevo = (T[])new Object[longitud * 2];
        for(i = 0; i < longitud; i++)
            nuevo[i] = coleccion[(i + 1) % longitud];
    }
    
   
    @Override
    public void add(T dato) {
        int longitud;
        
        longitud = coleccion.length;
        if((fin + 1) % longitud == inicio)
            expande();
        fin = (fin + 1) % longitud;
        coleccion[fin] = dato;
        if(inicio == -1)
            inicio = 0;  
    }
  

    @Override
    public T remove() {
        T elemento;
        if(isEmpty())
            elemento = null;
        else{
            elemento = coleccion[inicio];
            coleccion[inicio] = null;
            if(inicio == fin){
                inicio = -1;
                fin = -1;
            }
            else
                inicio = (inicio + 1) % coleccion.length;
        }
        return elemento;
    }

    @Override
    public boolean isEmpty() {
        return inicio == -1;
    }

    @Override
    public T showPrimero() {
        T object;
        if(!isEmpty())
            object = coleccion[inicio];
        else
            object = null;
        return object;
    }
    
    
}
