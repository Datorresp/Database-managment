package datastructure;

/**
 *
 * @author diegoa.torres
 * @param <K>
 * @param <E>
 */
public class ABB <K extends Comparable<K>, E> implements ABBInterface<K, E> {

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
            
            if(n.getKey().compareTo(tmp.getKey())>=0) {
                
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
    
    public boolean deleteFromKey(){
        
        return false;
    }

    @Override
    public boolean  delete(K key) {
        
        boolean del = false;

        
        return del;
    }   

    @Override
    public E search(K key) {
        
        Node<K, E> n = fullSearch(key);
        if (n!= null){
            return n.getType();
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
    
    public void update(K key, E element){
        
        Node<K, E> n = fullSearch(key);
        n.setType(element);
    }
}
