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

    public boolean insert(K key, E element);
    public Node<K,E> deleteAVL(Node<K,E> n, K key);
    public void update(K key, E element, K newKey);
    public E search(K key);
}
