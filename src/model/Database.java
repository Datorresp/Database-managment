package model;

import datastructure.AVL;
import datastructure.AVLInterface;
import datastructure.HashTable;
import datastructure.HashTableInterface;
import datastructure.RBT;
import datastructure.RBTInterface;
import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 */
public class Database implements Serializable{

    private HashTableInterface people;
    private AVLInterface name, lastName, fullName;
    private RBTInterface id;

    public Database() {
        this.people = new HashTable();
        this.name = new AVL();
        this.lastName = new AVL();
        this.fullName = new AVL();
        this.id = new RBT();
    }
    
    
}
