package datastructure;

/**
 *
 * @author diegoa.torres
 * @param <K>
 */
public class HashNode <K,E> {
	private K key;
	private E value;
	
	private HashNode<K, E> nextHashNode;
	private HashNode<K, E> prevHashNode;
	
	public HashNode(K key,E value) {
		this.key = key;
		this.value = value;
		this.nextHashNode = null;
		this.prevHashNode = null;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public HashNode<K, E> getNextHashNode() {
		return nextHashNode;
	}

	public void setNextHashNode(HashNode<K, E> newElement) {
		this.nextHashNode = newElement;
	}
	public HashNode<K, E> getPrevHashNode() {
		return prevHashNode;
	}
	public void setPrevHashNode(HashNode<K, E> prior) {
		this.prevHashNode = prior;
	}

}

