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
public interface ABBInterface <K,V>{
    
    public boolean  add(V value);
    public boolean remove(K key);
    public V search(K key);
    public boolean isEmpty();
    public int size();
}
