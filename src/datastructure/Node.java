package datastructure;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 * @param <E>
 * @param <K>
 */
public class Node<K extends Comparable<K>, E> implements Serializable {
    
    private E type;
    private K key;
    public  Node<K, E> left;
    public  Node<K, E> right;
    public  Node<K, E> parent;
    private int balance;

    public Node(K key, E type) {
        this.type = type;
        this.key = key;
        balance = 0;
//        if (left == null && right == null){
//            
//            setHeight(1);
//        }else if (left == null) {
//            setHeight(right.getHeight() + 1);
//        }else if (right == null){
//            setHeight(left.getHeight() + 1);
//        }else{
//            setHeight(Math.max(left.getHeight(), right.getHeight()) + 1);
//        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public Node<K, E> getParent() {
        return parent;
    }

    public void setParent(Node<K, E> parent) {
        this.parent = parent;
    }
    
    
    public E getType() {
        return type;
    }

    public void setType(E type) {
        this.type = type;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public Node<K, E> getLeft() {
        return left;
    }

    public void setLeft(Node<K, E> left) {
        this.left = left;
    }

    public Node<K, E> getRight() {
        return right;
    }

    public void setRight(Node<K, E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return type +"";
    }
}
