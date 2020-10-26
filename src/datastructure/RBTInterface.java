/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

/**
 *
 * @author diegoa.torres
 */
public interface RBTInterface<K extends Comparable<K>, E> {
    
    public void swpColor(K key1, K key2);
    public boolean insert(K key, E element);
    public void update(K key, E element, K newKey);
    public void rotateRight(K key);
    public void rotateLeft(K key);
    public boolean delete(K key);
}
