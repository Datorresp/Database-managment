/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructure;

/**
 *
 * @author diegoa.torres
 * @param <K>
 * @param <E>
 */
public interface AVLInterface<K extends Comparable<K>, E> {
    
    public E maximum();
    public E minimum();
    public void rotateRight(K key);
    public void rotateLeft(K key);
    public boolean insert(K key, E element);
    public void deleteAVL(K key);
}
