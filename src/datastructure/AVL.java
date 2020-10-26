package datastructure;

/**
 *
 * @author diegoa.torres
 * @param <K>
 * @param <E>
 * 
 */
public class AVL <K extends Comparable<K>, E> extends ABB<K, E> implements AVLInterface<K, E>{

    @Override
    public E maximum() {
 
        Node tmp = super.getRoot();
        if (tmp == null) {
            
            return null;
        }
        while (tmp.getRight() != null) {
            
            tmp = tmp.getRight();
        }
        
        return (E) tmp.getType();
    }

    @Override
    public E minimum() {
        
        Node tmp = super.getRoot();
        if (tmp == null) {
            
            return null;
        }
        while (tmp.getLeft()!= null) {
            
            tmp = tmp.getLeft();
        }
        
        return (E) tmp.getType();       
    }

    @Override
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

    @Override
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
    
    public void update(K key, E element){
        
        super.update(key, element);
    }
    
//    public int height(Node N)  
//    {  
//        if (N == null)  
//            return 0;  
//        return N.height;  
//    }  

    @Override
    public void deleteAVL(K key) {
        
        deleteFromKey(key);
        
    }

}
