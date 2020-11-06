package datastructure;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 * @param <K>
 * @param <E>
 * 
 */
public class AVL <K extends Comparable<K>, E> extends ABB<K, E> implements AVLInterface<K, E>, Serializable{

    public E maximum() {
 
        Node<K, E> tmp = super.getRoot();
        if (tmp == null) {
            
            return null;
        }
        while (tmp.getRight() != null) {
            
            tmp = tmp.getRight();
        }
        
        return (E) tmp.getType();
    }

    public E minimum() {
        
        Node<K, E> tmp = super.getRoot();
        if (tmp == null) {
            
            return null;
        }
        while (tmp.getLeft()!= null) {
            
            tmp = tmp.getLeft();
        }
        
        return (E) tmp.getType();       
    }
    
    public int max(int a, int b){  
        return (a > b) ? a : b;  
    }  
    
    public int height(Node<K,E> n){  
        if (n == null)  
            return 0;  
        return n.getBalance();  
    } 

    public void rotateRight(K key) {
        
        Node<K, E> n = super.fullSearch(key);
        rotateR(n);
    }
    
    private void rotateR(Node <K, E> n1){
        
        Node<K, E> n2 = n1.getLeft();
        n1.setLeft(n1.getRight());
        if (n2.getRight() != null) {
            
            n2.getRight().setParent(n1);
        }
        
        n2.setParent(n1.getParent());
        if (n1.getParent() == null) {
            
            super.setRoot(n2);
        }else if (n1 == n1.getParent().getRight()) {
            
            n1.getParent().setRight(n2);
        }else{
            
            n1.getParent().setLeft(n2);
        }
        n2.setParent(n1);
        n1.setParent(n2);
    }

    public void rotateLeft(K key) {
        
        Node<K, E> n = fullSearch(key);
        rotateL(n);
    }
    
    private void rotateL(Node <K, E> n1){
        
        Node<K, E> n2 = n1.getRight();
        n1.setRight(n1.getLeft());
        if (n2.getLeft()!= null) {
            
            n2.getLeft().setParent(n1);
        }
        
        n2.setParent(n1.getParent());
        if (n1.getParent() == null) {
            
            super.setRoot(n2);
        }else if (n1 == n1.getParent().getLeft()) {
            
            n1.getParent().setLeft(n2);
        }else{
            
            n1.getParent().setRight(n2);
        }
        n2.setParent(n1);
        n1.setParent(n2);        
    }
    
    private void balance(K key){
        
        Node<K, E> n = fullSearch(key);
        boolean isBalanced = false;
        
        Node<K,E> n1 = n.getParent();
            
            while (!isBalanced && n1!= null) {
                
                if (n != n1.getLeft()) {
                    
                    if(n1.getBalance()==1) {
                        
                        n1.setBalance(0); 
                        isBalanced = true;
                    }

                    n1.setBalance(-1); 
                    
                    if(n1.getBalance()==-1) { 
                        
                        if(n.getBalance()==1) { 
                            rotateR(n); 
                        }

                        rotateL(n1);
                        isBalanced = true; 
                    }

                }else{
                    
                    if (n1.getBalance()==-1) {
                        
                        n1.setBalance(0);
                        isBalanced = true;
                    }
                    
                    n1.setBalance(0);
                    
                    if (n1.getBalance()==1) {
                        
                        if (n.getBalance() == 1) {
                            
                            rotateL(n);
                        }
                        
                        rotateR(n1);
                        isBalanced = true;
                    }
                }
            }
        }
    

    @Override
    public boolean insert(K key, E element) {
        
        Node<K, E> n = new Node<>(key, element);
        boolean added = super.add(n);
        if (added) {
            
            balance(key);
        }
        return added;
    }
    
    @Override
    public void update(K key, E element, K newKey){
        
        super.update(key, element, newKey);
    }
    
    int getBalance(Node<K,E> N){  
        if (N == null)  
            return 0;  
        return height(N.left) - height(N.right);  
    } 

    @Override
    public void deleteAVL(Node<K,E> root, K key) {
//    	Node<K,E> d = super.search(key);
//    	super.delete(d);
    	//establecer el factor balanceo
    	//rebalancear
    }
    
    private  Node<K, E> rightRotate(Node<K,E> y){  
        Node<K,E> x = y.left;  
        Node<K,E> T2 = x.right;  
   
        x.right = y;  
        y.left = T2;  
  
        // Update heights  
        y.setBalance(max(height(y.left), height(y.right)) + 1); 
        x.setBalance(max(height(x.left), height(x.right)) + 1);  
 
        return x;  
    }  
  

    public Node<K, E> leftRotate(Node<K,E> x){  
        Node<K,E> y = x.right;  
        Node<K,E> T2 = y.left;  
   
        y.left = x;  
        x.right = T2;  
  
        // Update heights  
        x.setBalance(max(height(x.left), height(x.right)) + 1);  
        y.setBalance(max(height(y.left), height(y.right)) + 1);  
 
        return y;  
    }
    
    public Node<K,E> minValueAVL(Node<K,E> node){  
           
        Node<K,E> current = node;  
 
        while (current.left != null)  
            current = current.left;  
  
        return current;  
    }  

    @Override
    public E search(K key){
        
        return super.search(key);
    }
}