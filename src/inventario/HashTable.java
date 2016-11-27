/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

/**
 *
 * @author Namakasi
 */
public class HashTable {
    private int M[] = new int[100];
    
    public HashTable(){
        
    }
    
    public int hash(int key){
        key = (key & 0x7fffffff)%M.length; //Operacion de modulo ya que esta nos generara un residuo,
        //0x7fffffff --> esta operacion fuerza a K a ser positivo numero maximo de enteros utilizados en java y otros lenguajes como c, c++ 0111-> 7 1111-> f 
        //El primer bit es el signo del numero 0= positivo 1 = mantendria el negativo
        //Es una alternativa a no usar math.abs();
        return key;
    }
    
    public void insertar(Producto key, int valor){
        
    }
    
    public void search(int key){
        int i = M[key];
        
    }
}
