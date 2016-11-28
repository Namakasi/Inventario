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
        ht.Baja("Martilloaaa", 15);
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
        int hashcode=hashCode(nombre);
        if(ht[hashcode]==null)
            return -1;
        if(ht[hashcode].Search(nombre)!=null)
            return hashcode;
        return -1;
    }
    
    public int Baja(String nombre, int x){
        if(search(nombre)>=0){
            int hashcode=search(nombre);
            int i=search(nombre);
            Producto tmp=ht[i].searchItem(nombre);
            if(tmp.getCantidad()-x<0){
                System.out.println("No tenemos esa cantidad del producto: "+tmp.getNombre());
            }else{
                tmp.setCantidad(tmp.getCantidad()-x); 
            }
            

            return 0;
        }else{
            System.out.println("No existe el producto "+nombre+ "en nuestro inventario c:");
        }
        return 1;
    }
    
    public int Listar(int x){
        if(ht[x]==null){
            System.out.println("Lol aqui no hay nada xhaval xdxdxdxdx");
            return -1;
        }else{
            Producto p;
            int tipo=1;
            switch(tipo){
                case 1://Minimo
                    p=ht[x].searchItem(ht[x].Minimum());
                    System.out.println(p);
                    break;
                case 2:// Maximo
                    p=ht[x].searchItem(ht[x].Maximum());
                    System.out.println(p);
                    break;
                case 3:// In Order
                    ht[x].inOrder();
                    break;
                case 4:// Pre Order
                    ht[x].preOrder();
                    break;
                case 5:// Post Order
                    ht[x].postOrder();
                    break;
                default:
                    System.out.println("Opción Incorrecta");
            }
            return 0;
        }
    }
    
    private int hashCode(String key){
        return ((key.hashCode()& 0x7fffffff)%ht.length);
    }
}
