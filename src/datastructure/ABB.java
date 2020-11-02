package datastructure;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 * @param <K>
 * @param <E>
 */
public class ABB <K extends Comparable<K>, E> implements ABBInterface<K, E>, Serializable {

    private Node<K, E> root;

    public ABB() {
        this.root = null;
    }

    public Node<K, E> getRoot() {
        return root;
        
    }

    public void setRoot(Node<K, E> root) {
        this.root = root;
    }
    
    
    
    @Override
    public boolean  insert(K key, E element) {
              
        Node n = new Node(key, element);
        return add(n);
		
    }
    
    public boolean add(Node<K, E> n){
        
        if(search(n.getKey()) != null) {
            return false;
            
        }if(root == null) {
            
            root = n;
            return true;
        }

        Node<K, E> tmp = root;
        boolean added = false;

        while(!added){
            
            if(n.getKey().compareTo(tmp.getKey())>0) {
                
                if(tmp.getRight() != null){
                    
                    tmp = tmp.getRight();
                }else {
                    
                    tmp.setRight(n);
                    n.setParent(tmp);
                    added = true;
                }
                
            }else {
                                
                if(tmp.getLeft() != null) {

                    tmp = tmp.getLeft();
                }else {

                    tmp.setLeft(n);
                    n.setParent(tmp);
                    added = true;
                }
            }
        }
        return added;
    }
    
    public Node<K,E> deleteFromKey(K key){
    	Node<K,E> deleteK = fullSearch(key);
    	return delete(deleteK);
    }

    @Override
    public Node<K,E>  delete(Node<K,E> n) {
       Node<K,E> deleteKey = null;
       Node<K,E> current = null;
       if (n != null) {
		if (n.getLeft() == null || n.getRight() == null) {
			deleteKey = n;
		}else {
			deleteKey = next(n);
		}
		if (deleteKey.getLeft() != null) {
			current = deleteKey.getLeft();
		}else {
			current = deleteKey.getRight();
		}
		if (current != null) {
			current.setParent(deleteKey.getParent());
		}
		if (deleteKey.getParent() == null) {
			root = current;
		}else {
			if(deleteKey == deleteKey.getParent().getLeft()) {
				deleteKey.getParent().setLeft(current);
			}else {
				deleteKey.getParent().setRight(current);
			}
		}
		if (deleteKey != n) {
			n.setKey(deleteKey.getKey());
		}
       }
       return deleteKey;
    }   
    
    public Node<K,E> next(Node<K,E> n){
    	Node<K,E> actual;
    	if (n.getRight()!= null) {
			actual = minValue(n.getRight());
		}else {
			actual = n.getParent();
			while (actual != null && n == actual.getRight()) {
				n = actual;
				actual = actual.getParent();
			}
		}
    	return actual;
    }


    public  Node<K,E> minValue(Node<K,E> n){ 
        Node<K,E> minv = null; 
        while (n.left != null) 
        { 
            minv = n.getLeft();  
        } 
        return minv; 
    } 
    @Override
    public Node<K,E> search(K key) {
        
        Node<K, E> n = fullSearch(key);
        if (n!= null){
            return n;
        }else{
            return null;  
        }
    }
    
    public  Node<K, E> fullSearch(K key){
        
        Node<K, E> tmp = root;

        while (tmp != null && !tmp.getKey().equals(key)) {

            if (key.compareTo(tmp.getKey()) < 0) {

                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        return tmp;
    }
    
    @Override
    public void update(K key, E element, K newKey){
        
        Node<K, E> n = fullSearch(key);
        n.setType(element);
        n.setKey(newKey);
    }
}
