package datastructure;

/**
 *
 * @author diegoa.torres
 */
public class HashTable <K,V> implements HashTableInterface<K, V> {
	
	public final static int ARRAY_SIZE = 5;  
	
	private HashNode<K, V>[] node;
	
	public HashTable() {
		node = (HashNode<K,V>[])new HashNode[ARRAY_SIZE];
	}
	
	
	public int hashFunction(K key) {
		int hashFunction = key.hashCode() % ARRAY_SIZE;
		return hashFunction;
	}
	
	public HashNode<K, V>[] getNode() {
		return node;
	}

	public void setNode(HashNode<K, V>[] node) {
		this.node = node;
	}

	@Override
	public V search (K key) {
		
		HashNode<K, V> newKey = node[hashFunction(key)];
		V value = null;
		if(newKey != null) {
			
			while(newKey != null) {
				
				if(newKey.getKey().equals(key)) {
					value = newKey.getValue();
				}
				newKey = newKey.getNextHashNode();
			}
		}
		return value;
	}

	
	@Override
	public void insert(K key, V value) {
		
		HashNode<K,V> checkNode = node[hashFunction(key)];
		
		if(checkNode == null) {
			
			checkNode = new HashNode<>(key,value);
			
			node[hashFunction(key)] = checkNode;
			
		}else {
			
			boolean found = false;
			
			while(checkNode != null && !found) {
				
				if(checkNode.getKey().equals(key)) {
					checkNode.setValue(value);
					found = true;
				}
				checkNode = checkNode.getNextHashNode();
			}
			
			checkNode = node[hashFunction(key)];
			HashNode<K, V> nodeH2 = new HashNode<K,V>(key, value);
			nodeH2.setNextHashNode(checkNode);
			checkNode.setPrevHashNode(nodeH2);
			node[hashFunction(key)] = nodeH2;
		}
	}
	

	@Override
	public void delete(K key) {
		
		int position = hashFunction(key);
		HashNode<K, V> aux = node[position];
		boolean found = false; 
		
		while (aux != null && !found) {
			
			if (aux.getKey().equals(key)) {
				found = true;
				
				if (aux.getNextHashNode() != null) {
					aux.getNextHashNode().setPrevHashNode(aux.getPrevHashNode());
				}
				
				if (aux.getPrevHashNode() != null) {
					aux.getPrevHashNode().setNextHashNode(aux.getNextHashNode());
				}
				
				node[position] = aux.getNextHashNode(); 
			}
			aux = aux.getNextHashNode();
		}
	}
}
