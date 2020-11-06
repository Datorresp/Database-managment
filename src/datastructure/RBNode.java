package datastructure;

import java.io.Serializable;

/**
 *
 * @author diegoa.torres
 */
public class RBNode<K extends Comparable<K>, E> extends Node<K, E> implements Serializable {

    //RED = TRUE ; BLACK = FALSE
    private boolean color;

    public RBNode(K key, E type) {
        super(key, type);
        color = true; 
    }

    public boolean isRed() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    } 
}
