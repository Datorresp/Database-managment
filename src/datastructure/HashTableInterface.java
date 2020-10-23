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
public interface HashTableInterface<K, V> {

	public V search(K key);

	public void insert(K key, V value);

	public void delete(K key);

}
