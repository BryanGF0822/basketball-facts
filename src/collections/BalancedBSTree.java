package collections;

import java.util.List;

public interface BalancedBSTree<K extends Comparable<K>, V> {
	public Node<K, V>add(K key,V value);
	public void delete(K key);
	
	
}
