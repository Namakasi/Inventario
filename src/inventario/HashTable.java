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
    BinaryTree<String, Producto>[] ht;
    
    public HashTable(){
        this.ht = new BinaryTree[100];
    }
    
    public static void main(String[] args){
        HashTable ht=new HashTable();
        Producto p=new Producto("Martillo",1,1,1);
        ht.insertar(p);
        p=new Producto("Martillo",1,2,1);
        ht.insertar(p);
        p=new Producto("Martillo",1,2,1);
        ht.insertar(p);
        p=new Producto("Martillo",1,2,1);
        ht.insertar(p);
        p=new Producto("Martillo",1,2,1);
        ht.insertar(p);
        p=new Producto("Martillo",1,2,1);
        ht.insertar(p);
        ht.Listar(12);
    }
    
    public int insertar(Producto producto){
        if(search(producto.getNombre())>=0){
            int i=search(producto.getNombre());
            Producto tmp=ht[i].searchItem(producto.getNombre());
            tmp.setCantidad(tmp.getCantidad()+producto.getCantidad());
            return 2;
        }else{
            int hashcode=producto.getNombre().hashCode()%100;
            if(ht[hashcode]==null)
                ht[hashcode]=new BinaryTree();
            ht[hashcode].Insert(producto.getNombre(), producto);
            return 1;
        }
    }
    
    private int search(String nombre){
        int hashcode=nombre.hashCode()%100;
        if(ht[hashcode]==null)
            return -1;
        if(ht[hashcode].Search(nombre)!=null)
            return hashcode;
        return -1;
    }
    
    public int Baja(String nombre){
        if(search(nombre)>=0){
            int hashcode=search(nombre);
            ht[hashcode].Delete(nombre);
            return 0;
        }
        return 1;
    }
    
    public int Listar(int x){
        if(ht[x]==null){
            System.out.println("Lol aqui no hay nada xhaval xdxdxdxdx");
            return -1;
        }else{
            int tipo=1;
            // 1-->Minimo
            // 2-->Maximo
            // 3-->In Order
            // 4-->Pre Order
            // 5-->Post Order
            switch(tipo){
                case 1:
                    Producto p=ht[x].searchItem(ht[x].Minimum());
                    System.out.println("Producto: "+p.getNombre());
                    System.out.println("Cantidad: "+p.getCantidad());
                    System.out.println("Precio: "+p.getPrecio());
                    System.out.println("Serie: "+p.getSerie());
                    System.out.println();
                    break;
                case 2:
                    
            }
            return 0;
        }
    }
}
