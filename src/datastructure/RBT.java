package datastructure;

import java.io.Serializable;

/**
 * @param <K>
 * @param <E>
 * @author diegoa.torres
 */
public class RBT<K extends Comparable<K>, E> extends ABB<K, E> implements RBTInterface<K, E>, Serializable {

    @Override
    public void swpColor(K key1, K key2) {

        boolean tmp = ((RBNode) super.fullSearch(key1)).isRed();
        ((RBNode) super.fullSearch(key1)).setColor(((RBNode) fullSearch(key2)).isRed());
        ((RBNode) super.fullSearch(key2)).setColor(tmp);
    }

    @Override
    public void rotateRight(K key) {

        RBNode<K, E> n = (RBNode) super.fullSearch(key);
        rotateR(n);
    }

    private void rotateR(RBNode<K, E> n1) {

        RBNode<K, E> n2 = (RBNode) n1.getLeft();
        n1.setLeft(n1.getRight());
        if (n2.getRight() != null) {

            n2.getRight().setParent(n1);
        }

        n2.setParent(n1.getParent());
        if (n1.getParent() == null) {

            super.setRoot(n2);
        } else if (n1 == n1.getParent().getRight()) {

            n1.getParent().setRight(n2);
        } else {

            n1.getParent().setLeft(n2);
        }
        n2.setParent(n1);
        n1.setParent(n2);
    }

    @Override
    public void rotateLeft(K key) {

        RBNode<K, E> n = (RBNode) fullSearch(key);
        rotateL(n);
    }

    private void rotateL(RBNode<K, E> n1) {

        RBNode<K, E> n2 = (RBNode) n1.getRight();
        n1.setRight(n1.getLeft());
        if (n2.getLeft() != null) {

            n2.getLeft().setParent(n1);
        }

        n2.setParent(n1.getParent());
        if (n1.getParent() == null) {

            super.setRoot(n2);
        } else if (n1 == n1.getParent().getLeft()) {

            n1.getParent().setLeft(n2);
        } else {

            n1.getParent().setRight(n2);
        }
        n2.setParent(n1);
        n1.setParent(n2);
    }

    private void balance(K key) {

        RBNode<K, E> n = (RBNode) super.fullSearch(key);

        if (n.getRight() != null) {

            if (((RBNode) n.getRight()).isRed() && !((RBNode) n.getLeft()).isRed()) {

                rotateL(n);
                swpColor(n.getKey(), n.getLeft().getKey());
            }
        }

        if (n.getRight() != null && n.getLeft() != null) {
            if (((RBNode) n.getLeft()).isRed() && ((RBNode) n.getRight()).isRed()) {

                n.setColor(!n.isRed());
                ((RBNode) n.getLeft()).setColor(false);
                ((RBNode) n.getRight()).setColor(false);
            }
        }

        if (n.getLeft() != null) {
            if (((RBNode) n.getLeft()).isRed() && ((RBNode) n.getLeft().getLeft()).isRed()) {

                rotateR(n);
                swpColor(n.getKey(), n.getRight().getKey());
            }
        }
    }

    @Override
    public boolean insert(K key, E element) {

        RBNode<K, E> n = new RBNode<>(key, element);
        boolean added = add(n);
        if (added) {

            balance(key);
        }

        return added;
    }

    @Override
    public void update(K key, E element, K newKey) {

        super.update(key, element, newKey);
    }

    @Override
    public boolean delete(K key) {

        boolean deleted = delete(key);

        if (deleted) {


        }

        return deleted;
    }
}
