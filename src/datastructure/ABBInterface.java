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
public interface ABBInterface <K extends Comparable<K>, E>{
    
    public boolean  insert( K key, E element);
    public boolean  delete(K key);
    public E search(K key);
}
