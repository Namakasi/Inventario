/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import java.util.Scanner;

/**
 *
 * @author Yue
 */
public class BinaryTree<Item extends Comparable<Item>, Value>{
    Node root;

    public BinaryTree() {
        root = null;
    }
    
    private class Node{
        Item key;
        Value value;
        Node left;
        Node right;
        Node parent;

        public Node(Item key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public Value getValue(Item item){
        Node tmp=Search(item);
        if(tmp!=null)
            return tmp.value;
        return null;
    }
    
    public void Insert(Item item, Value value){
        Node z=new Node(item, value);
        Node x=root;
        Node y=null;
        z.key=item;
        while(x!=null){
            y=x;
            if(z.key.compareTo(x.key)<0)
                x=x.left;
            else
                x=x.right;
        }
        z.parent=y;
        if(y==null)
            root=z;
        else if(z.key.compareTo(y.key)<0)
            y.left=z;
        else
            y.right=z;
    }
    
    public Node Delete(Item key){
        Node z=Search(key);
        if(z==null)
            return null;
        Node y;
        Node x;
        if(z.left==null || z.right==null)
            y=z;
        else
            y=Search(Successor((Item) z.key));
        if(y.left!=null)
            x=y.left;
        else
            x=y.right;
        if(x!=null)
            x.parent=y.parent;
        if(y.parent==null)
            root=x;
        else if(y==y.parent.left)
            y.parent.left=x;
        else
            y.parent.right=x;
        if(y!=z)
            z.key=y.key;
        return y;
    }
    
    public Item Successor(Item key){
        Node x=Search(key);
        if(x==null)
            return null;
        if(x.right!=null)
            return Minimum((Item) x.right.key);
        Node y=x.parent;
        while(y!=null && x==y.right){
            x=y;
            y=y.parent;
        }
        if(y!=null)
            return (Item) y.key;
        return null;
    }
    
    public Item Minimum(Item key){
        Node x=Search(key);
        while(x.left!=null)
            x=x.left;
        return (Item) x.key;
    }
    
    public Item Minimum(){
        Node x=root;
        if(x==null)
            return null;
        while(x.left!=null)
            x=x.left;
        return (Item) x.key;
    }
    
    public Item Maximum(Item key){
        Node x=Search(key);
        while(x.right!=null)
            x=x.right;
        return (Item) x.key;
    }
    
    public Item Maximum(){
        Node x=root;
        if(x==null)
            return null;
        while(x.right!=null)
            x=x.right;
        return (Item) x.key;
    }
    
    public Value searchItem(Item k){
        Node x=root;
        if(x==null || x.key.compareTo(k)==0)
            return x.value;
        if(x.key.compareTo(k)>0)
            return searchItem(x.left, k).value;
        else
            return searchItem(x.right,k).value;
    }
    
    private Node searchItem(Node x, Item k){
        if(x==null || x.key.compareTo(k)==0)
            return x;
        if(x.key.compareTo(k)>0)
            return Search(x.left, k);
        else
            return Search(x.right,k);
    }
    
    public Node Search(Item k){
        Node x=root;
        if(x==null || x.key.compareTo(k)==0)
            return x;
        if(x.key.compareTo(k)>0)
            return Search(x.left, k);
        else
            return Search(x.right,k);
    }
    
    private Node Search(Node x, Item k){
        if(x==null || x.key.compareTo(k)==0)
            return x;
        if(x.key.compareTo(k)>0)
            return Search(x.left, k);
        else
            return Search(x.right,k);
    }
    
    public Item Predecessor(Item key){
        Node x=Search(key);
        if(x==null)
            return null;
        if(x.left!=null)
            return Maximum((Item) x.left);
        Node y=x.parent;
        while(y!=null && x==y.left){
            x=y;
            y=x.parent;
        }
        if(y!=null)
            return (Item) y.key;
        return null;
    }
    
    public void inOrder(){
        Node x=root;
        if(x==null)
            System.out.println("Arbol vacío");
        if(x!=null){
            inOrder(x.left);
            System.out.println(x.key);
            inOrder(x.right);
        }
    }
    
    private void inOrder(Node x){
        if(x!=null){
            inOrder(x.left);
            System.out.println(x.key);
            inOrder(x.right);
        }
    }
    
    public void postOrder(){
        Node x=root;
        if(x==null)
            System.out.println("Arbol vacío");
        if(x!=null){
            postOrder(x.left);
            postOrder(x.right);
            System.out.println(x.key);
        }
    }
    
    private void postOrder(Node x){
        if(x!=null){
            postOrder(x.left);
            postOrder(x.right);
            System.out.println(x.key);
        }
    }
    
    public void preOrder(){
        Node x=root;
        if(x==null)
            System.out.println("Arbol vacío");
        if(x!=null){
            System.out.println(x.key);
            preOrder(x.left);
            preOrder(x.right);
        }
    }
    
    private void preOrder(Node x){
        if(x!=null){
            System.out.println(x.key);
            preOrder(x.left);
            preOrder(x.right);
        }
    }
}
